package sort;

/**
 * 找到一组数中第K小的元素（特殊情况就是找中位数）
 * Created by Silocean on 2016-04-26.
 */
public class SelectK {
    private static Comparable[] a = new Comparable[]{0, 3, 4, 6, 2, 7, 9};

    public static void main(String[] args) {
        System.out.println(select(a, 1));
    }

    private static Comparable select(Comparable[] a, int k) {
        int lo = 0;
        int hi = a.length - 1;
        while (lo < hi) {
            int j = partition(lo, hi);
            if (j == k) {
                return a[k];
            } else if (j > k) {
                hi = j - 1;
            } else if (j < k) {
                lo = j + 1;
            }
        }
        return a[k];
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