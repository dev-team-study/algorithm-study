package changhyeon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_15650 {

    private static final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    private static int N, M;
    private static boolean[] visited;
    private static int[] nums;

    public static void main(String[] args) throws IOException {

        String[] numbers = bufferedReader.readLine().split(" ");
        N = Integer.parseInt(numbers[0]);
        M = Integer.parseInt(numbers[1]);

        visited = new boolean[N];
        nums = new int[M];

        dfs(0, 0);
    }

    private static void dfs(int count, int j) {
        if (count == M) {
            for (int num : nums) {
                System.out.print(num + " ");
            }

            System.out.println();
            return;
        }

        for (int i = j; i < N; i++) {
            nums[count] = i + 1;
            dfs(count + 1, i + 1);
        }
    }
}
