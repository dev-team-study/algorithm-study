package changhyeon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/*
    시간 복잡도: O(N^2) 이중 For문 이용하여 O(N^2)
    공간 복잡도: O(1) 배열을 사용하긴하나 고정된 배열이므로 별도의 N개의 공간을 차지하지 않고 1로 침
 */

public class BOJ_1107 {

    private static final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int target = Integer.parseInt(bufferedReader.readLine());
        int count = Integer.parseInt(bufferedReader.readLine());
        boolean[] broken = new boolean[10];

        if (count != 0) {
            int[] errorButtons = Arrays.stream(bufferedReader.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();

            for (int i = 0; i < count; i++) {
                int n = errorButtons[i];
                broken[n] = true;
            }
        }

        int result = Math.abs(target - 100);
        for (int i = 0; i <= 999999; i++) {
            String str = String.valueOf(i);
            int len = str.length();

            boolean isBreak = false;
            for (int j = 0; j < len; j++) {
                if (broken[str.charAt(j) - '0']) {
                    isBreak = true;
                    break;
                }
            }
            if (!isBreak) {
                int min = Math.abs(target - i) + len;
                result = Math.min(min, result);
            }
        }

        System.out.println(result);
    }
}
