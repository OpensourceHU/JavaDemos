package leetcode.editor.cn;

class qingWaTiaoTaiJieWenTiLcof {
  //2022-12-19 14:02:51
  //青蛙跳台阶问题
  //编号：[剑指 Offer 10- II]

  public static void main(String[] args) {
    Solution solution = new qingWaTiaoTaiJieWenTiLcof().new Solution();
    // TO TEST
  }

  //leetcode submit region begin(Prohibit modification and deletion)
  class Solution {
    public int numWays(int n) {
      if (n == 0) {
        return 1;
      }
      if (n == 1) {
        return 1;
      }
      int[] ans = new int[n + 1];
      ans[0] = 1;
      ans[1] = 1;
      for (int i = 2; i <= n; i++) {
        ans[i] = (ans[i - 1] + ans[i - 2]) % (int) (1e9 + 7);
      }
      return ans[n];
    }

  }
//leetcode submit region end(Prohibit modification and deletion)

}