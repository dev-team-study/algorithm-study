package changhyeon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


/*
 * 시간 복잡도: O(N^2)
 * 공간 복잡도: O(N)
 */

public class BOJ_15990 {

    private static final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int T = Integer.parseInt(bufferedReader.readLine());
        int[] arr = new int[T];

        for (int i = 0; i < T; i++) {
            arr[i] = Integer.parseInt(bufferedReader.readLine());
        }

        long dp[][] = new long[100001][4];
        dp[1][1] = 1;
        dp[2][2] = 1;
        dp[3][1] = 1;
        dp[3][2] = 1;
        dp[3][3] = 1;

        for (int i = 0; i < T; i++) {
            for (int j = 4; j <= arr[i]; j++) {
                dp[j][1] = (dp[j - 1][2] + dp[j - 1][3]) % 1000000009;
                dp[j][2] = (dp[j - 2][1] + dp[j - 2][3]) % 1000000009;
                dp[j][3] = (dp[j - 3][1] + dp[j - 3][2]) % 1000000009;
            }
        }

        for (int i = 0; i < T; i++) {
            System.out.println((dp[arr[i]][1] + dp[arr[i]][2] + dp[arr[i]][3]) % 1000000009);
        }
    }
}
