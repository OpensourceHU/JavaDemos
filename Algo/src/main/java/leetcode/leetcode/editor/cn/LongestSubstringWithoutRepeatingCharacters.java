//给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。 
//
// 示例 1: 
//
// 输入: "abcabcbb"
//输出: 3 
//解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
// 
//
// 示例 2: 
//
// 输入: "bbbbb"
//输出: 1
//解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
// 
//
// 示例 3: 
//
// 输入: "pwwkew"
//输出: 3
//解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
//     请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
// 
// Related Topics 哈希表 双指针 字符串 Sliding Window 
// 👍 4410 👎 0

package leetcode.leetcode.editor.cn;

import java.util.HashMap;
import java.util.HashSet;

public class LongestSubstringWithoutRepeatingCharacters {
    public static void main(String[] args) {
        Solution solution = new LongestSubstringWithoutRepeatingCharacters().new Solution();

        String str = "pwwkew";
        System.out.println(solution.lengthOfLongestSubstring(str));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
//        public int lengthOfLongestSubstring(String s) {
//            if (s.length() == 0) return 0;
//            char[] list = s.toCharArray();
//            int L = 0;
//            int R = -1;
//            int ans = Integer.MIN_VALUE;
//            HashSet<Character> set = new HashSet<>();
//            while (R < s.length()) {
//                //右指针右移  直到出现重复
//                while (++R < s.length() && !set.contains(list[R])) {
//                    set.add(list[R]);
//                }
//                //此时右指针指到的位置 刚好是重复的字符  最大子串只可能在这个位置产生 更新答案
//                ans = Math.max(ans, R - L);
//                //左指针左移  收缩范围  注意右指针位置可能会越界  要记得判断
//                while (L < R && R < s.length()) {
//                    //若左指针来到了重复的字符处 再往后一格 跳出
//                    if (list[L] == list[R]) {
//                        L++;
//                        break;
//                    }
//                    //若没有来到重复字符处  将左指针指向的字符删掉 再左移
//                    set.remove(list[L]);
//                    L++;
//                }
//            }
//            return ans;
//        }

        public int lengthOfLongestSubstring(String s) {
            if (s == null || s.equals("")) return 0;
            char[] arr = s.toCharArray();
            HashSet<Character> set = new HashSet<>();
            for (int len = 100; len >= 1; len--) {
                for (int L = 0; L + len - 1 < arr.length; L++) {
                    int R = L + len - 1;
                    boolean flag = true;
                    set.clear();
                    for (int i = L; i <= R; i++) {
                        if (set.contains(arr[i])) {
                            flag = false;
                            break;
                        } else {
                            set.add(arr[i]);
                        }
                    }
                    if (flag) {
                        return len;
                    } else {
                        continue;
                    }
                }
            }
            return 1;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}