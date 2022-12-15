package problem_list;

import java.util.HashMap;

/**
 * @author OpensourceHU
 * @version V1.0
 * @Description 有一条单链表，其节点除了有next指针外，还有一个random指针。random指针可指向单链表中的任意节点，包括它自身。
 * random指针一旦指定，便不再更改。请设计算法，复制此单链表，并给出时间复杂度。
 */
public class copyListwithRandomPtr {
    private static class Node {
        int value;
        Node next;
        Node random;

        public Node(int value) {
            this.value = value;
        }
    }

    public static Node drawList() {
        Node head = new Node(1);
        Node second = new Node(2);
        Node third = new Node(3);
        Node forth = new Node(4);
        Node fifth = new Node(5);
        head.next = second;
        second.next = third;
        third.next = forth;
        forth.next = fifth;
        head.random = third;
        second.random = fifth;
        third.random = null;
        forth.random = head;
        fifth.random = null;
        return head;
    }

    public static void main(String[] args) {
        Node head = drawList();//
        HashMap<Node, Node> map = new HashMap<Node, Node>();
        Node p = head;
        while (p != null) {
            map.put(p, new Node(p.value));
            p = p.next;
        }//新建节点放进map里  形成对应关系
        p = head;
        while (p.next != null) {
            map.get(p).next = map.get(p.next);
            map.get(p).random = map.get(p.random);//p指向的节点的复制 的random指针 指向 p指向节点的random指针指向的节点的复制
            p = p.next;
        }//p来到最后一个节点
        Node newHead = map.get(head);

    }

}
