package charlesuu;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class BOJ_10866 {

	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();

		int n = sc.nextInt();
		sc.nextLine();

		Deque<Integer> queue = new ArrayDeque<>();

		for (int i = 0; i < n; i++) {
			String[] tokens = sc.nextLine().split(" ");

			switch (tokens[0]) {
				case "push_front":
					queue.addFirst(Integer.valueOf(tokens[1]));
					break;
				case "push_back":
					queue.addLast(Integer.valueOf(tokens[1]));
					break;
				case "pop_front":
					if (queue.isEmpty()) {
						sb.append(-1).append("\n");
					} else {
						sb.append(queue.removeFirst()).append("\n");
					}
					break;
				case "pop_back":
					if (queue.isEmpty()) {
						sb.append(-1).append("\n");
					} else {
						sb.append(queue.removeLast()).append("\n");
					}
					break;
				case "size":
					sb.append(queue.size()).append("\n");
					break;
				case "empty":
					if (queue.isEmpty()) {
						sb.append(1).append("\n");
					} else {
						sb.append(0).append("\n");
					}
					break;
				case "front":
					if (queue.isEmpty()) {
						sb.append(-1).append("\n");
					} else {
						sb.append(queue.peekFirst()).append("\n");
					}
					break;
				case "back":
					if (queue.isEmpty()) {
						sb.append(-1).append("\n");
					} else {
						sb.append(queue.peekLast()).append("\n");
					}
					break;
			}
		}

		System.out.println(sb);
	}
}
