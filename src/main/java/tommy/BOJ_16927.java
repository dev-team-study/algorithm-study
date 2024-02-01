package tommy;

import java.util.Scanner;

public class BOJ_16927 {
    static int N, M;
    static int[][] arr;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        int R = sc.nextInt();
        int min = Math.min(M, N);

        arr = new int[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        int nN = N;
        int nM = M;
        for (int i = 0; i < min / 2; i++) {
            int nR = R % (2 * nN + 2 * nM - 4);
            for (int r = 0; r < nR; r++) {
                rotation(i);
            }
            nN -= 2;
            nM -= 2;
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

    private static void rotation(int start) {
        int x = start;
        int y = start;
        int index = 0;
        int temp = arr[x][y];
        while (index < 4) {
            int nx = x + dx[index];
            int ny = y + dy[index];
            if (nx >= start && nx < N - start && ny >= start && ny < M - start) {
                arr[x][y] = arr[nx][ny];
                x = nx;
                y = ny;
            } else {
                index++;
            }
        }
        arr[start + 1][start] = temp;
    }
}
