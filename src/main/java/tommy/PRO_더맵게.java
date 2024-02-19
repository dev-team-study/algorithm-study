package tommy;

import java.util.PriorityQueue;

public class PRO_더맵게 {
    public int solution(int[] scoville, int K) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for(int s : scoville){
            queue.add(s);
        }

        int answer = 0;
        int min = queue.peek();
        while(min < K){
            if(queue.size() >= 2){
                queue.add(queue.poll() + (queue.poll() * 2));
                min = queue.peek();
                answer++;
            } else {
                return -1;
            }
        }
        return answer;
    }
}
