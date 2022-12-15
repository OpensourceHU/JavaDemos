//给你一个未排序的整数数组 nums ，请你找出其中没有出现的最小的正整数。 
//请你实现时间复杂度为 O(n) 并且只使用常数级别额外空间的解决方案。
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,2,0]
//输出：3
// 
//
// 示例 2： 
//
// 
//输入：nums = [3,4,-1,1]
//输出：2
// 
//
// 示例 3： 
//
// 
//输入：nums = [7,8,9,11,12]
//输出：1
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 5 * 105 
// -231 <= nums[i] <= 231 - 1 
// 
// Related Topics 数组 哈希表 
// 👍 1391 👎 0

package leetcode.leetcode.editor.cn;

public class FirstMissingPositive {
    public static void main(String[] args) {
        Solution solution = new FirstMissingPositive().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        void swap(int[] nums, int L, int R) {
            int tmp = 0;
            tmp = nums[L];
            nums[L] = nums[R];
            nums[R] = tmp;
        }

        public int firstMissingPositive(int[] nums) {
            //如果数组长度为len  那么最小整数 顶多是len+1
            //把值在1~len的数  放在下标1~len中对应位置
            //1~len 遍历一次数组,若arr[i]!=i 则为所求答案
            int[] book = new int[nums.length + 2];
            for (int i = 0; i < nums.length; i++) {
                //nums[i]当前位置的值 应该交换到index = nums[i]-1的位置上  即第i个 位置
                int curVal = nums[i];
                if (curVal >= 1 && curVal <= nums.length) {
                    book[curVal] = curVal;
                }
            }

            for (int i = 1; i < book.length; i++) {
                if (book[i] != i) return i;
            }
            return nums.length + 1;

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}