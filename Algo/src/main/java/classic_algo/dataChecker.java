package classic_algo;

import java.util.Arrays;
import java.util.Random;

/**
 * @author OpensourceHU
 * @version V1.0
 * @Description 对数器, 用于生成大规模随机数, 验证算法正确性
 * @date 2020/4/14 0014 11:27
 */
public class dataChecker {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(randomIntArrayGenerator(100)));
    }

    public static int[] randomIntArrayGenerator(int scale) {
        int[] array = new int[scale];
        Random r = new Random();
        for (int i = 0; i < scale; i++) {
            array[i] = r.nextInt();
        }
        return array;
    }
}
