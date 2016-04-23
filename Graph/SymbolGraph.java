package graph;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * 反向索引的图
 * Created by Silocean on 2016-04-21.
 */
public class SymbolGraph {
    private Map<String, Integer> map; // 符号名->索引
    private String[] keys; // 索引->符号名
    private Graph graph; // 图

    public SymbolGraph(BufferedReader br, String sp) throws IOException {
        br = new BufferedReader(new FileReader("src/Graph/movies.txt"));
        map = new HashMap<>();
        String string;
        while ((string = br.readLine()) != null) { // 构造索引
            String[] splits = string.split(sp);
            for (int i = 0; i < splits.length; i++) { // 为每个不同的字符关联一个索引
                if (!map.containsKey(splits[i])) {
                    map.put(splits[i], map.size());
                }
            }
        }

        keys = new String[map.size()]; // 用来获得顶点名的反向索引的数组
        for (String name : map.keySet()) {
            keys[map.get(name)] = name;
        }

        graph = new Graph(map.size());
        br = new BufferedReader(new FileReader("src/Graph/movies.txt"));
        String str;
        while ((str = br.readLine()) != null) { // 将每一个行的第一个顶点和该行的其他顶点相连
            String[] splits = str.split(sp);
            int v = map.get(splits[0]);
            for (int i = 1; i < splits.length; i++) {
                graph.addEdge(v, map.get(splits[i]));
            }
        }
    }

    public boolean contains(String s) {
        return map.containsKey(s);
    }

    public int index(String s) {
        return map.get(s);
    }

    public String name(int v) {
        return keys[v];
    }

    public Graph G() {
        return graph;
    }

}
