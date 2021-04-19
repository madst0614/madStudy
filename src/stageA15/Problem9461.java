package stageA15;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Problem9461 {

	static long[] length;

	public static long P(int N) {
		for (int i = 6; i < N + 1; i++) {
			length[i] = length[i - 1] + length[i - 5];
		}
		return length[N];
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int maxNum = 100;
		length = new long[maxNum + 1];
		length[1] = 1;
		length[2] = 1;
		length[3] = 1;
		length[4] = 2;
		length[5] = 2;

		int T = Integer.parseInt(br.readLine());
		for (int i = 0; i < T; i++) {
			int N = Integer.parseInt(br.readLine());
			bw.write(P(N) + "\n");
		}
		br.close();
		bw.flush();
		bw.close();
	}

}
