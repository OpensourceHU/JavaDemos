package classic_algo.sort_algo;

import classic_algo.dataChecker;

/**
 * @author OpensourceHU
 * @version V1.0
 * @Description 希尔排序
 * @date 2020/4/14 0014 21:41
 */
public class shell_sort {
    public static void main(String[] args) {
        int[] array = dataChecker.randomIntArrayGenerator(10000);
        shellSort(array);
        for (int i : array
        ) {
            System.out.println(i + " ");
        }
//        int[] array2 = Arrays.copyOf(array, array.length);
//        int[] array3 = Arrays.copyOf(array, array.length);
//        int[] array4 = Arrays.copyOf(array, array.length);
//
//        long begind = System.currentTimeMillis();
//        shellSort(array);
//        long end = System.currentTimeMillis();
//        show(array);
//        System.out.println("希尔排序耗时"+(end-begind));
//        begind = System.currentTimeMillis();
//        Arrays.sort(array2);
//        end = System.currentTimeMillis();
//        show(array2);
//        System.out.println("系统快排耗时"+(end-begind));
//        begind = System.currentTimeMillis();
//        Insertion_sort.sort2(array3);
//        end = System.currentTimeMillis();
//        show(array3);
//        System.out.println("插入排序耗时"+(end-begind));
//        begind = System.currentTimeMillis();
//        Insertion_sort.sort(array4);
//        end = System.currentTimeMillis();
//        show(array4);
//        System.out.println("未优化的插入排序耗时"+(end-begind));
    }

    public static void shellSort(int[] array) {
        for (int gap = array.length / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < array.length; i++) {//从第gap个元素开始  逐个跨组处理(反正最后每个元素的处理方法相同,按不按组无所谓)
                int tmp = array[i];
                int j;
                for (j = i; (j - gap) >= 0 && tmp < array[j - gap]; j -= gap) {
                    array[j] = array[j - gap];
                }
                array[j] = tmp;
            }
        }
    }
//    private static void shellSort(int[] arr) {
//        //step:步长
//        for (int step = arr.length / 2; step > 0; step /= 2) {
//            //对一个步长区间进行比较 [step,arr.length)
//            for (int i = step; i < arr.length; i++) {
//                int value = arr[i];
//                int j;
//
//                //对步长区间中具体的元素进行比较
//                for (j = i - step; j >= 0 && arr[j] > value; j -= step) {
//                    //j为左区间的取值，j+step为右区间与左区间的对应值。
//                    arr[j + step] = arr[j];
//                }
//                //此时step为一个负数，[j + step]为左区间上的初始交换值
//                arr[j + step] = value;
//            }
//        }
//    }
}
