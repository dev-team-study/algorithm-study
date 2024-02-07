package changhyeon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2290 {

    private static final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    private static int S, N;
    private static int left;
    private static String[][] board;
    private static int[][] map = {
            {0, 1, 1, 1, 0, 1, 1, 1},
            {0, 0, 0, 1, 0, 0, 1, 0},
            {0, 1, 0, 1, 1, 1, 0, 1},
            {0, 1, 0, 1, 1, 0, 1, 1},
            {0, 0, 1, 1, 1, 0, 1, 0},
            {0, 1, 1, 0, 1, 0, 1, 1},
            {0, 1, 1, 0, 1, 1, 1, 1},
            {0, 1, 0, 1, 0, 0, 1, 0},
            {0, 1, 1, 1, 1, 1, 1, 1},
            {0, 1, 1, 1, 1, 0, 1, 1}
    };

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(bufferedReader.readLine());
        S = Integer.parseInt(st.nextToken());

        String[] num = st.nextToken().split("");
        N = num.length;

        board = new String[2 * S + 4][N * (S + 4)];

        fillEmptyBoard();

        for (int i = 0; i < N; i++) {
            makeNumber(num[i]);
        }

        result();
        bufferedReader.close();
    }

    private static void makeNumber(final String num) {
        int n = Integer.parseInt(num);

        if (map[n][1] == 1)
            fill(0, 0, left + 1, left + S, "-");
        if (map[n][4] == 1)
            fill(S + 1, S + 1, left + 1, left + S, "-");
        if (map[n][7] == 1)
            fill(2 * (S + 1), 2 * (S + 1), left + 1, left + S, "-");
        if (map[n][2] == 1)
            fill(1, S, left, left, "|");
        if (map[n][5] == 1)
            fill(1 + (S + 1), S + (S + 1), left, left, "|");
        if (map[n][3] == 1)
            fill(1, S, left + S + 1, left + S + 1, "|");
        if (map[n][6] == 1)
            fill(1 + (S + 1), S + (S + 1), left + S + 1, left + S + 1, "|");

        left += S + 3;
    }

    private static void fillEmptyBoard() {
        for (int i = 0; i < 2 * S + 3; i++) {
            for (int j = 0; j < N * (S + 4); j++) {
                board[i][j] = " ";
            }
        }
    }

    public static void result() {
        for (int i = 0; i < 2 * S + 3; i++) {
            for (int j = 0; j < left; j++) {
                System.out.print(board[i][j]);
            }
            System.out.println();
        }
    }

    public static void fill(int sx, int ex, int sy, int ey, String str) {
        for (int x = sx; x <= ex; x++)
            for (int y = sy; y <= ey; y++)
                board[x][y] = str;
    }
}
