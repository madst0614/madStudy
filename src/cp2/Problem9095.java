package cp2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Problem9095 {
	static int[] num;

	private static void solution(int N) {

		num[1] = 1;
		num[2] = 2;
		num[3] = 4;

		for (int i = 4; i <= N; i++) {
			num[i] = num[i - 1] + num[i - 2] + num[i - 3];
		}
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int T = Integer.parseInt(br.readLine());
		for (int i = 0; i < T; i++) {
			int N = Integer.parseInt(br.readLine());
			num = new int[12];
			solution(N);
			bw.write(num[N] + "\n");
		}

		br.close();
		bw.flush();
		bw.close();
	}

}
