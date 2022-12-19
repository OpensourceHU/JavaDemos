//实现一个二叉搜索树迭代器。你将使用二叉搜索树的根节点初始化迭代器。 
//
// 调用 next() 将返回二叉搜索树中的下一个最小的数。 
//
// 
//
// 示例： 
//
// 
//
// BSTIterator iterator = new BSTIterator(root);
//iterator.next();    // 返回 3
//iterator.next();    // 返回 7
//iterator.hasNext(); // 返回 true
//iterator.next();    // 返回 9
//iterator.hasNext(); // 返回 true
//iterator.next();    // 返回 15
//iterator.hasNext(); // 返回 true
//iterator.next();    // 返回 20
//iterator.hasNext(); // 返回 false 
//
// 
//
// 提示： 
//
// 
// next() 和 hasNext() 操作的时间复杂度是 O(1)，并使用 O(h) 内存，其中 h 是树的高度。 
// 你可以假设 next() 调用总是有效的，也就是说，当调用 next() 时，BST 中至少存在一个下一个最小的数。 
// 
// Related Topics 栈 树 设计 
// 👍 338 👎 0

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class BinarySearchTreeIterator {
  public static void main(String[] args) {

  }
  //leetcode submit region begin(Prohibit modification and deletion)

  /**
   * Definition for a binary tree node.
   * <p>
   * <p>
   * <p>
   * <p>
   * <p>
   * <p>
   * <p>
   * <p>
   * <p>
   * <p>
   * <p>
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

  class BSTIterator {

    ArrayList<TreeNode> arr = new ArrayList<>();
    int cnt = 0;

    public BSTIterator(TreeNode root) {
      traverse(root);
      Collections.sort(arr, new Comparator<TreeNode>() {
        @Override
        public int compare(TreeNode o1, TreeNode o2) {
          if (o1.val == o2.val) {
            return 0;
          } else {
            return o1.val < o2.val ? -1 : 1;
          }
        }
      });
      for (int i = 0; i < arr.size(); i++) {
        System.out.println(arr.get(i).val);
      }
    }

    public void traverse(TreeNode root) {
      if (root == null) {
        return;
      }
      arr.add(root);
      traverse(root.left);
      traverse(root.right);
    }

    public int next() {
      if (hasNext()) {
        return arr.get(cnt++).val;
      }
      return -1;
    }

    public boolean hasNext() {
      return cnt < arr.size();
    }
  }

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */
//leetcode submit region end(Prohibit modification and deletion)

}