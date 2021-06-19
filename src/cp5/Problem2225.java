package cp5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem2225 {
	static int[][] num;
	static int mod = 1_000_000_000;

	private static void solution(int N, int K) {

		num[0][1] = 1;
		for (int i = 0; i <= N; i++) {
			num[i][1] = 1;
		}

		for (int i = 0; i <= N; i++) {
			for (int k = 2; k <= K; k++) {
				for (int j = 0; j <= i; j++) {
					num[i][k] += num[j][k - 1];
					num[i][k] %= mod;
				}
			}
		}

		System.out.println(num[N][K]);
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		num = new int[N + 1][K + 1];

		solution(N, K);
	}

}
