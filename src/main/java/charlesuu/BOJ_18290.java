package charlesuu;

import java.util.Scanner;
/*
 시간 복잡도 : O(N * N!) < T < O(N^2 * N!)
 공간 복잡도 : O(N^2)
 */

public class BOJ_18290 {
    public static int[][] board = new int[10][10];
    public static boolean[][] hasSelected = new boolean[10][10];
    public static int[] dRow = {-1, 0, 1, 0};
    public static int[] dCol = {0, 1, 0, -1};

    public static int answer = Integer.MIN_VALUE;

    public static int N;
    public static int M;
    public static int K;

    public static void recursive(int depth, int prevRow, int prevCol, int sum) {
        if (depth == K) {
            if (sum > answer) {
                answer = sum;
            }
            return;
        }

        for (int i = prevRow; i < N; i++) {
            for (int j = (i == prevRow ? prevCol : 0); j < M; j++) {
                if (hasSelected[i][j]) continue;

                boolean isSelectable = true;
                for (int k = 0; k < 4; k++) {
                    int nRow = i + dRow[k];
                    int nCol = j + dCol[k];

                    if (0 <= nRow && nRow < N && 0 <= nCol && nCol < M) {
                        if (hasSelected[nRow][nCol]) {
                            isSelectable = false;
                        }
                    }
                }

                if (isSelectable) {
                    hasSelected[i][j] = true;
                    recursive(depth + 1, i, j, sum + board[i][j]);
                    hasSelected[i][j] = false;
                }

            }
        }
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();
        K = sc.nextInt();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                board[i][j] = sc.nextInt();
            }
        }

        recursive(0, 0, 0, 0);

        System.out.println(answer);
    }
}
