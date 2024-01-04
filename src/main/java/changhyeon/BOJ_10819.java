package changhyeon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_10819 {

    private static final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    private static int sum, N, max = Integer.MIN_VALUE;
    private static int[] arr, numbers;
    private static boolean[] visited;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(bufferedReader.readLine());
        arr = Arrays.stream(bufferedReader.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        numbers = new int[N];
        visited = new boolean[N];

        recursive(0);

        System.out.println(max);
    }

    private static void recursive(int count) {
        if (count == N) {
            calculate();
            return;
        }

        for (int i = 0; i < N; i++) {
            if (!visited[i]) {
                numbers[count] = arr[i];
                visited[i] = true;
                recursive(count + 1);
                visited[i] = false;
            }
        }
    }

    private static void calculate() {
        sum = 0;
        for (int i = 0; i < N - 1; i++) {
            sum = sum + Math.abs(numbers[i] - numbers[i + 1]);
        }

        max = Math.max(max, sum);
    }
}
