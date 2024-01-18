package tommy;

import java.util.LinkedList;
import java.util.Scanner;

public class BOJ_10866 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        LinkedList<Integer> deque = new LinkedList<>();
        StringBuilder sb = new StringBuilder();


        for (int i = 0; i < n; i++) {
            String command = sc.next();
            switch (command) {
                case "push_front" :
                    int front = sc.nextInt();
                    deque.addFirst(front);
                    break;

                case "push_back" :
                    int back = sc.nextInt();
                    deque.addLast(back);
                    break;
                case "pop_front" :
                    if (deque.isEmpty()) {
                        sb.append(-1).append("\n");
                    } else {
                        sb.append(deque.pollFirst()).append("\n");
                    }
                    break;
                case "pop_back" :
                    if (deque.isEmpty()) {
                        sb.append(-1).append("\n");
                    } else {
                        sb.append(deque.pollLast()).append("\n");
                    }
                    break;
                case "size" :
                    sb.append(deque.size()).append("\n");
                    break;
                case "empty" :
                    if (deque.isEmpty()) {
                        sb.append(1).append("\n");
                    } else {
                        sb.append(0).append("\n");
                    }
                    break;
                case "front" :
                    if (deque.isEmpty()) {
                        sb.append(-1).append("\n");
                    } else {
                        sb.append(deque.peekFirst()).append("\n");
                    }
                    break;
                case "back" :
                    if (deque.isEmpty()) {
                        sb.append(-1).append("\n");
                    } else {
                        sb.append(deque.peekLast()).append("\n");
                    }
                    break;

            }
        }
        System.out.println(sb);
    }
}
