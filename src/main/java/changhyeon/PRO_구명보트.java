package changhyeon;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class PRO_구명보트 {

    public int solution(int[] people, int limit) {
        int count = 0;
        Arrays.sort(people);
        Deque<Integer> deque = new ArrayDeque<>();

        for (int i = people.length - 1; i >= 0; i--) {
            deque.add(people[i]);
        }

        while (deque.size() >= 2) {
            int first = deque.peekFirst();
            int last = deque.peekLast();

            if (first + last <= limit) {
                deque.pollFirst();
                deque.pollLast();
                count++;
                continue;
            }

            deque.poll();
            count++;
        }

        if (!deque.isEmpty()) {
            deque.poll();
            count++;
        }

        return count;
    }
}
