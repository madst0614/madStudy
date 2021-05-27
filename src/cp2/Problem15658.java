package cp2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem15658 {
	static int[] num;
	static int[] oper;
	static int max;
	static int min;

	private static void solution(int N, int prevResult) {
		if (N == num.length - 1) {
			if (prevResult < min)
				min = prevResult;
			if (max < prevResult)
				max = prevResult;
			return;
		}

		for (int i = 0; i < oper.length; i++) {
			if (oper[i] != 0) {
				oper[i]--;

				// +
				if (i == 0)
					solution(N + 1, prevResult + num[N + 1]);

				// -
				else if (i == 1)
					solution(N + 1, prevResult - num[N + 1]);

				// *
				else if (i == 2)
					solution(N + 1, prevResult * num[N + 1]);

				// /
				else if (i == 3)
					solution(N + 1, prevResult / num[N + 1]);

				oper[i]++;
			}
		}
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());
		int op = 4;

		num = new int[N];
		oper = new int[op];
		max = Integer.MIN_VALUE;
		min = Integer.MAX_VALUE;

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < num.length; i++) {
			num[i] = Integer.parseInt(st.nextToken());
		}

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < oper.length; i++) {
			oper[i] = Integer.parseInt(st.nextToken());
		}

		solution(0, num[0]);

		System.out.println(max + "\n" + min);

	}

}
