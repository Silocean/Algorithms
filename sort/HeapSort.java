package sort;

/**
 * 堆排序
 * Created by Silocean on 2016-03-25.
 */
public class HeapSort {

    private static Comparable[] pq = new Comparable[]{0, 3, 4, 6, 2, 7, 9};

    public static void main(String[] args) {
        heapSort(pq);
        for (int i = 0; i < pq.length; i++) {
            System.out.println(pq[i]);
        }
    }

    public static void heapSort(Comparable[] a) {
        int N = a.length - 1;
        for (int k = N / 2; k >= 1; k--) {
            sink(k, N);
        }
        while (N > 1) {
            exch(1, N--);
            sink(1, N);
        }
    }

    private static boolean less(int i, int j) {
        return pq[i].compareTo(pq[j]) < 0;
    }

    private static void exch(int i, int j) {
        Comparable t = pq[i];
        pq[i] = pq[j];
        pq[j] = t;
    }

    public static void sink(int k, int n) {
        while (k * 2 <= n) {
            int j = k * 2;
            if (j < n && less(j, j + 1)) j++;
            if (!less(k, j)) break;
            exch(k, j);
            k = j;
        }
    }


}
