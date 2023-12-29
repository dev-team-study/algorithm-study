package tommy;

import java.util.Scanner;

public class BOJ_14501 {
    static int[] T; // Time
    static int[] P; // Income
    static int maxProfit = Integer.MIN_VALUE;

    /*
     * 시간 복잡도 : O(N!) -> 생각보다 시간 많이 잡아먹는 거 같음..
     * 공간 복잡도 : O(1) -> 별도의 공간사용 X
     */
    private void solution() {
        recursion(0, 0);
        System.out.println(maxProfit);
    }

    private void recursion(int days, int profit) {

        if (days == T.length) {
            maxProfit = Math.max(maxProfit, profit);
        } else if (days > T.length - 1){
            return;
        }

        for (int i = days; i < T.length; i++) {
            recursion(i + T[i], profit + P[i]);
            recursion(i + 1, profit);
        }

    }


    public static void main(String[] args) {
        BOJ_14501 main = new BOJ_14501();
        Scanner sc = new Scanner(System.in);
        int rows = sc.nextInt();
        T = new int[rows];
        P = new int[rows];
        for (int i = 0; i < rows; i++) {
            T[i] = sc.nextInt();
            P[i] = sc.nextInt();
        }

        main.solution();
    }
}
