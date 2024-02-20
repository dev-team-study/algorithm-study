package tommy;

import java.util.PriorityQueue;

public class PRO_이중우선순위큐 {
    /*
     * 시간 복잡도 : O(N)
     * 공간 복잡도 : O(2N) => queue 두개.
     */
    public int[] solution(String[] operations) {
        PriorityQueue<Integer> queue1 = new PriorityQueue<>();   // 오름차순
        PriorityQueue<Integer> queue2 = new PriorityQueue<>((n1, n2) -> n2 - n1);    // 내림차순

        for(String operation : operations){
            String operator = operation.split(" ")[0];
            String number = operation.split(" ")[1];
            if (operator.equals("I")){
                queue1.add(Integer.valueOf(number));
                queue2.add(Integer.valueOf(number));
            } else {
                if(!queue1.isEmpty()){
                    if (number.equals("1")){    // 최댓 값 삭제
                        int max = queue2.peek();
                        queue1.remove(max);
                        queue2.remove(max);
                    } else{ // 최소 값 삭제
                        int min = queue1.peek();
                        queue1.remove(min);
                        queue2.remove(min);
                    }
                }
            }
        }
        if (queue1.isEmpty()){
            return new int[]{0,0};
        } else{
            return new int[]{queue2.peek(), queue1.peek()};
        }
    }
}
