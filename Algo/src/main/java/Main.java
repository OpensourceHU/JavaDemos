import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Main {
    static volatile int cnt = 0;
    static Lock lock = new ReentrantLock(true);

    public static void main(String[] args) {
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                lock.lock();
                System.out.println(lock);
                try {
                    if (lock.tryLock()) {
                        System.out.println(Thread.currentThread().getName() + "get Lock");
                        for (int i = 0; i < 5; i++) {
                            cnt++;
                            System.out.println(cnt);
                        }
                    }
                } catch (Exception e) {
                } finally {
                    System.out.println(Thread.currentThread().getName() + "release lock");
                    lock.unlock();
                }
            }
        });
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                lock.lock();
                System.out.println(lock);
                try {
                    if (lock.tryLock()) {
                        System.out.println(Thread.currentThread().getName() + "get Lock");
                        for (int i = 0; i < 5; i++) {
                            cnt++;
                            System.out.println(cnt);
                        }
                    }
                } catch (Exception e) {
                } finally {
                    System.out.println(Thread.currentThread().getName() + "release lock");
                    lock.unlock();
                }
            }
        });

        t1.start();
        t2.start();

    }

}








