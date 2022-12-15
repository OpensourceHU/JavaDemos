//给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。 
//
// 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。 
//
// 
//
// 示例: 
//
// 给定 1->2->3->4, 你应该返回 2->1->4->3.
// 
// Related Topics 链表 
// 👍 643 👎 0

package leetcode.leetcode.editor.cn;

import java.util.List;

public class SwapNodesInPairs {

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


    public static void main(String[] args) {
        Solution solution = new SwapNodesInPairs().new Solution();
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
        public ListNode swapPairs(ListNode head) {
//        if(head==null||head.next==null)
//            return head;
//        ListNode first = head;
//        ListNode second = head.next;
//        ListNode newHead = swapPairs(second.next);
//        second.next = first;
//        first.next = newHead;
//        return second;
            if (head == null || head.next == null) return head;
            ListNode first = head;
            ListNode second = head.next;
            ListNode temp = second;
            first.next = swapPairs(temp.next);
            second.next = first;
            return second;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}