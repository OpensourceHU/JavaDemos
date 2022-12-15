package problem_list.recursive;

/**
 * @author OpensourceHU
 * @version V1.0
 * @Description 给定一个数组作为排成一列的牌的点数, AB两人依次从最左或最右端摸牌, 假设两人绝对理性, 那么获胜者得到的点数为多少?
 * @date 2020/5/14 0014 18:03
 */
public class Predict_the_Winner {
    public static int predict(int[] arr, int left, int right) {
        if (left == right) return arr[left];
        //抽左边
        return 0;
    }
}
