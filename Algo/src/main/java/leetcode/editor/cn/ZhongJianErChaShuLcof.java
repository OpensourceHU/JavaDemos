//输入某二叉树的前序遍历和中序遍历的结果，请构建该二叉树并返回其根节点。 
//
// 假设输入的前序遍历和中序遍历的结果中都不含重复的数字。 
//
// 
//
// 示例 1: 
//
// 
//Input: preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
//Output: [3,9,20,null,null,15,7]
// 
//
// 示例 2: 
//
// 
//Input: preorder = [-1], inorder = [-1]
//Output: [-1]
// 
//
// 
//
// 限制： 
//
// 0 <= 节点个数 <= 5000 
//
// 
//
// 注意：本题与主站 105 题重复：https://leetcode-cn.com/problems/construct-binary-tree-from-
//preorder-and-inorder-traversal/ 
// Related Topics 树 数组 哈希表 分治 二叉树 
// 👍 714 👎 0

package leetcode.editor.cn;

import java.util.Arrays;

public class ZhongJianErChaShuLcof {
  public static void main(String[] args) {
    Solution solution = new ZhongJianErChaShuLcof().new Solution();
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

  public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
      val = x;
    }
  }

  class Solution {

    public TreeNode buildTree(int[] preorder, int[] inorder) {
      int len = preorder.length;
      if (len == 0) {
        return null;
      }
      int rootVal = preorder[0];
      int idx = 0;
      for (int i = 0; i < inorder.length; i++) {
        if (inorder[i] == rootVal) {
          idx = i;
          break;
        }
      }
      TreeNode root = new TreeNode(rootVal);
      root.left = buildTree(Arrays.copyOfRange(preorder, 1, 1 + idx), Arrays.copyOfRange(inorder, 0,
          idx));
      root.right = buildTree(Arrays.copyOfRange(preorder, 1 + idx, len), Arrays.copyOfRange(inorder,
          idx + 1, len));
      return root;


    }
  }
//leetcode submit region end(Prohibit modification and deletion)

}