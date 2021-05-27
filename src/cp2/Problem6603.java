package cp2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Problem6603 {
	static int[] lotto;
	static int[] pick;

	private static void solution(int N, int prev, BufferedWriter bw) throws IOException {
		if (N == pick.length) {
			for (int i = 0; i < pick.length; i++) {
				bw.write(pick[i] + " ");

			}
			bw.write("\n");
			return;
		}

		for (int i = prev; i < lotto.length; i++) {
			if (lotto[i] != -1) {
				pick[N] = lotto[i];
				lotto[i] = -1;
				solution(N + 1, i, bw);
				lotto[i] = pick[N];
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		while (true) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());

			if (N == 0)
				break;

			lotto = new int[N];
			pick = new int[6];
			for (int i = 0; i < lotto.length; i++) {
				lotto[i] = Integer.parseInt(st.nextToken());
			}

			solution(0, 0, bw);
			bw.write("\n");
			bw.flush();
		}

		br.close();
		bw.close();
	}

}
