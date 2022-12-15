package classic_algo;


import data_structure.binaryTree;

/**
 * @author OpensourceHU
 * @version V1.0
 * @Description 二叉树的莫里斯遍历
 * @date 2020/6/2 0002 16:27
 */
public class Morris_Traverse {


//    public static void morrisTraverse(binaryTree head) {
//        if (head == null) return;
//        binaryTree cur = head;
//        binaryTree mostRight = null;
//        while (cur != null) {
//            System.out.println(cur.data);
//            mostRight = cur.leftSon;
//            if (mostRight != null) {
//                while (mostRight.rightSon != null && mostRight.rightSon != cur)
//                    mostRight = mostRight.rightSon;
//                if (mostRight.rightSon == null) {
//                    mostRight.rightSon = cur;
//                    cur = cur.leftSon;
//                    continue;
//                } else {
//                    mostRight.rightSon = null;
//                }
//            }
//            cur = cur.rightSon;
//        }
//    }

    public static void morrisTraverse(binaryTree head) {
        if (head == null) return;
        binaryTree cur = head;
        binaryTree mostRight = null;
        while (cur != null) {
            System.out.println(cur.data);
            mostRight = cur.leftSon;
            if (mostRight != null) {
                while (mostRight.rightSon != null && mostRight.rightSon != cur)
                    mostRight = mostRight.rightSon;
                //现在已经找到了左树的最右节点
                if (mostRight.rightSon == null)//如果为空  则还未遍历此左子树
                {
                    mostRight.rightSon = cur;
                    cur = cur.leftSon;
                } else {//如果不为空 则已经遍历到了此左子树
                    mostRight.rightSon = null;
                    cur = cur.rightSon;
                }
            } else {
                cur = cur.rightSon;
            }
        }
    }

    //莫里斯遍历改前序遍历
    public static void morrisTraversePre(binaryTree head) {
        if (head == null) return;
        binaryTree cur = head;
        binaryTree mostRight = null;
        System.out.println(cur.data);

        while (cur != null) {
            mostRight = cur.leftSon;
            if (mostRight != null) {
                while (mostRight.rightSon != null && mostRight.rightSon != cur)
                    mostRight = mostRight.rightSon;
                //现在已经找到了左树的最右节点
                if (mostRight.rightSon == null)//如果为空  则还未遍历此左子树
                {
                    mostRight.rightSon = cur;
                    cur = cur.leftSon;
                    System.out.println(cur.data);
                } else {//如果不为空 则已经遍历到了此左子树
                    mostRight.rightSon = null;
                    cur = cur.rightSon;
                    System.out.println(cur.data);
                }
            } else {
                cur = cur.rightSon;
            }
        }
    }

    //莫里斯遍历改中序遍历
    public static void morrisTraverseMid(binaryTree head) {
        if (head == null) return;
        binaryTree cur = head;
        binaryTree mostRight = null;
        while (cur != null) {
            mostRight = cur.leftSon;
            if (mostRight != null)//左孩子不为空的节点  第二次遍历到的时候打印
            {

                while (mostRight.rightSon != null && mostRight.rightSon != cur) {
                    mostRight = mostRight.rightSon;
                }
                //现在已经找到了左树的最右节点
                if (mostRight.rightSon == null)//如果为空  则还未遍历此左子树
                {
                    mostRight.rightSon = cur;
                    cur = cur.leftSon;

                } else {//如果不为空 则已经遍历到了此左子树
                    System.out.println(cur.data);
                    mostRight.rightSon = null;
                    cur = cur.rightSon;
                }
            } else {
                System.out.println(cur.data);//左孩子为空的节点  直接打印
                cur = cur.rightSon;
            }
        }
    }

    //莫里斯遍历改后续遍历   待续
    public static void morrisTraverseIn(binaryTree head) {
        if (head == null) return;
        binaryTree cur = head;
        binaryTree mostRight = null;
        while (cur != null) {
            System.out.println(cur.data);
            mostRight = cur.leftSon;
            if (mostRight != null) {
                while (mostRight.rightSon != null && mostRight.rightSon != cur)
                    mostRight = mostRight.rightSon;
                //现在已经找到了左树的最右节点
                if (mostRight.rightSon == null)//如果为空  则还未遍历此左子树
                {
                    mostRight.rightSon = cur;
                    cur = cur.leftSon;
                } else {//如果不为空 则已经遍历到了此左子树
                    mostRight.rightSon = null;
                    cur = cur.rightSon;
                }
            } else {
                cur = cur.rightSon;
            }
        }
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
        morrisTraverseMid(head);
    }
}
