package problem_list.recursive;

/**
 * @description:熄灯问题
 * @author: OpensourceHU
 * @date: Created in 2020/3/15 0015 10:10
 * @modified By:
 * {{0,1,1,0,1,0}
 * ,{1,0,0,1,1,1}
 * ,{0,0,1,0,0,1}
 * ,{1,0,0,1,0,1}
 * ,{0,1,1,1,0,0}};
 */
public class lightoff_Problem {
    static char[] ori_light = new char[5];//初始灯情况
    static char[] light = new char[5];//变化中的灯的情况
    static char[] result = new char[5];

    static int getBit(char c, int i) {
        return (c >> i) & 1;
    }//返回第i位

    static char setBit(char c, int i, int v)//第i位设为v
    {
        if (v == 1)
            c |= 1 << i;
        else
            c &= 1 << i;
        return c;
    }

    static char flick(char c, int i) {
        c ^= 1 << i;
        return c;
    }//第i位取反

    static void Output(char[] result) {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 6; j++) {
                System.out.print(getBit(result[i], j) + " ");
            }
            System.out.println();
        }
    }//打印结果

    public static void main(String[] args) {
        int input[][] = {{0, 1, 1, 0, 1, 0}
                , {1, 0, 0, 1, 1, 1}
                , {0, 0, 1, 0, 0, 1}
                , {1, 0, 0, 1, 0, 1}
                , {0, 1, 1, 1, 0, 0}};
        for (int i = 0; i < 5; i++)
            for (int j = 0; j < 6; j++)
                ori_light[i] = setBit(ori_light[i], j, input[i][j]);
        System.arraycopy(ori_light, 0, light, 0, 5);

        for (int n = 0; n < 64; n++) //n是第一行开关的状态
        {
            int switchs = n;  //switchs记录64种第一行开关的状态
            for (int i = 0; i < 5; i++) {
                result[i] = (char) switchs;
                for (int j = 0; j < 6; j++) {
                    if (getBit(light[i], j) == 1) {
                        if (j > 0)
                            flick(light[i], j - 1);
                        flick(light[i], j);
                        if (j < 5)
                            flick(light[i], j + 1);
                    }
                }
                if (i < 4)
                    light[i + 1] ^= switchs;  //对下一行灯的暗灭影响,是下一行灯与上一行开关 取异或的结果
                switchs = light[i];
            }
            if (light[4] == 0)  //每轮操作完毕后 除了最后一行,前N行灯一定都灭了  只需判断最后一行灯是否全灭 全灭则为所求答案
            {
                Output(result);
                break;
            }
        }


    }


}
