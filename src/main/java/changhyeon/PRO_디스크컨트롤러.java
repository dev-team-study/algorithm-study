package changhyeon;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class PRO_디스크컨트롤러 {

    public int solution(int[][] jobs) {
        Arrays.sort(jobs, Comparator.comparingInt(job -> job[0]));

        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>((job1, job2) -> job1[1] - job2[1]);

        int index = 0;
        int count = 0;
        int total = 0;
        int end = 0;

        while (count < jobs.length) {

            while (index < jobs.length && jobs[index][0] <= end) {
                priorityQueue.add(jobs[index++]);
            }

            if (priorityQueue.isEmpty()) {
                end = jobs[index][0];
            } else {
                int[] cur = priorityQueue.poll();
                total += cur[1] + end - cur[0];
                end += cur[1];
                count++;
            }
        }

        return total / jobs.length;
    }
}
