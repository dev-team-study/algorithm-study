package tommy;

import java.util.Scanner;

public class BOJ_16931 {

    static int N, M;
    static int[][] map;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();

        int area = 0;

        map = new int[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                map[i][j] = sc.nextInt();
                area++; // 위
            }
        }

        area *= 2;  // 아래

        // East
        for (int i = 0; i < N; i++) {
            for (int j = M - 1; j >= 1; j--) {
                int space = map[i][j - 1] - map[i][j];
                if (space >= 0) {
                    area += space;
                }
            }
            area += map[i][M - 1];
        }

        // West
        for (int i = 0; i < N; i++) {
            for (int j = 1; j < M; j++) {
                int space = map[i][j] - map[i][j - 1];
                if (space >= 0) {
                    area += space;
                }
            }
            area += map[i][0];
        }

        // North
        for (int j = 0; j < M; j++) {
            for (int i = 0; i < N - 1; i++) {
                int space = map[i + 1][j] - map[i][j];
                if (space >= 0) {
                    area += space;
                }
            }
            area += map[0][j];
        }

        // South
        for (int j = 0; j < M; j++) {
            for (int i = N - 1; i >= 1; i--) {
                int space = map[i - 1][j] - map[i][j];
                if (space >= 0) {
                    area += space;
                }
            }
            area += map[N - 1][j];
        }

        System.out.println(area);
    }
}
