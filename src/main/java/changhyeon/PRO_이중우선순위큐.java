package changhyeon;

import java.util.PriorityQueue;

public class PRO_이중우선순위큐 {

    PriorityQueue<Integer> queue = new PriorityQueue<>();

    public int[] solution(String[] operations) {
        for (String operation : operations) {
            String[] line = operation.split(" ");
            String order = line[0];
            int number = Integer.parseInt(line[1]);

            if (order.equals("I")) {
                addNumber(number);
                continue;
            }

            deleteNumber(number);
        }

        if (queue.isEmpty()) { // 큐가 비었을 때
            return new int[] {0, 0};
        }

        int max = -10000000;
        for (int num : queue) { // 최대 값
            if (num > max) {
                max = num;
            }
        }

        return new int[] {max, queue.poll()};
    }

    private void addNumber(int number) {
        queue.add(number);
    }

    private void deleteNumber(int number) {
        if (!queue.isEmpty()) { // 큐가 비지 않았을 때
            if (number == 1) { // 1이면 최대 값 삭제
                int max = -10000000;
                for (int num : queue) {
                    if (num > max) {
                        max = num;
                    }
                }

                queue.remove(max);
                return;
            }

            queue.poll(); // -1이면 최소 값 삭제
        }
    }
}
