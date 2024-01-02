package tommy;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class BOJ_2529 {
    static String[] sign;
    static List<String> answer;
    static boolean[] visited;

    /*
     * 시간 복잡도 : O(N!)
     * 공간 복잡도 : O(N) -> 이 부분은 애매하다..
     */
    private void solution() {
        recursion(0, "");
        System.out.println(answer.get(answer.size() - 1));
        System.out.println(answer.get(0));
    }

    private void recursion(int depth, String num) {
        if (depth == sign.length + 1) {
            if (isValid(num)) {
                answer.add(num);
            }
        }

        for (int i = 0; i <= 9; i++) {
            if (!visited[i]) {
                visited[i] = true;
                recursion(depth + 1, num + i);
                visited[i] = false;
            }
        }
    }

    private boolean isValid(String num) {
        boolean result = true;
        for (int i = 0; i < num.length() - 1; i++) {
            if (sign[i].equals("<")) {
                if (num.charAt(i) > num.charAt(i + 1)) {
                    return false;
                }
            }
            if (sign[i].equals(">")) {
                if (num.charAt(i) < num.charAt(i + 1)) {
                    return false;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        BOJ_2529 main = new BOJ_2529();
        Scanner sc = new Scanner(System.in);

        int nums = sc.nextInt();
        sign = new String[nums];
        visited = new boolean[10];
        answer = new ArrayList<>();

        for (int i = 0; i < nums; i++) {
            sign[i] = sc.next();
        }
        main.solution();
    }
}
