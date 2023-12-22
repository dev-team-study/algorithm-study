package charlesuu;

import java.util.Scanner;

public class BOJ_1748 {


    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int number = sc.nextInt();

        int count = 1;
        int answer = 0;
        int length = 10;

        for(int i = 1; i <= number; i++){
            if(i == length){
                count++;
                length = length * 10;
            }
            answer += count;
        }
        System.out.println(answer);
    }
}
