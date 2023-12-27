package changhyeon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;


/*
 * 시간 복잡도: O(N!)
 * 공간 복잡도: O(N)
 */

public class BOJ_18290 {

    private static final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    private static int N, M, select, MAX;
    private static int[][] box;
    private static boolean[][] visited;
    private static int[] mx = {0, 0, -1, 1};
    private static int[] my = {1, -1, 0, 0};

    public static void main(String[] args) throws IOException {
        String[] line = bufferedReader.readLine().split(" ");
        N = Integer.parseInt(line[1]);
        M = Integer.parseInt(line[0]);
        select = Integer.parseInt(line[2]);
        box = new int[M][N];
        visited = new boolean[M][N];
        MAX = Integer.MIN_VALUE;

        for (int i = 0; i < M; i++) {
            box[i] = Arrays.stream(bufferedReader.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }

        dfs(0, 0, 0, 0);
        System.out.println(MAX);
    }

    private static void dfs(int y, int x, int index, int sum) {
        if (index == select) {
            MAX = Math.max(MAX, sum);
            return;
        }

        for (int i = y; i < M; i++) {
            for (int j = (i == y ? x : 0); j < N; j++) {
                if (!visited[i][j]) {
                    if (isBoundary(i, j)) {
                        visited[i][j] = true;
                        dfs(i, j, index + 1, sum + box[i][j]);
                        visited[i][j] = false;
                    }
                }
            }
        }
    }

    private static boolean isBoundary(int y, int x) {
        boolean flag = true;
        for (int i = 0; i < 4; i++) {
            int dx = mx[i] + x;
            int dy = my[i] + y;

            if ((dx < N && dy < M && dx >= 0 && dy >= 0) && (visited[dy][dx])) {
                flag = false;
            }
        }

        return flag;
    }
}
