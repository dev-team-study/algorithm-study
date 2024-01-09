package tommy;

import java.util.Scanner;

public class BOJ_1182 {
    static int N;
    static int target;
    static int[] arr;
    static int answer = 0;


    private static void dfs(int depth, int sum) {
        if (depth == N) {
            if (sum == target) {
                answer++;
            }
            return;
        }
        dfs(depth + 1, sum + arr[depth]);
        dfs(depth + 1, sum);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        target = sc.nextInt();
        arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }
        dfs(0, 0);
        if (target == 0) {
            answer--;
        }
        System.out.println(answer);
    }
}
