package stageA15;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Problem9184 {
	static int[][][] storedW;

	public static void initStoreW() {
		for (int a = 0; a <= 50; a++)
			for (int b = 0; b <= 50; b++)
				for (int c = 0; c <= 50; c++) {
					storedW[a][b][c] = 0;
				}
	}

	public static int w(int a, int b, int c) {

		if (a <= 0 || b <= 0 || c <= 0)
			return 1;

		if (storedW[a][b][c] != 0)
			return storedW[a][b][c];

		if (a > 20 || b > 20 || c > 20) {
			storedW[a][b][c] = w(20, 20, 20);
			return storedW[a][b][c];
		}

		if (a < b && b < c) {
			storedW[a][b][c] = w(a, b, c - 1) + w(a, b - 1, c - 1) - w(a, b - 1, c);
			return storedW[a][b][c];
		} else {
			storedW[a][b][c] = w(a - 1, b, c) + w(a - 1, b - 1, c) + w(a - 1, b, c - 1) - w(a - 1, b - 1, c - 1);
			return storedW[a][b][c];
		}

	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		int maxNum = 51;
		storedW = new int[maxNum][maxNum][maxNum];
		initStoreW();
		while (true) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			if (a == -1 && b == -1 && c == -1)
				break;
			else
				bw.write("w(" + a + ", " + b + ", " + c + ") = " + w(a, b, c) + "\n");
		}
		br.close();
		bw.flush();
		bw.close();
	}

}
