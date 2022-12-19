package data_structure;

/**
 * @description:泛型定容栈
 * @author: OpensourceHU
 * @date: Created in 2020/2/26 0026 18:25
 * @version: ${VERSION}
 * @modified By:
 */
public class FixedCapacityStack<Item> {
  private int N;      //定义栈的元素个数
  private Item[] a;  //储存载体

  FixedCapacityStack(int cap) {
    a = (Item[]) new Object[cap];
  }

  /************]
   * 用于调试的main函数
   * @param args
   */
  public static void main(String[] args) {
    FixedCapacityStack stack1 = new FixedCapacityStack(10);
    System.out.println(stack1.N);
    stack1.push(1);
    stack1.push(2);
    stack1.push(3);
    stack1.push(4);


    System.out.println(stack1.isEmpty());
    System.out.println(stack1.pop());
    System.out.println(stack1.getsize());
  }

  public void push(Item item) {
    if (N > 0 && N >= a.length / 2) {
      resize(2 * a.length);//每当栈大于数组1/2时,数组扩大一倍
    }
    this.a[N++] = item;
  }

  public Item pop() {
    if (isEmpty()) {
      System.out.println("栈空");
      return null;
    }
    Item item = a[--N];
    a[N] = null;
    if (N < a.length / 4) {
      resize(a.length / 2);//每当栈小于数组大小的1/4时,数组缩小一半
    }
    return item;
  }

  /***************************
   * 实现动态数组  param--参数
   * @param max
   */
  private void resize(int max) {
    Item[] temp = (Item[]) new Object[max];
    for (int i = 0; i < N; i++) {
      temp[i] = a[i];
    }
    a = temp;
  }

  public boolean isEmpty() {
    return this.N == 0;
  }

  public int getsize() {
    return this.N;
  }
}
