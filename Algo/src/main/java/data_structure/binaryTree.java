package data_structure;


import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @author OpensourceHU
 * @version V1.0
 * @Description 二叉树相关操作
 * @date 2020/4/26 0026 17:09
 */
public class binaryTree {
    public binaryTree leftSon;
    public binaryTree rightSon;
    public int data;

    public binaryTree(int data) {
        this.data = data;
    }

    public static void traverse(binaryTree root) {//遍历的递归实现
        if (root != null) {
            System.out.print(root.data + " ");
            traverse(root.leftSon);
            traverse(root.rightSon);
        }
    }

    public static void iterateTraverse(binaryTree root)//中序遍历的迭代实现
    {
//        Stack<binaryTree> stack =  new Stack<binaryTree>();
//        binaryTree cur = root;
//        while(!stack.isEmpty()||cur!=null)//左子树与根节点弹出后要处理右子树 此时栈空  所以有两个退出指标
//        {
//            if(cur!=null)//cur不为空  开始压栈阶段
//            {
//                stack.push(cur);
//                cur = cur.leftSon;
//            }//左斜树全部压栈  cur往左下窜,沿途节点依次进栈
//            else{//此时cur为空  压栈阶段结束
//                cur = stack.pop();
//                System.out.print(cur.data+" ");//弹出并打印
//                cur = cur.rightSon;   //cur来到右子树节点  若右子树节点不为空则压栈,若为空则继续弹出打印
//            }
//        }
        Stack<binaryTree> stack = new Stack<>();
        binaryTree cur = root;
        stack.push(cur);
        while (cur != null && !stack.empty()) {
            if (cur.leftSon != null) {
                stack.push(cur.leftSon);
                cur = cur.leftSon;
            } else {
                cur = stack.pop();
                System.out.println(cur.data);
                if (cur.rightSon != null) {
                    stack.push(cur.rightSon);
                    cur = cur.rightSon;
                }
            }
        }
    }

    public static void layFirstTraverse(binaryTree root)//二叉树的层序遍历 用队列实现 左儿子先进队列右儿子再进
    {
        if (root == null)
            return;
        Queue<binaryTree> queue = new LinkedList<>();
        queue.add(root);
        binaryTree q;
        while (!queue.isEmpty()) {
            q = queue.poll();
            System.out.printf(q.data + " ");
            if (q.leftSon != null)
                queue.add(q.leftSon);
            if (q.rightSon != null)
                queue.add(q.rightSon);
        }
        return;
    }

    /********************************序列化与反序列化*****************************/
    public static String serialization(binaryTree root)//树的序列化(中序遍历)
    {
        if (root == null)
            return "#_";
        String ret = root.data + "_";
        ret += serialization(root.leftSon);
        ret += serialization(root.rightSon);
        return ret;
    }

    public static binaryTree Deserialization(String list) {
        String[] node = list.split("_");
        Queue<String> queue = new LinkedList<String>();
        for (String N : node
        ) {
            queue.add(N);
        }
        return deserializationProcess(queue);
    }

    private static binaryTree deserializationProcess(Queue<String> queue) {
        String value = queue.poll();
        if (value.equals("#"))
            return null;
        binaryTree root = new binaryTree(Integer.valueOf(value));
        root.leftSon = deserializationProcess(queue);
        root.rightSon = deserializationProcess(queue);
        return root;
    }
/****************************************************************************/

    /****************************在中序遍历序列中 找到给定节点的下一节点***************/
    public static binaryTree nextNode(binaryTree root, binaryTree p) {
        binaryTree ret = null;
        toQueue(root);
        while (!queue.isEmpty()) {
            binaryTree cur = queue.poll();
            if (cur == p) {
                ret = queue.poll();
                break;
            }
        }
        return ret;
    }

    public static Queue<binaryTree> queue = new LinkedList<binaryTree>();

    public static void toQueue(binaryTree root) {
        if (root == null) return;
        toQueue(root.leftSon);
        queue.add(root);
        toQueue(root.rightSon);
    }
/****************************************************************************/

    /*******************共同祖先******************/
    private static class info {
        boolean findp;
        boolean findq;
        binaryTree ancestor;

        public info(boolean findp, boolean findq, binaryTree ancestor) {
            this.findp = findp;
            this.findq = findq;
            this.ancestor = ancestor;
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
        iterateTraverse(head);

    }
}
