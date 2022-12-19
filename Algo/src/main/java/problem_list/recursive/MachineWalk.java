package problem_list.recursive;

/**
 * @author OpensourceHU
 * @version V1.0
 * @Description给定四个参数N、P、M、K。表示： N : 一共有1～N个位置
 * P : 一共有P步要走
 * M : 机器人初始停留在M位置上
 * K : 机器人想要去的位置是K
 * 题目：已知，如果机器人来到 1 位置，那么下一步一定会走到 2 位置。如果机器人来到 N 位置，那么下一步一定会走到 N - 1
 * 位置；如果机器人在中间的位置，那么下一步既可以走向左，也可以走向右。请返回，机器人如果初始停留在 M 位置，经过 P 步之后，机器人来到 K 位置的走法有多少种。
 * @date 2020/6/11 0011 9:37
 */
public class MachineWalk {
  static int num = 0;

  public static void main(String[] args) {
    test();
  }

  public static int walk(int N, int K, int start, int end)//N个位置走K步,从start走到end
  {
    if ((start == end) && (K == 0)) {
      return 1;
    }
    if (K == 0) {
      return 0;
    }
    if (start == N && K > 0) {
      return walk(N, K - 1, start - 1, end);
    }
    if (start == 1 && K > 0) {
      return walk(N, K - 1, start + 1, end);
    } else {
      return (walk(N, K - 1, start + 1, end) + walk(N, K - 1, start - 1, end));
    }
  }

  public static synchronized void test() {
    return;
  }
}
