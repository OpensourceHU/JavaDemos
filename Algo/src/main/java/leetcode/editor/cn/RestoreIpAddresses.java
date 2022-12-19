//有效 IP 地址 正好由四个整数（每个整数位于 0 到 255 之间组成，且不能含有前导 0），整数之间用 '.' 分隔。 
//
// 
// 例如："0.1.2.201" 和 "192.168.1.1" 是 有效 IP 地址，但是 "0.011.255.245"、"192.168.1.312" 
//和 "192.168@1.1" 是 无效 IP 地址。 
// 
//
// 给定一个只包含数字的字符串 s ，用以表示一个 IP 地址，返回所有可能的有效 IP 地址，这些地址可以通过在 s 中插入 '.' 来形成。你 不能 重新
//排序或删除 s 中的任何数字。你可以按 任何 顺序返回答案。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "25525511135"
//输出：["255.255.11.135","255.255.111.35"]
// 
//
// 示例 2： 
//
// 
//输入：s = "0000"
//输出：["0.0.0.0"]
// 
//
// 示例 3： 
//
// 
//输入：s = "101023"
//输出：["1.0.10.23","1.0.102.3","10.1.0.23","10.10.2.3","101.0.2.3"]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 20 
// s 仅由数字组成 
// 
//
// Related Topics 字符串 回溯 👍 1091 👎 0

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class RestoreIpAddresses {
  public static void main(String[] args) {
    Solution solution = new RestoreIpAddresses().new Solution();
    System.out.println(solution.restoreIpAddresses("0279245587303"));
  }

  //leetcode submit region begin(Prohibit modification and deletion)
  class Solution {
    List<String> ret = new ArrayList<>();

    public List<String> restoreIpAddresses(String s) {
      char[] arr = s.toCharArray();
      solve(s, "", 0, 0);
      return ret.stream().distinct().collect(Collectors.toList());
    }

    boolean check(String s) {
      if (s.length() >= 1 && s.length() <= 3) {
        if (s.length() == 1 && s.charAt(0) == '0') {
          return true;
        }
        return s.charAt(0) != '0' && Integer.valueOf(s) <= 255;
      }
      return false;
    }

    void solve(String s, String ans, int idx, int cnt) {
      if (idx >= s.length()) {
        return;
      }
      if (cnt == 3) {
        String least = s.substring(idx);
        if (check(least)) {
          ans += least;
          ret.add(ans);
          return;
        }
        return;
      }
      String s1 = idx + 1 < s.length() ? s.substring(idx, idx + 1) : "";
      String s2 = idx + 2 < s.length() ? s.substring(idx, idx + 2) : "";
      String s3 = idx + 3 < s.length() ? s.substring(idx, idx + 3) : "";

      if (check(s1)) {
        solve(s, ans + s1 + ".", idx + 1, cnt + 1);
      }
      if (check(s2)) {
        solve(s, ans + s2 + ".", idx + 2, cnt + 1);
      }
      if (check(s3)) {
        solve(s, ans + s3 + ".", idx + 3, cnt + 1);
      }

    }
  }
//leetcode submit region end(Prohibit modification and deletion)

}