package changhyeon;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PRO_K번째수 {

    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];

        for (int i = 0; i < commands.length; i++) {
            answer[i] = doProcess(array, commands[i]);
        }

        return answer;
    }

    private int doProcess(int[] array, int[] command) {
        int start = command[0];
        int end = command[1];
        int select = command[2];
        List<Integer> slicedArray = slice(array, start, end);

        Collections.sort(slicedArray);

        return slicedArray.get(select - 1);
    }

    private List<Integer> slice(int[] array, int start, int end) {
        List<Integer> slicedArray = new ArrayList<>();

        for (int i = start - 1; i <= end - 1; i++) {
            slicedArray.add(array[i]);
        }

        return slicedArray;
    }
}
