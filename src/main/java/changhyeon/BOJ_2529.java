package changhyeon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/*
 * 시간 복잡도: O(N! * N)
 * 공간 복잡도: O(N)
 */

public class BOJ_2529 {

    private static final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    private static int K;
    private static String[] sign;
    private static int[] numbers;
    private static boolean[] visited;
    private static List<String> result = new ArrayList<>();
    private static StringBuilder stringBuilder = new StringBuilder();

    public static void main(String[] args) throws IOException {
        K = Integer.parseInt(bufferedReader.readLine());
        sign = bufferedReader.readLine().split(" ");
        numbers = new int[K + 1];
        visited = new boolean[10];

        recursive(0);

        System.out.println(result.get(result.size() - 1));
        System.out.println(result.get(0));
    }

    private static void recursive(int count) {
        if (count == K + 1) {
            calculate();

            return;
        }

        for (int i = 0; i <= 9; i++) {
            if (!visited[i]) {
                numbers[count] = i;
                visited[i] = true;
                recursive(count + 1);
                visited[i] = false;
            }
        }
    }

    private static void calculate() {
        for (int i = 0; i < K; i++) {
            if (sign[i].equals("<")) {
                if (numbers[i] < numbers[i + 1]) {
                    continue;
                }
                return;
            }

            if (sign[i].equals(">")) {
                if (numbers[i] > numbers[i + 1]) {
                    continue;
                }
                return;
            }
        }

        stringBuilder = new StringBuilder();
        for (int num : numbers) {
            stringBuilder.append(num);
        }

        result.add(stringBuilder.toString());
    }
}
