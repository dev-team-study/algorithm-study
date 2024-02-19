package tommy;

import java.util.ArrayList;
import java.util.List;

public class PRO_주식가격 {
    public int[] solution(int[] prices) {
        List<Integer> answer = new ArrayList<>();

        for(int i = 0; i < prices.length; i++){
            int current = prices[i];

            int pointer = i + 1;
            while(true){
                if(pointer == prices.length){
                    answer.add(pointer - i - 1);
                    break;
                }

                int temp = prices[pointer];

                if(temp < current){
                    answer.add(pointer - i);
                    break;
                } else{
                    pointer++;
                }
            }
        }

        return answer.stream().mapToInt(i -> i).toArray();
    }
}
