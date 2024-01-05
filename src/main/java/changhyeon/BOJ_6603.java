package changhyeon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/*
 * 시간 복잡도 (N * N!)
 * 공간 복잡도 (N)
 */

public class BOJ_6603 {

    private static final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    private static int[] numbers, tempArr;
    private static int numberCount, LOTTO_MAX = 6;
    private static boolean[] visited;

    public static void main(String[] args) throws IOException {

        while (true) {
            String line = bufferedReader.readLine();

            if (line.equals("0")) {
                break;
            }

            String[] numberArr = line.split(" ");
            numberCount = Integer.parseInt(numberArr[0]);
            numbers = new int[numberCount];
            tempArr = new int[LOTTO_MAX];
            visited = new boolean[numberCount];

            for (int i = 1; i <= numberCount; i++) {
                numbers[i - 1] = Integer.parseInt(numberArr[i]);
            }

            Arrays.sort(numbers);
            recursive(0);
            System.out.println();
        }
    }

    private static void recursive(final int count) {
        if (count == LOTTO_MAX) {
            checkSort();
            return;
        }

        for (int i = 0; i < numberCount; i++) {
            if (!visited[i]) {
                tempArr[count] = numbers[i];
                visited[i] = true;
                recursive(count + 1);
                visited[i] = false;
            }
        }
    }

    private static void checkSort() {
        boolean flag = false;
        for (int i = 0; i < LOTTO_MAX - 1; i++) {
            if (tempArr[i] > tempArr[i + 1]) {
                flag = true;
            }
        }

        if (!flag) {
            for (int num : tempArr) {
                System.out.print(num + " ");
            }

            System.out.println();
        }
    }
}
