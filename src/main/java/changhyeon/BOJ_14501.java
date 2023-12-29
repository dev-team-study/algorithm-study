package changhyeon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ_14501 {

    private static int n, answer = 0;
    private static int[] T, P;
    private static final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws Exception {
        n = Integer.parseInt(bufferedReader.readLine());

        T = new int[n];
        P = new int[n];

        for (int i = 0; i < n; i++) {
            String[] line = bufferedReader.readLine().split(" ");

            T[i] = Integer.parseInt(line[0]);
            P[i] = Integer.parseInt(line[1]);
        }

        dfs(0, 0);
        System.out.println(answer);
    }

    private static void dfs(int index, int value) {
        if (index >= n) {
            answer = Math.max(answer, value);
            return;
        }

        if (index + T[index] <= n) {
            dfs(index + T[index], value + P[index]);
        } else {
            dfs(index + T[index], value);
        }

        dfs(index + 1, value);
    }
}
