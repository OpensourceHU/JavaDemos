package pri.concurrent;

/**
 * @author OpensourceHU
 * @version V1.0
 * @Description 双线程交替打印1~100 使用Sync关键字
 * @date 2022/12/15 0:04
 */
public class twoThreadPrintWithSync {
  volatile static int num = 0;
  static Object lock = new Object();
  static Thread t1, t2;

  public static void main(String[] args) throws InterruptedException {
    t1 = new Thread(() -> {
      while (num < 100) {
        synchronized (lock) {
          num++;
          System.out.println(Thread.currentThread().getName() + num);
          try {
            lock.notifyAll();
            lock.wait();
          } catch (InterruptedException e) {
            throw new RuntimeException(e);
          }
        }
      }
    }, "Thread 1 ");
    t2 = new Thread(() -> {
      while (num < 100) {
        synchronized (lock) {
          num++;
          System.out.println(Thread.currentThread().getName() + num);
          lock.notifyAll();
          try {
            lock.wait();
          } catch (InterruptedException e) {
            throw new RuntimeException(e);
          }
        }
      }
    }, "Thread 2 ");

    t1.start();
    t2.start();

  }

}
