package classic_algo.recursive;

import data_structure.binaryTree;

/**
 * @author OpensourceHU
 * @version V1.0
 * @Description 求一棵树上 任意两节点之间最大距离
 * @date 2020/6/4 0004 9:51
 */
public class MaxDistance {
    private static class Info {
        int maxHeight;
        int maxDistance;

        public Info(int maxHeight, int maxDistance) {
            this.maxHeight = maxHeight;
            this.maxDistance = maxDistance;
        }
    }

    private static Info process(binaryTree node) {
        if (node == null) return null;
        Info leftInfo = process(node.leftSon);
        Info rightInfo = process(node.rightSon);

        int maxDistance = 0;
        int maxHeight = 0;

        //最大高度好求  左右子树最大高度+1
        maxHeight = Math.max((leftInfo == null ? 0 : leftInfo.maxHeight), (rightInfo == null ? 0 :
                rightInfo.maxHeight)) + 1;
        //假如与node 节点没有关系  即最长路径不经过node
        int maxDistance1 = Math.max(leftInfo == null ? 0 : leftInfo.maxDistance, rightInfo == null ? 0 :
                rightInfo.maxDistance);
        //假如与node节点 有关系  即最长路径经过了node
        int maxDistance2 = (leftInfo == null ? 0 : leftInfo.maxHeight) + (rightInfo == null ? 0 :
                rightInfo.maxHeight) + 1;
        maxDistance = Math.max(maxDistance1, maxDistance2);
        return new Info(maxHeight, maxDistance);
    }

    public static int MaxDistance(binaryTree Node) {
        return process(Node).maxDistance;
    }

    public static void main(String[] args) {
        binaryTree head = new binaryTree(1);
        head.leftSon = new binaryTree(2);
        head.rightSon = new binaryTree(3);
        head.leftSon.leftSon = new binaryTree(4);
        head.leftSon.rightSon = new binaryTree(5);
        head.rightSon.leftSon = new binaryTree(6);
        head.rightSon.rightSon = new binaryTree(7);
        head.leftSon.leftSon.leftSon = new binaryTree(8);
        head.leftSon.leftSon.rightSon = new binaryTree(9);
        System.out.println(MaxDistance(head));
    }
}
