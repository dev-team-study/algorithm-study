package tommy;

import java.util.Arrays;

public class PRO_구명보트 {
    public int solution(int[] people, int limit) {
        Arrays.sort(people);
        int answer = 0;
        int pointer = 0;

        for(int i = people.length - 1; i >= pointer; i--){
            if (people[i] + people[pointer] <= limit){
                answer++;
                pointer++;
            } else{
                answer++;
            }
        }
        return answer;
    }
}
