package classic_algo.sort_algo;

import classic_algo.dataChecker;

import java.util.Arrays;

/**
 * @author OpensourceHU
 * @version V1.0
 * @Description 插入排序
 * @date 2020/4/14 0014 11:38
 */
public class Insertion_sort {
    public static void main(String[] args) {
        int[] array1 = dataChecker.randomIntArrayGenerator(10000);
        int[] array2 = Arrays.copyOf(array1, array1.length);
        int[] array3 = Arrays.copyOf(array1, array1.length);

        long begin = System.currentTimeMillis();
        sort(array1);           //插入排序未改进
        long end = System.currentTimeMillis();
        print(array1);
        System.out.println("自己写的插入排序1耗时" + (end - begin));

        begin = System.currentTimeMillis();
        sort3(array2);
        end = System.currentTimeMillis();
        print(array2);
        System.out.println("优化过的插入排序2耗时" + (end - begin));

        begin = System.currentTimeMillis();
        Arrays.sort(array3);   //系统自带快排
        end = System.currentTimeMillis();
        print(array3);
        System.out.println("java快排耗时" + (end - begin));
    }

    public static void sort(int[] array) {
        for (int i = 0; i < array.length - 1; i++)
            for (int j = i + 1; j > 0 && array[j] < array[j - 1]; j--)//判断放循环里,少写几行
                swap(array, j, j - 1);
    }

    public static void sort2(int[] array) {
        for (int i = 0; i < array.length; i++) {
            int tmp = array[i];
            int j;
            for (j = i; j > 0 && tmp < array[j - 1]; j--) {
                array[j] = array[j - 1];
            }
            array[j] = tmp;
        }                                 //简单优化,去掉swap函数
    }

    public static void swap(int[] array, int i, int j) {
        int tmp = 0;
        tmp = array[j];
        array[j] = array[i];
        array[i] = tmp;
    }

    public static void print(int[] array) {
        for (int i : array
        ) {
            System.out.print(i + "\t");
        }
    }

    public static void sort3(int[] array) {
        for (int i = 0; i < array.length; i++) {
            int tmp = array[i];
            int j;
            for (j = i; j > 0 && array[j - 1] > tmp; j--)
                array[j] = array[j - 1];
            array[j] = tmp;
        }
    }


}

