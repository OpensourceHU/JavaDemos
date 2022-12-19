//给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：height = [0,1,0,2,1,0,1,3,2,1,2,1]
//输出：6
//解释：上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。 
// 
//
// 示例 2： 
//
// 
//输入：height = [4,2,0,3,2,5]
//输出：9
// 
//
// 
//
// 提示： 
//
// 
// n == height.length 
// 1 <= n <= 2 * 104 
// 0 <= height[i] <= 105 
// 
// Related Topics 栈 数组 双指针 动态规划 单调栈 
// 👍 3280 👎 0

package leetcode.editor.cn;

public class TrappingRainWater {
  public static void main(String[] args) {
    Solution solution = new TrappingRainWater().new Solution();
  }

  //leetcode submit region begin(Prohibit modification and deletion)
  class Solution {
    public int trap(int[] height) {
      int[] dp1 = new int[height.length];
      int[] dp2 = new int[height.length];
      dp1[0] = height[0];
      for (int i = 1; i < height.length; i++) {
        dp1[i] = Math.max(height[i], dp1[i - 1]);
      }
      dp2[height.length - 1] = height[height.length - 1];
      for (int i = height.length - 2; i >= 0; i--) {
        dp2[i] = Math.max(dp2[i + 1], height[i]);
      }
      int[] dp3 = new int[height.length];
      for (int i = 0; i < height.length; i++) {
        dp3[i] = Math.min(dp1[i], dp2[i]);
        System.out.print(dp3[i] + " ");
      }
      int ans = 0;
      for (int i = 0; i < height.length; i++) {
        ans += dp3[i] - height[i];
      }
      return ans;
    }
  }
//leetcode submit region end(Prohibit modification and deletion)

}