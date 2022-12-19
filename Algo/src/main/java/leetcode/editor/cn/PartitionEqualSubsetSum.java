//给定一个只包含正整数的非空数组。是否可以将这个数组分割成两个子集，使得两个子集的元素和相等。 
//
// 注意: 
//
// 
// 每个数组中的元素不会超过 100 
// 数组的大小不会超过 200 
// 
//
// 示例 1: 
//
// 输入: [1, 5, 11, 5]
//
//输出: true
//
//解释: 数组可以分割成 [1, 5, 5] 和 [11].
// 
//
// 
//
// 示例 2: 
//
// 输入: [1, 2, 3, 5]
//
//输出: false
//
//解释: 数组不能分割成两个元素和相等的子集.
// 
//
// 
// Related Topics 动态规划 
// 👍 615 👎 0

package leetcode.editor.cn;

import java.util.Arrays;

public class PartitionEqualSubsetSum {
  public static void main(String[] args) {
    Solution solution = new PartitionEqualSubsetSum().new Solution();
    System.out.println(
        solution.canPartition(new int[] {100, 100, 100, 100, 100, 100, 100, 100, 100, 100
            , 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100,
            100,
            100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100,
            100,
            100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100,
            100,
            100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100,
            100,
            100, 100, 100, 100, 100, 100, 100, 100, 100, 99, 97}));
  }

  //leetcode submit region begin(Prohibit modification and deletion)
  class Solution {
    int[] arr;

    public boolean canPartition(int[] nums) {
      int sum = 0;
      arr = nums;
      for (int i = 0; i < nums.length; i++) {
        sum += nums[i];
      }
      if ((sum & 1) == 1) {
        return false;
      }
      Arrays.sort(nums);
      for (int i = 0; i < arr.length; i++) {
        System.out.print(arr[i] + " ");
      }
      int half = sum / 2;
      int L = 0, R = 0;
      int curSum = arr[0];
      do {
        if (curSum < half) {
          R++;
          if (R >= arr.length) {
            break;
          }
          curSum += arr[R];
        }
        if (curSum > half) {
          curSum -= arr[L];
          L++;
        }
        if (curSum == half) {
          return true;
        }
      } while (L < arr.length && R < arr.length && L <= R);
      return false;
    }

//        boolean dfs(int cur, int curSum, int target) {
//            if (curSum > target || cur>=arr.length)
//                return false;
//            if (curSum == target)
//                return true;
//            return dfs(cur + 1, curSum + arr[cur], target)||dfs(cur + 1, curSum, target);
//        }


  }
//leetcode submit region end(Prohibit modification and deletion)

}