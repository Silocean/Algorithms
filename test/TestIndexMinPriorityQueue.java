package test;

import priorityQueue.IndexMinPriorityQueue;

/**
 * Created by Silocean on 2016-04-28.
 */
public class TestIndexMinPriorityQueue {
    public static void main(String[] args) {
        IndexMinPriorityQueue<String> queue = new IndexMinPriorityQueue<>(5);
        queue.insert(0, "nihao");
        queue.insert(1, "siyunfei");
        queue.insert(2, "hello");
        queue.insert(3, "world");
        queue.insert(4, "bread");
        while (!queue.isEmpty()) {
            System.out.println(queue.deleteMin());
        }
    }
}
