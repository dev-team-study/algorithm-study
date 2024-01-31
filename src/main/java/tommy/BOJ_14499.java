package tommy;

import java.util.Scanner;

public class BOJ_14499 {
    static int N, M, x, y;
    static int[][] map;
    static int[] dice = new int[7];
    // 동 서 북 남
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0};
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        x = sc.nextInt();
        y = sc.nextInt();
        int K = sc.nextInt();

        map = new int[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                map[i][j] = sc.nextInt();
            }
        }

        for (int k = 0; k < K; k++) {
            int direction = sc.nextInt() - 1;
            int nx = x + dx[direction];
            int ny = y + dy[direction];
            if (nx < 0 || ny < 0 || nx >= N || ny >= M) {
                continue;
            } else {
                rotation(nx, ny, direction);
            }
            x = nx;
            y = ny;
        }

        System.out.println(sb);
    }

    private static void rotation(int nx, int ny, int direction) {
        int temp;
        switch (direction) {
            // 동
            case 0:
                temp = dice[1];
                dice[1] = dice[4];
                dice[4] = dice[6];
                dice[6] = dice[3];
                dice[3] = temp;
                break;
            // 서
            case 1:
                temp = dice[1];
                dice[1] = dice[3];
                dice[3] = dice[6];
                dice[6] = dice[4];
                dice[4] = temp;
                break;
            // 북
            case 2:
                temp = dice[1];
                dice[1] = dice[5];
                dice[5] = dice[6];
                dice[6] = dice[2];
                dice[2] = temp;
                break;
            // 남
            case 3:
                temp = dice[1];
                dice[1] = dice[2];
                dice[2] = dice[6];
                dice[6] = dice[5];
                dice[5] = temp;
                break;
        }
        sb.append(dice[1]).append("\n");
        if (map[nx][ny] == 0) {
            map[nx][ny] = dice[6];
        } else {
            dice[6] = map[nx][ny];
            map[nx][ny] = 0;
        }
    }
}
