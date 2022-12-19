package pri.ThreadTest;

/**
 * @author OpensourceHU
 * @version V1.0
 * @Description 联系创建线程的两种方法
 * @date 2020/6/5 0005 9:34
 */

/*
 * 创建方法1  如果只想要重写run() 方法  则实现runnable接口即可
 *       如果要启动线程  将实现了runnable的实例 作为参数传入thread的构造函数
 *                       再通过thread的start方法  启动线程
 *       java文档中: 大多数情况下，如果只想重写 run() 方法，而不重写其他 Thread 方法，那么应使用 Runnable 接口。
 *                   这很重要，因为除非程序员打算修改或增强类的基本行为，否则不应为该类创建子类。
 *
 *      run() 与 start() 的区别  start() 是线程开始抢占资源 要切换线程
 *                              run() 相当于主程序去调用了thread类中的一个普通方法  线程依然是main线程
 *
 * */
public class create_ThreadTest implements Runnable {
  public static void main(String[] args) {
    create_ThreadTest thread = new create_ThreadTest();
    Thread newThread = new Thread(thread);
    newThread.start();
    for (int i = 0; i < 10; i++) {
      {
        System.out.println(Thread.currentThread().getName() + "=====");
      }
    }
  }

  @Override
  public void run() {
    for (int i = 0; i < 5; i++) {
      System.out.println(Thread.currentThread().getName() + "------");
    }
  }
}