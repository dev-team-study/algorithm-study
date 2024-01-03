package tommy;

import java.util.Scanner;

public class BOJ_10974 {
    static int nums;
    static int[] answer;
    static boolean[] visited;
    static StringBuilder sb = new StringBuilder();

    /*
     * 시간 복잡도 : O(N!)
     * 공간 복잡도 : O(N)
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        nums = sc.nextInt();
        answer = new int[nums];
        visited = new boolean[nums + 1];

        solution(0);
        System.out.println(sb);
    }

    private static void solution(int depth) {
        if (depth == nums) {
            for (int i : answer) {
                sb.append(i).append(" ");
            }
            sb.append("\n");
        }

        for (int i = 1; i <= nums; i++) {
            if (!visited[i]) {
                visited[i] = true;
                answer[depth] = i;
                solution(depth + 1);
                visited[i] = false;
            }
        }
    }
}
