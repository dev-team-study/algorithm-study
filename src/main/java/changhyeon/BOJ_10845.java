package changhyeon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class BOJ_10845 {

    private static final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    private static final Deque<Integer> deque = new ArrayDeque<>();

    public static void main(String[] args) throws IOException {
        int count = Integer.parseInt(bufferedReader.readLine());

        for (int i = 0; i < count; i++) {
            String[] line = bufferedReader.readLine().split(" ");
            String order = line[0];
            int number = 0;

            if (line.length == 2) {
                number = Integer.parseInt(line[1]);
            }

            switch (order) {
                case "push":
                    push(number);
                    break;
                case "pop":
                    pop();
                    break;
                case "size":
                    size();
                    break;
                case "empty":
                    empty();
                    break;
                case "front":
                    front();
                    break;
                case "back":
                    back();
                    break;
            }
        }
    }

    static void push(int number) {
        deque.add(number);
    }

    static void pop() {
        System.out.println(deque.isEmpty() ? -1 : deque.removeFirst());
    }

    static void size() {
        System.out.println(deque.size());
    }

    static void empty() {
        System.out.println(deque.isEmpty() ? 1 : 0);
    }

    static void front() {
        System.out.println(deque.peekFirst() == null ? -1 : deque.peekFirst());
    }

    static void back() {
        System.out.println(deque.peekLast() == null ? -1 : deque.peekLast());
    }
}
