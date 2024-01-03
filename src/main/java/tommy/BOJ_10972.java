package tommy;

import java.util.Arrays;
import java.util.Scanner;

public class BOJ_10972 {
    static int[] input;
    static int N;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        input = new int[N];

        for (int i = 0; i < N; i++) {
            input[i] = sc.nextInt();
        }

        solution();
    }

    private static void solution() {
        // 주어진 순열의 뒤부터 탐색하며 증가하는 부분을 찾는다.
        int idx = N - 1;
        while (idx > 0 && input[idx - 1] > input[idx]) {
            idx--;
        }

        // 만약 증가하는 부분이 존재하지 않는다면 다음 순열은 존재하지 않는것.
        if (idx == 0) {
            System.out.println("-1");
            return;
        }

        // 해당 인덱스를 기준으로 좌/우 지점으로 나눈다.
        // 좌측의 제일 오른쪽 숫자에 대해 우측의 제일 오른쪽 지점부터 탐색하며 큰 수를 찾는다.
        int big_idx = N - 1;
        while (big_idx > idx && input[idx - 1] > input[big_idx]) {
            big_idx--;
        }

        // 해당 숫자를 찾았다면 서로 swap
        int temp = input[idx - 1];
        input[idx - 1] = input[big_idx];
        input[big_idx] = temp;

        // 우측 지점 정렬
        Arrays.sort(input, idx, N);
        // 결과 출력
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < input.length; i++) {
            sb.append(input[i]).append(" ");
        }
        System.out.println(sb);
    }
}
