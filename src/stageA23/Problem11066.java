package stageA23;

// 출처 : https://pangtrue.tistory.com/302
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Problem11066 {
	static int[] chapter;
	static int[] sum;
	static int[][] size;

	private static void solution(int K) {
		for (int i = 2; i <= K; i++) {
			for (int j = i - 1; j > 0; j--) {
				size[j][i] = Integer.MAX_VALUE;
				for (int k = j; k <= i; k++) {
					size[j][i] = Math.min(size[j][i], size[j][k] + size[k + 1][i]);
				}
				size[j][i] += sum[i] - sum[j - 1];
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());
		for (int i = 0; i < T; i++) {
			int K = Integer.parseInt(br.readLine());
			chapter = new int[K + 1];
			sum = new int[K + 1];
			size = new int[K + 2][K + 2];

			st = new StringTokenizer(br.readLine());
			for (int j = 1; j < K + 1; j++) {
				chapter[j] = Integer.parseInt(st.nextToken());
				sum[j] = sum[j - 1] + chapter[j];
			}

			solution(K);
			bw.write(size[1][K] + "\n");

		}

		br.close();
		bw.flush();
		bw.close();
	}
}
