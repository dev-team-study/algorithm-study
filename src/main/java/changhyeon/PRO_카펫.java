package changhyeon;

public class PRO_카펫 {

    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];

        for (int width = 1; width <= 5000; width++) {
            for (int height = 1; height <= width; height++) {

                int brownTile = (width + height - 2) * 2;
                int yellowTile = width * height - brownTile;

                if (brownTile == brown && yellowTile == yellow) {
                    answer[0] = width;
                    answer[1] = height;
                    break;
                }
            }
        }

        return answer;
    }
}
