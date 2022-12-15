package problem_list.recursive;

/**
 * @description: N皇后问题  已完成
 * @author: OpensourceHU
 * @date: Created in 2020/3/21 0021 20:20
 * @modified By:
 */
public class N_Queens_problem {
    public static void N_queen(int[] touched, int N, int row) {
        if (row == N) {
            for (int res : touched
            ) {
                System.out.print(res + 1 + " ");
            }
            System.out.println();
        }
        for (int j = 0; j < N; j++)//逐列尝试
        {
            int limit = 0;
            for (limit = 0; limit < row; limit++)//以前touch过的 对现有列有限制 limit是以前摆放好的第limit列
            {
                if (touched[limit] == j || Math.abs(row - limit) == Math.abs(j - touched[limit])) {
                    break;//中了限制条件  直接break掉
                }
            }
            if (limit == row)//limit来到了当前位置 说明和以前拜访的都不冲突
            {
                touched[row] = j;
                N_queen(touched, N, row + 1);
            }
        }
        return;
    }

    public static void main(String[] args) {
        int[] touched = new int[4];
        N_queen(touched, 4, 0);
    }
}
