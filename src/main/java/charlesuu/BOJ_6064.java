package charlesuu;

import java.util.Scanner;
/*
 시간 복잡도 : O(N) == O((M * N) / M)
 공간 복잡도 : O(1) 
 */

public class BOJ_6064 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int count = sc.nextInt();

        for (int i = 0; i < count; i++) {

            int M = sc.nextInt();
            int N = sc.nextInt();
            int x = sc.nextInt();
            int y = sc.nextInt();

            boolean isFinished = false;
            for (int j = x; j <= M * N; j = j + M) {
                if (N == y) {
                    if (j % N == 0) {
                        System.out.println(j);
                        isFinished = true;
                        break;
                    }
                } else {
                    if (j % N == y) {
                        System.out.println(j);
                        isFinished = true;
                        break;
                    }
                }
            }

            if (!isFinished) {
                System.out.println(-1);
            }
        }
    }
}
