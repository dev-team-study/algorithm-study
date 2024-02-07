package changhyeon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_16931 {

    private static final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    private static final int[] mx = {-1, 0, 1, 0};
    private static final int[] my = {0, 1, 0, -1};
    private static int result = 0;

    public static void main(String[] args) throws IOException {
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        int N = Integer.parseInt(stringTokenizer.nextToken());
        int M = Integer.parseInt(stringTokenizer.nextToken());

        int[][] map = new int[N][M];

        for (int i = 0; i < N; i++) {
            map[i] = Arrays.stream(bufferedReader.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }

        result += 2 * N * M;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {

                for (int k = 0; k < 4; k++) {
                    int dx = i + mx[k];
                    int dy = j + my[k];

                    if (dx < 0 || dy < 0 || dx > N - 1 || dy > M - 1) {
                        result += map[i][j];
                        continue;
                    }

                    if (map[dx][dy] < map[i][j]) {
                        result += map[i][j] - map[dx][dy];
                    }
                }
            }
        }

        System.out.println(result);
    }
}
