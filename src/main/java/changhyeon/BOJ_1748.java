package changhyeon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
    시간 복잡도: O(N) -> 입력 값에 따라 N번의 for문 돌아감
    공간 복잡도: O(1)
 */

public class BOJ_1748 {

    private static final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(bufferedReader.readLine());
        int result = 0;

        for (int i = 1; i <= N; i *= 10) {
            result += (N - i + 1);
        }

        System.out.println(result);
    }
}
