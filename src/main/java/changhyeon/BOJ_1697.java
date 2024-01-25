package changhyeon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class BOJ_1697 {

    private static final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    private static int MIN = 0, MAX = 100_001, count = 0;
    private static boolean[] visited = new boolean[MAX];

    public static void main(String[] args) throws IOException {
        String[] line = bufferedReader.readLine().split(" ");

        int N = Integer.parseInt(line[0]);
        int K = Integer.parseInt(line[1]);

        if (N == K) {
            System.out.println(0);
            return;
        }

        bfs(N, K);
    }

    private static void bfs(final int N, final int K) {
        Deque<Integer> deque = new ArrayDeque<>();
        deque.add(N);
        visited[N] = true;
        int size;

        while (true) {
            count++;
            size = deque.size();
            for (int i = 0; i < size; i++) {
                int current = deque.poll();

                if (current - 1 == K || current + 1 == K || current * 2 == K) {
                    System.out.println(count);
                    return;
                }

                if (current - 1 >= MIN && current - 1 < MAX && !visited[current - 1]) {
                    deque.add(current - 1);
                    visited[current - 1] = true;
                }

                if (current + 1 >= MIN && current + 1 < MAX && !visited[current + 1]) {
                    deque.add(current + 1);
                    visited[current + 1] = true;
                }

                if (current * 2 >= MIN && current * 2 < MAX && !visited[current * 2]) {
                    deque.add(current * 2);
                    visited[current * 2] = true;
                }
            }
        }
    }
}
