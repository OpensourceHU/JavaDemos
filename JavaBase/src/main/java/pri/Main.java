package pri;

import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author OpensourceHU
 * @version V1.0
 * @Description ${todo}
 * @date ${DATE} ${TIME}
 */
public class Main {
    static volatile int num = 0;

    public static void main(String[] args) {
        ThreadPoolExecutor pool = new ThreadPoolExecutor(4, 8, 10, TimeUnit.SECONDS,
                new LinkedBlockingDeque());
        pool.execute(new Runnable() {
            @Override
            public void run() {
                if (num >= 1000000) return;
                num++;
                System.out.println(Thread.currentThread().getName() + "==" + num);
            }
        });

    }
}