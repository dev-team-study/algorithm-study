package changhyeon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class BOJ_10866 {

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
                case "push_front" -> push_front(number);
                case "push_back" -> push_back(number);
                case "pop_front" -> pop_front();
                case "pop_back" -> pop_back();
                case "size" -> size();
                case "empty" -> empty();
                case "front" -> front();
                case "back" -> back();
            }
        }
    }

    static void push_front(final int number) {
        deque.addFirst(number);
    }

    static void push_back(final int number) {
        deque.addLast(number);
    }

    static void pop_front() {
        if (deque.isEmpty()) {
            System.out.println(-1);
            return;
        }
        Integer number = deque.removeFirst();
        System.out.println(number);
    }

    static void pop_back() {
        if (deque.isEmpty()) {
            System.out.println(-1);
            return;
        }
        Integer number = deque.removeLast();
        System.out.println(number);
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
