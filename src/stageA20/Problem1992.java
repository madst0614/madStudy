package stageA20;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem1992 {
	static int[][] video;

	public static String solution(int rowStart, int rowEnd, int colStart, int colEnd) {
		if (rowStart == rowEnd && colStart == colEnd) {
			if (video[rowStart][colStart] == 0)
				return "0";
			else
				return "1";
		}

		boolean oneColored = true;
		int color = video[rowStart][colStart];

		for (int i = rowStart; i < rowEnd + 1; i++)
			for (int j = colStart; j < colEnd + 1; j++) {
				if (video[i][j] != color) {
					oneColored = false;
					break;
				}
			}

		if (oneColored) {
			if (video[rowStart][colStart] == 0)
				return "0";
			else
				return "1";
		}

		int rowMid = (rowStart + rowEnd) / 2;
		int colMid = (colStart + colEnd) / 2;

		StringBuffer sb = new StringBuffer("(");
		sb.append(solution(rowStart, rowMid, colStart, colMid));
		sb.append(solution(rowStart, rowMid, colMid + 1, colEnd));
		sb.append(solution(rowMid + 1, rowEnd, colStart, colMid));
		sb.append(solution(rowMid + 1, rowEnd, colMid + 1, colEnd));
		sb.append(")");
		return sb.toString();
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb;

		int N = Integer.parseInt(br.readLine());
		video = new int[N][N];

		for (int i = 0; i < N; i++) {
			sb = new StringBuffer(br.readLine());
			for (int j = 0; j < N; j++)
				video[i][j] = sb.charAt(j) - '0';
		}

		System.out.println(solution(0, N - 1, 0, N - 1));
	}

}
