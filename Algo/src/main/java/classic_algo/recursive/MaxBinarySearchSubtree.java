package classic_algo.recursive;

import data_structure.binaryTree;

/**
 * @author OpensourceHU
 * @version V1.0
 * @Description 最大二叉搜索子树问题
 * :二叉搜索子树  子树:从该节点以下所有节点  左节点<父节点<右节点
 * @date 2020/6/4 0004 10:23
 */
public class MaxBinarySearchSubtree {
  public static Info process(binaryTree node) {
    if (node == null) {
      return null;
    }
    Info leftInfo = process(node.leftSon);
    Info rightInfo = process(node.rightSon);
    int Treesize = 0;
    int maxBSTsize = 0;
    Treesize =
        (leftInfo == null ? 0 : leftInfo.Treesize) + (rightInfo == null ? 0 : rightInfo.Treesize) +
            1;
    if (isBST(node)) {//如果答案与本节点有关  即node为头的整棵树是BST
      maxBSTsize = Treesize;
    } else {//如果答案与本节点无关  即node为头的整棵树不是BST
      maxBSTsize = Math.max(leftInfo == null ? 0 : leftInfo.maxBSTsize, rightInfo == null ? 0 :
          rightInfo.maxBSTsize);
    }
    return new Info(Treesize, maxBSTsize);
  }

  public static boolean isBST(binaryTree head) {
    return processBST(head).isBST;
  }

  private static BSTinfo processBST(binaryTree head) {
    if (head == null) {
      return null;
    }

    BSTinfo leftInfo = processBST(head.leftSon);
    BSTinfo rightInfo = processBST(head.rightSon);
    //处理本节点要向上反应的信息
    int max =
        Math.max((leftInfo == null ? head.data : leftInfo.max), (rightInfo == null ? head.data :
            rightInfo.max));

    int min =
        Math.min((leftInfo == null ? head.data : leftInfo.min), (rightInfo == null ? head.data :
            rightInfo.min));


    boolean isBST = false;
    //判断本节点是否为搜索二叉树   必须同时满足三个条件
    // 1. 左子树必须是BST   2.右子树必须是BST  3. 左子树max < 本节点的值 < 右子数min
    if ((leftInfo == null ? true : leftInfo.isBST) &&
        (rightInfo == null ? true : rightInfo.isBST) &&
        (leftInfo == null ? true : (leftInfo.max < head.data)) &&
        (rightInfo == null ? true : (rightInfo.min > head.data))) {
      isBST = true;
    }
    return new BSTinfo(min, max, isBST);
  }

  public static void main(String[] args) {
    binaryTree head = new binaryTree(1);
    head.leftSon = new binaryTree(1);
    System.out.println(isBST(head));
  }

  private static class Info {
    int Treesize;
    int maxBSTsize;

    public Info(int treesize, int maxBSTsize) {
      Treesize = treesize;
      this.maxBSTsize = maxBSTsize;
    }
  }

  private static class BSTinfo {
    int min;
    int max;
    boolean isBST;

    public BSTinfo(int min, int max, boolean isBST) {
      this.min = min;
      this.max = max;
      this.isBST = isBST;
    }
  }
}
