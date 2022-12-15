package data_structure;

/**
 * @author OpensourceHU
 * @version V1.0
 * @Description 数数字:一个数组存放若干整数，两个不同的数出现奇数次，其余数均出现偶数次，找出这个出现奇数次的数？
 * 异或运算
 * @date 2020/4/20 0020 22:28
 */
public class countNumber {
    public static void main(String[] args) {
        int[] a = new int[]{1, 1, 2, 3, 4, 4, 3, 2, 5, 6, 7, 7, 8, 8, 8, 8, 9, 9};
        int tmp = 0;
        for (int i : a
        ) {
            tmp ^= i;
        }
        //假设答案是a b(ab不相同)  此时tmp=a^b 现要分离出a b
        int j = tmp & (~tmp + 1);//j是应该取得的答案异或后最低位的1
        // 在这一位上a b一个为1一个为0  不妨设a该位为1  b为0
        int ans = 0;//其中一个答案为ans
        for (int i : a
        ) {
            if ((i & j) != 0)   //不为1则a可以被异或操作 其他数也可能被异或操作,但是偶数次异或得0
            {
                ans ^= i;
            }//最终获得的ans 是a
        }
        System.out.println("一个是" + ans + "另一个是" + (tmp ^ ans));  //a^b =tmp 现已得a  再异或一次得b
    }
}
