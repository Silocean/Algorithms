package sort;

/**
 * 快速排序
 * Created by Silocean on 2016-04-25.
 */
public class QuickSort {

    private static Comparable[] a = new Comparable[]{0, 3, 4, 6, 2, 7, 9};

    public static void main(String[] args) {
        sort(a, 0, a.length - 1);
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
    }

    public static void sort(Comparable[] a, int lo, int hi) {
        if (lo >= hi) return;
        int j = partition(lo, hi);
        sort(a, lo, j - 1);
        sort(a, j + 1, hi);
    }

    private static int partition(int lo, int hi) {
        int i = lo;
        int j = hi + 1;
        Comparable v = a[lo]; // 切分元素
        while (true) {
            while (less(a[++i], v)) {
                if (i == hi) break;
            }
            while (less(v, a[--j])) {
                if (j == lo) break;
            }
            if (i >= j) break;
            exch(i, j);
        }
        exch(lo, j);
        return j;
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
