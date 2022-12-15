package classic_algo.recursive;

public class binarySearch {
    public static void main(String[] args) {
        int[] a = new int[]{1, 3, 8, 14};
        int target = 4;
        int tail = a.length - 1;
        int head = 0;
        int tmp = 0;
        while (head <= tail) {
            tmp = (head + tail) / 2;
            if (target < a[tmp])
                tail = tmp - 1;
            else if (target > a[tmp])
                head = tmp + 1;
            else break;
        }
        System.out.println(tmp);
    }
}
