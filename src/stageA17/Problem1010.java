package stageA17;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Problem1010 {
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

			}
		}

		return fact[N][K];
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());

		for (int i = 0; i < T; i++) {
			st = new StringTokenizer(br.readLine());

			int K = Integer.parseInt(st.nextToken());
			int N = Integer.parseInt(st.nextToken());
			fact = new long[N + 1][K + 1];

			bw.write((int) findFact(N, K) + "\n");
		}
		br.close();
		bw.flush();
		bw.close();

	}

}
