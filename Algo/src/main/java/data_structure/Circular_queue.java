package data_structure;

import java.util.Scanner;

/**
 * @description:利用数组实现循环队列 注意取余的运用, 使得tail和front可以被限制在data的size里面不会越界访问
 * @author: OpensourceHU
 * @date: Created in 2020/3/13 0013 10:52
 * @modified By:
 */
public class Circular_queue {
  Object data[];
  int front;
  int tail;

  public static Circular_queue create(int size) {
    Circular_queue queque = new Circular_queue();
    queque.data = new Object[size];
    queque.front = 0;
    queque.tail = 0;
    return queque;
  }

  public static void main(String[] args) {
    int i;
    Scanner scan = new Scanner(System.in);
    Circular_queue queue = create(10);
    while (true) {
      i = scan.nextInt();
      if (i == 0) {
        break;
      }
      if (i > 0) {
        queue.enqueue(i);
      }
      if (i < 0) {
        queue.dequeue();
      }
    }
    System.out.println("最终队列如下");
    queue.showQueue();
  }

  public boolean isEmpty() {
    return this.front == this.tail;
  }

  public boolean isFull() {
    return (this.tail + 1) % this.data.length == this.front;
  }

  /***********************************************
   *@Description:将一个object类型的数据添加进队列 如果队列满返回false 否则返回true
   *Param:一个object变量
   *@return:队列满 false  未满 true
   *@Author:OpensourceHU
   *@Date:2020/3/13 0013
   *
   */
  public boolean enqueue(Object obj) {
    if (isFull()) {
      System.out.println("The queue is FULL");
      return false;
    } else {
      tail = (tail + 1) % data.length;
      data[tail] = obj;
      return true;
    }
  }

  public boolean dequeue() {
    if (isEmpty()) {
      System.out.println("The queue is empty");
      return false;
    } else {
      data[front + 1] = null;
      front = (front + 1) % data.length;
      return true;
    }
  }

  public void showQueue() {
    if (isEmpty()) {
      System.out.println("The queue is Empty!");
    } else {
      int p = this.front + 1;
      while (p != tail) {
        System.out.println(this.data[p]);
        p = (p + 1) % data.length;
      }
      System.out.println(this.data[tail]);
    }
  }
}
