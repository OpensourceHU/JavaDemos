//给定一个未排序的整数数组 nums ，找出数字连续的最长序列（不要求序列元素在原数组中连续）的长度。 
//
// 请你设计并实现时间复杂度为 O(n) 的算法解决此问题。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [100,4,200,1,3,2]
//输出：4
//解释：最长数字连续序列是 [1, 2, 3, 4]。它的长度为 4。 
//
// 示例 2： 
//
// 
//输入：nums = [0,3,7,2,5,8,4,6,0,1]
//输出：9
// 
//
// 
//
// 提示： 
//
// 
// 0 <= nums.length <= 105 
// -109 <= nums[i] <= 109 
// 
// Related Topics 并查集 数组 哈希表 
// 👍 1184 👎 0

package leetcode.leetcode.editor.cn;

import java.util.*;

public class LongestConsecutiveSequence {
    public static void main(String[] args) {
        Solution solution = new LongestConsecutiveSequence().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        HashMap<Integer, Integer> map;
        HashSet<Integer> vis = new HashSet<>();

        void fresh(int i, int val) {
            map.put(i, val);
            if (map.containsKey(i - 1) && !vis.contains(i - 1)) {
                vis.add(i - 1);
                fresh(i - 1, val);
                vis.remove(i - 1);
            }
            if (map.containsKey(i + 1) && !vis.contains(i + 1)) {
                vis.add(i + 1);
                fresh(i + 1, val);
                vis.remove(i + 1);
            }
        }

        public int longestConsecutive(int[] nums) {
            if (nums == null || nums.length == 0) return 0;
            if (nums.length == 1) return 1;
            Arrays.sort(nums);
            int cnt = 1;
            int ans = 0;
            for (int i = 1; i < nums.length; i++) {
                if (nums[i] == nums[i - 1] + 1) {
                    cnt++;
                    ans = Math.max(ans, cnt);
                }
                if (nums[i] > nums[i - 1] + 1) cnt = 1;
            }
            List<Integer> list = new LinkedList<>();
            return Math.max(ans, cnt);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}