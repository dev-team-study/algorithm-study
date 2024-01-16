package tommy;

import java.util.Scanner;

public class BOJ_15988 {
    static int t;
    static int[] N;
    static long[] dp;
    static StringBuilder sb = new StringBuilder();

    /*
     * Time Complexity : O(N)
     * Space Complexity : O(N)
     */
    static void solution() {
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;
        for (int i = 4; i <= 1000000; i++) {
            dp[i] = (dp[i - 1] + dp[i - 2] + dp[i - 3]) % 1000000009;
        }

        for (int n : N) {
            sb.append(dp[n]).append("\n");
        }

        System.out.println(sb);
    }



    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        t = sc.nextInt();
        N = new int[t];
        dp = new long[1000001];
        for (int i = 0; i < t; i++) {
            N[i] = sc.nextInt();
        }

        solution();
    }
}
