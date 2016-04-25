package sort;

/**
 * 自底向上的归并排序
 * Created by Silocean on 2016-04-25.
 */
public class MergeSortBU {
    private static Comparable[] a = new Comparable[]{0, 3, 4, 6, 2, 7, 9};

    private static Comparable[] aux; // 归并所需要的辅助数组

    public static void main(String[] args) {
        aux = new Comparable[a.length]; // 一次性分配空间
        sort(a);
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
    }

    private static void sort(Comparable[] a) {
        int N = a.length;
        aux = new Comparable[N];
        for (int sz = 1; sz < N; sz = sz + sz) {
            for (int lo = 0; lo < N - sz; lo += sz + sz) {
                merge(lo, lo + sz - 1, Math.min(lo + sz + sz - 1, N - 1));
            }
        }
    }

    private static void merge(int lo, int mid, int hi) {
        int i = lo;
        int j = mid + 1;
        for (int k = lo; k <= hi; k++) { // 把a[lo..hi]复制到aux[lo..hi]
            aux[k] = a[k];
        }
        for (int k = lo; k <= hi; k++) { // 归并回到a[lo..hi]
            if (i > mid) { // 左半边用尽
                a[k] = aux[j++];
            } else if (j > hi) { // 右半边用尽
                a[k] = aux[i++];
            } else if (less(aux[j], aux[i])) { // 右半边当前元素小于左半边当前元素
                a[k] = aux[j++];
            } else { // 右半边当前元素大于左半边当前元素
                a[k] = aux[i++];
            }
        }
    }

    public static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }
}
