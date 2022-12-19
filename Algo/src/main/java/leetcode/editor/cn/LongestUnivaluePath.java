//给定一个二叉树，找到最长的路径，这个路径中的每个节点具有相同值。 这条路径可以经过也可以不经过根节点。 
//
// 注意：两个节点之间的路径长度由它们之间的边数表示。 
//
// 示例 1: 
//
// 输入: 
//
// 
//              5
//             / \
//            4   5
//           / \   \
//          1   1   5
// 
//
// 输出: 
//
// 
//2
// 
//
// 示例 2: 
//
// 输入: 
//
// 
//              1
//             / \
//            4   5
//           / \   \
//          4   4   5
// 
//
// 输出: 
//
// 
//2
// 
//
// 注意: 给定的二叉树不超过10000个结点。 树的高度不超过1000。 
// Related Topics 树 递归 
// 👍 362 👎 0

package leetcode.editor.cn;


public class LongestUnivaluePath {

  public static void main(String[] args) {
    Solution solution = new LongestUnivaluePath().new Solution();
  }

  public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
      val = x;
    }
  }
  //leetcode submit region begin(Prohibit modification and deletion)

  /**
   * Definition for a binary tree node.
   * public class TreeNode {
   * int val;
   * TreeNode left;
   * TreeNode right;
   * TreeNode(int x) { val = x; }
   * }
   */
  class Solution {
    public int longestUnivaluePath(TreeNode root) {
      return process(root);
    }

    int process(TreeNode root) {
      if (root == null) {
        return 0;
      }
      int Lpath = process(root.left);
      int Rpath = process(root.right);
      int both = 0;
      if (root.left != null && root.left.val == root.val) {
        Lpath = Lpath + 1;
        both++;
      }
      if (root.right != null && root.right.val == root.val) {
        Rpath = Rpath + 1;
        both++;
      }
      int ans = 0;
      if (both == 2) {
        ans = Lpath + Rpath;
      } else {
        ans = Math.max(Lpath, Rpath);
      }
      return ans;
    }
  }
//leetcode submit region end(Prohibit modification and deletion)

}