package sort;

/**
 * 三向切分的快速排序
 * （对于存在大量重复元素的数组，这种方法比标准的快速排序的效率搞的多）
 * Created by Silocean on 2016-04-26.
 */
public class Quick3waySort {

    private static Comparable[] a = new Comparable[]{0, 3, 4, 6, 2, 7, 9};

    public static void main(String[] args) {
        sort(a, 0, a.length - 1);
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
    }

    public static void sort(Comparable[] a, int lo, int hi) {
        if (lo >= hi) return;
        int lt = lo;
        int i = lo + 1;
        int gt = hi;
        Comparable v = a[lo];
        while (i <= gt) {
            int cmp = a[i].compareTo(v);
            if (cmp < 0) {
                exch(lt++, i++);
            } else if (cmp > 0) {
                exch(i, gt--);
            } else {
                i++;
            }
        }
        sort(a, lo, lt - 1);
        sort(a, gt + 1, hi);
    }

    public static void exch(int i, int j) {
        Comparable t = a[i];
        a[i] = a[j];
        a[j] = t;
    }
}
