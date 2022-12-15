package classic_algo.sort_algo;


import java.util.Random;

import static edu.princeton.cs.algs4.StdOut.print;
import static classic_algo.sort_algo.bubble_sort.show;

/**
 * @author OpensourceHU
 * @version V1.0
 * @Description 计数排序
 * @date 2020/4/18 0018 10:31
 */
public class Counting_sort {
    public static int[] generate(int scale) {
        int[] tmp = new int[scale];
        Random r = new Random();
        for (int i = 0; i < scale; i++) {
            tmp[i] = r.nextInt(10);
        }
        return tmp;
    }

    public static int[] countingSort(int[] arr, int bucket_from, int bucket_to) {
        int[] bucket = new int[bucket_to - bucket_from + 1];
        int[] ret = new int[arr.length];
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            bucket[arr[i] - bucket_from]++;
        }//遍历原数组  把每个桶里的元素个数给统计出来  桶数组的下标 就是原数组的值

        for (int index = 0 + bucket_from; index < bucket.length + bucket_from; index++) {
            for (int j = 0; j < bucket[index]; j++) {
                ret[count++] = index + bucket_from;
            }
        }
        return ret;
    }

    public static void main(String[] args) {
        int[] arr = generate(100);
        arr = countingSort(arr, 0, 10);
        System.out.println(arr.length);
        show(arr);
    }

}

