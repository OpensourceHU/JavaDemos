package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

class groupAnagrams {
  //2022-12-18 11:43:47
  //字母异位词分组
  //编号：[49]

  public static void main(String[] args) {
    Solution solution = new groupAnagrams().new Solution();
    // TO TEST
  }

  //leetcode submit region begin(Prohibit modification and deletion)
  class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
      if (strs == null || strs.length == 0) {
        return new ArrayList<>();
      }
      HashMap<String, ArrayList<String>> ans = new HashMap<>();
      Arrays.stream(strs).
          forEach((str) -> {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String sortStr = String.copyValueOf(chars);
            if (ans.containsKey(sortStr)) {
              ans.get(sortStr).add(str);
            } else {
              ArrayList<String> newLis = new ArrayList<>();
              newLis.add(str);
              ans.put(sortStr, newLis);
            }
          });
      return ans.values().stream().collect(Collectors.toList());
    }
  }
//leetcode submit region end(Prohibit modification and deletion)

}