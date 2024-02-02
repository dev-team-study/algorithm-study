package tommy;

import java.util.Scanner;

public class BOJ_14890 {
    static int N;
    static int L;
    static int[][] map;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        L = sc.nextInt();

        map = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                map[i][j] = sc.nextInt();
            }
        }

        int answer = 0;
        for (int i = 0; i < N; i++) {
            if (checkRow(i)) answer++;
            if (checkCol(i)) answer++;
        }

        System.out.println(answer);
    }

    private static boolean checkRow(int row) {
        boolean[] isInstalled = new boolean[N];

        for (int i = 0; i < N - 1; i++) {
            int diff = map[row][i] - map[row][i + 1];
            if (diff < -1 || diff > 1) return false;
            else if (diff == -1) {  // 경사로가 높아지는 경우
                for (int j = 0; j < L; j++) {
                    // 범위를 벗어나거나 이미 설치한 경우
                    if (i - j < 0 || isInstalled[i - j]) return false;
                    if (map[row][i] != map[row][i - j]) return false;
                    isInstalled[i - j] = true;
                }
            } else if (diff == 1) { // 경사로가 낮아지는 경우
                for (int j = 1; j <= L; j++) {
                    if (i + j >= N || isInstalled[i + j]) return false;
                    if (map[row][i] - 1 != map[row][i + j]) return false;
                    isInstalled[i + j] = true;
                }
            }
        }
        return true;
    }

    private static boolean checkCol(int col) {
        boolean[] isInstalled = new boolean[N];

        for (int i = 0; i < N - 1; i++) {
            int diff = map[i][col] - map[i + 1][col];

            if (diff < -1 || diff > 1) return false;
            else if (diff == -1) {   // 경사로가 높아지는 경우
                for (int j = 0; j < L; j++) {
                    if (i - j < 0 || isInstalled[i - j]) return false;
                    if (map[i][col] != map[i - j][col]) return false;
                    isInstalled[i - j] = true;
                }
            } else if (diff == 1) { // 경사로가 낮아지는 경우
                for (int j = 1; j <= L; j++) {
                    if (i + j >= N || isInstalled[i+j]) return false;
                    if (map[i][col] -1 != map[i + j][col]) return false;
                    isInstalled[i + j] = true;
                }
            }
        }
        return true;
    }
}
