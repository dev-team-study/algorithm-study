package tommy;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class BOJ_1759 {
    static int L;
    static int C;
    static char[] charArray;
    static char[] answer;
    static StringBuilder sb = new StringBuilder();
    static List<Character> mo = List.of('a', 'e', 'i', 'o', 'u');

    private void solution() {
        Arrays.sort(charArray);
        dfs(0, 0);
        System.out.println(sb);
    }

    private void dfs(int depth, int startIndex) {
        if (depth == L) {
            // 최소 모음 1개 자음 2개 검증
            int moCount = 0;
            int jaCount = 0;
            for (char c : answer) {
                if (mo.contains(c)) {
                    moCount++;
                }
            }
            jaCount = answer.length - moCount;

            if (moCount >= 1 && jaCount >= 2) {
                for (char c : answer) {
                    sb.append(c);
                }
                sb.append("\n");
            }
            return;
        }

        for (int i = startIndex; i < C; i++) {
            answer[depth] = charArray[i];
            dfs(depth + 1, i + 1);
        }
    }

    public static void main(String[] args) {
        BOJ_1759 main = new BOJ_1759();
        Scanner sc = new Scanner(System.in);
        L = sc.nextInt();
        C = sc.nextInt();
        charArray = new char[C];
        answer = new char[L];
        for (int i = 0; i < C; i++) {
            charArray[i] = sc.next().charAt(0);
        }
        main.solution();
    }
}
