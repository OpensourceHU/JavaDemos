//数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 3
//输出：["((()))","(()())","(())()","()(())","()()()"]
// 
//
// 示例 2： 
//
// 
//输入：n = 1
//输出：["()"]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 8 
// 
//
// Related Topics 字符串 动态规划 回溯 👍 2987 👎 0

package leetcode.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {
    public static void main(String[] args) {
        Solution solution = new GenerateParentheses().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        List<String> list = new ArrayList<>();

        void dfs(int L, int R, String ans) {
            if (L == 0) {
                for (int i = 0; i < R; i++) {
                    ans += ")";
                }
                list.add(ans);
                return;
            }
            if (R > L) {
                dfs(L, R - 1, ans + ")");
                dfs(L - 1, R, ans + "(");
            }
            if (R == L) {
                dfs(L - 1, R, ans + "(");
            }
            if (R < L) {
                dfs(L, R - 1, ans + ")");
            }
        }

        public List<String> generateParenthesis(int n) {
            dfs(n, n, "");
            list.sort(String::compareTo);
            return list;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}