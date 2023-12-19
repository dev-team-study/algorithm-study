package charlesuu;

import java.util.Scanner;

/*
시간복잡도: O(N^4){가로 스왑, 배열 체크} + O(N^4){세로 스왑, 배열 체크}
공간복잡도: O(N^2)
*/

public class BOJ_3085 {
    public static char[][] board;
    public static int N;
    public static int max = 0;

    /* 가로로, 세로로 비교하면서 먹을 수 있는 사탕의 최대 갯수 찾기 */
    public static void arrCheck() {

        // → 가로로 체크
        for(int i=0; i<N; i++) {
            int count = 1;
            for(int j=0; j<N-1; j++) {

                // 이전 사탕과 동일한 경우 -> 계속 먹는다
                if(board[i][j] == board[i][j+1])
                    count ++;

                    // 이전과 다른 사탕인 경우 -> 새로 먹어야하므로 1로 초기화
                else
                    count = 1;

                // 사탕 최대 개수 저장
                max = Math.max(max, count);
            }
        }

        // ↓ 세로로 체크
        for(int i=0; i<N; i++) {
            int count = 1;
            for(int j=0; j<N-1; j++) {
                if(board[j][i] == board[j+1][i])
                    count ++;
                else
                    count = 1;
                max = Math.max(max, count);
            }
        }
    }

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        N = scan.nextInt();
        board = new char[N][N];

        for(int i=0; i<N; i++) {
            String str = scan.next();
            for(int j=0; j<board[i].length; j++) {
                board[i][j] = str.charAt(j);
            }
        }

        /* 가로로 인접한 두 사탕 교환하고 최대 사탕 개수 찾고 원위치 */
        for(int i=0; i<N; i++) {
            for(int j=0; j<N-1; j++) {
                // 가로로 인접한 두 문자 교환
                char temp = board[i][j];
                board[i][j] = board[i][j+1];
                board[i][j+1] = temp;

                // →, ↓ 체크
                arrCheck();

                // 이전에 교환한 문자 복구
                temp = board[i][j];
                board[i][j] = board[i][j+1];
                board[i][j+1] = temp;
            }
        }

        /* 세로로 인접한 두 사탕 교환하고 최대 사탕 개수 찾고 원위치 */
        for(int i=0; i<N; i++) {
            for(int j=0; j<N-1; j++) {
                char temp = board[j][i];
                board[j][i] = board[j+1][i];
                board[j+1][i] = temp;

                // →, ↓ 체크
                arrCheck();

                // 이전에 교환한 문자 복구
                temp = board[j][i];
                board[j][i] = board[j+1][i];
                board[j+1][i] = temp;
            }
        }

        System.out.println(max);
        scan.close();
    }
}
