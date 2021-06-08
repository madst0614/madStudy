package cp5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem11052 {
	static int[][] card;
	static int[] value;

	private static void solution(int N) {
		for (int i = 1; i < card.length; i++) {
			for (int j = 0; j < card[i].length; j++) {
				if (i > j)
					card[i][j] = card[i - 1][j];
				else
					card[i][j] = Math.max(card[i][j - i] + value[i], card[i - 1][j]);
			}
		}

		System.out.println(card[N][N]);
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());
		value = new int[N + 1];
		card = new int[N + 1][N + 1];

		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			value[i] = Integer.parseInt(st.nextToken());
		}

		solution(N);
	}
}
