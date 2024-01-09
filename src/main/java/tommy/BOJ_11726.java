package tommy;

import java.util.Scanner;

public class BOJ_11726 {
    static int[] arr;

    /*
     * 시간 복잡도 : O(N)
     * 공간 복잡도 : O(N)
     */
    private static void solution(int n) {
        if (n == 1) {
            System.out.println(1);
            return;
        }
        if (n == 2) {
            System.out.println(2);
            return;
        }

        arr[0] = 1;
        arr[1] = 2;
        for (int i = 2; i < n; i++) {
            arr[i] = (arr[i - 1] + arr[i - 2]) % 10007;
        }
        System.out.println(arr[n - 1]);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        arr = new int[n];
        solution(n);
    }
}
