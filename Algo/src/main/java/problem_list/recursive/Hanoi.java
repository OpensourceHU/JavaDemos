package problem_list.recursive;

/**
 * @author OpensourceHU
 * @version V1.0
 * @Description 汉诺塔问题  递归求解
 * @date 2020/5/13 0013 10:50
 */
public class Hanoi {
  public static void hanoi(int N, String from, String helper, String to) {
    if (N == 1) {
      System.out.println("Move from " + from + " to " + to);
      return;
    }
    hanoi(N - 1, from, to, helper);
    System.out.println("Move from " + from + " to " + to);
    hanoi(N - 1, helper, from, to);
  }

  public static void main(String[] args) {
    hanoi(3, "A", "B", "C");
  }
}
