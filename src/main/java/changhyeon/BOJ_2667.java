package changhyeon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class BOJ_2667 {

    private static final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    private static int[][] map;
    private static boolean[][] visited;
    private static int N, count;
    private static int[] dx = {0, 0, -1, 1};
    private static int[] dy = {-1, 1, 0, 0};
    private static List<Integer> nums = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(bufferedReader.readLine());
        map = new int[N][N];
        visited = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            String[] line = bufferedReader.readLine().split("");
            map[i] = Arrays.stream(line)
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!visited[i][j] && map[i][j] == 1) {
                    count = 0;
                    dfs(i, j);
                    nums.add(count);
                }
            }
        }

        System.out.println(nums.size());
        Collections.sort(nums);

        for (int num : nums) {
            System.out.println(num);
        }
    }

    private static void dfs(final int y, final int x) {
        count++;
        visited[y][x] = true;

        for (int i = 0; i < 4; i++) {
            int mx = dx[i] + x;
            int my = dy[i] + y;

            if (isBoundary(mx, my)) {
                dfs(my, mx);
            }
        }
    }

    private static boolean isBoundary(final int mx, final int my) {
        if (mx < N && my < N && mx >= 0 && my >= 0 && !visited[my][mx] && map[my][mx] == 1) {
            return true;
        }

        return false;
    }
}
