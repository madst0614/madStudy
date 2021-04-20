package stageA15;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem1932 {
	static int[][] triangle;

	// i-1번째 row에서 max(j-1번째 column value, j번째 column value)
	public static int findMaxPrev(int i, int j) {
		if (triangle[i - 1][j - 1] < triangle[i - 1][j])
			return triangle[i - 1][j];
		else
			return triangle[i - 1][j - 1];
	}

	// N-1번째 row에서 최종 Max Sum Route 값 리턴
	public static int findResult(int N) {
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < N; i++) {
			if (max < triangle[N - 1][i])
				max = triangle[N - 1][i];
		}
		return max;
	}

	public static int findMaxSumRoute(int N) {
		for (int i = 1; i < N; i++) {
			// 삼각형 맨 앞(=0)과 맨 끝(=i) 값 할당 => i값 상관 없이 (i-1)번째 Value + i번째 Value이기 때문
			triangle[i][0] = triangle[i - 1][0] + triangle[i][0];
			triangle[i][i] = triangle[i - 1][i - 1] + triangle[i][i];

			// 현재 i번째 row의 j번 column의 최댓값
			// = i-1번째 row의 max(j-1번째 column 값, j번째 column 값) + 현재 j번째 column 값
			for (int j = 1; j < i; j++) {
				triangle[i][j] = findMaxPrev(i, j) + triangle[i][j];
			}
		}
		return findResult(N);
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());
		triangle = new int[N][];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			triangle[i] = new int[i + 1];
			for (int j = 0; j <= i; j++) {
				triangle[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		br.close();
		System.out.println(findMaxSumRoute(N));
	}

}
