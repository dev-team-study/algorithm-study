package tommy;

import java.util.Scanner;

public class BOJ_1463 {
    static int x;
    static int[] arr;

    /*
     * 시간 복잡도 : O(N)
     * 공간 복잡도 : O(N)
     */
    private static void solution() {
        arr[0] = 0;
        arr[1] = 0;

        for (int i = 2; i <= x; i++) {
            arr[i] = arr[i - 1] + 1;
            if (i % 2 == 0) arr[i] = Math.min(arr[i], arr[i / 2] + 1);
            if (i % 3 == 0) arr[i] = Math.min(arr[i], arr[i / 3] + 1);
        }
        System.out.println(arr[x]);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        x = sc.nextInt();
        arr = new int[x + 1];
        solution();
    }
}
