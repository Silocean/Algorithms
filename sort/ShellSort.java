package sort;

/**
 * 希尔排序
 * Created by Silocean on 2016-04-24.
 */
public class ShellSort {

    private static Comparable[] a = new Comparable[]{0, 3, 4, 6, 2, 7, 9};

    public static void main(String[] args) {
        shellSort(a);
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
    }

    public static void shellSort(Comparable[] a) {
        int N = a.length;
        int h = 1;
        while (h < N / 3) h = 3 * h + 1;
        while (h >= 1) {
            for (int i = h; i < N; i++) {
                //将a[i]插入到a[i-h]、a[i-2*h]、a[i-3*h]...之中
                for (int j = i; j >= h && less(a[j], a[j - h]); j -= h) {
                    exch(j, j - h);
                }
            }
            h = h / 3;
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
