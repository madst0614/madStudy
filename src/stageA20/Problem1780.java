package stageA20;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem1780 {
	static int[][] paper;
	static int minusPaper = 0;
	static int zeroPaper = 0;
	static int plusPaper = 0;

	public static void solution(int rowStart, int rowEnd, int colStart, int colEnd) {
		if (rowStart == rowEnd && colStart == colEnd) {
			if (paper[rowStart][colStart] == -1)
				minusPaper++;
			else if (paper[rowStart][colStart] == 0)
				zeroPaper++;
			else
				plusPaper++;
			return;
		}

		boolean oneColored = true;
		int color = paper[rowStart][colStart];

		for (int i = rowStart; i < rowEnd + 1; i++)
			for (int j = colStart; j < colEnd + 1; j++) {
				if (paper[i][j] != color) {
					oneColored = false;
					break;
				}
			}

		if (oneColored) {
			if (paper[rowStart][colStart] == -1)
				minusPaper++;
			else if (paper[rowStart][colStart] == 0)
				zeroPaper++;
			else
				plusPaper++;
			return;
		}

		int rowThird = (rowEnd - rowStart + 1) / 3;
		int colThird = (colEnd - colStart + 1) / 3;

		// Terminal 조건 (i<rowEnd)에 '='이 포함되어야 하는 이유
		// 0~2 3~5 6~8엔 필요 없지만, 범위가 좀 더 세밀한 경우 예를 들어
		// 0~0, 1~1, 2~2 같은 경우 rowEnd가 포함되어야 한다
		// 코드를 짤 떄, 세밀한 부분을 놓치지 않도록 조심. 최대한 타이트하게 조건을 맞추도록 짠다면 실수할 일은 없을 것이다.
		for (int i = rowStart; i <= rowEnd; i += rowThird) {
			for (int j = colStart; j <= colEnd; j += colThird) {
				solution(i, i + rowThird - 1, j, j + colThird - 1);
			}
		}
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());
		paper = new int[N][N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++)
				paper[i][j] = Integer.parseInt(st.nextToken());
		}

		solution(0, N - 1, 0, N - 1);
		System.out.println(minusPaper + "\n" + zeroPaper + "\n" + plusPaper);
	}

}
