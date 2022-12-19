package classic_algo.sort_algo;

/**
 * @author OpensourceHU
 * @version V1.0
 * @Description 小和问题:在一个数组中，每一个数左边比当前数小的数累加起来，叫做这个数组的小和。求一个数组的小和。
 * 思路:改编归并排序
 * @date 2020/4/21 0021 10:49
 */
public class Xiaohe_problem {
  public static void main(String[] args) {
    int[] arr = new int[] {1, 3, 4, 2, 5};
    System.out.println(smallSum(arr));
  }

  public static int smallSum(int[] arr) {
    if (arr == null) {
      return 0;
    }
    return process(arr, 0, arr.length - 1);
  }

  public static int process(int[] arr, int left, int right) {
    if (left == right) {
      return 0;
    }
    int mid = left + ((right - left) >> 1);//记得打括号 这个优先级bug是真的烦人
    return
        process(arr, left, mid)
            + process(arr, mid + 1, right)
            + merge(arr, left, mid + 1, right);
  }

  public static int merge(int[] arr, int leftPtr, int rightPtr, int rightEdge) {
    int i = leftPtr;
    int j = rightPtr;
    int k = 0;
    int[] help = new int[rightEdge - leftPtr + 1];
    int sum = 0;
    while (i < rightPtr && j <= rightEdge) {
      if (arr[i] < arr[j]) {
        sum += arr[i] * (rightEdge - j + 1); //如果左小于右 左边的数要记录rightEdge-j+1次
      }
      help[k++] = arr[i] < arr[j] ? arr[i++] : arr[j++];
    }
    while (i < rightPtr) {
      help[k++] = arr[i++];
    }
    while (j <= rightEdge) {
      help[k++] = arr[j++];
    }
    for (int elem : help
    ) {
      arr[leftPtr++] = elem;
    }
    return sum;
  }
}
