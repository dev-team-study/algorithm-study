package tommy;

import java.util.Scanner;

public class BOJ_16926 {
    static int[][] arr;
    static int min;     // 돌려야 하는 기준 rep 정하기
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int R = sc.nextInt();
        min = Math.min(N, M);

        arr = new int[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        for (int r = 0; r < R; r++) {
            rotate(N,M);
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                sb.append(arr[i][j]).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    private static void rotate(int N, int M) {
        for (int t = 0; t < min / 2; t++) {
            int x = t;
            int y = t;
            int idx = 0;
            int temp = arr[t][t];
            while (idx < 4) {
                int nx = x + dx[idx];
                int ny = y + dy[idx];
                if (nx >= t && nx < N - t && ny >= t && ny < M - t) {
                    arr[x][y] = arr[nx][ny];
                    x = nx;
                    y = ny;
                } else {
                    idx++;
                }
            }
            arr[t + 1][t] = temp;
        }
    }
}
