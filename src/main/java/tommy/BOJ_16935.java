package tommy;

import java.util.Scanner;

public class BOJ_16935 {
    static int N;
    static int M;
    static int[][] arr;
    static int[][] transArr;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        int R = sc.nextInt();

        arr = new int[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        for (int r = 0; r < R; r++) {
            int operator = sc.nextInt();
            switch (operator) {
                case 1 :
                    solution1();
                    break;
                case 2:
                    solution2();
                    break;
                case 3 :
                    solution3();
                    break;
                case 4 :
                    solution4();
                    break;
                case 5 :
                    solution5();
                    break;
                case 6:
                    solution6();
                    break;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                sb.append(arr[i][j]).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    // 상하 반전
    static void solution1() {
        transArr = new int[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                transArr[N - 1 - i][j] = arr[i][j];
            }
        }
        arr = transArr;
    }
    // 좌우 반전
    static void solution2() {
        transArr = new int[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                transArr[i][M - 1 - j] = arr[i][j];
            }
        }
        arr = transArr;
    }
    // 오른쪽 90도 회전
    static void solution3() {
        transArr = new int[M][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                transArr[j][N - 1 - i] = arr[i][j];
            }
        }
        // 크기 변환
        int temp = N;
        N = M;
        M = temp;
        arr = transArr;
    }

    static void solution4() {
        transArr = new int[M][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                transArr[M - 1 - j][i] = arr[i][j];
            }
        }
        // 크기 변환
        int temp = N;
        N = M;
        M = temp;
        arr = transArr;
    }
    static void solution5() {
        transArr = new int[N][M];
        int N_mean = N / 2;
        int M_mean = M / 2;

        // 1 -> 2
        for (int i = 0; i < N_mean; i++) {
            for (int j = 0; j < M_mean; j++) {
                transArr[i][M_mean + j] = arr[i][j];
            }
        }
        // 2 -> 3
        for (int i = 0; i < N_mean; i++) {
            for (int j = M_mean; j < M; j++) {
                transArr[N_mean + i][j] = arr[i][j];
            }
        }
        // 3 -> 4
        for (int i = N_mean; i < N; i++) {
            for (int j = M_mean; j < M; j++) {
                transArr[i][j - M_mean] = arr[i][j];
            }
        }
        // 4 -> 1
        for (int i = N_mean; i < N; i++) {
            for (int j = 0; j < M_mean; j++) {
                transArr[i - N_mean][j] = arr[i][j];
            }
        }

        arr = transArr;
    }

    static void solution6() {
        transArr = new int[N][M];
        int N_mean = N / 2;
        int M_mean = M / 2;

        // 1 -> 4
        for (int i = 0; i < N_mean; i++) {
            for (int j = 0; j < M_mean; j++) {
                transArr[i + N_mean][j] = arr[i][j];
            }
        }
        // 4 -> 3
        for (int i = N_mean; i < N; i++) {
            for (int j = 0; j < M_mean; j++) {
                transArr[i][j + M_mean] = arr[i][j];
            }
        }
        // 3 -> 2
        for (int i = N_mean; i < N; i++) {
            for (int j = M_mean; j < M; j++) {
                transArr[i - N_mean][j] = arr[i][j];
            }
        }
        // 2 -> 1
        for (int i = 0; i < N_mean; i++) {
            for (int j = M_mean; j < M; j++) {
                transArr[i][j - M_mean] = arr[i][j];
            }
        }

        arr = transArr;
    }

}
