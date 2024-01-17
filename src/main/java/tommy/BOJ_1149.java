package tommy;

import java.util.Scanner;

public class BOJ_1149 {

    static final int RED = 0;
    static final int GREEN = 1;
    static final int BLUE = 2;

    static int N;
    static int[][] arr;
    static int[][] dp;

    /*
     * Time Complexity : O(N)
     * Space Complexity : O(N)
     */
    private static int solution(int depth, int color) {
        if (dp[depth][color] == 0) {
            if (color == RED) {
                dp[depth][RED] = Math.min(solution(depth - 1, GREEN), solution(depth - 1, BLUE)) + arr[depth][RED];
            } else if (color == GREEN) {
                dp[depth][GREEN] = Math.min(solution(depth - 1, RED), solution(depth - 1, BLUE)) + arr[depth][GREEN];
            } else {
                dp[depth][BLUE] = Math.min(solution(depth - 1, RED), solution(depth - 1, GREEN)) + arr[depth][BLUE];
            }
        }
        return dp[depth][color];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        arr = new int[N][3];
        dp = new int[N][3];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < 3; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        dp[0][RED] = arr[0][RED];
        dp[0][GREEN] = arr[0][GREEN];
        dp[0][BLUE] = arr[0][BLUE];

        System.out.println(Math.min(solution(N - 1, RED), Math.min(solution(N - 1, GREEN), solution(N - 1, BLUE))));
    }
}
