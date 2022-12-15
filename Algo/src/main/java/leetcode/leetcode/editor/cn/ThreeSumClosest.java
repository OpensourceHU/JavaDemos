//给定一个包括 n 个整数的数组 nums 和 一个目标值 target。找出 nums 中的三个整数，使得它们的和与 target 最接近。返回这三个数的和
//。假定每组输入只存在唯一答案。 
//
// 
//
// 示例： 
//
// 输入：nums = [-1,2,1,-4], target = 1
//输出：2
//解释：与 target 最接近的和是 2 (-1 + 2 + 1 = 2) 。
// 
//
// 
//
// 提示： 
//
// 
// 3 <= nums.length <= 10^3 
// -10^3 <= nums[i] <= 10^3 
// -10^4 <= target <= 10^4 
// 
// Related Topics 数组 双指针 
// 👍 601 👎 0

package leetcode.leetcode.editor.cn;


import java.util.ArrayList;
import java.util.Arrays;

public class ThreeSumClosest {
    public static void main(String[] args) {
        Solution solution = new ThreeSumClosest().new Solution();
        System.out.println(solution.threeSumClosest(new int[]{1, 1, -1, -1, 3}, -1));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int threeSumClosest(int[] nums, int target) {
            Arrays.sort(nums);
            int minDistance = Integer.MAX_VALUE;
            int ans = Integer.MAX_VALUE;
            for (int i = 0; i < nums.length; i++) {
                int L = i + 1;
                int R = nums.length - 1;
                while (L < R) {
                    int cur = nums[i] + nums[L] + nums[R];
                    if (minDistance > Math.abs(cur - target)) {
                        minDistance = Math.abs(cur - target);
                        ans = cur;
                    }
                    if (cur < target)
                        L++;
                    else R--;
                }
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}