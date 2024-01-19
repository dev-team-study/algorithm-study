package changhyeon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class BOJ_1260 {

    private static final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    private static int N, M, V;
    private static boolean[][] arr;
    private static boolean[] visited;
    private static Deque<Integer> deque = new ArrayDeque<>();

    public static void main(String[] args) throws IOException {
        String[] line = bufferedReader.readLine().split(" ");
        N = Integer.parseInt(line[0]);
        M = Integer.parseInt(line[1]);
        V = Integer.parseInt(line[2]);

        arr = new boolean[N + 1][N + 1];
        for (int i = 0; i < M; i++) {
            String[] numbers = bufferedReader.readLine().split(" ");
            int num1 = Integer.parseInt(numbers[0]);
            int num2 = Integer.parseInt(numbers[1]);

            arr[num1][num2] = true;
            arr[num2][num1] = true;
        }

        visited = new boolean[N + 1];
        dfs(V);
        System.out.println();

        visited = new boolean[N + 1];
        bfs(V);
    }

    private static void dfs(final int V) {
        System.out.print(V + " ");
        visited[V] = true;

        for (int i = 1; i <= N; i++) {
            if (arr[V][i] && !visited[i]) {
                dfs(i);
            }
        }
    }

    private static void bfs(final int V) {
        System.out.println(V);
        deque.add(V);
        visited[V] = true;

        while (!deque.isEmpty()) {
            int number = deque.remove();

            for (int i = 1; i <= N; i++) {
                if (arr[number][i] && !visited[i]) {
                    deque.add(i);
                    visited[i] = true;
                    System.out.print(i + " ");
                }
            }
        }
    }
}
