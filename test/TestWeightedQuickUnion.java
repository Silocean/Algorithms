package test;

import unionFind.WeightedQuickUnion;

import java.io.BufferedReader;
import java.io.FileReader;

/**
 * Created by Tracy on 2016-04-23.
 */
public class TestWeightedQuickUnion {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new FileReader("src/test/UF.txt"));
        int N = Integer.parseInt(br.readLine()); // 读取触点数量
        WeightedQuickUnion weightedQuickUnion = new WeightedQuickUnion(N); // 初始化N个分量
        String str;
        while ((str = br.readLine()) != null) {
            String[] splits = str.split(" ");
            int p = Integer.parseInt(splits[0]);
            int q = Integer.parseInt(splits[1]); // 读取整数对
            if (weightedQuickUnion.connected(p, q)) continue; // 如果已经连通则忽略
            weightedQuickUnion.union(p, q); // 归并分量
            System.out.println(p + " " + q);
        }
        System.out.println(weightedQuickUnion.count()+" conmponents");
    }
}
