package data_structure;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Stack;

/**
 * @author OpensourceHU
 * @version V1.0
 * @Description 并查集结构的实现
 * @date 2020/5/22 0022 22:38
 */
public class UnionFindSet<T> {
  private static int count = 0;//整个集合的元素个数
  private HashMap<T, T> elementMap = new HashMap<T, T>();//注册每个节点
  private HashMap<T, T> fatherMap = new HashMap<T, T>();//每个节点的父节点
  private HashMap<T, Integer> rankMap = new HashMap<T, Integer>();//父节点所在集合的元素个数

  UnionFindSet(Collection<T> elements) {
    init(elements);
  }

  public static void main(String[] args) {
    ArrayList arr = new ArrayList();
    arr.add(1);
    arr.add(2);
    arr.add(3);
    arr.add(4);
    arr.add(5);
    arr.add(6);
    arr.add(7);
    UnionFindSet UF = new UnionFindSet(arr);
    UF.union(arr.get(0), arr.get(1));
    System.out.println(UF.size());

  }

  private void init(Collection<T> elements) {
    for (T element : elements
    ) {
      this.elementMap.put(element, element);
      this.fatherMap.put(element, element);
      this.rankMap.put(element, 1);
      count++;
    }
  }

  public void union(T p, T q) {
    if ((p == null || q == null) ||
        (!this.elementMap.containsKey(p) || !this.elementMap.containsKey(q))) {
      return;
    }
    if (isConnected(p, q)) {
      return;
    }
    T pFather = this.fatherMap.get(p);
    T qFather = this.fatherMap.get(q);
    T small;
    if (this.rankMap.get(pFather) < this.rankMap.get(qFather)) {
      //如果p的集合比q的集合小
      this.fatherMap.put(pFather, qFather);  //小挂大
      small = pFather;
    } else {
      this.fatherMap.put(qFather, pFather);
      small = qFather;
    }
    flat(small);
    count--;
  }

  //扁平化处理沿途节点
  private void flat(T key) {
    Stack<T> stack = new Stack<T>();
    while (key != this.fatherMap.get(key)) {
      stack.push(key);
      key = this.fatherMap.get(key);
    }
    while (!stack.isEmpty()) {
      this.fatherMap.put(stack.pop(), key);
    }
  }

  //返回头节点的元素个数
  private Integer find(T key) {
    if (key == null) {
      return null;
    }
    if (this.elementMap.get(key) == null) {
      return null;
    }
    T father = this.fatherMap.get(key);
    return this.rankMap.get(father);
  }

  //判断两触点是否联通
  private boolean isConnected(T p, T q) {
    return this.fatherMap.get(p) == this.fatherMap.get(q);//若两节点拥有同一个头节点 则联通
  }

  public int size() {
    return this.count;
  }
}
