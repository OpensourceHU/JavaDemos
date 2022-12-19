package leetcode.editor.cn;

class rotateImage {
  //2022-12-18 11:31:05
  //旋转图像
  //编号：[48]

  public static void main(String[] args) {
    Solution solution = new rotateImage().new Solution();
    // TO TEST
  }

  //leetcode submit region begin(Prohibit modification and deletion)
  class Solution {

    void swap(int[][] matrix, int i, int j, int l, int m) {
      int tmp = matrix[i][j];
      matrix[i][j] = matrix[l][m];
      matrix[l][m] = tmp;
    }

    public void rotate(int[][] matrix) {
      int N = matrix.length;
      int[][] ans = new int[N][N];
      for (int i = 0; i < matrix.length; i++) {
        for (int j = 0; j < matrix.length; j++) {
          ans[j][i] = matrix[i][j];
        }
      }
      for (int i = 0; i < N; i++) {
        for (int j = 0; j < (int) Math.ceil(N / 2); j++) {
          swap(ans, i, j, i, N - 1 - j);
        }
      }
      for (int i = 0; i < matrix.length; i++) {
        for (int j = 0; j < matrix.length; j++) {
          matrix[i][j] = ans[i][j];
        }
      }
    }
  }
//leetcode submit region end(Prohibit modification and deletion)

}