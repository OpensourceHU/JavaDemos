package pri.concurrent;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author OpensourceHU
 * @version V1.0
 * @Description 线程池使用实例
 * @date 2022/12/15 11:55
 */
public class ThreadPoolDemo {
  static ThreadPoolExecutor pool = new ThreadPoolExecutor(3, 10, 5, TimeUnit.SECONDS,
      new ArrayBlockingQueue(100));
  static volatile int num;

  public static void main(String[] args) {
    for (int i = 0; i < 10; i++) {
      pool.execute(() -> {
        synchronized (ThreadPoolDemo.class) {
          num++;
          System.out.println(Thread.currentThread().getName() + "==" + num);
        }
      });
    }

    while (!pool.isTerminated()) ;
    pool.shutdown();

  }
}
