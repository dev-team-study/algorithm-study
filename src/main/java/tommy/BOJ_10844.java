package tommy;

import java.util.Scanner;

public class BOJ_10844 {
    static Long[][] dp;
    static long MOD = 1000000000;
    static int N;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        dp = new Long[N + 1][10];
        solution();
    }

    private static void solution() {
        // 1번째 값 초기화
        for (int i = 0; i < 10; i++) {
            dp[1][i] = 1L;
        }

        long result = 0;
        for (int i = 1; i <= 9; i++) {
            result += (recursion(N, i));
        }
        System.out.println(result);
    }

    private static long recursion(int depth, int value) {
        if (depth == 1) {
            return dp[depth][value];
        }

        if (dp[depth][value] == null) {
            if (value == 0) {
                dp[depth][value] = recursion(depth - 1, 1);
            } else if (value == 9) {
                dp[depth][value] = recursion(depth - 1, 8);
            } else {
                dp[depth][value] = recursion(depth - 1, value - 1) + recursion(depth - 1, value + 1);
            }
        }
        return dp[depth][value] % MOD;
    }

}
