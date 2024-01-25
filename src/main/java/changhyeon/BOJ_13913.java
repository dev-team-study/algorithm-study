package changhyeon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class BOJ_13913 {

    private static final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    private static int N, K, MAX = 100_001, MIN = 0, count;
    private static int[] before;
    private static boolean[] visited;

    public static void main(String[] args) throws IOException {
        String[] line = bufferedReader.readLine().split(" ");
        N = Integer.parseInt(line[0]);
        K = Integer.parseInt(line[1]);

        visited = new boolean[MAX];
        before = new int[MAX];

        if (N == K) {
            System.out.println(0);
            System.out.println(N);
            return;
        }

        bfs(N);

        Deque<Integer> deque = new ArrayDeque<>();

        while (K != N) {
            deque.add(K);
            K = before[K];
        }

        deque.add(K);

        while (!deque.isEmpty()) {
            System.out.print(deque.pollLast() + " ");
        }
    }

    private static void bfs(final int N) {
        Deque<Integer> deque = new ArrayDeque<>();
        deque.add(N);
        visited[N] = true;
        int size;

        while (true) {
            size = deque.size();

            for (int i = 0; i < size; i++) {
                int number = deque.poll();

                if (number == K) {
                    System.out.println(count);
                    return;
                }

                if (number * 2 >= MIN && number * 2 < MAX && !visited[number * 2]) {
                    deque.add(number * 2);
                    visited[number * 2] = true;
                    before[number * 2] = number;
                }

                if (number - 1 >= MIN && number - 1 < MAX && !visited[number - 1]) {
                    deque.add(number - 1);
                    visited[number - 1] = true;
                    before[number - 1] = number;
                }

                if (number + 1 >= MIN && number + 1 < MAX && !visited[number + 1]) {
                    deque.add(number + 1);
                    visited[number + 1] = true;
                    before[number + 1] = number;
                }
            }
            count++;
        }
    }
}
