package cp2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem14500 {
	static int[][] paper;

	private static int solution(int N, int M) {
		int max = Integer.MIN_VALUE;

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {

				// ㅡ, ㄴ, ㅗ(가로 버전)
				if (j + 2 < M) {
					int common = paper[i][j] + paper[i][j + 1] + paper[i][j + 2];

					// ㅡ
					if (j + 3 < M) {
						int temp = common + paper[i][j + 3];
						if (max < temp)
							max = temp;
					}

					// ㄴ , ㅗ
					if (i > 0) {
						int temp = common;
						int plus = Math.max(paper[i - 1][j], paper[i - 1][j + 1]);
						plus = Math.max(plus, paper[i - 1][j + 2]);
						temp += plus;

						if (max < temp)
							max = temp;
					}
					if (i + 1 < N) {
						int temp = common;
						int plus = Math.max(paper[i + 1][j], paper[i + 1][j + 1]);
						plus = Math.max(plus, paper[i + 1][j + 2]);
						temp += plus;

						if (max < temp)
							max = temp;
					}
				}

				// ㅡ, ㄴ, ㅗ(세로 버전)
				if (i + 2 < N) {
					int common = paper[i][j] + paper[i + 1][j] + paper[i + 2][j];

					// ㅣ
					if (i + 3 < N) {
						int temp = common + paper[i + 3][j];
						if (max < temp)
							max = temp;
					}

					// L , ㅗ
					if (j > 0) {
						int temp = common;
						int plus = Math.max(paper[i][j - 1], paper[i + 1][j - 1]);
						plus = Math.max(plus, paper[i + 2][j - 1]);
						temp += plus;

						if (max < temp)
							max = temp;
					}
					if (j + 1 < M) {
						int temp = common;
						int plus = Math.max(paper[i][j + 1], paper[i + 1][j + 1]);
						plus = Math.max(plus, paper[i + 2][j + 1]);
						temp += plus;

						if (max < temp)
							max = temp;
					}
				}

				// 4(가로 버전), ㅁ
				if (j + 1 < M) {
					int common = paper[i][j] + paper[i][j + 1];

					// 4(가로 버전) - 1
					if (i + 1 < N && j + 2 < M) {
						int temp = common + paper[i + 1][j + 1] + paper[i + 1][j + 2];

						if (max < temp)
							max = temp;
					}
					// 4(가로 버전) - 2
					if (i + 1 < N && j > 0) {
						int temp = common + paper[i + 1][j - 1] + paper[i + 1][j];

						if (max < temp)
							max = temp;
					}

					// ㅁ
					if (i + 1 < N && j + 1 < M) {
						int temp = common + paper[i + 1][j] + paper[i + 1][j + 1];

						if (max < temp)
							max = temp;
					}
				}
				// 4(세로 버전)
				if (i + 1 < N) {
					int common = paper[i][j] + paper[i + 1][j];

					// 4(세로 버전) - 1
					if (i + 2 < N && j + 1 < M) {
						int temp = common + paper[i + 1][j + 1] + paper[i + 2][j + 1];

						if (max < temp)
							max = temp;
					}
					// 4(세로 버전) - 2
					if (i + 2 < N && j > 0) {
						int temp = common + paper[i + 1][j - 1] + paper[i + 2][j - 1];

						if (max < temp)
							max = temp;
					}
				}
			}
		}

		return max;
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		paper = new int[N][M];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());

			for (int j = 0; j < M; j++)
				paper[i][j] = Integer.parseInt(st.nextToken());
		}

		System.out.println(solution(N, M));
	}

}
