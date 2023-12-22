package changhyeon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


/*
    시간 복잡도: O(N) -> 재귀
    공간 복잡도: O(1)
 */

public class BOJ_9095 {

    private static final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    private static int count = 0;

    public static void main(String[] args) throws IOException {
        int targetCount = Integer.parseInt(bufferedReader.readLine());

        for (int i = 0; i < targetCount; i++) {
            int target = Integer.parseInt(bufferedReader.readLine());
            count = 0;
            dfs(target, 0);

            System.out.println(count);
        }
    }

    private static void dfs(final int target, final int sum) {
        if (target < sum) {
            return;
        }

        if (target == sum) {
            count++;
            return;
        }

        for (int i = 1; i <= 3; i++) {
            dfs(target, sum + i);
        }
    }
}
