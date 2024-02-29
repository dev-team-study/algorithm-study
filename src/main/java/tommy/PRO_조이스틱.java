package tommy;

public class PRO_조이스틱 {
    public int solution(String name) {
        int answer = 0;
        int move = name.length() - 1; // 단순하게 오른쪽으로만 움직일 경우의 move count

        for(int i = 0; i < name.length(); i++){
            answer += Math.min(name.charAt(i) - 'A', 26 - (name.charAt(i) - 'A'));  // 조이스틱 위아래 move
            if(i < name.length() - 1 && name.charAt(i + 1) == 'A'){    // 다음 글자가 A 라면
                int pointer = i + 1;
                while(pointer < name.length() && name.charAt(pointer) == 'A'){
                    pointer++;
                }
                move = Math.min(move, i * 2 + (name.length() - pointer));   // 오른쪽으로 갔다가 왼쪽으로 돌아가는 경우
                move = Math.min(move, i + 2 * (name.length() - pointer));   // 왼쪽으로 갔다가 오른쪽으로 돌아가는 경우
            }
        }
        return answer + move;
    }
}
