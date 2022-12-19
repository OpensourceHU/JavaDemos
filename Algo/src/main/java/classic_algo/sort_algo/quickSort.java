package classic_algo.sort_algo;

/**
 * @description:快速排序算法
 * @author: OpensourceHU
 * @date: Created in 2020/4/1 0001 18:01
 * @modified By:
 */
public class quickSort {
  public static void showlist(int[] list) {
    for (int i : list
    ) {
      System.out.print(i + "\t");
    }
    System.out.println("\n");
  }
//
//    public static int getMiddle(int[] list, int low, int high) {
//        int tmp = list[low]; // 数组的第一个值作为中轴（分界点或关键数据）
//        while (low < high) {
//            while (low < high && list[high] > tmp) {
//                high--;
//            }
//            list[low] = list[high]; // 比中轴小的记录移到低端
//            showlist(list);
//
//            while (low < high && list[low] < tmp) {
//                low++;
//            }
//            list[high] = list[low]; // 比中轴大的记录移到高端
//            showlist(list);
//        }
//
//        list[low] = tmp; // 中轴记录到尾
//        System.out.println("完成一次排序");
//        System.out.println("中轴位置"+low);
//        return low; // 返回中轴的位置
//    }
//
//    public static void unckSort(int[] list,int low,int high) {
//        if(low < high) {
//            int middle = getMiddle(list,low,high);    // 将list数组一分为二
//            unckSort(list,low,middle-1);    // 对低字表进行递归排序
//            unckSort(list,middle+1,high);    // 对高字表进行递归排序
//        }
//        System.out.println("递归!");
//    }
//
//    public static void quick(int[] str) {
//        if(str.length > 0) {
//            // 查看数组是否为空
//            unckSort(str,0,str.length-1);
//        }
//    }

  /************************自己复写一遍****************************/
  public static int getmiddle(int[] str, int low, int high) {
    int tmp = str[low];
    while (low < high) {
      while (low < high && tmp < str[high]) {
        high--;
      }
      str[low] = str[high];
      while (low < high && tmp > str[low]) {
        low++;
      }
      str[high] = str[low];
    }
    str[low] = tmp;
    return low;
  }

  public static void uncksort(int[] str, int low, int high) {
    if (low < high) {
      int middle = getmiddle(str, low, high);
      uncksort(str, low, middle - 1);
      uncksort(str, middle + 1, high);
    }
  }

  public static void quickSort(int[] str) {
    if (str.length > 0) {
      uncksort(str, 0, str.length - 1);
    }
  }

  public static void main(String[] args) {
    int[] number = {7, 3, 4, 6, 5, 1, 8, 9, 2, 10};
    System.out.println(getmiddle(number, 0, number.length - 1));
    showlist(number);

  }
}
