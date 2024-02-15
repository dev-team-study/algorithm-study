package tommy;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class PRO_기능개발 {

    /*
     * Time Complexity : O(N)
     * Space Complexity : O(N)
     */
    public int[] solution(int[] progresses, int[] speeds) {
        Queue<Integer> queue = new LinkedList<>();
        for(int i = 0; i < progresses.length; i++){
            int due = (int) Math.ceil((100.0 - progresses[i]) / speeds[i]);
            queue.add(due);
        }

        List<Integer> list = new ArrayList<>();
        while(!queue.isEmpty()){
            int current = queue.poll();
            int days = 1;
            while(!queue.isEmpty() && queue.peek() <= current){
                queue.poll();
                days++;
            }
            list.add(days);
        }

        return list.stream().mapToInt(i -> i).toArray();
    }
}
