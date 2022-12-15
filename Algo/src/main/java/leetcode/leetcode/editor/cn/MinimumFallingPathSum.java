//给你一个 n x n 的 方形 整数数组 matrix ，请你找出并返回通过 matrix 的下降路径 的 最小和 。 
//
// 下降路径 可以从第一行中的任何元素开始，并从每一行中选择一个元素。在下一行选择的元素和当前行所选元素最多相隔一列（即位于正下方或者沿对角线向左或者向右的第
//一个元素）。具体来说，位置 (row, col) 的下一个元素应当是 (row + 1, col - 1)、(row + 1, col) 或者 (row + 1
//, col + 1) 。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：matrix = [[2,1,3],[6,5,4],[7,8,9]]
//输出：13
//解释：如图所示，为和最小的两条下降路径
// 
//
// 示例 2： 
//
// 
//
// 
//输入：matrix = [[-19,57],[-40,-5]]
//输出：-59
//解释：如图所示，为和最小的下降路径
// 
//
// 
//
// 提示： 
//
// 
// n == matrix.length == matrix[i].length 
// 1 <= n <= 100 
// -100 <= matrix[i][j] <= 100 
// 
// Related Topics 数组 动态规划 矩阵 
// 👍 153 👎 0

package leetcode.leetcode.editor.cn;

public class MinimumFallingPathSum {
    public static void main(String[] args) {
        Solution solution = new MinimumFallingPathSum().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        int n, m;
        int[][] dp;

        int dfs(int i, int j, int[][] matrix) {
            if (j < 0 || j >= m) {
                return Integer.MAX_VALUE;
            }
            if (i == n - 1) {
                return matrix[i][j];
            }
            if (dp[i][j] == 0)
                return dp[i][j] = matrix[i][j] + Math.min(Math.min(dfs(i + 1, j, matrix), dfs(i + 1, j - 1,
                        matrix)), dfs(i + 1, j + 1, matrix));
            else return dp[i][j];
        }


        public int minFallingPathSum(int[][] matrix) {
            n = matrix.length;
            m = matrix[0].length;
            dp = new int[n][m];
            int ans = Integer.MAX_VALUE;
            for (int i = 0; i < m; i++) {
                ans = Math.min(ans, dfs(0, i, matrix));
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}