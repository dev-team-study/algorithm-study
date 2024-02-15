package changhyeon;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class PRO_기능개발 {

    public int[] solution(int[] progresses, int[] speeds) {
        List<Integer> answer = new ArrayList<>();
        Deque<Integer> deque = new ArrayDeque<>();

        for (int i = 0; i < progresses.length; i++) {
            int progress = progresses[i];
            int count = 0;

            while (progress < 100) {
                count++;
                progress += speeds[i];
            }

            deque.add(count);
        }

        int count = 0;
        int number = 0;
        while (!deque.isEmpty()) {
            if (number >= deque.peek()) {
                deque.poll();
            } else {
                number = deque.poll();
            }

            count++;

            if (deque.isEmpty()) {
                answer.add(count);
            } else if (deque.peek() > number) {
                answer.add(count);
                count = 0;
                number = 0;
            }
        }

        return answer.stream().mapToInt(i -> i).toArray();
    }
}
