package changhyeon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_15649 {

    private static final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    private static int N, M;
    private static boolean[] visited;
    private static int[] nums;

    public static void main(String[] args) throws IOException {

        String[] inputs = bufferedReader.readLine().split(" ");
        N = Integer.parseInt(inputs[0]);
        M = Integer.parseInt(inputs[1]);

        int count = 0;
        visited = new boolean[N];
        nums = new int[M];

        dfs(count);
    }

    private static void dfs(int count) {
        if (count == M) {
            for (int num : nums) {
                System.out.print(num + " ");
            }

            System.out.println();
            return;
        }

        for (int i = 0; i < N; i++) {
            if (!visited[i]) {
                visited[i] = true;
                nums[count] = i + 1;
                dfs(count + 1);
                visited[i] = false;
            }
        }
    }
}
