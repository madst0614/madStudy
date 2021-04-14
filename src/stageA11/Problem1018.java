package stageA11;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem1018 {
	public static int checker(int startN, int endN, int startM, int endM, char[][] chessBoard) {
		int startW = 0;
		int startB = 0;
		char[][] chessBoardClone = new char[chessBoard.length][chessBoard[0].length];

		for (int i = 0; i < chessBoard.length; i++) {
			for (int j = 0; j < chessBoard[0].length; j++) {
				chessBoardClone[i][j] = chessBoard[i][j];
			}
		}

		if (chessBoardClone[startN][startM] == 'B')
			startW++;
		chessBoardClone[startN][startM] = 'W';
		for (int i = startN; i <= endN; i++) {
			for (int j = startM; j <= endM; j++) {
				if (j == startM) {
					if (i != startN) {
						if (chessBoardClone[i - 1][startM] == 'W' && chessBoardClone[i][startM] == 'W') {
							chessBoardClone[i][startM] = 'B';
							startW++;
						} else if (chessBoardClone[i - 1][startM] == 'B' && chessBoardClone[i][startM] == 'B') {
							chessBoardClone[i][startM] = 'W';
							startW++;
						}
					}
					continue;
				}
				if (chessBoardClone[i][j - 1] == 'W' && chessBoardClone[i][j] == 'W') {
					chessBoardClone[i][j] = 'B';
					startW++;
				} else if (chessBoardClone[i][j - 1] == 'B' && chessBoardClone[i][j] == 'B') {
					chessBoardClone[i][j] = 'W';
					startW++;
				}
			}
		}
		// printChess(chessBoardClone);

		for (int i = 0; i < chessBoard.length; i++) {
			for (int j = 0; j < chessBoard[0].length; j++) {
				chessBoardClone[i][j] = chessBoard[i][j];
			}
		}
		if (chessBoardClone[startN][startM] == 'W')
			startB++;
		chessBoardClone[startN][startM] = 'B';
		for (int i = startN; i <= endN; i++) {
			for (int j = startM; j <= endM; j++) {
				if (j == startM) {
					if (i != startN) {
						if (chessBoardClone[i - 1][startM] == 'W' && chessBoardClone[i][startM] == 'W') {
							chessBoardClone[i][startM] = 'B';
							startB++;
						} else if (chessBoardClone[i - 1][startM] == 'B' && chessBoardClone[i][startM] == 'B') {
							chessBoardClone[i][startM] = 'W';
							startB++;
						}
					}
					continue;
				}

				if (chessBoardClone[i][j - 1] == 'W' && chessBoardClone[i][j] == 'W') {
					chessBoardClone[i][j] = 'B';
					startB++;
				} else if (chessBoardClone[i][j - 1] == 'B' && chessBoardClone[i][j] == 'B') {
					chessBoardClone[i][j] = 'W';
					startB++;
				}
			}
		}
		// printChess(chessBoardClone);

		if (startW <= startB)
			return startW;
		else
			return startB;
	}

	public static void printChess(char[][] chessBoard) {
		for (int i = 0; i < chessBoard.length; i++) {
			for (int j = 0; j < chessBoard[0].length; j++) {
				System.out.print(chessBoard[i][j]);
			}
			System.out.println();
		}
		System.out.println();
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuffer sb;

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int minFill = Integer.MAX_VALUE;

		char[][] chessBoard = new char[N][M];

		for (int i = 0; i < N; i++) {
			sb = new StringBuffer(br.readLine());

			for (int j = 0; j < M; j++)
				chessBoard[i][j] = sb.charAt(j);
		}

		for (int i = 0; i + 7 < N; i++) {
			for (int j = 0; j + 7 < M; j++) {
				int startN = i;
				int endN = i + 7;
				int startM = j;
				int endM = j + 7;

				int temp = Problem1018.checker(startN, endN, startM, endM, chessBoard);
				if (temp < minFill)
					minFill = temp;

			}
		}
		System.out.println(minFill);
	}

}
