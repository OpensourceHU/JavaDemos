package leetcode.editor.cn;

import java.util.Arrays;

class sortColors {
  //2022-12-18 12:17:46
  //颜色分类
  //编号：[75]

  public static void main(String[] args) {
    Solution solution = new sortColors().new Solution();
    solution.sortColors(new int[] {2, 0, 2, 1, 2, 2, 2, 0, 0, 1});
    // TO TEST
  }

  //leetcode submit region begin(Prohibit modification and deletion)
  class Solution {
    void swap(int[] nums, int i, int j) {
      int tmp = nums[i];
      nums[i] = nums[j];
      nums[j] = tmp;
    }

    public void sortColors(int[] nums) {
      int L = 0;
      int R = nums.length - 1;
      while (L < R) {
        while (nums[L] == 0 || nums[L] == 1) {
          L++;
        }
        while ((nums[R] == 2 || nums[R] == 1)) {
          R--;
        }
        swap(nums, L, R);
        System.out.println(L + " " + R);
        System.out.println(Arrays.toString(nums));
      }
    }
  }
//leetcode submit region end(Prohibit modification and deletion)

}