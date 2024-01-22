package changhyeon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_11724 {

    private static final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    private static int N, M, count;
    private static boolean[][] arr;
    private static boolean[] visited;

    public static void main(String[] args) throws IOException {
        String[] line = bufferedReader.readLine().split(" ");
        N = Integer.parseInt(line[0]);
        M = Integer.parseInt(line[1]);
        arr = new boolean[N + 1][N + 1];
        visited = new boolean[N + 1];

        for (int i = 0; i < M; i++) {
            String[] numbers = bufferedReader.readLine().split(" ");
            int num1 = Integer.parseInt(numbers[0]);
            int num2 = Integer.parseInt(numbers[1]);

            arr[num1][num2] = true;
            arr[num2][num1] = true;
        }

        for (int i = 1; i <= N; i++) {
            if (!visited[i]) {
                dfs(i);
                count++;
            }
        }

        System.out.println(count);
    }

    private static void dfs(final int start) {
        for (int i = 1; i <= N; i++) {
            if (arr[start][i] && !visited[i]) {
                visited[i] = true;
                dfs(i);
            }
        }
    }
}
