//给你一个整数数组 nums ，请你求出乘积为正数的最长子数组的长度。 
//
// 一个数组的子数组是由原数组中零个或者更多个连续数字组成的数组。 
//
// 请你返回乘积为正数的最长子数组长度。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,-2,-3,4]
//输出：4
//解释：数组本身乘积就是正数，值为 24 。
// 
//
// 示例 2： 
//
// 
//输入：nums = [0,1,-2,-3,-4]
//输出：3
//解释：最长乘积为正数的子数组为 [1,-2,-3] ，乘积为 6 。
//注意，我们不能把 0 也包括到子数组中，因为这样乘积为 0 ，不是正数。 
//
// 示例 3： 
//
// 
//输入：nums = [-1,-2,-3,0,1]
//输出：2
//解释：乘积为正数的最长子数组是 [-1,-2] 或者 [-2,-3] 。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 10^5 
// -10^9 <= nums[i] <= 10^9 
// 
//
// 
// Related Topics 贪心 数组 动态规划 
// 👍 127 👎 0

package leetcode.editor.cn;

public class MaximumLengthOfSubarrayWithPositiveProduct {
  public static void main(String[] args) {
    Solution solution = new MaximumLengthOfSubarrayWithPositiveProduct().new Solution();
  }

  //leetcode submit region begin(Prohibit modification and deletion)
  class Solution {
    public int getMaxLen(int[] nums) {
      if (nums.length == 0 || nums == null) {
        return 0;
      }
      int[] pos = new int[nums.length];
      int[] neg = new int[nums.length];
      int ans = 0;
      pos[0] = nums[0] > 0 ? 1 : 0;
      neg[0] = nums[0] < 0 ? 1 : 0;
      for (int i = 1; i < nums.length; i++) {
        if (nums[i] > 0) {
          pos[i] = pos[i - 1] + 1;
          neg[i] = neg[i - 1] == 0 ? 0 : neg[i - 1] + 1;
        } else if (nums[i] < 0) {
          pos[i] = neg[i - 1] == 0 ? 0 : neg[i - 1] + 1;
          neg[i] = pos[i - 1] + 1;
        } else {
          pos[i] = 0;
          neg[i] = 0;
        }
      }
      int mx = 0;
      for (int i = 0; i < pos.length; i++) {
        mx = Math.max(mx, pos[i]);
      }
      return mx;
    }
  }
//leetcode submit region end(Prohibit modification and deletion)

}