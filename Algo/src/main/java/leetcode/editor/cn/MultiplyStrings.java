//给定两个以字符串形式表示的非负整数 num1 和 num2，返回 num1 和 num2 的乘积，它们的乘积也表示为字符串形式。 
//
// 注意：不能使用任何内置的 BigInteger 库或直接将输入转换为整数。 
//
// 
//
// 示例 1: 
//
// 
//输入: num1 = "2", num2 = "3"
//输出: "6" 
//
// 示例 2: 
//
// 
//输入: num1 = "123", num2 = "456"
//输出: "56088" 
//
// 
//
// 提示： 
//
// 
// 1 <= num1.length, num2.length <= 200 
// num1 和 num2 只能由数字组成。 
// num1 和 num2 都不包含任何前导零，除了数字0本身。 
// 
//
// Related Topics 数学 字符串 模拟 👍 1107 👎 0

package leetcode.editor.cn;

public class MultiplyStrings {
  public static void main(String[] args) {
    Solution solution = new MultiplyStrings().new Solution();
    System.out.println(solution.multiply("123", "456"));
  }

  //leetcode submit region begin(Prohibit modification and deletion)
  class Solution {
    public String multiply(String num1, String num2) {
      int n = num1.length();
      int m = num2.length();
      int[] arr = new int[n + m];
      for (int i = n - 1; i >= 0; i--) {
        for (int j = m - 1; j >= 0; j--) {
          int pos1 = i + j;
          int pos2 = pos1 + 1;
          int mul = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
          int sum = mul + arr[pos2];
//                    System.err.println(sum);
          arr[pos2] = sum % 10;
          arr[pos1] += sum / 10;
//                    for (int k = 0; k < arr.length; k++) {
//                        System.out.print(arr[k]);
//                    }
//                    System.out.println();
        }

      }
      int idx = 0;
      while (idx < arr.length) {
        if (arr[idx] == 0) {
          idx++;
        } else {
          break;
        }
      }
//            for (int i = 0; i < arr.length; i++) {
//                System.out.print(arr[i]);
//            }
      System.out.println();
      String ans = "";
      for (int i = idx; i < arr.length; i++) {
        ans += String.valueOf(arr[i]);
      }
      return ans == "" ? "0" : ans;
    }
  }
//leetcode submit region end(Prohibit modification and deletion)

}