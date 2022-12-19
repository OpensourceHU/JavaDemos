package pri.ThreadTest;

/**
 * @author OpensourceHU
 * @version V1.0
 * @Description 并发访问时会出现数据不同步的问题
 * 解决方法: synchronized 同步代码块  synchronized(Object o){...}  其中的object被称为同步监视器
 * @date 2020/6/6 0006 10:39
 */
public class Ticket implements Runnable {
  public int remain = 10;

  public static void main(String[] args) {
    Ticket run = new Ticket();
    Thread thread1 = new Thread(run, "a");
    Thread thread2 = new Thread(run, "b");
    thread1.start();
    thread2.start();


  }

  @Override
  public void run() {

    while (remain > 0) {
      if (remain > 0) {//如果有票则取票
        synchronized (this) {//同步代码块
          System.out.println(Thread.currentThread().getName() + "------" + (remain--));
        }
      }
      //取票需要时间  这个时候线程挂起  别的线程可以访问资源
      try {
        Thread.sleep(200);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }

  }
}
