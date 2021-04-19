package stageA15;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Problem1003 {
	static int[][] fibStore;

	public static void initStore() {
		for (int i = 0; i < 2; i++)
			for (int j = 0; j < 2; j++)
				if (i == j)
					fibStore[i][j]++;
	}

	public static void fibonacciCount(int maxIndex, int n) {

		for (int i = maxIndex + 1; i < n + 1; i++) {
			fibStore[i][0] = fibStore[i - 1][0] + fibStore[i - 2][0];
			fibStore[i][1] = fibStore[i - 1][1] + fibStore[i - 2][1];
		}
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int maxNum = 40;
		fibStore = new int[maxNum + 1][2];

		initStore();
		int T = Integer.parseInt(br.readLine());
		int maxIndex = 1;
		for (int i = 0; i < T; i++) {
			int n = Integer.parseInt(br.readLine());
			if (maxIndex < n) {
				fibonacciCount(maxIndex, n);
				bw.write(fibStore[n][0] + " " + fibStore[n][1] + "\n");
			} else
				bw.write(fibStore[n][0] + " " + fibStore[n][1] + "\n");
		}
		br.close();
		bw.flush();
		bw.close();
	}

}
