package stageA20;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem2630 {
	static int[][] paper;
	static int whitePaper = 0;
	static int bluePaper = 0;

	public static void solution(int rowStart, int rowEnd, int colStart, int colEnd) {
		if (rowStart == rowEnd && colStart == colEnd) {
			if (paper[rowStart][colStart] == 0)
				whitePaper++;
			else
				bluePaper++;
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
			if (paper[rowStart][colStart] == 0)
				whitePaper++;
			else
				bluePaper++;
			return;
		}

		int rowMid = (rowStart + rowEnd) / 2;
		int colMid = (colStart + colEnd) / 2;
		
		solution(rowStart, rowMid, colStart, colMid);
		solution(rowMid + 1, rowEnd, colStart, colMid);
		solution(rowStart, rowMid, colMid + 1, colEnd);
		solution(rowMid + 1, rowEnd, colMid + 1, colEnd);
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
		System.out.println(whitePaper + "\n" + bluePaper);
	}

}
