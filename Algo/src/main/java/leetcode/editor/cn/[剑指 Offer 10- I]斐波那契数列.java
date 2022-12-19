package leetcode.editor.cn;

class feiBoNaQiShuLieLcof {
  //2022-12-19 13:50:49
  //斐波那契数列
  //编号：[剑指 Offer 10- I]

  public static void main(String[] args) {
    Solution solution = new feiBoNaQiShuLieLcof().new Solution();
    // TO TEST
  }

  //leetcode submit region begin(Prohibit modification and deletion)
  class Solution {
    public int fib(int n) {
      if (n == 0 || n == 1) {
        return n;
      }
      int[] ans = new int[n + 1];
      ans[0] = 0;
      ans[1] = 1;
      for (int i = 2; i <= n; i++) {
        ans[i] = (ans[i - 1] + ans[i - 2]) % (int) (1e9 + 7);
      }
      return ans[n];

    }
  }
//leetcode submit region end(Prohibit modification and deletion)

}