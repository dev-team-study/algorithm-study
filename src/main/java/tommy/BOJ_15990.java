package tommy;

import java.util.Scanner;

public class BOJ_15990 {
    static int T;
    static int[] n;
    static long[][] dp; // 두번째 [] 의 경우 끝나는 원소의 숫자
    private static void solution() {
        dp[1][1] = 1;
        dp[2][2] = 1;
        dp[3][1] = 1;
        dp[3][2] = 1;
        dp[3][3] = 1;

        for (int i = 4; i <= 100000; i++) {
            dp[i][1] = (dp[i - 1][2] + dp[i - 1][3]) % 1000000009;
            dp[i][2] = (dp[i - 2][1] + dp[i - 2][3]) % 1000000009;
            dp[i][3] = (dp[i - 3][1] + dp[i - 3][2]) % 1000000009;
        }

        for (int num : n) {
            System.out.println((dp[num][1] + dp[num][2] + dp[num][3]) % 1000000009);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        T = sc.nextInt();
        n = new int[T];
        dp = new long[100001][4];
        for (int i = 0; i < T; i++) {
            n[i] = sc.nextInt();
        }

        solution();
    }
}
