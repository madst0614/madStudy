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

		for (int i = rowStart; i < rowEnd; i += rowThird) {
			for (int j = colStart; j < colEnd; j += colThird) {
				System.out.println(i + " " + (i + rowThird - 1) + " " + j + " " + (j + colThird - 1));
				solution(i, i + rowThird - 1, j, j + colThird - 1);
				System.out.println();
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
