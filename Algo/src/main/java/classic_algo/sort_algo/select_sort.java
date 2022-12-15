package classic_algo.sort_algo;

import classic_algo.dataChecker;

import java.util.Arrays;

/**
 * @author OpensourceHU
 * @version V1.0
 * @Description 选择排序
 * @date 2020/4/14 0014 20:13
 */
public class select_sort {
    public static void main(String[] args) {
        int[] array = dataChecker.randomIntArrayGenerator(1000);
        int[] array2 = Arrays.copyOf(array, array.length);
        select_sort(array);
        System.out.println(Arrays.toString(array));
        Arrays.sort(array2);
        System.out.println(Arrays.toString(array));
    }

    public static void select_sort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            int tmp = array[i];
            int index = i;
            for (int j = i; j < array.length; j++) {
                if (tmp > array[j]) {
                    tmp = array[j];
                    index = j;
                }
            }
            array[index] = array[i];
            array[i] = tmp;
        }
    }
}
