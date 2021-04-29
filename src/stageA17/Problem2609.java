package stageA17;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem2609 {

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
		StringTokenizer st = new StringTokenizer(br.readLine());
		br.close();

		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());

		findBigger(A, B);
		int gcd = findGCD(A, B);
		System.out.println(gcd + "\n" + A * B / gcd);

	}

}
