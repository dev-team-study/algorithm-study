package changhyeon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class BOJ_2178 {

    private static final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    private static int N, M;
    private static int[][] map;
    private static boolean[][] visited;
    private static int[] mx = {0, 0, -1, 1};
    private static int[] my = {-1, 1, 0, 0};

    public static void main(String[] args) throws IOException {
        String[] line = bufferedReader.readLine().split(" ");

        N = Integer.parseInt(line[0]);
        M = Integer.parseInt(line[1]);

        map = new int[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            String[] temp = bufferedReader.readLine().split("");
            map[i] = Arrays.stream(temp)
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }

        bfs(0, 0);
        System.out.println(map[N - 1][M - 1]);
    }

    private static void bfs(final int i, final int j) {
        Deque<int[]> deque = new ArrayDeque<>();
        deque.add(new int[] {i, j});

        while (!deque.isEmpty()) {
            int[] point = deque.poll();
            int x = point[0];
            int y = point[1];

            visited[y][x] = true;

            for (int k = 0; k < 4; k++) {
                int dx = mx[k] + x;
                int dy = my[k] + y;

                if (isBoundary(dx, dy)) {
                    deque.add(new int[] {dx, dy});
                    map[dy][dx] = map[y][x] + 1;
                }
            }
        }
    }

    private static boolean isBoundary(final int dx, final int dy) {
        if (dx >= 0 && dx < M && dy >= 0 && dy < N && !visited[dy][dx] && map[dy][dx] == 1) {
            return true;
        }

        return false;
    }
}
