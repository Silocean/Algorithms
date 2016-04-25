package test;

import unionFind.QuickUnion;

import java.io.BufferedReader;
import java.io.FileReader;

/**
 * Created by Tracy on 2016-04-23.
 */
public class TestQuickUnion {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new FileReader("src/test/UF.txt"));
        int N = Integer.parseInt(br.readLine()); // 读取触点数量
        QuickUnion quickUnion = new QuickUnion(N); // 初始化N个分量
        String str;
        while ((str = br.readLine()) != null) {
            String[] splits = str.split(" ");
            int p = Integer.parseInt(splits[0]);
            int q = Integer.parseInt(splits[1]); // 读取整数对
            if (quickUnion.connected(p, q)) continue; // 如果已经连通则忽略
            quickUnion.union(p, q); // 归并分量
            System.out.println(p + " " + q);
        }
        System.out.println(quickUnion.count()+" conmponents");
    }
}
