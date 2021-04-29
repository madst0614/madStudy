package stageA17;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Problem3036 {
	static int[] ring;

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
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());
		ring = new int[N];

		st = new StringTokenizer(br.readLine());
		br.close();

		ring[0] = Integer.parseInt(st.nextToken());
		for (int i = 1; i < N; i++) {
			ring[i] = Integer.parseInt(st.nextToken());
			int gcd = findGCD(ring[0], ring[i]);
			bw.write(ring[0] / gcd + "/" + ring[i] / gcd + "\n");
		}
		bw.flush();
		bw.close();

	}

}
