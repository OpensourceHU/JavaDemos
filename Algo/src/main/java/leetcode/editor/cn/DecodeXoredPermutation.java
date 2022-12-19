//给你一个整数数组 perm ，它是前 n 个正整数的排列，且 n 是个 奇数 。 
//
// 它被加密成另一个长度为 n - 1 的整数数组 encoded ，满足 encoded[i] = perm[i] XOR perm[i + 1] 。比方说
//，如果 perm = [1,3,2] ，那么 encoded = [2,1] 。 
//
// 给你 encoded 数组，请你返回原始数组 perm 。题目保证答案存在且唯一。 
//
// 
//
// 示例 1： 
//
// 输入：encoded = [3,1]
//输出：[1,2,3]
//解释：如果 perm = [1,2,3] ，那么 encoded = [1 XOR 2,2 XOR 3] = [3,1]
// 
//
// 示例 2： 
//
// 输入：encoded = [6,5,4,6]
//输出：[2,4,1,5,3]
// 
//
// 
//
// 提示： 
//
// 
// 3 <= n < 105 
// n 是奇数。 
// encoded.length == n - 1 
// 
// Related Topics 位运算 
// 👍 56 👎 0

package leetcode.editor.cn;

public class DecodeXoredPermutation {
  public static void main(String[] args) {

    Solution solution = new DecodeXoredPermutation().new Solution();
    solution.decode(new int[] {3, 1});
  }

  //leetcode submit region begin(Prohibit modification and deletion)
  class Solution {
    public int[] decode(int[] encoded) {
      int pren = encoded.length + 1;
//            System.out.println(pren);
      int prenXor = 0;
      for (int i = 1; i <= pren; i++) {
        prenXor ^= i;
//                System.out.println(prenXor);
      }
//            System.out.println("prenxor" + prenXor);
      int xor2 = 0;
      for (int i = encoded.length - 2; i >= 0; i -= 2) {
        xor2 ^= encoded[i];
      }
//            System.out.println("xor2 = " + xor2);

      int tail = xor2 ^ prenXor;
//            System.out.println("tail"+tail);
      int[] ans = new int[encoded.length + 1];
      ans[encoded.length] = tail;
      int j = encoded.length - 1;
      for (int i = encoded.length - 1; i >= 0; i--) {
        ans[i] = ans[i + 1] ^ encoded[j];
        j--;
      }
      return ans;

    }
  }
//leetcode submit region end(Prohibit modification and deletion)

}