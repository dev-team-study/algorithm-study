package tommy;

import java.util.Arrays;

public class PRO_K번째수 {
    /*
     * Time Complexity : O(N^2 logN)
     * Space Complexity : O(N)
     */
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        for(int i = 0; i < commands.length; i++){
            int[] ints = Arrays.stream(array)
                .skip(commands[i][0] - 1)
                .limit(commands[i][1] - commands[i][0] + 1)
                .sorted()
                .toArray();
            answer[i] = ints[commands[i][2] - 1];
        }

        return answer;
    }
}
