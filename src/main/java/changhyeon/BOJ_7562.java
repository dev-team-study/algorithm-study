package changhyeon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class BOJ_7562 {

    private static final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    private static int count, S;
    private static int[] cur, next;
    private static int[] mx = {1, 2, 2, 1, -1, -2, -2, -1};
    private static int[] my = {-2, -1, 1, 2, 2, 1, -1, -2};
    private static boolean[][] visited;
    private static int[][] map;

    public static void main(String[] args) throws IOException {
        count = Integer.parseInt(bufferedReader.readLine());

        for (int i = 0; i < count; i++) {
            S = Integer.parseInt(bufferedReader.readLine());
            map = new int[S][S];
            visited = new boolean[S][S];

            cur = Arrays.stream(bufferedReader.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            next = Arrays.stream(bufferedReader.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();

            bfs(cur[0], cur[1]);

            System.out.println(map[next[0]][next[1]]);
        }
    }

    private static void bfs(final int i, final int j) {
        Deque<int[]> deque = new ArrayDeque<>();
        deque.add(new int[] {i, j});
        visited[i][j] = true;

        while (!deque.isEmpty()) {
            int[] point = deque.poll();
            int x = point[0];
            int y = point[1];

            for (int k = 0; k < 8; k++) {
                int dx = mx[k] + x;
                int dy = my[k] + y;

                if (isBoundary(dx, dy)) {
                    deque.add(new int[] {dx, dy});
                    map[dx][dy] = map[x][y] + 1;
                    visited[dx][dy] = true;
                }
            }
        }
    }

    private static boolean isBoundary(final int dx, final int dy) {
        if (dx >= 0 && dy >= 0 && dx < S && dy < S && !visited[dx][dy]) {
            return true;
        }

        return false;
    }
}
