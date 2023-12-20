package charlesuu;

import java.util.Scanner;

/*
시간복잡도: O(N)
공간복잡도: O(1)
*/

public class BOJ_1476 {
    public static int E_SIZE = 16;
    public static int S_SIZE = 29;
    public static int M_SIZE = 20;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int E = sc.nextInt();
        int S = sc.nextInt();
        int M = sc.nextInt();

        int pE = 0;
        int pS = 0;
        int pM = 0;

        int count = 0;
        while(true) {
            count++;

            pE++;
            pS++;
            pM++;

            if (pE == E_SIZE) {
                pE = 1;
            }

            if (pS == S_SIZE) {
                pS = 1;
            }

            if (pM == M_SIZE) {
                pM = 1;
            }

            if (pE == E && pS == S && pM == M) {
                System.out.println(count);
                return;
            }

        }
    }
}
