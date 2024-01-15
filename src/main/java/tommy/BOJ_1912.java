package tommy;

import java.util.Scanner;

public class BOJ_1912 {
    static int n;
    static int[] arr;
    static Integer[] dp;
    static int max;

    /*
     * Time Complexity : O(N^2)
     * Space Complexity : O(N)
     */
    private static void solution() {
        // 기본 초기화
        dp[0] = arr[0];
        max = dp[0];

        recursion(n - 1);

        System.out.println(max);
    }

    private static int recursion(int n) {
        if (dp[n] == null) {
            dp[n] = Math.max(recursion(n - 1) + arr[n], arr[n]);
            max = Math.max(max, dp[n]);
        }

        return dp[n];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        arr = new int[n];
        dp = new Integer[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        solution();
    }
}
