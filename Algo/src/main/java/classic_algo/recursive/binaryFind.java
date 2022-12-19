package classic_algo.recursive;

/**
 * @author OpensourceHU
 * @version V1.0
 * @Description
 * @date 2020/11/12 0012 21:59
 */
public class binaryFind {
  public static void main(String[] args) {
    int[] arr = new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
    System.out.println(findX(arr, -11));

  }

  public static int findX(int[] arr, int x) {
    int i = 0;
    int j = arr.length - 1;
    while (i <= j) {
      int mid = i + (j - i) >> 2;
      if (mid == i) {
        break;
      }
      if (arr[mid] < x) {
        i = mid;
        continue;
      } else if (arr[mid] > x) {
        j = mid;
        continue;
      } else {
        return mid;
      }
    }
    return -1;
  }
}
