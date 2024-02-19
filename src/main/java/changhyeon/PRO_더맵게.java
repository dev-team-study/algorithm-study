package changhyeon;

import java.util.PriorityQueue;

public class PRO_더맵게 {

    public int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();

        for (int number : scoville) {
            priorityQueue.add(number);
        }

        while (true) {
            if (priorityQueue.size() < 2 && priorityQueue.peek() < K) {
                return -1;
            }

            Integer num1 = priorityQueue.peek();

            if (num1 >= K) {
                break;
            }

            priorityQueue.poll();
            int num2 = priorityQueue.poll();
            int newNumber = num1 + (num2 * 2);
            priorityQueue.add(newNumber);
            answer++;
        }

        return answer;
    }
}
