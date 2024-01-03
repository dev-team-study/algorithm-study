package changhyeon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.stream.Collectors;

public class BOJ_10972 {

    private static final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    private static int N;
    private static String numString;
    private static int[] numbers;
    private static boolean[] visited;
    private static boolean flag = false;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(bufferedReader.readLine());
        numString = bufferedReader.readLine().replace(" ", "");
        numbers = new int[N];
        visited = new boolean[N];

        recursive(0);

        if (flag) {
            System.out.println(-1);
        }
    }

    private static void recursive(int count) {
        if (count == N) {
            if (flag) {
                for (int num : numbers) {
                    System.out.print(num + " ");
                }
                flag = false;
                return;
            }

            String temp = Arrays.stream(numbers)
                    .boxed()
                    .map(String::valueOf)
                    .collect(Collectors.joining());

            if (numString.equals(temp)) {
                flag = true;
            }

            return;
        }

        for (int i = 0; i < N; i++) {
            if (!visited[i]) {
                numbers[count] = i + 1;
                visited[i] = true;
                recursive(count + 1);
                visited[i] = false;
            }
        }
    }
}
