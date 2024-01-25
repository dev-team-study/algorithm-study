package changhyeon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class BOJ_13549 {

    private static final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    private static int N, K, MAX = 100_001, MIN = 0, count;
    private static boolean[] visited;
    private static int[] time;

    public static void main(String[] args) throws IOException {
        String[] line = bufferedReader.readLine().split(" ");
        N = Integer.parseInt(line[0]);
        K = Integer.parseInt(line[1]);

        visited = new boolean[MAX];
        time = new int[MAX];

        if (N == K) {
            System.out.println(0);
            return;
        }

        bfs(N);
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
                    System.out.println(time[number]);
                    return;
                }

                if (number * 2 >= MIN && number * 2 < MAX && !visited[number * 2]) {
                    deque.add(number * 2);
                    visited[number * 2] = true;
                    time[number * 2] = time[number];
                }

                if (number - 1 >= MIN && number - 1 < MAX && !visited[number - 1]) {
                    deque.add(number - 1);
                    visited[number - 1] = true;
                    time[number - 1] = time[number] + 1;
                }

                if (number + 1 >= MIN && number + 1 < MAX && !visited[number + 1]) {
                    deque.add(number + 1);
                    visited[number + 1] = true;
                    time[number + 1] = time[number] + 1;
                }
            }
            count++;
        }
    }
}
