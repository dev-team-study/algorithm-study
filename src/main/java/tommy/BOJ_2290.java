package tommy;

import java.util.Scanner;

public class BOJ_2290 {

    static int[][] map;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int s = sc.nextInt();

        String numbers = sc.next();
        int num = numbers.length();
        map = new int[(2 * s) + 3][(s + 2) * num];

        // 1 : - , 2 : |

        for (int i = 0; i < num; i++) {
            int number = numbers.charAt(i) - '0';
            int x = (s + 2) * i ;   // base line
            switch (number) {
                case 1:
                    for (int j = 1; j < 1 + s; j++) {
                        map[j][x + s + 1] = 2;
                    }
                    for (int j = s + 2; j < (2 * s) + 2; j++) {
                        map[j][x + s + 1] = 2;
                    }
                break;
                case 2:
                    for (int j = x + 1; j < (x + s + 1); j++) {
                        map[0][j] = 1;
                        map[s + 1][j] = 1;
                        map[2 * s + 2][j] = 1;
                    }
                    for (int j = 1; j <= s; j++) {
                        map[j][x + s + 1] = 2;
                    }
                    for (int j = s + 2; j <= s * 2 + 1; j++) {
                        map[j][x] = 2;
                    }
                break;
                case 3:
                    for (int j = x + 1; j < (x + s + 1); j++) {
                        map[0][j] = 1;
                        map[s + 1][j] = 1;
                        map[2 * s + 2][j] = 1;
                    }
                    for (int j = 1; j <= s; j++) {
                        map[j][x + s + 1] = 2;
                    }
                    for (int j = s + 2; j <= s * 2 + 1; j++) {
                        map[j][x + s + 1] = 2;
                    }
                break;
                case 4:
                    for (int j = 1; j <= s; j++) {
                        map[j][x] = 2;
                        map[j][x + s + 1] = 2;
                    }
                    for (int j = s + 2; j <= 2 * s + 1; j++) {
                        map[j][x + s + 1] = 2;
                    }
                    for (int j = x + 1; j <= (x + s); j++) {
                        map[s + 1][j] = 1;
                    }
                break;
                case 5:
                    for (int j = x + 1; j < (x + s + 1); j++) {
                        map[0][j] = 1;
                        map[s + 1][j] = 1;
                        map[2 * s + 2][j] = 1;
                    }
                    for (int j = 1; j <= s; j++) {
                        map[j][x] = 2;
                    }
                    for (int j = s + 2; j <= 2 * s + 1; j++) {
                        map[j][x + s + 1] = 2;
                    }
                break;
                case 6:
                    for (int j = x + 1; j < (x + s + 1); j++) {
                        map[0][j] = 1;
                        map[s + 1][j] = 1;
                        map[2 * s + 2][j] = 1;
                    }
                    for (int j = 1; j <= s; j++) {
                        map[j][x] = 2;
                    }
                    for (int j = s + 2; j <= 2 * s + 1; j++) {
                        map[j][x] = 2;
                        map[j][x + s + 1] = 2;
                    }
                break;
                case 7:
                    for (int j = x + 1; j < (x + s + 1); j++) {
                        map[0][j] = 1;
                    }
                    for (int j = 1; j <= s; j++) {
                        map[j][x + s + 1] = 2;
                    }
                    for (int j = s + 2; j <= 2 * s + 1; j++) {
                        map[j][x + s + 1] = 2;
                    }
                break;
                case 8:
                    for (int j = x + 1; j < (x + s + 1); j++) {
                        map[0][j] = 1;
                        map[s + 1][j] = 1;
                        map[2 * s + 2][j] = 1;
                    }
                    for (int j = 1; j <= s; j++) {
                        map[j][x] = 2;
                        map[j][x + s + 1] = 2;
                    }
                    for (int j = s + 2; j <= 2 * s + 1; j++) {
                        map[j][x] = 2;
                        map[j][x + s + 1] = 2;
                    }
                break;
                case 9:
                    for (int j = x + 1; j < (x + s + 1); j++) {
                        map[0][j] = 1;
                        map[s + 1][j] = 1;
                        map[2 * s + 2][j] = 1;
                    }
                    for (int j = 1; j <= s; j++) {
                        map[j][x] = 2;
                        map[j][x + s + 1] = 2;
                    }
                    for (int j = s + 2; j <= 2 * s + 1; j++) {
                        map[j][x + s + 1] = 2;
                    }
                break;
                case 0:
                    for (int j = x + 1; j < (x + s + 1); j++) {
                        map[0][j] = 1;
                        map[2 * s + 2][j] = 1;
                    }
                    for (int j = 1; j <= s; j++) {
                        map[j][x] = 2;
                        map[j][x + s + 1] = 2;
                    }
                    for (int j = s + 2; j <= 2 * s + 1; j++) {
                        map[j][x] = 2;
                        map[j][x + s + 1] = 2;
                    }
                break;
            }
        }

        StringBuilder sb = new StringBuilder();
        int index = 0;
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                if (map[i][j] == 2) {
                    sb.append("|");
                } else if (map[i][j] == 1) {
                    sb.append("-");
                } else {
                    sb.append(" ");
                }
                index++;
                if (index % (s + 2) == 0) {
                    sb.append(" ");
                }
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
