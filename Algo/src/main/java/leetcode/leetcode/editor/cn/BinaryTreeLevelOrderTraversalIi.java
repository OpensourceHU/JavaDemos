//给你二叉树的根节点 root ，返回其节点值 自底向上的层序遍历 。 （即按从叶子节点所在层到根节点所在的层，逐层从左向右遍历） 
//
// 
//
// 示例 1： 
// 
// 
//输入：root = [3,9,20,null,null,15,7]
//输出：[[15,7],[9,20],[3]]
// 
//
// 示例 2： 
//
// 
//输入：root = [1]
//输出：[[1]]
// 
//
// 示例 3： 
//
// 
//输入：root = []
//输出：[]
// 
//
// 
//
// 提示： 
//
// 
// 树中节点数目在范围 [0, 2000] 内 
// -1000 <= Node.val <= 1000 
// 
//
// Related Topics 树 广度优先搜索 二叉树 👍 636 👎 0

package leetcode.leetcode.editor.cn;

import com.sun.source.tree.Tree;

import java.util.*;

public class BinaryTreeLevelOrderTraversalIi {
    public static void main(String[] args) {
        Solution solution = new BinaryTreeLevelOrderTraversalIi().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode() {}
     * TreeNode(int val) { this.val = val; }
     * TreeNode(int val, TreeNode left, TreeNode right) {
     * this.val = val;
     * this.left = left;
     * this.right = right;
     * }
     * }
     */
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    class Solution {
        public List<List<Integer>> levelOrderBottom(TreeNode root) {
            if (root == null) return new ArrayList<>();
            Queue<TreeNode> que = new LinkedList<>();
            que.add(root);
            ArrayList<ArrayList<Integer>> ans = new ArrayList();
            while (!que.isEmpty()) {
                int size = que.size();
                ArrayList<Integer> arr = new ArrayList(size);
                for (int i = 0; i < size; i++) {
                    TreeNode cur = que.poll();
                    arr.add(cur.val);
                    if (cur.left != null) que.add(cur.left);
                    if (cur.right != null) que.add(cur.right);
                }
                ans.add(arr);
            }
            List<List<Integer>> reverseAns = new ArrayList<>();
            for (int i = ans.size() - 1; i >= 0; i--) {
                reverseAns.add(ans.get(i));
            }
            return reverseAns;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}