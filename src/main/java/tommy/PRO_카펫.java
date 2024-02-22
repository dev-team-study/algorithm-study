package tommy;

public class PRO_카펫 {
    public int[] solution(int brown, int yellow) {
        int sum = brown + yellow;

        for(int i = 3; i < sum; i++){
            int j = sum / i;
            if(sum % i == 0 && j >= 3){
                int col = Math.min(i, j);
                int row = Math.max(i, j);
                int area = (col - 2) * (row - 2);
                if(area == yellow){
                    return new int[]{row, col};
                }
            }
        }
        return new int[]{};
    }
}
