package tommy;

import java.util.Arrays;
import java.util.Scanner;

/*
왕비를 피해 일곱 난쟁이들과 함께 평화롭게 생활하고 있던 백설공주에게 위기가 찾아왔다. 일과를 마치고 돌아온 난쟁이가 일곱 명이 아닌 아홉 명이었던 것이다.

아홉 명의 난쟁이는 모두 자신이 "백설 공주와 일곱 난쟁이"의 주인공이라고 주장했다. 뛰어난 수학적 직관력을 가지고 있던 백설공주는, 다행스럽게도 일곱 난쟁이의 키의 합이 100이 됨을 기억해 냈다.

아홉 난쟁이의 키가 주어졌을 때, 백설공주를 도와 일곱 난쟁이를 찾는 프로그램을 작성하시오.
 */
public class BOJ_2309 {
    public static void main(String[] args) {
        BOJ_2309 prob = new BOJ_2309();

        Scanner scanner = new Scanner(System.in);
        int[] param = new int[9];
        for (int i = 0; i < 9; i++) {
            param[i] = scanner.nextInt();
        }
        scanner.close();
        Arrays.sort(param);
        prob.solution(param);
    }

    public void  solution(int[] param) {
        int total = 0;
        int a = 0;
        int b = 0;

        for (int i : param) {
            total += i;
        }

        for (int i = 0; i < 8; i++) {
            for (int j = i + 1; j < 9; j++) {
                if (total - param[i] - param[j] == 100) {
                    a = i;
                    b = j;
                    break;
                }
            }
        }

        for (int i = 0; i < param.length; i++) {
            if (i != a && i != b) {
                System.out.println(param[i]);
            }
        }
    }

}
