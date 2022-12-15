package pri.ThreadTest;

/**
 * @author OpensourceHU
 * @version V1.0
 * @Description
 * @date 2020/6/15 0015 7:43
 */

public class AccountingSync implements Runnable {
    //共享资源(临界资源)
    static int i = 0;

    /**
     * synchronized 修饰实例方法
     * 相当于给当前实例加锁  即给this加锁
     */
    public static synchronized void increase() {
        i++;
    }

    @Override
    public void run() {
        for (int j = 0; j < 1000000; j++) {
            increase();
            System.out.println(i);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        AccountingSync instance01 = new AccountingSync();
        AccountingSync instance02 = new AccountingSync();

        Thread t1 = new Thread(instance01);
        Thread t2 = new Thread(instance02);
        //t1  t2 就是当前的实例
        t1.start();
        t2.start();

        t1.join();
        t2.join();
        System.out.println(i);
    }
    /**
     * 输出结果:
     * 2000000
     */
}
