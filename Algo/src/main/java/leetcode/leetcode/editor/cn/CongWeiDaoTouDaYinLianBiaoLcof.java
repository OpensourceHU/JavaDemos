//输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。 
//
// 
//
// 示例 1： 
//
// 输入：head = [1,3,2]
//输出：[2,3,1] 
//
// 
//
// 限制： 
//
// 0 <= 链表长度 <= 10000 
// Related Topics 链表 
// 👍 61 👎 0

package leetcode.leetcode.editor.cn;

import java.awt.image.AreaAveragingScaleFilter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class CongWeiDaoTouDaYinLianBiaoLcof {

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }


    public static void main(String[] args) {
        Solution solution = new CongWeiDaoTouDaYinLianBiaoLcof().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode(int x) { val = x; }
     * }
     */
    class Solution {
        public int[] reversePrint(ListNode head) {
            ListNode p = head;
            ArrayList<Integer> arr = new ArrayList();
            while (p != null) {
                arr.add(p.val);
                p = p.next;
            }
            Collections.reverse(arr);
            int[] ans = new int[arr.size()];
            for (int i = 0; i < arr.size(); i++) {
                ans[i] = arr.get(i);
            }
            return ans;

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}