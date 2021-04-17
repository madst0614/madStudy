package stageA14;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Problem2580 {

	static int[][] board;
	static int[] zeroCount;

	public static void printBoard() throws IOException {
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board.length; j++)
				bw.write(board[i][j] + " ");
			bw.write("\n");
		}
		bw.flush();
		bw.close();
	}

	public static boolean isPromising(int row, int col, int num) {
		int sectorRow = row - row % 3;
		int sectorCol = col - col % 3;

		for (int i = 0; i < board.length; i++) {
			if (board[i][col] == num)
				return false;
		}

		for (int j = 0; j < board.length; j++) {
			if (board[row][j] == num)
				return false;
		}

		for (int i = 0; i < 3; i++)
			for (int j = 0; j < 3; j++) {
				if (board[sectorRow + i][sectorCol + j] == num)
					return false;
			}
		return true;
	}

	public static void sudokuSolver(int row, int col) throws IOException {
		if (row == board.length) {
			printBoard();
			System.exit(0);
		}
		if (col == board.length) {
			sudokuSolver(row + 1, 0);
			return;
		}

		if (board[row][col] == 0) {
			for (int num = 1; num <= 9; num++) {
				if (isPromising(row, col, num)) {
					board[row][col] = num;
					sudokuSolver(row, col + 1);
				}
			}
			board[row][col] = 0;
			return;
		}
		sudokuSolver(row, col + 1);
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		board = new int[9][9];
		zeroCount = new int[9];

		for (int i = 0; i < 9; i++) {
			int sum = 0;
			int temp = -1;
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 9; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
				if (board[i][j] == 0) {
					zeroCount[i]++;
					if (zeroCount[i] > 1) {
						continue;
					} else {
						temp = j;
					}
				}
				sum += board[i][j];
			}
			if (zeroCount[i] == 1) {
				zeroCount[i] = 0;
				board[i][temp] = 45 - sum;
			}
		}
		Problem2580.sudokuSolver(0, 0);
	}
}
