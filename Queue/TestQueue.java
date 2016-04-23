package queue;

import java.util.Iterator;

/**
 * Created by Silocean on 2016-04-20.
 */
public class TestQueue {
    public static void main(String[] args) {
        Queue<Integer> queue = new Queue<Integer>();
        queue.enqueue(3);
        queue.enqueue(13);
        queue.dequeue();
        queue.enqueue(45);
        queue.enqueue(1);
        Iterator<Integer> iterator = queue.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
