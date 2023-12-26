package tommy;

import java.util.Scanner;

public class BOJ_3085 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BOJ_3085 prob = new BOJ_3085();

        int rows = scanner.nextInt();
        char[][] array = new char[rows][rows];
        scanner.nextLine();
        for (int i = 0; i < rows; i++) {
            String s = scanner.nextLine();
            int index = 0;
            for (char c : s.toCharArray()) {
                array[i][index++] = c;
            }
        }

        prob.solution(array);
    }
    
    /*
     * 시간 복잡도 : O(N^4) -> 가로 교환 및 세로 교환 O(N^2) * search O(N^2)
     * 공간 복잡도 : O(1) -> 별다르게 저장하는 것이 없으므로 O(1) 
     */
    public void solution(char[][] array) {
        int rows = array.length;
        int maximumLength = Integer.MIN_VALUE;

        // 가로 교환
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < rows - 1; j++) {
                // swap
                char temp = array[i][j];
                array[i][j] = array[i][j + 1];
                array[i][j + 1] = temp;
                int result = search(array);
                maximumLength = Math.max(maximumLength, result);

                // restore
                temp = array[i][j];
                array[i][j] = array[i][j + 1];
                array[i][j + 1] = temp;
            }
        }

        // 세로 교환
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < rows - 1; j++) {
                // swap
                char temp = array[j][i];
                array[j][i] = array[j + 1][i];
                array[j + 1][i] = temp;
                int result = search(array);
                maximumLength = Math.max(maximumLength, result);

                // restore
                temp = array[j][i];
                array[j][i] = array[j + 1][i];
                array[j + 1][i] = temp;
            }
        }
        System.out.println(maximumLength);
    }

    private int search(char[][] array) {
        int rows = array.length;
        int max = 0;
        // 가로 검색
        for (int i = 0; i < rows; i++) {
            int count = 1;
            for (int j = 0; j < rows - 1; j++) {
                if (array[i][j] == array[i][j + 1]) {
                    count++;
                } else {
                    count = 1;
                }
                max = Math.max(max, count);
            }
        }

        // 세로 검색
        for (int i = 0; i < rows; i++) {
            int count = 1;
            for (int j = 0; j < rows - 1; j++) {
                if (array[j][i] == array[j+1][i]) {
                    count++;
                } else {
                    count = 1;
                }
                max = Math.max(max, count);
            }
        }
        return max;
    }
}
