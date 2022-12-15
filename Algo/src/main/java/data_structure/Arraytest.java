package data_structure;

import java.util.Arrays;

/**
 * @description:
 * @author: OpensourceHU
 * @date: Created in 2020/4/1 0001 15:47
 * @modified By:
 */
public class Arraytest {
    public static void main(String[] args) {
//        int[] a1 = new int[]{1,2,3,4,5};
//        for (int val:a1
//             ) {
//            System.out.println(val);
//        }
//
//        int[][] matrix = new int[][]{{1,2,3},{4,5,6},{7,8,9}};
//        System.out.println(matrix[0][1]);
//        System.out.println("deeptoString:");
//        System.out.println(Arrays.deepToString(matrix));
//
//
//        int[][] matrix2 = new int[][]{{1,2},{1,2,3},{2,3,4,5}};
//        for(int i =0;i<matrix2.length;i++)
//        {
//            for (int j =0;j<matrix2[i].length;j++)
//            {
//                System.out.print(matrix2[i][j]);
//            }
//            System.out.println();
//        }
//
        int[] a1 = new int[]{3, 4, 5, 6};
        int[] a2 = new int[]{3, 4, 5, 6};
        System.out.println("equal?  " + Arrays.equals(a1, a2));
        int[] c = Arrays.copyOf(a1, a1.length * 2);
        int scores[] = new int[]{57, 81, 68, 75, 91};
//        int[] copy = Arrays.copyOf(scores,scores.length+3);
//        for (int i:copy
//             ) {
//            System.out.println(i);
//        }
//        System.out.println();
//        copy = Arrays.copyOfRange(scores,0,5);
//        for (int i:copy
//        ) {
//            System.out.println(i);
//        }
        int[] clone = scores.clone();
        for (int i : clone
        ) {
            System.out.println(i);
        }

    }
}
