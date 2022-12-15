//给你一个 m x n 的矩阵 mat 和一个整数 k ，请你返回一个矩阵 answer ，其中每个 answer[i][j] 是所有满足下述条件的元素 ma
//t[r][c] 的和： 
//
// 
// i - k <= r <= i + k, 
// j - k <= c <= j + k 且 
// (r, c) 在矩阵内。 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：mat = [[1,2,3],[4,5,6],[7,8,9]], k = 1
//输出：[[12,21,16],[27,45,33],[24,39,28]]
// 
//
// 示例 2： 
//
// 
//输入：mat = [[1,2,3],[4,5,6],[7,8,9]], k = 2
//输出：[[45,45,45],[45,45,45],[45,45,45]]
// 
//
// 
//
// 提示： 
//
// 
// m == mat.length 
// n == mat[i].length 
// 1 <= m, n, k <= 100 
// 1 <= mat[i][j] <= 100 
// 
// Related Topics 数组 矩阵 前缀和 
// 👍 131 👎 0

package leetcode.leetcode.editor.cn;

public class MatrixBlockSum {
//    public static void main(String[] args) {
//        Solution.matrixBlockSum(new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}}, 1);
//    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public int[][] matrixBlockSum(int[][] mat, int k) {
            int n = mat.length;
            int m = mat[0].length;

            int[][] prefix = new int[n + 1][m + 1];
            prefix[1][1] = mat[0][0];
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= m; j++) {
                    prefix[i][j] =
                            prefix[i - 1][j] + prefix[i][j - 1] - prefix[i - 1][j - 1] + mat[i - 1][j - 1];

                }
            }
            //TMLGB的  细节和边界怎么这么多
            int[][] ans = new int[n][m];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {

                    int row1 = Math.max(i - k, 0);
                    int row2 = Math.min(i + k, n - 1);
                    int col1 = Math.max(j - k, 0);
                    int col2 = Math.min(j + k, m - 1);
                    //      System.out.println(row1+" "+row2+" "+col1+" "+col2+" ");
                    ans[i][j] = prefix[row1][col1] + prefix[row2 + 1][col2 + 1]
                            - prefix[row2 + 1][col1] - prefix[row1][col2 + 1];
                    System.out.print(ans[i][j] + " ");
                }
                System.out.println();
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}