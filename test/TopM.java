package test;

import priorityQueue.MaxPriorityQueue;

import java.util.Scanner;
import java.util.Stack;

/**
 * Created by Silocean on 2016-03-25.
 */
public class TopM {
    public static void main(String[] args) {
        int M = 3;
        MaxPriorityQueue pq = new MaxPriorityQueue(10);
        Scanner scanner = new Scanner(System.in);
        String str = "";
        while (!(str = scanner.nextLine()).equals("")) {
            pq.insert(str);
            if (pq.size() > M) {
                pq.deleteMax();
            }
        }
        Stack<String> stack = new Stack<>();
        while (!pq.isEmpty()) {
            stack.push((String) pq.deleteMax());
        }
        while (!stack.isEmpty()) {
            System.out.println(stack.pop());
        }
    }
}
