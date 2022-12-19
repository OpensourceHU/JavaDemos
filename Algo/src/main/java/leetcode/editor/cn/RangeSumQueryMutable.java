//给你一个数组 nums ，请你完成两类查询，其中一类查询要求更新数组下标对应的值，另一类查询要求返回数组中某个范围内元素的总和。 
//
// 实现 NumArray 类： 
//
// 
// 
// 
// NumArray(int[] nums) 用整数数组 nums 初始化对象 
// void update(int index, int val) 将 nums[index] 的值更新为 val 
// int sumRange(int left, int right) 返回子数组 nums[left, right] 的总和（即，nums[left] + 
//nums[left + 1], ..., nums[right]） 
// 
//
// 
//
// 示例： 
//
// 
//输入：
//["NumArray", "sumRange", "update", "sumRange"]
//[[[1, 3, 5]], [0, 2], [1, 2], [0, 2]]
//输出：
//[null, 9, null, 8]
//
//解释：
//NumArray numArray = new NumArray([1, 3, 5]);
//numArray.sumRange(0, 2); // 返回 9 ，sum([1,3,5]) = 9
//numArray.update(1, 2);   // nums = [1,2,5]
//numArray.sumRange(0, 2); // 返回 8 ，sum([1,2,5]) = 8
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 3 * 104 
// -100 <= nums[i] <= 100 
// 0 <= index < nums.length 
// -100 <= val <= 100 
// 0 <= left <= right < nums.length 
// 最多调用 3 * 104 次 update 和 sumRange 方法 
// 
// 
// 
// Related Topics 树状数组 线段树 
// 👍 247 👎 0

package leetcode.editor.cn;

public class RangeSumQueryMutable {
  public static void main(String[] args) {
    int[] arr = {1, 3, 5};

  }

  //leetcode submit region begin(Prohibit modification and deletion)

  class NumArray {
    int[] tree;
    int len;

    public NumArray(int[] nums) {
      len = nums.length;
      tree = new int[len];
      for (int i = 0; i < len; i++) {
        update(i, nums[i]);
      }

    }

    public void update(int index, int val) {
      for (int i = index; i < tree.length; i += i & (-i)) {
        tree[i] += val;
      }
    }

    public int find(int index) {
      int sum = 0;
      for (int i = index; i >= 0; i -= i & (-i)) {
        sum += tree[i];
      }
      return sum;
    }

    public int sumRange(int left, int right) {
      return find(right) - find(left);
    }


/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(index,val);
 * int param_2 = obj.sumRange(left,right);
 */
//leetcode submit region end(Prohibit modification and deletion)

  }

}