//给定一个 m x n 二维字符网格 board 和一个字符串单词 word 。如果 word 存在于网格中，返回 true ；否则，返回 false 。 
//
// 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。 
//
// 
//
// 示例 1： 
// 
// 
//输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = 
//"ABCCED"
//输出：true
// 
//
// 示例 2： 
// 
// 
//输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = 
//"SEE"
//输出：true
// 
//
// 示例 3： 
// 
// 
//输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = 
//"ABCB"
//输出：false
// 
//
// 
//
// 提示： 
//
// 
// m == board.length 
// n = board[i].length 
// 1 <= m, n <= 6 
// 1 <= word.length <= 15 
// board 和 word 仅由大小写英文字母组成 
// 
//
// 
//
// 进阶：你可以使用搜索剪枝的技术来优化解决方案，使其在 board 更大的情况下可以更快解决问题？ 
//
// Related Topics 数组 回溯 矩阵 👍 1492 👎 0

package leetcode.leetcode.editor.cn;

public class WordSearch {
    public static void main(String[] args) {
        Solution solution = new WordSearch().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        char[][] arr;
        boolean[][] vis;

        boolean dfs(int i, int j, String s, int idx) {
            // out of map
            if (!(i >= 0 && i < arr.length && j >= 0 && j < arr[0].length) || vis[i][j]) return false;
            //mark
            vis[i][j] = true;
            // end
            if (idx == s.length() - 1) {
                //undo mark when return
                vis[i][j] = false;
                return arr[i][j] == s.charAt(idx);
            }
            //search
            if (arr[i][j] == s.charAt(idx)) {
                boolean ans = dfs(i + 1, j, s, idx + 1) ||
                        dfs(i - 1, j, s, idx + 1) ||
                        dfs(i, j + 1, s, idx + 1) ||
                        dfs(i, j - 1, s, idx + 1);
                vis[i][j] = false;
                return ans;
            }
            //undo mark when return
            vis[i][j] = false;
            return false;
        }

        public boolean exist(char[][] board, String word) {
            if (board == null) return false;
            arr = board;
            int n = board.length;
            int m = board[0].length;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    vis = new boolean[n][m];
                    if (dfs(i, j, word, 0)) return true;
                }
            }
            return false;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}