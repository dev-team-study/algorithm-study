package changhyeon;

import java.util.ArrayDeque;
import java.util.Deque;

public class PRO_같은숫자는싫어 {

    public int[] solution(int[] arr) {
        Deque<Integer> deque = new ArrayDeque<>();

        for (int number : arr) {
            if (deque.isEmpty()) {
                deque.add(number);
                continue;
            }

            if (deque.peekLast() != number) {
                deque.add(number);
            }
        }

        int[] answer = new int[deque.size()];

        for (int i = 0; i < answer.length; i++) {
            answer[i] = deque.poll();
        }

        return answer;
    }
}
