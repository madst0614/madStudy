package cp1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Problem9613 {
	static int[] num;
	static int[] gcdSet;

	private static int getGCD(int num1, int num2) {
		int x = num1;
		int y = num2;
		int rem;

		while (y != 0) {
			rem = x % y;
			x = y;
			y = rem;
		}

		return x;
	}

	private static long solution() {
		int count = 0;
		long sum = 0;

		for (int i = 0; i < num.length - 1; i++)
			for (int j = i + 1; j < num.length; j++) {
				if (num[i] > num[j])
					gcdSet[count++] = getGCD(num[i], num[j]);
				else
					gcdSet[count++] = getGCD(num[j], num[i]);
			}

		for (int i = 0; i < count + 1; i++) {
			sum += gcdSet[i];
		}

		return sum;
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());

		for (int i = 0; i < T; i++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			num = new int[N];
			gcdSet = new int[10000];

			for (int j = 0; j < N; j++) {
				num[j] = Integer.parseInt(st.nextToken());
			}

			bw.write(solution() + "\n");
		}

		br.close();
		bw.flush();
		bw.close();

	}

}
