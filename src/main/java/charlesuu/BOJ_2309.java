package charlesuu;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class BOJ_2309 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int sum = 0;
        int[] array = new int[9];
        for (int i = 0; i < 9; i++) {
            array[i] = sc.nextInt();
            sum += array[i];
        }

        for (int i = 0; i < 8; i++) {
            for (int j = i + 1; j < 9; j++) {
                if (sum - array[i] - array[j] == 100) {
                    array[i] = 0;
                    array[j] = 0;

                    Arrays.sort(array);

                    for (int k = 2; k < 9; k++) {
                        System.out.println(array[k]);
                    }
                    return;
                }
            }
        }
    }
}
