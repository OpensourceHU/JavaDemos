package classic_algo.sort_algo;

import static classic_algo.sort_algo.Insertion_sort.print;

/**
 * @author OpensourceHU
 * @version V1.0
 * @Description 快排
 * @date 2020/4/17 0017 16:37
 */
public class quick_sort {
    public static void main(String[] args) {
        int[] a = new int[]{4, 4, 6, 5, 1, 8, 9, 2, 7, 3, 10};
        quick_sort1(a, 0, a.length);
        print(a);
    }

    public static int getmiddle(int[] array, int leftbound, int rightbound) {
        int axis = array[rightbound];
        int i = leftbound;
        int j = rightbound;
        while (i < j) {
            while (array[i] <= axis && i < j) i++;
            while (array[j] > axis && i < j) j--;
            swap(array, i, j);
        }
        swap(array, j, rightbound);
        return j;
    }


    public static void quick_sort1(int[] array, int left, int right) {
        if (left >= right) return;
        process(array, 0, array.length - 1);
    }

    public static void process(int[] arr, int left, int right) {
        if (left < right) {
            int mid = getmiddle(arr, left, right);
            process(arr, left, mid - 1);
            process(arr, mid + 1, right);
        }
    }

    private static void swap(int[] array, int i, int j) {
        int tmp;
        tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }
}
