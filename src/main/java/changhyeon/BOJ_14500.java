package changhyeon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_14500 {

    private static final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    private static int N, M, result;
    private static int[][] map;
    private static int[] dy = {-1, 1, 0, 0};
    private static int[] dx = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        String[] line = bufferedReader.readLine().split(" ");
        N = Integer.parseInt(line[0]);
        M = Integer.parseInt(line[1]);

        map = new int[N][M];
        for (int i = 0; i < N; i++)
            map[i] = Arrays.stream(bufferedReader.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();

        boolean[][] visit = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                visit[i][j] = true;
                dfs(i, j, 1, map[i][j], visit);
                visit[i][j] = false;
                check(i, j);
            }
        }

        System.out.println(result);
    }

    static void dfs(int y, int x, int cnt, int sum, boolean[][] visit) {

        if (cnt >= 4) {
            result = Math.max(result, sum);
            return;
        }

        for (int k = 0; k < 4; k++) {
            int ny = y + dy[k];
            int nx = x + dx[k];

            if (ny < 0 || nx < 0 || ny >= N || nx >= M || visit[ny][nx]) {
                continue;
            }

            visit[ny][nx] = true;
            dfs(ny, nx, cnt + 1, sum + map[ny][nx], visit);
            visit[ny][nx] = false;
        }
    }

    static void check(int y, int x) {
        if (y < N - 2 && x < M - 1)
            result = Math.max(result, map[y][x] + map[y + 1][x] + map[y + 2][x] + map[y + 1][x + 1]);

        if (y < N - 2 && x > 0)
            result = Math.max(result, map[y][x] + map[y + 1][x] + map[y + 2][x] + map[y + 1][x - 1]);

        if (y < N - 1 && x < M - 2)
            result = Math.max(result, map[y][x] + map[y][x + 1] + map[y][x + 2] + map[y + 1][x + 1]);

        if (y > 0 && x < M - 2)
            result = Math.max(result, map[y][x] + map[y][x + 1] + map[y][x + 2] + map[y - 1][x + 1]);
    }
}
