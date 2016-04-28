package test;

import priorityQueue.MinPriorityQueue;

/**
 * Created by Silocean on 2016-04-28.
 */
public class TestMinPriorityQueue {
    public static void main(String[] args) {
        MinPriorityQueue<Integer> queue = new MinPriorityQueue<>(5);
        queue.insert(4);
        queue.insert(1);
        queue.insert(3);
        queue.insert(2);
        queue.insert(5);
        while (!queue.isEmpty()) {
            System.out.println(queue.deleteMin());
        }
    }
}
