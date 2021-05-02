package stageA18;

import java.util.Scanner;
import java.util.Stack;

public class Problem1874 {

	private static void solution() {
		Scanner sc = new Scanner(System.in);
		Stack<Integer> s = new Stack<>();

		int N = sc.nextInt();
		int count = 0;
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < N; i++) {
			int num = sc.nextInt();

			if (count < num) {
				if (!s.isEmpty() && s.peek() == count) {
					s.pop();
					sb.append("-\n");
				}
				for (int j = count + 1; j <= num; j++) {
					s.push(j);
					sb.append("+\n");
				}

				if (i == N - 1) {
					sb.append("-\n");
				}
				count = num;
				continue;
			}

			if (num < count) {
				while (true) {
					if (s.isEmpty()) {
						System.out.println("NO");
						return;
					}
					int temp = s.pop();
					if (temp < num) {
						System.out.println("NO");
						return;
					}
					if (temp > num) {
						sb.append("-\n");
						continue;
					}
					if (temp == num) {
						sb.append("-\n");
						break;
					}
				}
			}

		}
		sc.close();
		System.out.println(sb);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		solution();
	}

}
