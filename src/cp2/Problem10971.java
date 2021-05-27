package cp2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem10971 {
	static int[][] w;
	static boolean[] city;
	static int min;

	private static void solution(int N, int start, int prev, int total) {
		if (N == w.length) {
			if (w[prev][start] != 0) {
				total += w[prev][start];

				if (total < min)
					min = total;
			}

			return;
		}

		for (int i = 0; i < w.length; i++) {
			if (start == -1) {
				city[i] = true;
				solution(N + 1, i, i, total);
				city[i] = false;

				continue;
			}

			if (!city[i] && w[prev][i] != 0) {
				city[i] = true;
				solution(N + 1, start, i, total + w[prev][i]);
				city[i] = false;
			}
		}
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());
		w = new int[N][N];
		city = new boolean[N];
		min = Integer.MAX_VALUE;

		for (int i = 0; i < w.length; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < w.length; j++) {
				w[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		solution(0, -1, -1, 0);
		System.out.println(min);
	}

}
