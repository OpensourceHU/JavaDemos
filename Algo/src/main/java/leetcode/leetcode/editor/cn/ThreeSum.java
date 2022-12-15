//给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有满足条件且不重复
//的三元组。 
//
// 注意：答案中不可以包含重复的三元组。 
//
// 
//
// 示例： 
//
// 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
//
//满足要求的三元组集合为：
//[
//  [-1, 0, 1],
//  [-1, -1, 2]
//]
// 
// Related Topics 数组 双指针 
// 👍 2669 👎 0

package leetcode.leetcode.editor.cn;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {
    public static void main(String[] args) {
        Solution solution = new ThreeSum().new Solution();
        System.out.println(solution.threeSum(new int[]{-1, 0, 1, 2, -1, -4}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> threeSum(int[] nums) {
            List<List<Integer>> ans = new ArrayList();
            Arrays.sort(nums);
            for (int i = 0; i < nums.length; i++) {
                if (i >= 1 && nums[i] == nums[i - 1]) {
                    continue;
                }
                int L = i + 1;
                int R = nums.length - 1;
                int target = -nums[i];
                //开始双指针
                while (L < R) {
                    if ((L > i + 1 && nums[L] == nums[L - 1]) || nums[L] + nums[R] < target) {
                        L++;
                    } else if ((R < nums.length - 1 && nums[R] == nums[R + 1]) || nums[L] + nums[R] > target) {
                        R--;
                    } else {
                        ArrayList<Integer> findOne = new ArrayList<>();
                        findOne.add(nums[i]);
                        findOne.add(nums[L]);
                        findOne.add(nums[R]);
                        ans.add(findOne);
                        L++;
                    }
                }
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}