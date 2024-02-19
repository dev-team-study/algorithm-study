package tommy;

import java.util.LinkedList;
import java.util.Queue;

public class PRO_다리를지나는트럭 {

    public int solution(int bridge_length, int weight, int[] truck_weights) {
        Queue<Integer> queue = new LinkedList<>();
        int time = 0;
        int sum = 0;

        for(int i = 0; i < truck_weights.length; i++){
            int current = truck_weights[i];

            while(true){
                if(queue.isEmpty()){
                    queue.add(current);
                    sum += current;
                    time++;
                    break;
                } else if (queue.size() == bridge_length){
                    sum -= queue.poll();
                } else {
                    if(sum + current <= weight){
                        queue.add(current);
                        sum += current;
                        time++;
                        break;
                    } else{
                        queue.add(0);
                        time++;
                    }
                }
            }
        }

        return bridge_length + time;
    }
}
