//给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。 
//
// 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。 
//
// 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。 
//
// 示例： 
//
// 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
//输出：7 -> 0 -> 8
//原因：342 + 465 = 807
// 
// Related Topics 链表 数学 
// 👍 4989 👎 0

package leetcode.editor.cn;


public class AddTwoNumbers {

  public class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
      this.val = val;
    }

    ListNode(int val, ListNode next) {
      this.val = val;
      this.next = next;
    }
  }


//    public static void main(String[] args) {
//        Solution solution = new AddTwoNumbers().new Solution();
//        ListNode test = new ListNode(1);
//        test.next = new ListNode(9);
//        test.next.next = new ListNode(9);
//
//        ListNode test2 = new ListNode(9);
//        int x = solution.process(test);
//        int y = solution.process(test2);
//        int sum = x + y;
//
//        ListNode traverse = solution.traverse(sum);
//        while (traverse!= null){
//            System.out.println(traverse.val);
//            traverse = traverse.next;
//        }
//    }
  //leetcode submit region begin(Prohibit modification and deletion)

  /**
   * Definition for singly-linked list.
   * public class ListNode {
   * int val;
   * ListNode next;
   * ListNode() {}
   * ListNode(int val) { this.val = val; }
   * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
   * }
   */
  class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
      ListNode p = l1;
      ListNode q = l2;
      ListNode head = new ListNode(0);
      ListNode cur = head;
      int carry = 0;
      while (p != null || q != null) {

        int x = p == null ? 0 : p.val;
        int y = q == null ? 0 : q.val;
        int sum = x + y + carry;
        if (sum > 9) {
          int least = sum % 10;
          carry = sum / 10;
          cur.next = new ListNode(least);
          cur = cur.next;
        } else {
          carry = 0;
          cur.next = new ListNode(sum);
          cur = cur.next;
        }
        if (p != null) {
          p = p.next;
        }
        if (q != null) {
          q = q.next;
        }
      }
      //可能出现 carry还有位数 但是pq已经都为空的情况 这时候退出了while循环 需要补充
      if (carry > 0) {
        cur.next = new ListNode(carry);
      }
      return head.next;
    }

    //一开始想转化成两个整数相加后  再转化回去  但是溢出的情况很不好讨论
//        public ListNode traverse(long x) {
//            if (x == 0) return new ListNode(0);
//            ListNode ans = new ListNode(0);
//            ListNode cur = ans;
//            while (x >= 1.0) {
//                int R =(int) x % 10;
//                x /= 10;
//                cur.next = new ListNode(R);
//                cur = cur.next;
//            }
//            return ans.next;
//        }
//
//        public long process(ListNode node) {
//            if (node == null) return -1;
//            int count = 0;
//            long sum = 0;
//            ListNode cur = node;
//            while (cur != null) {
//                sum += cur.val * Math.pow(10.0, count++);
//                cur = cur.next;
//            }
//            return sum;
//        }
  }
//leetcode submit region end(Prohibit modification and deletion)

}