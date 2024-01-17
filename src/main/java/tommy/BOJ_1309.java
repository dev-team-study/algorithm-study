package tommy;

import java.util.Scanner;

public class BOJ_1309 {
    static final int MOD = 9901;
    static int N;
    static int[][] dp;

    /*
     * Time Complexity : O(N)
     * Space Complexity : O(N)
     */
    private static void solution() {
        for (int i = 2; i <= N; i++) {
            dp[i][0] = (dp[i - 1][0] + dp[i - 1][1] + dp[i - 1][2]) % MOD;
            dp[i][1] = (dp[i - 1][0] + dp[i - 1][2]) % MOD;
            dp[i][2] = (dp[i - 1][0] + dp[i - 1][1]) % MOD;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        dp = new int[N + 1][3];
        dp[1][0] = 1;   // 아무것도 놓지 않는 경우
        dp[1][1] = 1;   // 왼쪽에 놓는 경우
        dp[1][2] = 1;   // 오른쪽에 놓는 경우
        solution();
        System.out.println((dp[N][0] + dp[N][1] + dp[N][2]) % MOD);
    }
}
