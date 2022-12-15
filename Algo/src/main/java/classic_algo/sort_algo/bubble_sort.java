package classic_algo.sort_algo;

import classic_algo.dataChecker;

import java.util.Arrays;

/**
 * @author OpensourceHU
 * @version V1.0
 * @Description 冒泡排序
 * @date 2020/4/13 0013 20:51
 */
public class bubble_sort {
    public static void main(String[] args) {
        int[] array = dataChecker.randomIntArrayGenerator(10000);
        int[] array2 = Arrays.copyOf(array, array.length);
        int[] array3 = Arrays.copyOf(array, array.length);

        long begin = System.currentTimeMillis();
        bubbleSort(array);
        long end = System.currentTimeMillis();
        show(array);
        System.out.println("冒泡排序耗时:" + (end - begin));

//        begin = System.currentTimeMillis();
//        Arrays.sort(array2);
//        end = System.currentTimeMillis();
//        show(array2);
//        System.out.println("系统快排耗时:"+(end-begin));
//
//        begin = System.currentTimeMillis();
//        quickSort.quick(array3);
//        end = System.currentTimeMillis();
//        show(array3);
//        System.out.println("自己写的快排耗时:"+(end-begin));

    }

    //    public static void  bubbleSort(int[] array)
//    {
//        for(int i=0;i<array.length;i++)
//            for(int j=0;j<array.length-i-1;j++)
//            {
//                if(array[j]>array[j+1])
//                {
//                    int tmp=0;
//                    tmp = array[j];
//                    array[j]=array[j+1];
//                    array[j+1]=tmp;
//                }
//            }
//    }
    public static void bubbleSort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length - 1 - i; j++) {
                if (array[j] > array[j + 1]) {
                    int tmp = array[j + 1];
                    array[j + 1] = array[j];
                    array[j] = tmp;
                }
            }
        }
    }

    public static void show(int[] array) {
        for (int i : array
        ) {
            System.out.print(i + "\t");
        }
        System.out.println();
    }
}
