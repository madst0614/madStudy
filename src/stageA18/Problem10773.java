package stageA18;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Problem10773 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		Stack<Integer> stack = new Stack<Integer>();

		for (int i = 0; i < N; i++) {
			int num = Integer.parseInt(br.readLine());
			if (num == 0) {
				stack.pop();
				continue;
			}
			stack.push(num);
		}
		br.close();

		int answer = 0;
		while (!stack.isEmpty()) {
			answer += stack.pop();
		}
		System.out.println(answer);
	}

}
