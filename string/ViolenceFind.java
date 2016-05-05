package string;

/**
 * Created by Tracy on 2016-05-05.
 */
public class ViolenceFind {
    public static void main(String[] args) {
        System.out.println(search("abra", "abacadabrac"));
    }

    /**
     * 暴力子字符串查找算法
     *
     * @param pat
     * @param txt
     * @return
     */
    public static int search(String pat, String txt) {
        int M = pat.length();
        int N = txt.length();
        for (int i = 0; i <= N - M; i++) {
            int j;
            for (j = 0; j < M; j++) {
                if (txt.charAt(i + j) != pat.charAt(j)) break;
            }
            if (j == M) {
                return i; // 找到匹配
            }
        }
        return N; // 未找到匹配
    }

    /**
     * 暴力子字符串查找算法的另一种实现(显示回退)
     *
     * @param pat
     * @param txt
     * @return
     */
    public static int search2(String pat, String txt) {
        int j, M = pat.length();
        int i, N = txt.length();
        for (i = 0, j = 0; i < N && j < M; i++) {
            if (txt.charAt(i) == pat.charAt(j)) j++;
            else {
                i -= j;
                j = 0;
            }
        }
        if (j == M) return i - M; // 找到匹配
        else return N; // 未找到匹配
    }
}
