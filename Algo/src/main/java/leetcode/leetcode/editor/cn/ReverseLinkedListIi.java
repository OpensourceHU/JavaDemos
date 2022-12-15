//给你单链表的头指针 head 和两个整数 left 和 right ，其中 left <= right 。请你反转从位置 left 到位置 right 的链
//表节点，返回 反转后的链表 。
//
// 
//
// 示例 1： 
// 
// 
//输入：head = [1,2,3,4,5], left = 2, right = 4
//输出：[1,4,3,2,5]
// 
//
// 示例 2： 
//
// 
//输入：head = [5], left = 1, right = 1
//输出：[5]
// 
//
// 
//
// 提示： 
//
// 
// 链表中节点数目为 n 
// 1 <= n <= 500 
// -500 <= Node.val <= 500 
// 1 <= left <= right <= n 
// 
//
// 
//
// 进阶： 你可以使用一趟扫描完成反转吗？ 
//
// 👍 1451 👎 0

package leetcode.leetcode.editor.cn;

public class ReverseLinkedListIi {
    public static void main(String[] args) {
        Solution solution = new ReverseLinkedListIi().new Solution();
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

    class Solution {
        public ListNode reverseBetween(ListNode head, int left, int right) {
            if (head == null) return new ListNode();
            ListNode pre1, pre2, cur1, cur2;
            pre1 = head;
            for (int i = 0; i < left - 1; i++) {
                pre1 = pre1.next;
            }
            cur1 = pre1.next;
            pre2 = head;
            for (int i = 0; i < right - 1; i++) {
                pre2 = pre2.next;
            }
            cur2 = pre2.next;

            //split
            pre1.next = null;
            pre2.next = null;

            //reverse
            ListNode q = null;
            while (cur1 != null) {
                ListNode next = cur1.next;
                cur1.next = q;
                q = cur1;
                cur1 = next;
            }

            ListNode p = q;
            while (p.next != null) {
                p = p.next;
            }

            pre1.next = q;
            p.next = cur2;
            return head;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}