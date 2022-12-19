package pri;

import java.util.concurrent.CyclicBarrier;

/**
 * @author OpensourceHU
 * @version V1.0
 * @Description ${todo}
 * @date ${DATE} ${TIME}
 */
public class Main {

  public static void main(String[] args) {
    CyclicBarrier cyclicBarrier = new CyclicBarrier(5, () -> {
      for (int i = 0; i < 10; i++) {
        System.out.println(Thread.currentThread().getName() + " " + i);
      }
    });

  }
}