package problem_list.recursive;

/**
 * @author OpensourceHU
 * @version V1.0
 * @Description 背包问题:给定一组物品，每种物品都有自己的重量和价格，在限定的总重量内，我们如何选择，才能使得物品的总价格最高。
 * @date 2020/5/14 0014 17:20
 */
public class Backpack_Problem {
  public static int process(int[] weight, int[] value, int capacity, int index, int selected) {
    if (index == weight.length - 1) {
      return 0;
    }
    if (selected > capacity) {
      return -1;
    }
    //如果不要当前物品
    int p1 = process(weight, value, capacity, index + 1, selected);
    //如果要当前物品
    int p2next = process(weight, value, capacity, index + 1, selected + weight[index]);
    int p2 = -1;
    if (p2next != -1) {
      p2 = value[index] + p2next;
    }
    return Math.max(p1, p2);
  }

  public static void main(String[] args) {
    int[] weight = new int[] {1, 2, 3};
    int[] value = new int[] {3, 2, 1};
    int max = process(weight, value, 5, 0, 0);
    System.out.println(max);
  }
}
