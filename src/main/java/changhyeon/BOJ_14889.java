package changhyeon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/*
 * 시간 복잡도: O(N^3)
 * 공간 복잡도: O(N^2)
 */

public class BOJ_14889 {

    private static final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    private static int[][] ability;
    private static int N, MIN;
    private static List<Integer> teamA = new ArrayList<>();
    private static List<Integer> teamB = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        MIN = Integer.MAX_VALUE;
        N = Integer.parseInt(bufferedReader.readLine());
        ability = new int[N][N];

        for (int i = 0; i < N; i++) {
            ability[i] = Arrays.stream(bufferedReader.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }

        int teamNum = N / 2;
        recursive(0, teamNum);

        System.out.println(MIN);
    }

    private static void recursive(int index, int teamNum) {
        if (teamNum == 0) {
            for (int i = 0; i < N; i++) {
                if (!teamA.contains(i)) {
                    teamB.add(i);
                }
            }
            checkScore();
            teamB.clear();
            return;
        }

        for (int i = index; i < N; i++) {
            teamA.add(i);
            recursive(i + 1, teamNum - 1);
            teamA.remove(teamA.size() - 1);
        }
    }

    private static void checkScore() {
        int teamAScore = 0;
        int teamBScore = 0;

        for (int i = 0; i < N / 2 - 1; i++) {
            for (int j = i + 1; j < N / 2; j++) {
                int teamAFirst = teamA.get(i);
                int teamASecond = teamA.get(j);

                teamAScore += ability[teamAFirst][teamASecond] + ability[teamASecond][teamAFirst];

                int teamBFirst = teamB.get(i);
                int teamBSecond = teamB.get(j);

                teamBScore += ability[teamBFirst][teamBSecond] + ability[teamBSecond][teamBFirst];
            }
        }

        int tempResult = Math.abs(teamAScore - teamBScore);
        MIN = Math.min(MIN, tempResult);
    }
}
