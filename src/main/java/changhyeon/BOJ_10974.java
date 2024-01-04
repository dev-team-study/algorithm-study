package changhyeon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_10974 {

    private static final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    private static int N;
    private static int[] numbers;
    private static boolean[] visited;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(bufferedReader.readLine());

        numbers = new int[N];
        visited = new boolean[N];

        recursive(0);
    }

    private static void recursive(final int count) {
        if (count == N) {
            for (int num : numbers) {
                System.out.print(num + " ");
            }
            System.out.println();
            return;
        }

        for (int i = 1; i <= N; i++) {
            if (!visited[i - 1]) {
                numbers[count] = i;
                visited[i - 1] = true;
                recursive(count + 1);
                visited[i - 1] = false;
            }
        }
    }
}
