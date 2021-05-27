package cp2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem14501 {
	static int N;
	static int[] T;
	static int[] P;
	static int max;

	private static void solution(int day, int prevSum) {
		if (day == N + 1) {
			if (max < prevSum)
				max = prevSum;
		}

		for (int i = day; i <= N; i++) {
			int temp = i + T[i];
			if (temp <= N + 1) {
				solution(temp, prevSum + P[i]);
			}

			if (max < prevSum)
				max = prevSum;

		}
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		N = Integer.parseInt(br.readLine());
		T = new int[N + 1];
		P = new int[N + 1];
		max = Integer.MIN_VALUE;

		for (int i = 1; i < N + 1; i++) {
			st = new StringTokenizer(br.readLine());
			T[i] = Integer.parseInt(st.nextToken());
			P[i] = Integer.parseInt(st.nextToken());
		}

		solution(1, 0);
		System.out.println(max);
	}

}
