package changhyeon;

public class PRO_조이스틱 {

    public int solution(String name) {
        int result = 0;
        int idx;
        int move = name.length() - 1;

        for (int i = 0; i < name.length(); i++) {
            result += Math.min(name.charAt(i) - 'A', 'Z' - name.charAt(i) + 1);

            idx = i + 1;
            while (idx < name.length() && name.charAt(idx) == 'A') {
                idx++;
            }
            move = Math.min(move, (i * 2) + name.length() - idx); // 순서대로, 반대로 중 적은 횟수 값
            move = Math.min(move, (name.length() - idx) * 2 + i); // 뒷부분 먼저
        }
        return result + move;
    }
}
