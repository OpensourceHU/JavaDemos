//将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。 
//
// 
//
// 示例： 
//
// 输入：1->2->4, 1->3->4
//输出：1->1->2->3->4->4
// 
// Related Topics 链表 
// 👍 1293 👎 0

package leetcode.editor.cn;

public class MergeTwoSortedLists {

  public static void main(String[] args) {
    Solution solution = new MergeTwoSortedLists().new Solution();
  }

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
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
      ListNode p = l1;
      ListNode q = l2;
      ListNode head = new ListNode(-1);
      ListNode cur = head;
      while (p != null && q != null) {
        int smaller = p.val < q.val ? p.val : q.val;
        cur.next = new ListNode(smaller);
        cur = cur.next;
        if (smaller == p.val) {
          p = p.next;
        } else {
          q = q.next;
        }
      }
      while (p != null) {
        cur.next = new ListNode(p.val);
        cur = cur.next;
        p = p.next;
      }
      while (q != null) {
        cur.next = new ListNode(q.val);
        cur = cur.next;
        q = q.next;
      }
      return head.next;
    }
  }
//leetcode submit region end(Prohibit modification and deletion)

}