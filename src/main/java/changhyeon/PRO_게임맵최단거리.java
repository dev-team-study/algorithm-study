package changhyeon;

import java.util.ArrayDeque;
import java.util.Deque;

public class PRO_게임맵최단거리 {

    private static int[] mx = {0, 0, -1, 1};
    private static int[] my = {-1, 1, 0, 0};
    private static boolean[][] visited;
    private static int WIDTH = 5, HEIGHT = 5;

    public int solution(int[][] maps) {
        visited = new boolean[maps.length][maps[0].length];
        WIDTH = maps[0].length;
        HEIGHT = maps.length;

        bfs(0, 0, maps);

        if (maps[HEIGHT - 1][WIDTH - 1] == 1) {
            return -1;
        }

        return maps[HEIGHT - 1][WIDTH - 1];
    }

    private void bfs(int x, int y, int[][] maps) {
        Deque<int[]> deque = new ArrayDeque<>();
        deque.add(new int[] {x, y});
        visited[y][x] = true;

        while (!deque.isEmpty()) {
            int[] cur = deque.poll();

            for (int i = 0; i < 4; i++) {
                int dx = mx[i] + cur[0];
                int dy = my[i] + cur[1];

                if (dx >= 0 && dy >= 0 && dx < WIDTH && dy < HEIGHT && maps[dy][dx] != 0 && !visited[dy][dx]) {
                    visited[dy][dx] = true;
                    maps[dy][dx] = maps[cur[1]][cur[0]] + 1;
                    deque.add(new int[] {dx, dy});
                }
            }
        }
    }
}
