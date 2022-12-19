//给定一个非空二叉树，返回其最大路径和。 
//
// 本题中，路径被定义为一条从树中任意节点出发，沿父节点-子节点连接，达到任意节点的序列。该路径至少包含一个节点，且不一定经过根节点。 
//
// 
//
// 示例 1： 
//
// 输入：[1,2,3]
//
//       1
//      / \
//     2   3
//
//输出：6
// 
//
// 示例 2： 
//
// 输入：[-10,9,20,null,null,15,7]
//
//   -10
//   / \
//  9  20
//    /  \
//   15   7
//
//输出：42 
// Related Topics 树 深度优先搜索 
// 👍 726 👎 0

package leetcode.editor.cn;

public class BinaryTreeMaximumPathSum {

  public static void main(String[] args) {


    Solution solution = new BinaryTreeMaximumPathSum().new Solution();
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
    int MaxSum = Integer.MIN_VALUE;

//        class info {
//            boolean passBy;
//            int max;
//
//            public info(boolean passBy, int max) {
//                this.passBy = passBy;
//                this.max = max;
//            }
//        }
//
//        public info process(TreeNode ro, boolean Pass) {
//            if (ro == null) return new info(false, Integer.MIN_VALUE);
//            info LPass = process(ro.left, true);
//            info L = process(ro.left, false);
//            info RPass = process(ro.right, true);
//            info R = process(ro.right, false);
//            if (Pass == false) {
//                //不走根节点  直接返回左右孩子中较大的值
//                int Lmax = Math.max(LPass.max, L.max);
//                int Rmax = Math.max(RPass.max, R.max);
//                int SonMax = Math.max(Lmax, Rmax);
//                return new info(false, SonMax);
//            } else {
//                //走根节点  返回以下三种情况的最大值
//                //2.走右子树+根+左子树
//                int Max4 = ro.val;
//                Max4 += LPass.max > 0 ? LPass.max : 0;
//                Max4 += RPass.max > 0 ? RPass.max : 0;
//                return new info(true, Max4);
//            }
//        }

    public int maxPathSum(TreeNode root) {
      process(root);
      return MaxSum;

    }

    public int process(TreeNode ro) {
      if (ro == null) {
        return 0;
      }
      int L = process(ro.left);
      int R = process(ro.right);
      //以当前节点为根的  最大值
      int max = ro.val;
      max += L > 0 ? L : 0;
      max += R > 0 ? R : 0;
      MaxSum = Math.max(max, MaxSum);
      int ret = ro.val + Math.max(L, R);
      return ret > 0 ? ret : 0;
    }

  }
//leetcode submit region end(Prohibit modification and deletion)

}