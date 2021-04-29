package stageA17;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Problem1934 {

	private static void findBigger(int A, int B) {
		if (A >= B)
			return;
		else {
			int temp = A;
			A = B;
			B = temp;
		}
	}

	private static int findGCD(int A, int B) {
		int X = A;
		int Y = B;
		int R = 0;
		while (Y != 0) {
			R = X % Y;
			X = Y;
			Y = R;
		}
		return X;
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());

			findBigger(A, B);
			int gcd = findGCD(A, B);
			bw.write(A * B / gcd + "\n");
		}
		br.close();
		bw.flush();
		bw.close();

	}

}
