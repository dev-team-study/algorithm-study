package tommy;

import java.util.Scanner;

public class BOJ_1699 {
    static int[] dp;

    private static void solution(int n) {
        for (int i = 1; i <= n; i++) {
            dp[i] = i;
            for (int j = 1; j * j <= i; j++) {
                if (dp[i] > dp[i - j * j] + 1) {
                    dp[i] = dp[i - j * j] + 1;
                }
            }
        }
        System.out.println(dp[n]);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        dp = new int[N + 1];
        solution(N);
    }
}
