package charlesuu;

import java.util.Scanner;

/*
시간복잡도: O(1) 999999번의 상수 시간에 해결
공간복잡도: O(1)
*/

public class BOJ_1107 {

    public static int TARGET;
    public static boolean[] BROKEN_BUTTEN = new boolean[10];


    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        TARGET = sc.nextInt();

        int brokenButtenCount = sc.nextInt();

        for (int i = 0; i < brokenButtenCount; i++) {
            BROKEN_BUTTEN[sc.nextInt()] = true;
        }

        int min = Math.abs(TARGET - 100);
        for (int i = 0; i <= 999999; i++) {
            String str = String.valueOf(i);

            boolean isBroken = false;
            for (int j = 0; j < str.length(); j++) {
                if (BROKEN_BUTTEN[str.charAt(j) - '0']) {
                    isBroken = true;
                    break;
                }
            }

            if (!isBroken) {
                int temp_min = Math.abs(i - TARGET) + str.length();
                min = Math.min(min, temp_min);
            }
        }

        System.out.println(min);
    }
}
