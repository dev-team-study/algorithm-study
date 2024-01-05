package changhyeon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_10971 {

    private static final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    private static int N, min = Integer.MAX_VALUE;
    private static boolean[] visited;
    private static int[][] expenseMap;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(bufferedReader.readLine());
        expenseMap = new int[N][N];
        visited = new boolean[N];

        for (int i = 0; i < N; i++) {
            expenseMap[i] = Arrays.stream(bufferedReader.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }

        for (int i = 0; i < N; i++) {
            visited[i] = true;
            recursive(i, i, 0, 0);
            visited[i] = false;
        }

        System.out.println(min);
    }

    private static void recursive(final int start, final int prev, final int depth, final int sum) {
        if (depth == N - 1) { // 만약 N이 4고 도시가 4개면 0 -> 1, 1 -> 2, 2-> 3 N - 1이 도시간 이동 거리 수가 됨
            if (expenseMap[prev][start] != 0) { // 마지막으로 다시 원래 도시로 이동할 때 0이 아닐 경우
                min = Math.min(min, sum + expenseMap[prev][start]);
            }
        }

        for (int i = 0; i < N; i++) {
            if (!visited[i] && expenseMap[prev][i] != 0) { // 도시를 방문한 적 없고 이동할 수 있는 도시 인 경우
                visited[i] = true;
                recursive(start, i, depth + 1, sum + expenseMap[prev][i]);
                visited[i] = false;
            }
        }
    }
}
