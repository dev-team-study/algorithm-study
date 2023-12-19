package changhyeon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


/*
    시간복잡도: O(N^4) -> 위치 교환 중첩 for문 O(N^2) * 긴 연속 부분을 고른 다음 먹는 부분 중첩 for문 O(N^2)
    공간복잡도: O(N^2) -> 2차원 배열을 이용하므로 O(N^2)

    주어진 보드의 최고 크기 : 50
    50^4 = 6,250,000

    시간복잡도가 O(N^4) 이더라도 제한 시간 1초에 영향 없음
 */

public class BOJ_3085 {

    private static final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    private static String[][] map;
    private static int max = 0;

    public static void main(String[] args) throws IOException {

        final int N = Integer.parseInt(bufferedReader.readLine());
        map = new String[N][N];

        for (int i = 0; i < N; i++) {
            String[] line = bufferedReader.readLine().split("");
            map[i] = line;
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N - 1; j++) {
                swap(i, j, i, j + 1);
                chooseAndEat(N);
                swap(i, j + 1, i, j);
            }
        }

        for (int i = 0; i < N - 1; i++) {
            for (int j = 0; j < N; j++) {
                swap(i, j, i + 1, j);
                chooseAndEat(N);
                swap(i + 1, j, i, j);
            }
        }

        System.out.println(max);
    }

    private static void swap(final int y1, final int x1, final int y2, final int x2) {
        String tempValue = map[y1][x1];
        map[y1][x1] = map[y2][x2];
        map[y2][x2] = tempValue;
    }

    private static void chooseAndEat(int N) {
        for (int i = 0; i < N; i++) {
            int count = 1;

            for (int j = 0; j < N - 1; j++) {
                if (map[i][j].equals(map[i][j + 1])) {
                    count++;
                    max = Math.max(count, max);
                } else {
                    count = 1;
                }
            }
        }

        for (int i = 0; i < N; i++) {
            int count = 1;

            for (int j = 0; j < N - 1; j++) {
                if (map[j][i].equals(map[j + 1][i])) {
                    count++;
                    max = Math.max(count, max);
                } else {
                    count = 1;
                }
            }
        }
    }
}
