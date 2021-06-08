package cp5;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Problem15988 {
	static long[] num;

	private static long solution(int n) {
		num[0] = 1;
		num[1] = 1;
		num[2] = 2;

		for (int i = 3; i <= n; i++) {
			num[i] = num[i - 1] + num[i - 2] + num[i - 3];

			if (num[i] > 1_000_000)
				num[i] %= 1_000_000_009;
		}

		return num[n];
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int T = Integer.parseInt(br.readLine());

		for (int i = 0; i < T; i++) {
			int N = Integer.parseInt(br.readLine());
			num = new long[1_000_001];

			bw.write(solution(N) + "\n");
		}

		br.close();
		bw.flush();
		bw.close();

	}

}
