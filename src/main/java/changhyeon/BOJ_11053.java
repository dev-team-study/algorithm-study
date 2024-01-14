package changhyeon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 시간 복잡도: O(N^2)
 * 공간 복잡도: O(N)
 */

public class BOJ_11053 {

    private static final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    private static int MAX = 0;

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(bufferedReader.readLine());
        int[] arr = new int[N];
        int[] dp = new int[N];

        StringTokenizer st = new StringTokenizer(bufferedReader.readLine());

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            dp[i] = 1;
        }

        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                if (arr[i] < arr[j]) {
                    dp[j] = Math.max(dp[j], dp[i] + 1);
                }
            }
        }

        for (int i = 0; i < N; i++) {
            if (MAX < dp[i])
                MAX = dp[i];
        }

        System.out.print(MAX);
    }
}
