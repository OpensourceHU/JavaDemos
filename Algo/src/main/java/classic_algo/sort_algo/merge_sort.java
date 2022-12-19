package classic_algo.sort_algo;

import java.util.Arrays;

/**
 * @author OpensourceHU
 * @version V1.0
 * @Description 并归排序
 * @date 2020/4/15 0015 16:26
 */
public class merge_sort {
  /*****************************复现********************************/
  public static void main(String[] args) {
    int[] array = new int[] {1, 2, 3, 4, 8, 1, 2, 3, 7, 10};
    int[] array2 = Arrays.copyOf(array, array.length);
    int i = 0;
    int j = 0;

  }

  public static void mergeSort(int[] array) {
    if (array == null) {
      return;
    }
    process(array, 0, array.length - 1);
  }

  public static void process(int[] arr, int left, int right)//process就是一次分割再整理的过程
  {
    if (left >= right) {
      return;
    }
    int mid = left + ((right - left) >> 1);
    process(arr, left, mid);
    process(arr, mid + 1, right);
    merge(arr, left, mid + 1, right);//merge(合并) 将已排序好的两个数组合并成新的有序数组
  }

  public static void merge(int[] arr, int leftPtr, int rightPtr, int rightEdge) {
    int i = leftPtr;//i j 分别为左右子数组指针
    int j = rightPtr;
    int k = 0;        //k为辅助数组指针
    int[] help = new int[rightEdge - leftPtr + 1];  //申请的新数组长度,别写成arr.length了
    while (i < rightPtr && j <= rightEdge) {
      help[k++] = arr[i] <= arr[j] ? arr[i++] : arr[j++];
    }//比较并填入辅助数组的过程, 直到i j任意一个跨过边界为止
    while (i < rightPtr) {
      help[k++] = arr[i++];
    }
    while (j <= rightEdge) {
      help[k++] = arr[j++];
    }
    //这两个while循环只会进入一个,把其中没有复制完的子数组剩余的元素全部依次复制到辅助数组中去
    for (int elem : help
    ) {
      arr[leftPtr++] = elem;
    }//辅助数组的元素 复制到原数组相应位置
  }
}





















