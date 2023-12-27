package changhyeon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/*
 * 시간 복잡도: O(N!)
 * 공간 복잡도: O(N) -> 입력받은 배열에 따라
 */

public class BOJ_15651 {

    private static final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
    private static int N, M;
    private static int[] nums;

    public static void main(String[] args) throws IOException {

        String[] line = bufferedReader.readLine().split(" ");
        N = Integer.parseInt(line[0]);
        M = Integer.parseInt(line[1]);

        nums = new int[M];

        dfs(0);
        bufferedWriter.close();
    }

    private static void dfs(final int count) throws IOException {
        if (count == M) {
            for (int num : nums) {
                bufferedWriter.write(num + " ");
            }

            bufferedWriter.newLine();
            return;
        }

        for (int i = 0; i < N; i++) {
            nums[count] = i + 1;
            dfs(count + 1);
        }
    }
}
