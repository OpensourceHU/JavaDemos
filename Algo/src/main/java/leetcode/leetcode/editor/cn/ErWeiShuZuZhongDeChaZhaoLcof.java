//在一个 n * m 的二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。请完成一个高效的函数，输入这样的一个二维数组和一个
//整数，判断数组中是否含有该整数。 
//
// 
//
// 示例: 
//
// 现有矩阵 matrix 如下： 
//
// 
//[
//  [1,   4,  7, 11, 15],
//  [2,   5,  8, 12, 19],
//  [3,   6,  9, 16, 22],
//  [10, 13, 14, 17, 24],
//  [18, 21, 23, 26, 30]
//]
// 
//
// 给定 target = 5，返回 true。 
//
// 给定 target = 20，返回 false。 
//
// 
//
// 限制： 
//
// 0 <= n <= 1000 
//
// 0 <= m <= 1000 
//
// 
//
// 注意：本题与主站 240 题相同：https://leetcode-cn.com/problems/search-a-2d-matrix-ii/ 
// Related Topics 数组 双指针 
// 👍 278 👎 0

package leetcode.leetcode.editor.cn;

public class ErWeiShuZuZhongDeChaZhaoLcof {
    public static void main(String[] args) {
        Solution solution = new ErWeiShuZuZhongDeChaZhaoLcof().new Solution();
        System.out.println(solution.findNumberIn2DArray(new int[1][0], 1));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        int m, n;
        boolean[][] books;

        public boolean findNumberIn2DArray(int[][] matrix, int target) {
            if (matrix == null) return false;
            m = matrix.length;
            n = matrix[0].length;
            if (m == 0 || n == 0) return false;
            books = new boolean[m][n];
            try {
                return dfs(target, 0, n - 1, matrix);
            } catch (Exception e) {
                return false;
            }
        }

        boolean isValid(int i, int j) {
            return (i >= 0 && i < m && j >= 0 && j < n && books[i][j] == false);
        }

        boolean dfs(int target, int i, int j, int[][] matrix) {
            int cur = matrix[i][j];
            if (cur == target)
                return true;
            boolean ret = false;
            if (cur < target) {
                // to the right or go down
                if (isValid(i, j + 1)) {
                    books[i][j + 1] = true;
                    ret |= dfs(target, i, j + 1, matrix);
                    books[i][j + 1] = false;
                }
                if (isValid(i + 1, j)) {
                    books[i + 1][j] = true;
                    ret |= dfs(target, i + 1, j, matrix);
                    books[i + 1][j] = false;
                }
                if (ret == true)
                    return true;
            } else {
                if (isValid(i, j - 1)) {
                    books[i][j - 1] = true;
                    ret |= dfs(target, i, j - 1, matrix);
                    books[i][j - 1] = false;
                }
                if (isValid(i - 1, j)) {
                    books[i - 1][j] = true;
                    ret |= dfs(target, i - 1, j, matrix);
                    books[i - 1][j] = false;
                }
            }
            return ret;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}