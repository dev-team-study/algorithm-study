package changhyeon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * 시간 복잡도: O(N^2)
 * 공간 복잡도: O(N)
 */

public class BOJ_10844 {

    private static final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    private static final int MOD = 1000000000;

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(bufferedReader.readLine());

        long[][] dp = new long[N + 1][10];
        for (int i = 1; i < 10; i++) {
            dp[1][i] = 1;
        }

        for (int i = 1; i < N; i++) {
            for (int j = 0; j < 10; j++) {
                if (dp[i][j] > 0) {
                    if (j - 1 >= 0)
                        dp[i + 1][j - 1] = (dp[i + 1][j - 1] + dp[i][j]) % MOD;
                    if (j + 1 <= 9)
                        dp[i + 1][j + 1] = (dp[i + 1][j + 1] + dp[i][j]) % MOD;
                }
            }
        }
        long sum = 0;
        for (int i = 0; i < 10; i++) {
            sum += (dp[N][i] % MOD);
        }

        System.out.println(sum % MOD);
    }
}
