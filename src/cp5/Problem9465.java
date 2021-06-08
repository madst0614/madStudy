package cp5;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Problem9465 {
	static int[][] value;
	static long[][] selected;

	private static long solution(int N) {
		selected[1][0] = value[1][0];
		selected[1][1] = value[1][1];

		for (int i = 2; i <= N; i++) {
			for (int j = 0; j <= 1; j++) {
				selected[i][j] = Math.max(selected[i - 2][j] + value[i - 1][1 - j], selected[i - 2][1 - j]);
				selected[i][j] = Math.max(selected[i][j], selected[i - 1][1 - j]);
				selected[i][j] += value[i][j];
			}
		}

		return Math.max(selected[N][0], selected[N][1]);
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());
		for (int t = 0; t < T; t++) {
			int N = Integer.parseInt(br.readLine());
			value = new int[N + 1][2];
			selected = new long[N + 1][2];

			for (int i = 0; i < 2; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 1; j < value.length; j++) {
					value[j][i] = Integer.parseInt(st.nextToken());
				}
			}

			bw.write(solution(N) + "\n");
		}
		br.close();
		bw.flush();
		bw.close();
	}

}
