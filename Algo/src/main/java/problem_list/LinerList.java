package problem_list;

import java.util.Arrays;

/**
 * @author OpensourceHU
 * @version V1.0
 * @Description
 * @date 2020/10/23 0023 11:22
 */
public class LinerList {
    static int[] arr = new int[100];
    static int len;

    public LinerList() {
        init();
    }

    private static void init() {
        Arrays.fill(arr, -1);
        len = 0;
    }

    public static void add(int value) {
        if (len + 1 < 100) {
            arr[len] = value;
            len++;
        } else System.out.println("空间不足");
    }

    public static void insert(int index, int value) {
        if (outOfRange(index)) return;
        for (int i = len; i > index; i--) {
            arr[i] = arr[i - 1];
        }
        arr[index] = value;
        len++;
    }

    private static boolean outOfRange(int index) {
        if (index < 0 || index > len) {
            System.err.println("index out of range");
            return false;
        } else return true;
    }

    public static void delete(int index) {
        if (outOfRange(index)) return;
        for (int i = index + 1; i < len; i++) {
            arr[i - 1] = arr[i];
        }
        len--;
    }

    public static void show() {
        for (int i = 0; i < len; i++) {
            System.out.println(arr[i]);
        }
    }

    public static void main(String[] args) {
        LinerList.init();
        LinerList.add(5);
        LinerList.add(9);
        LinerList.add(6);
        LinerList.add(7);
        LinerList.add(4);
        LinerList.add(8);
        LinerList.add(1);
        LinerList.add(3);
        LinerList.add(2);
        LinerList.show();
        LinerList.insert(1, 10);
        System.out.println("///////");
        show();

    }
}
