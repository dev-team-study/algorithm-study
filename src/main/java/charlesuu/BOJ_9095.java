package charlesuu;

import java.util.Scanner;
/*
 시간 복잡도 : O(N)
 공간 복잡도 : O(N)
 */

public class BOJ_9095 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int[] dp = new int[12];
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;

        for (int i = 4; i < 12; i++) {
            dp[i] = dp[i - 3] + dp[i - 2] + dp[i - 1];
        }

        int count = sc.nextInt();
        for (int i = 0; i < count; i++) {
            int index = sc.nextInt();
            System.out.println(dp[index]);
        }
    }
}
