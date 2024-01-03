package changhyeon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.stream.Collectors;

public class BOJ_10973 {

    private static final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    private static int N;
    private static String numString;
    private static int[] numbers;
    private static int[] tempNums;
    private static int[] resultNums;
    private static boolean[] visited;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(bufferedReader.readLine());
        numString = bufferedReader.readLine().replace(" ", "");
        numbers = new int[N];
        tempNums = new int[N];
        resultNums = new int[N];
        visited = new boolean[N];

        // 재귀
        recursive(0);

        if (Arrays.stream(resultNums).sum() == 0) {
            System.out.println(-1);
            return;
        }

        for (int num : resultNums) {
            System.out.print(num + " ");
        }
    }

    private static void recursive(int count) {
        // 만들어진 순열
        if (count == N) {
            // String으로 만들기 [1, 2, 3, 4] 면 "1234"로
            String temp = Arrays.stream(numbers)
                    .boxed()
                    .map(String::valueOf)
                    .collect(Collectors.joining());

            // 만들어진 숫자 "1234"가 입력받은 숫자랑 동일한지 확인
            if (numString.equals(temp)) {
                // 동일하면 바로 이전에 만들어진 순열을 복사해서 붙여넣기
                resultNums = Arrays.copyOf(tempNums, tempNums.length);
            }

            tempNums = Arrays.copyOf(numbers, numbers.length);
            return;
        }

        // 순열 만들기
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
