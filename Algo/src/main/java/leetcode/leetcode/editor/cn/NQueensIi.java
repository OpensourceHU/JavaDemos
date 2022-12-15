//n 皇后问题 研究的是如何将 n 个皇后放置在 n × n 的棋盘上，并且使皇后彼此之间不能相互攻击。 
//
// 给你一个整数 n ，返回 n 皇后问题 不同的解决方案的数量。 
//
// 
//
// 
// 
// 示例 1： 
// 
// 
//输入：n = 4
//输出：2
//解释：如上图所示，4 皇后问题存在两个不同的解法。
// 
// 
// 
//
// 示例 2： 
//
// 
//输入：n = 1
//输出：1
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 9 
// 
//
// 👍 405 👎 0

package leetcode.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

public class NQueensIi {
    public static void main(String[] args) {
        Solution solution = new NQueensIi().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        boolean[][] vis;
        int N;
        List<List<String>> ret = new ArrayList<>();

        boolean check(int i, int j) {
            if (!(i >= 0 && i < N && j >= 0 && j < N)) return false;
            int n = i;
            int m = j;
            while (n >= 0) {
                if (vis[n][m] == true) return false;
                n--;
            }
            n = i;
            m = j;
            while (n >= 0 && m >= 0) {
                if (vis[n][m] == true) return false;
                n--;
                m--;
            }
            n = i;
            m = j;
            while (n >= 0 && m < N) {
                if (vis[n][m] == true) return false;
                n--;
                m++;
            }
            return true;
        }

        void dfs(int i, ArrayList<Integer> ans) {
            if (i == N) {
                List<String> cur = new ArrayList<>();
                for (int j = 0; j < ans.size(); j++) {
                    String lay = "";
                    for (int k = 0; k < N; k++) {
                        if (k != ans.get(j))
                            lay += ".";
                        else lay += "Q";
                    }
                    cur.add(lay);
                }
                ret.add(cur);
            }
            for (int j = 0; j < N; j++) {
                if (check(i, j)) {
                    vis[i][j] = true;
                    ans.add(j);
                    dfs(i + 1, ans);
                    ans.remove(ans.size() - 1);
                    vis[i][j] = false;
                }
            }
        }

        public int totalNQueens(int n) {
            N = n;
            vis = new boolean[n][n];
            dfs(0, new ArrayList<>());
            return ret.size();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}