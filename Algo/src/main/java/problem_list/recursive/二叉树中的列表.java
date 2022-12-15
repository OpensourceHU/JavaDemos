package problem_list.recursive;

/**
 * @author OpensourceHU
 * @version V1.0
 * @Description
 * @date 2020/6/8 0008 9:18
 */
public class 二叉树中的列表 {

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public static boolean isSubPath(ListNode head, TreeNode root) {
//        if (head == null) return true;
//        if (root == null) return false;
        if (root.val == head.val)
            return check(head, root) || check(head, root.left) || check(head, root.right);
        else
            return isSubPath(head, root.left) || isSubPath(head, root.right);
    }

    //如果有两个节点相等了  去找下面的节点是否相等
    public static boolean check(ListNode head, TreeNode root) {
        if (head == null) return true;
        if (root == null) return false;
        if (head.val == root.val)
            return check(head.next, root.left) || check(head.next, root.right);
        else return false;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(4);
        root.right.left = new TreeNode(2);
        root.right.left.right = new TreeNode(8);

        ListNode head = new ListNode(1);
        head.next = new ListNode(4);
        head.next.next = new ListNode(2);
        head.next.next.next = new ListNode(6);
        head.next.next.next.next = new ListNode(8);
        System.out.println(isSubPath(head, root));
    }
}

