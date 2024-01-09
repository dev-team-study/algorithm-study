package charlesuu;

import java.util.Scanner;

public class BOJ_11723 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		sc.nextLine();
		int answer = 0;

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < n; i++) {
			String[] line = sc.nextLine().split(" ");
			int x;
			switch (line[0]) {
				case "add":
					x = Integer.valueOf(line[1]) - 1;
					answer = answer | (1 << x);
					break;
				case "remove":
					x = Integer.valueOf(line[1]) - 1;
					answer = answer & ~(1 << x);
					break;
				case "check":
					x = Integer.valueOf(line[1]) - 1;
					if ((answer & (1 << x)) == 0) {
						sb.append(0).append("\n");
					} else {
						sb.append(1).append("\n");
					}
					break;
				case "toggle":
					x = Integer.valueOf(line[1]) - 1;
					answer = answer ^ (1 << x);
					break;
				case "all":
					answer = Integer.MAX_VALUE;
					break;
				case "empty":
					answer = 0;
					break;
				default:
					System.out.println("sumthing wrong");
					break;
			}
		}

		System.out.println(sb);
	}
}