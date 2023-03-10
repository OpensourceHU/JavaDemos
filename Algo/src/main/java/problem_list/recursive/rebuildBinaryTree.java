package problem_list.recursive;

/**
 * @author OpensourceHU
 * @version V1.0
 * @Description输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。 例如输入前序遍历序列{1,2,4,7,3,5,6,
 * 8}和中序遍历序列{
 * 4,7,2,1,5,3,8,6}，则重建二叉树并返回。
 * @date 2020/6/19 0019 9:31
 */


class TreeNode {
  int val;
  TreeNode left;
  TreeNode right;

  TreeNode(int x) {
    val = x;
  }
}


public class rebuildBinaryTree {
  public static TreeNode rebuild(int[] pre, int[] in) {
    return process(pre, in, 0, pre.length - 1, 0, in.length - 1);
  }

  public static TreeNode process(int[] pre, int[] in, int preLeft, int preRight, int inLeft,
                                 int inRight) {
    if (preLeft > preRight || inLeft > inRight) {
      return null;
    }

    int index = 0;
    for (int i = 0; i < in.length; i++) {
      if (pre[preLeft] == in[i]) {
        index = i;
        break;
      }
    }//找到根下标
    int left = index - inLeft;
    int right = inRight - index;
    TreeNode root = new TreeNode(pre[preLeft]);
    root.left = process(pre, in, preLeft + 1, preLeft + left, inLeft, index - 1);
    root.right = process(pre, in, preRight - right + 1, preRight, index + 1, inRight);
    return root;
  }

  public static void main(String[] args) {
    int[] a = new int[] {1, 2, 3, 4, 5, 6, 7};
    int[] b = new int[] {3, 2, 4, 1, 6, 5, 7};
    TreeNode root = rebuild(a, b);
    System.err.println(root.val);
    System.out.println(root.left.val);
  }
}
