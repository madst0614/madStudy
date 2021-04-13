package stageA11;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem1018 {
	public static int checker(int startN, int endN, int startM, int endM, char[][] chessBoard) {
		int startW = 0;
		int startB = 0;
		char[][] chessBoardClone = chessBoard.clone();

		chessBoardClone[startN][startM] = 'W';
		for (int i = startN; i <= endN; i++)
			for (int j = startM; j <= endM; j++) {
				if (j == startM)
					continue;
				if (chessBoardClone[i][j - 1] == 'W' && chessBoardClone[i][j] == 'W') {
					chessBoardClone[i][j] = 'B';
					startW++;
				} else if (chessBoardClone[i][j - 1] == 'B' && chessBoardClone[i][j] == 'B') {
					chessBoardClone[i][j] = 'W';
					startW++;
				}
			}

		chessBoardClone[startN][startM] = 'B';
		for (int i = startN; i <= endN; i++)
			for (int j = startM; j <= endM; j++) {
				if (j == startM)
					continue;
				if (chessBoardClone[i][j - 1] == 'W' && chessBoardClone[i][j] == 'W') {
					chessBoardClone[i][j] = 'B';
					startB++;
				} else if (chessBoardClone[i][j - 1] == 'B' && chessBoardClone[i][j] == 'B') {
					chessBoardClone[i][j] = 'W';
					startB++;
				}
			}
		if (startW <= startB)
			return startW;
		else
			return startB;
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb = new StringBuffer(br.readLine());

		int N = sb.charAt(0) - '0';
		int M = sb.charAt(1) - '0';
		int diffN=N-8;
		int diffM=M-8;
		int minFill;
		
		char[][] chessBoard = new char[N][M];

		for (int i = 0; i < N; i++) {
			sb = new StringBuffer(br.readLine());

			for (int j = 0; j < M; j++)
				chessBoard[i][j] = sb.charAt(j);
		}

		for(int i=0; i<=diffN; i+=diffN) {
			for(int j=0; j<=diffM; j+=diffM) {
				if(i==0 && j==0) {
					minFill=Problem1018.checker(i, N-(diffN-i), j, M-(diffM-j), chessBoard);
				}
			}
			
			int temp;
			if(i==0) {
					minFill=Problem1018.checker(0, N-diffN, 0, M-diffM, chessBoard);
			}else if(i==1) {
				
			}
		}
		
	}

}
