package cp5;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class Problem15990 {
	static int[][] num;
	static int mod = 1_000_000_009;

	private static void solution() {

		num[1][1] = 1;
		num[1][2] = 0;
		num[1][3] = 0;

		num[2][1] = 0;
		num[2][2] = 1;
		num[2][3] = 0;

		num[3][1] = 1;
		num[3][2] = 1;
		num[3][3] = 1;

		for (int i = 4; i <= 100_000; i++) {
			num[i][1] = num[i - 1][2] + num[i - 1][3];
			num[i][2] = num[i - 2][1] + num[i - 2][3];
			num[i][3] = num[i - 3][1] + num[i - 3][2];

			num[i][1] %= mod;
			num[i][2] %= mod;
			num[i][3] %= mod;
		}

	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int T = sc.nextInt();
		num = new int[100_001][4];
		solution();

		for (int i = 0; i < T; i++) {
			int N = sc.nextInt();
			int answer = 0;
			for (int j = 1; j <= 3; j++) {
				answer += num[N][j];
				answer %= mod;
			}
			bw.write(answer + "\n");
		}

		sc.close();
		bw.flush();
		bw.close();
	}

}
