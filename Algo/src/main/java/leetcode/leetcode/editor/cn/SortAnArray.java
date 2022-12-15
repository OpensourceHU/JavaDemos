//给你一个整数数组 nums，请你将该数组升序排列。 
//
// 
//
// 
// 
//
// 示例 1： 
//
// 
//输入：nums = [5,2,3,1]
//输出：[1,2,3,5]
// 
//
// 示例 2： 
//
// 
//输入：nums = [5,1,1,2,0,0]
//输出：[0,0,1,1,2,5]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 5 * 10⁴ 
// -5 * 10⁴ <= nums[i] <= 5 * 10⁴ 
// 
//
// 👍 743 👎 0

package leetcode.leetcode.editor.cn;

public class SortAnArray {
    public static void main(String[] args) {
        Solution solution = new SortAnArray().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] sortArray(int[] nums) {
            quick_sort1(nums, 0, nums.length - 1);
            return nums;
        }

        public int getmiddle(int[] array, int leftbound, int rightbound) {
            int axis = array[rightbound];
            int i = leftbound;
            int j = rightbound;
            while (i < j) {
                while (array[i] <= axis && i < j) i++;
                while (array[j] > axis && i < j) j--;
                swap(array, i, j);
            }
            swap(array, j, rightbound);
            return j;
        }


        public void quick_sort1(int[] array, int left, int right) {
            if (left >= right) return;
            process(array, 0, array.length - 1);
        }

        public void process(int[] arr, int left, int right) {
            if (left < right) {
                int mid = getmiddle(arr, left, right);
                process(arr, left, mid - 1);
                process(arr, mid + 1, right);
            }
        }

        private void swap(int[] array, int i, int j) {
            int tmp;
            tmp = array[i];
            array[i] = array[j];
            array[j] = tmp;
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}