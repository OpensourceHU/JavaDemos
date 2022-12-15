package data_structure;

import static java.lang.System.exit;

/**
 * @description:单链表的实现
 * @author: OpensourceHU
 * @date: Created in 2020/3/1 0001 12:06
 * @modified By:
 */
public class Linkedlist<Item> {
    Item data;
    Linkedlist next = null;

    public Linkedlist createList(Item data) {
        Linkedlist head = new Linkedlist();
        head.data = data;
        return head;
    }

    public void append(Item data) {
        Linkedlist last = new Linkedlist();
        last.data = data;
        Linkedlist p = this;
        while (p.next != null) {
            p = p.next;
        }
        p.next = last;
    }

    public void showList() {
        Linkedlist p = this;
        int cnt = 0;
        while (p.next != null) {
            System.out.println(p.data);
            p = p.next;
            cnt++;
        }
        System.out.println(p.data);
        System.out.println("the length is " + (cnt + 1));
    }

    public Linkedlist insert(int index, Item data) {
        Linkedlist add = new Linkedlist();
        add.data = data;           //用来加入的节点
        Linkedlist p = new Linkedlist();
        p = this;                  //用来遍历的节点
        if (checkindex(index) == false) {
            System.out.println("下标错误");
            exit(-1);
        }
        if (index == 0) {
            add.next = this;
            return add;
        }
        for (int i = 0; i < index - 1; i++) {
            p = p.next;
        }//不要用while 贼不好想, 给出index就把p定位到index-1的位置上 一次循环p往后指一个 一共要指index-1次到指定位置

        add.next = p.next;
        p.next = add;
        return this;
    }

    private boolean checkindex(int index) {
        Linkedlist p = this;
        int cnt = 0;
        while (p.next != null) {
            p = p.next;
            cnt++;
        }
        if (index < cnt - 1 && index >= 0)
            return true;
        else return false;
    }

    public static void main(String[] args) {
        Linkedlist head = new Linkedlist();
        head = head.createList(0);
        head.append(1);
        head.append(2);
        head.append(3);
        head.append(4);
        head.showList();
        head.insert(99, 12);
        head.showList();
    }
}
