package problem_list.recursive;


/**
 * @author OpensourceHU
 * @version V1.0
 * @Description 树的平衡性 : 实现一个函数，检查二叉树是否平衡。在这个问题中，平衡树的定义如下：任意一个节点，其两棵子树的高度差不超过 1。
 * @date 2020/5/21 0021 22:41
 */
public class TreeBalance {
  public static boolean solution(TreeNode root) {
    if (root == null) {
      return true;
    }
    return process(root).isBalance;
  }

  public static info process(TreeNode root) {
    info ret = new info();
    if (root == null) {
      ret.isBalance = true;
      ret.lay = 0;
      return ret;
    }

    info left = process(root.left);
    info right = process(root.right);
    if ((left.isBalance && left.isBalance) && (Math.abs(left.lay - right.lay) <= 1)) {
      ret.isBalance = true;
    } else {
      ret.isBalance = false;
    }
    ret.lay = Math.max(left.lay, right.lay) + 1;
    return ret;
  }

  public static void main(String[] args) {
    TreeNode root = new TreeNode(1);
    root.left = new TreeNode(2);
    root.left.right = new TreeNode(3);
    root.left.left = new TreeNode(4);
    root.left.right = new TreeNode(5);
    root.left.left.left = new TreeNode(7);
    root.left.right.right = new TreeNode(6);
    root.left.right.right.right = new TreeNode(8);
//        TreeNode root = new TreeNode(1);
//        root.right = new TreeNode(3);
//        root.right.right = new TreeNode(6);
//        root.right.right.right = new TreeNode(8);
    System.out.println(solution(root));
  }

  public static class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
      val = x;
    }
  }

  public static class info {
    int lay;
    boolean isBalance;

    info() {
      this.lay = 0;
      this.isBalance = true;
    }
  }
}
