package classic_algo;

/**
 * @author OpensourceHU
 * @version V1.0
 * @Description KMP算法
 * @date 2020/5/28 0028 15:50
 */
public class KMP {
  public static int KMP(char[] ori, char[] match) {
    int[] next = nextArray(match);
    int x = 0;
    int y = 0;
    while (x < ori.length && y < match.length) {
      if (ori[x] == match[y]) {
        x++;
        y++;
      } else if (next[y] == -1) {
        x++;
      } else {
        y = next[y];
      }
    }
    return y == match.length ? (x - y) + 1 : -1;
  }

  /**
   * 求next数组  时间复杂度O(n)
   *
   * @param arr
   * @return
   */
  public static int[] nextArray(char[] arr) {
    if (arr.length == 1) {
      return new int[] {-1};
    }
    int[] ret = new int[arr.length];
    ret[0] = -1;
    ret[1] = 0;
    int cur = 0;
    int k = 2;
    while (k < arr.length) {
      if (arr[k - 1] == arr[cur]) {
        ret[k++] = cur++;
      } else if (cur > 0) {
        cur = ret[cur];
      } else {
        ret[k++] = 0;
      }
    }
    return ret;
  }

  public static void main(String[] args) {
    System.out.println(KMP("OpensourceHU".toCharArray(), "HU".toCharArray()));
  }

}
