package changhyeon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_20055 {

    private static final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    private static int N, K;
    private static int[][] belt;
    private static int[] durability;
    private static boolean[][] robot;

    public static void main(String[] args) throws IOException {
        String[] line = bufferedReader.readLine().split(" ");

        N = Integer.parseInt(line[0]);
        K = Integer.parseInt(line[1]);

        belt = new int[2][N + 1];
        robot = new boolean[2][N + 1];
        durability = new int[2 * N + 1];

        line = bufferedReader.readLine().split(" ");
        for (int i = 1; i <= 2 * N; i++) {
            durability[i] = Integer.parseInt(line[i - 1]);
        }

        int count = 1;

        for (int i = 1; i <= N; i++)
            belt[0][i] = count++;

        for (int i = N; i >= 1; i--)
            belt[1][i] = count++;

        System.out.println(goWork());
    }

    private static int goWork() {
        int count = 0;

        while (checkDurability()) {
            moveBelt();
            moveRobot();
            raiseRobot();
            count++;
        }

        return count;
    }

    private static boolean checkDurability() {
        int count = 0;

        for (int i = 1; i <= 2 * N; i++) {
            if (durability[i] == 0) {
                count++;
            }
        }

        return count < K;
    }

    private static void moveBelt() {
        int tempBelt = belt[1][1];

        for (int i = 1; i < N; i++) {
            belt[1][i] = belt[1][i + 1];
        }

        belt[1][N] = belt[0][N];

        for (int i = N; i >= 2; i--) {
            belt[0][i] = belt[0][i - 1];
            robot[0][i] = robot[0][i - 1];
        }

        belt[0][1] = tempBelt;

        robot[0][1] = false;
        robot[0][N] = false;
    }

    private static void moveRobot() {
        for (int i = N - 1; i >= 1; i--) {
            if (robot[0][i] && !robot[0][i + 1] && durability[belt[0][i + 1]] > 0) {
                robot[0][i] = false;
                robot[0][i + 1] = true;
                durability[belt[0][i + 1]]--;
            }
        }

        robot[0][N] = false;
    }

    private static void raiseRobot() {
        if (durability[belt[0][1]] > 0) {
            robot[0][1] = true;
            durability[belt[0][1]]--;
        }
    }
}
