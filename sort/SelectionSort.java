package sort;

/**
 * 选择排序
 * Created by Silocean on 2016-04-24.
 */
public class SelectionSort {

    private static Comparable[] a = new Comparable[]{0, 3, 4, 6, 2, 7, 9};

    public static void main(String[] args) {
        selectionSort(a);
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
    }

    public static void selectionSort(Comparable[] a) {
        int N = a.length;
        for (int i = 0; i < N; i++) {
            // 将a[i]和a[i+1...N]中最小的元素交换
            int min = i; // 最小元素的索引
            for (int j = i + 1; j < N; j++) {
                if (less(a[j], a[min])) min = j;
            }
            exch(i, min);
        }
    }

    public static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }

    public static void exch(int i, int j) {
        Comparable t = a[i];
        a[i] = a[j];
        a[j] = t;
    }
}
