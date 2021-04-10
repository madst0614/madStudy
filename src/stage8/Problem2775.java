package stage8;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Problem2775 {

	public static int moveIn(int K, int N) {
		int[][] roomReq = new int[K][N];

		// Initialization
		for (int j = 0; j < N; j++)
			roomReq[0][j] = j + 1;
		for (int i = 1; i < K; i++)
			for (int j = 0; j < N; j++) {
				if ((j - 1) < 0)
					roomReq[i][j] = 1;
				else
					roomReq[i][j] = roomReq[i][j - 1] + roomReq[i - 1][j];
			}
		return roomReq[K - 1][N - 1];
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int T = Integer.parseInt(br.readLine());

		for (int i = 0; i < T; i++) {
			int K = Integer.parseInt(br.readLine()) + 1; // 0층부터 있으므로
			int N = Integer.parseInt(br.readLine());
			bw.write(Problem2775.moveIn(K, N) + "\n");
		}
		br.close();
		bw.flush();
		bw.close();

	}

}
