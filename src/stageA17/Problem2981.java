package stageA17;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Problem2981 {
	static int[] num;

	public static void findM(int gcd) throws IOException {
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		for (int i = 2; i <= gcd; i++) {
			if (gcd % i == 0)
				bw.write(i + " ");
		}
		bw.flush();
		bw.close();
	}

	private static int findGCD(int A, int B) {
		if (A < B) {
			int temp = A;
			A = B;
			B = temp;
		}
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

		int N = Integer.parseInt(br.readLine());
		num = new int[N];

		num[0] = Integer.parseInt(br.readLine());

		for (int i = 1; i < N; i++) {
			num[i] = Integer.parseInt(br.readLine());
		}
		br.close();

		Arrays.sort(num);
		int gcd = num[1] - num[0];
		if (N != 2) {
			gcd = findGCD(num[2] - num[1], num[1] - num[0]);
			for (int i = 3; i < N; i++) {
				gcd = findGCD(num[i] - num[i - 1], gcd);
			}
		}
		findM(gcd);
	}

}
