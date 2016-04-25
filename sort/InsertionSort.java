package sort;

/**
 * 插入排序
 * Created by Silocean on 2016-04-24.
 */
public class InsertionSort {

    private static Comparable[] a = new Comparable[]{0, 3, 4, 6, 2, 7, 9};

    public static void main(String[] args) {
        insertionSort(a);
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
    }

    public static void insertionSort(Comparable[] a) {
        int N = a.length;
        for (int i = 1; i < N; i++) {
            // 将a[i]插入到a[i-1]、a[i-2]、a[i-3]...之中
            for (int j = i; j > 0 && less(a[j], a[j - 1]); j--) {
                exch(j, j - 1);
            }
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
