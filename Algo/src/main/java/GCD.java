/**
 * @author OpensourceHU
 * @version V1.0
 * @Description 欧几里得算法
 * @date 2020/10/24 0024 10:17
 */
public class GCD {
  /**
   * 物联网1902 201902182 胡开源
   *
   * @param m
   * @param n
   * @return
   */

  public static int GCDIterator(int m, int n) {
    if (m < n) {
      GCDIterator(n, m);
    }
    int div = m;
    int dividend = n;
    int remainder = Integer.MAX_VALUE;
    while (true) {
      remainder = div % dividend;
      if (remainder == 0) {
        break;
      }
      div = dividend;
      dividend = remainder;
    }
    return dividend;
  }

  /**
   * 物联网1902 201902182 胡开源
   *
   * @param m
   * @param n
   * @return
   */
  public static int GCDRecursion(int m, int n) {
    if (m < n) {
      return GCDRecursion(n, m);
    }
    int mod = m % n;
    if (mod == 0) {
      return n;
    } else {
      return GCDRecursion(n, mod);
    }
  }

  public static int[][] MatrixMultiply(int[][] a, int[][] b) {
    if (a[0].length != b.length) {
      System.err.println("输入矩阵无法相乘");
      return null;
    }
    int[][] ans = new int[a.length][b[0].length];
    for (int i = 0; i < a.length; i++) {
      // i为行数  j为列数
      for (int j = 0; j < b[0].length; j++) {
        int cur = 0;
        for (int k = 0; k < a[0].length; k++) {
          cur += a[i][k] * b[k][j];
        }
        ans[i][j] = cur;
      }
    }
    return ans;
  }


  public static void main(String[] args) {
    int[][] a = {{1, 7}, {2, 4}};
    int[][] b = {{3, 3}, {5, 2}};
    int[][] ans = MatrixMultiply(a, b);
    for (int i = 0; i < ans[0].length; i++) {
      for (int j = 0; j < ans.length; j++) {
        System.out.print(ans[i][j] + "  ");
      }
      System.out.println();
    }
  }
}
