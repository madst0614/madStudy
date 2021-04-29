package stageA17;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem11051 {
	static long[][] fact;

	public static long findFact(int N, int K) {

		if (K == 0)
			return 1;

		for (int i = 1; i < fact.length; i++) {
			for (int j = 0; j < fact[i].length; j++) {
				if (j == 0) {
					fact[i][j] = 0;
					continue;
				}

				if (j == 1) {
					fact[i][j] = i;
					continue;
				}

				fact[i][j] = fact[i - 1][j - 1] + fact[i - 1][j];
				fact[i][j] %= 10007;
			}
		}

		return fact[N][K];
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		br.close();

		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		fact = new long[N + 1][K + 1];

		System.out.println(findFact(N, K));

	}

}
