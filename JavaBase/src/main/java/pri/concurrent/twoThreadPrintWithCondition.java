package pri.concurrent;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author OpensourceHU
 * @version V1.0
 * @Description 双线程交替输出1~100 使用Condition对象
 * @date 2022/12/14 23:59
 */
public class twoThreadPrintWithCondition {
    volatile static int num = 0;

    public static void main(String[] args) {
        ReentrantLock lock = new ReentrantLock();
        Condition sig1 = lock.newCondition();
        Condition sig2 = lock.newCondition();
        new Thread(() -> {
            lock.lock();
            try {
                while (num < 100) {
                    num++;
                    System.out.println(Thread.currentThread().getName() + "==" + num);
                    sig2.signal();
                    sig1.await();
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            } finally {
                lock.unlock();
            }
        }, "Thread 1").start();

        new Thread(() -> {
            lock.lock();
            try {
                while (num < 100) {
                    num++;
                    System.out.println(Thread.currentThread().getName() + "==" + num);
                    sig1.signal();
                    //当前调用此方法的线程阻塞 自动放锁 直到有信号唤醒
                    sig2.await();
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            } finally {
                lock.unlock();
            }
        }, "Thread 2").start();
    }
}
