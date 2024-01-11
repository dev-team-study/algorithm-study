package changhyeon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * 시간 복잡도: O(N)
 * 공간 복잡도: O(N)
 */

public class BOJ_9095_DP {

    private static final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {

        int count = Integer.parseInt(bufferedReader.readLine());

        int[] arr = new int[12];

        arr[1] = 1;
        arr[2] = 2;
        arr[3] = 4;

        for (int j = 4; j <= 11; j++) {
            arr[j] = arr[j - 1] + arr[j - 2] + arr[j - 3];
        }

        for (int i = 0; i < count; i++) {
            int n = Integer.parseInt(bufferedReader.readLine());
            System.out.println(arr[n]);
        }
    }
}
