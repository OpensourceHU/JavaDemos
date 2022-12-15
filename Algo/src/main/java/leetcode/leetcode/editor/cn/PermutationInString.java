//给定两个字符串 s1 和 s2，写一个函数来判断 s2 是否包含 s1 的排列。 
//
// 换句话说，第一个字符串的排列之一是第二个字符串的子串。 
//
// 示例1: 
//
// 
//输入: s1 = "ab" s2 = "eidbaooo"
//输出: True
//解释: s2 包含 s1 的排列之一 ("ba").
// 
//
// 
//
// 示例2: 
//
// 
//输入: s1= "ab" s2 = "eidboaoo"
//输出: False
// 
//
// 
//
// 注意： 
//
// 
// 输入的字符串只包含小写字母 
// 两个字符串的长度都在 [1, 10,000] 之间 
// 
// Related Topics 双指针 Sliding Window 
// 👍 183 👎 0

package leetcode.leetcode.editor.cn;


import java.io.StringReader;
import java.util.*;

public class PermutationInString {
    public static void main(String[] args) {
        Solution solution = new PermutationInString().new Solution();
        System.out.println(solution.checkInclusion("adc", "dcda"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
//        /**
//         * 第一次的失败尝试
//         * @param s1
//         * @param s2
//         * @return
//         */
//        public boolean checkInclusion(String s1, String s2) {
//            if (s2.length() == 0) return false;
//            HashMap<Character, Integer> needs = new HashMap<>();
//            HashMap<Character, Integer> cur = new HashMap<>();
//            char[] chars = s1.toCharArray();
//            for (char c :
//                    chars) {
//                if (!needs.containsKey(c)) {
//                    needs.put(c, 1);
//                } else needs.put(c, needs.get(c) + 1);
//            }//获取词频
//
//            char[] list = s2.toCharArray();
//            for (int i = 0; i < list.length; i++) {
//                //如果是组合内的字母 更新cur表
//                if (needs.containsKey(list[i])) {
//                    if (!cur.containsKey(list[i])) {
//                        cur.put(list[i], 1);
//                    } else cur.put(list[i], needs.get(list[i]) + 1);
//                } else {
//                    //如果不是组合内的字母  判断一次
//                    boolean isCombination = isCombination(needs, cur);
//                    if(isCombination==true){
//                        return true;
//                    }else{
//                        cur.clear();
//                    }
//                }
//            }
//            return false;
//
//        }
//
//        public boolean isCombination(HashMap<Character, Integer> needs, HashMap<Character, Integer> cur) {
//
//            if (needs.size() != cur.size()) return false;
//            //长度相同  比较每个字母的词频
//            Set<Character> keySet = needs.keySet();
//            boolean flag = true;
//            for (char c : keySet
//            ) {
//                if (needs.get(c) != cur.get(c)) {
//                    flag = false;
//                    break;
//                }
//            }
//            return flag;
//        }


//        /**
//         * 成功通过  但是time beat只有5%
//         * @param s1
//         * @param s2
//         * @return
//         */
//        public boolean checkInclusion(String s1, String s2) {
//            if (s2.length() == 0 || s1.length() > s2.length()) return false;
//            HashMap<Character, Integer> needs = new HashMap<>();
//            char[] chars = s1.toCharArray();
//            for (char c :
//                    chars) {
//                if (!needs.containsKey(c)) {
//                    needs.put(c, 1);
//                } else needs.put(c, needs.get(c) + 1);
//            }//获取needs词频
//
//            char[] list = s2.toCharArray();
//            //窗口大小固定为s1的长度
//            int L = 0;
//            int R = s1.length() - 1;
//            int windowLen = R - L + 1;
//            while (R < s2.length()) {
//                //如果右边界踩到的是组合内的数  判断一下
//                if (needs.containsKey(list[R])) {
//                    boolean isCombination = isCombination(Arrays.copyOfRange(list, L, R + 1), needs);
//                    if (isCombination == true) return true;
//                    L++;
//                    R++;
//                } else {
//                    //没踩到组合内的数 直接划过一个窗口的长度
//                    L += windowLen;
//                    R+=windowLen;
//                }
//
//            }
//            return false;
//
//
//        }
//
//        public boolean isCombination(char[] subArray, HashMap<Character, Integer> needs) {
//            HashMap<Character, Integer> cur = new HashMap<>();
//            for (int i = 0; i < subArray.length; i++) {
//                if (!cur.containsKey(subArray[i])) {
//                    cur.put(subArray[i], 1);
//                } else cur.put(subArray[i], cur.get(subArray[i]) + 1);
//            }//获取子数组的词频
//
//            Set<Character> keySet = needs.keySet();
//            boolean flag = true;
//            for (char c : keySet
//            ) {
//                if (cur.get(c) == null || needs.get(c).intValue() != cur.get(c).intValue()) {
//                    flag = false;
//                    break;
//                }
//            }
//            return flag;
//        }

        /**
         * 不用哈希表 改用数组存储信息
         *
         * @param s1
         * @param s2
         * @return
         */
        public boolean checkInclusion(String s1, String s2) {
            if (s1.length() > s2.length()) return false;
            int[] needs = new int[26];
            int[] cur = new int[26];
            //更新needs数组  读取cur
            for (int i = 0; i < s1.length(); i++) {
                needs[s1.charAt(i) - 'a']++;
                cur[s2.charAt(i) - 'a']++;
            }
            //i为左边界
            for (int i = 0; i < s2.length() - s1.length(); i++) {
                if (Arrays.equals(cur, needs))
                    return true;
                //比较完成后要更新窗口
                cur[s2.charAt(i) - 'a']--;
                cur[s2.charAt(i + s1.length()) - 'a']++;
            }
            return Arrays.equals(cur, needs);
        }


    }
//leetcode submit region end(Prohibit modification and deletion)

}