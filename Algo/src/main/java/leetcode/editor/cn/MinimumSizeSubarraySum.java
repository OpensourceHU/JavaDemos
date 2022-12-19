//给定一个含有 n 个正整数的数组和一个正整数 s ，找出该数组中满足其和 ≥ s 的长度最小的 连续 子数组，并返回其长度。如果不存在符合条件的子数组，返回
// 0。 
//
// 
//
// 示例： 
//
// 输入：s = 7, nums = [2,3,1,2,4,3]
//输出：2
//解释：子数组 [4,3] 是该条件下的长度最小的子数组。
// 
//
// 
//
// 进阶： 
//
// 
// 如果你已经完成了 O(n) 时间复杂度的解法, 请尝试 O(n log n) 时间复杂度的解法。 
// 
// Related Topics 数组 双指针 二分查找 
// 👍 466 👎 0

package leetcode.editor.cn;

public class MinimumSizeSubarraySum {
  public static void main(String[] args) {
    Solution solution = new MinimumSizeSubarraySum().new Solution();
    System.out.println(solution.minSubArrayLen(7, new int[] {2, 3, 1, 2, 4, 3}));
  }

  //leetcode submit region begin(Prohibit modification and deletion)
  class Solution {
//        public int minSubArrayLen(int s, int[] nums) {
//            if (nums.length == 0) return 0;
//            int L = 0;
//            int R = 0;
//            int ans = Integer.MAX_VALUE;
//            int cur = 0;
//            while (R < nums.length) {
//                cur += nums[R];
//                while (cur >= s) {
//                    ans = Math.min(ans, R - L + 1);
//                    cur -= nums[L];
//                    L++;
//                }
//                R++;
//            }
//            return ans==Integer.MAX_VALUE?0:ans;
//        }

    public int minSubArrayLen(int s, int[] nums) {
      if (nums.length == 0) {
        return 0;
      }
      int L = 0;
      int cur = 0;
      int ans = Integer.MAX_VALUE;
      for (int i = 0; i < nums.length; i++) {
        cur += nums[i];
        while (cur >= s) {
          //一旦要开始缩小范围寻找最优解  就表明当前结果是可行的  所以先更新答案
          ans = Math.min(ans, i - L + 1);
          //左边界左移  在下一轮中判断是否可行
          cur -= nums[L];
          L++;
        }
      }
      return ans == Integer.MAX_VALUE ? 0 : ans;
    }


  }
//leetcode submit region end(Prohibit modification and deletion)

}