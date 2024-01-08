package changhyeon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BOJ_1182 {

    private static final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    private static int N, S, result;
    private static int[] arr;
    private static boolean[] visited;
    private static List<List<Integer>> calArr = new ArrayList<>();
    private static List<Integer> numbers = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        String[] line = bufferedReader.readLine().split(" ");

        N = Integer.parseInt(line[0]);
        S = Integer.parseInt(line[1]);

        arr = Arrays.stream(bufferedReader.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        visited = new boolean[N];

        recursive(0);
        System.out.println(result);
    }

    private static void recursive(final int count) {
        if (count == N + 1) {
            return;
        }

        int sum = 0;
        for (int number : numbers) {
            sum += number;
        }

        if (sum == S) {
            boolean tempCount = false;
            for (List<Integer> numArr : calArr) {
                if (numArr.containsAll(numbers)) {
                    tempCount = true;
                    break;
                }
            }

            if (!tempCount) {
                calArr.add(numbers);
                result++;
            }
        }

        for (int i = 0; i < N; i++) {
            if (!visited[i]) {
                numbers.add(arr[i]);
                visited[i] = true;
                recursive(count + 1);
                visited[i] = false;
                numbers.remove(numbers.size() - 1);
            }
        }
    }
}
