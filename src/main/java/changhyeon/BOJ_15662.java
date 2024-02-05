package changhyeon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_15662 {

    private static final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    private static int count, GEAR_MAX_NUMBER = 8, LEFT_GEAR = 6, RIGHT_GEAR = 2, LEFT_DIRECTION = -1, RIGHT_DIRECTION = 1;
    private static int[][] gears, method;
    private static int rotationCount;
    private static boolean[] visited;

    public static void main(String[] args) throws IOException {
        count = Integer.parseInt(bufferedReader.readLine());
        gears = new int[count + 1][GEAR_MAX_NUMBER];

        for (int i = 1; i <= count; i++) {
            gears[i] = Arrays.stream(bufferedReader.readLine().split(""))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }

        rotationCount = Integer.parseInt(bufferedReader.readLine());

        method = new int[rotationCount][2];

        for (int i = 0; i < rotationCount; i++) {
            method[i] = Arrays.stream(bufferedReader.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }

        for (int i = 0; i < rotationCount; i++) {
            int gearNumber = method[i][0]; // 톱니바퀴 번호
            int direction = method[i][1]; // 방향

            visited = new boolean[count + 1];
            process(gearNumber, direction);
        }

        int cnt = 0;
        for (int i = 1; i <= count; i++) {
            if (gears[i][0] == 1) {
                cnt++;
            }
        }

        System.out.println(cnt);
    }

    private static void process(final int gearNumber, final int direction) {
        visited[gearNumber] = true;

        changeDirection(gearNumber, direction);

        goLeftGear(gearNumber, direction);
        goRightGear(gearNumber, direction);
    }

    private static void goLeftGear(final int gearNumber, final int direction) {
        if (gearNumber - 1 >= 1 && !visited[gearNumber - 1]
                && gears[gearNumber - 1][RIGHT_GEAR] != gears[gearNumber][LEFT_GEAR + direction]) {
            process(gearNumber - 1, direction * -1);
        }
    }

    private static void goRightGear(final int gearNumber, final int direction) {
        if (gearNumber + 1 <= count && !visited[gearNumber + 1]
                && gears[gearNumber + 1][LEFT_GEAR] != gears[gearNumber][RIGHT_GEAR + direction]) {
            process(gearNumber + 1, direction * -1);
        }
    }

    private static void changeDirection(final int gearNumber, final int direction) {
        if (direction == LEFT_DIRECTION) {
            int zeroTemp = gears[gearNumber][0];

            for (int i = 0; i < GEAR_MAX_NUMBER - 1; i++) {
                gears[gearNumber][i] = gears[gearNumber][i + 1];
            }

            gears[gearNumber][7] = zeroTemp;
            return;
        }

        if (direction == RIGHT_DIRECTION) {
            int lastTemp = gears[gearNumber][GEAR_MAX_NUMBER - 1];

            for (int i = GEAR_MAX_NUMBER - 1; i > 0; i--) {
                gears[gearNumber][i] = gears[gearNumber][i - 1];
            }

            gears[gearNumber][0] = lastTemp;
        }
    }
}
