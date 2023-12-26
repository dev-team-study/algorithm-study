package tommy;

import java.util.Scanner;

public class BOJ_1784 {
    /*
     * 시간 복잡도 : O(N)
     * 공간 복잡도 : O(1)
     */
    private void solution(int input) {
        int length = 0;
        int plus = 1;
        int num = 10;
        for (int i = 1; i <= input; i++) {
            if (i % num == 0) {
                plus++;
                num *= 10;
            }
            length += plus;
        }
        System.out.println(length);
    }

    public static void main(String[] args) {
        BOJ_1784 boj_1784 = new BOJ_1784();
        Scanner sc = new Scanner(System.in);
        int input = sc.nextInt();

        boj_1784.solution(input);
    }
}
