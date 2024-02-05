package changhyeon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_14053 {

    private static final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    private static boolean[][] visited;
    private static int[][] map;
    private static int x, y;
    private static int count;
    private static final int[] mx = {-1, 0, 1, 0};
    private static final int[] my = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine(), " ");

        x = Integer.parseInt(stringTokenizer.nextToken());
        y = Integer.parseInt(stringTokenizer.nextToken());

        stringTokenizer = new StringTokenizer(bufferedReader.readLine(), " ");

        int startX = Integer.parseInt(stringTokenizer.nextToken());
        int startY = Integer.parseInt(stringTokenizer.nextToken());
        int startDirection = Integer.parseInt(stringTokenizer.nextToken());

        map = new int[x][y];
        visited = new boolean[x][y];

        for (int i = 0; i < x; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine(), " ");
            for (int j = 0; j < y; j++) {
                map[i][j] = Integer.parseInt(stringTokenizer.nextToken());
            }
        }

        count++;
        visited[startX][startY] = true;

        dfs(startX, startY, startDirection);

        System.out.println(count);
    }

    public static void dfs(int curX, int curY, int nowDirection) {
        int i = 1;
        for (; i <= 4; i++) {
            int newDirection = (nowDirection - i < 0) ? nowDirection - i + 4 : nowDirection - i;
            int nextX = curX + mx[newDirection];
            int nextY = curY + my[newDirection];

            if ((nextX > 0 && nextX < x - 1)
                    && (nextY > 0 && nextY < y - 1)
                    && map[nextX][nextY] == 0
                    && !visited[nextX][nextY]
            ) {
                count++;
                visited[nextX][nextY] = true;
                dfs(nextX, nextY, newDirection);

                break;
            }
        }

        if (i == 5) {
            int oppoDirection = (nowDirection + 2 > 3) ? nowDirection - 2 : nowDirection + 2;
            int nextX = curX + mx[oppoDirection];
            int nextY = curY + my[oppoDirection];

            if ((nextX > 0 && nextX < x - 1)
                    && (nextY > 0 && nextY < y - 1)
                    && map[nextX][nextY] == 0
            ) {
                dfs(nextX, nextY, nowDirection);
            }
        }
    }
}
