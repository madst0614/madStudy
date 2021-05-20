package cp1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Problem6588 {
	static int max = 1000000;
	static boolean[] notPrime;
	static int[] prime;
	static int count;

	private static void getPrime() {
		for (int i = 2; i <= max; i++) {
			if (!notPrime[i]) {
				for (int j = 2 * i; j <= max; j += i) {
					notPrime[j] = true;
				}
			}
		}

		for (int i = 2; i < max; i++) {
			if (!notPrime[i]) {
				prime[count++] = i;
			}
		}
	}

	private static String goldBach(int N) {
		StringBuffer sb = new StringBuffer(N + " = ");
		for (int i = 0; i < count; i++) {
			if (prime[i] < N) {
				int a = prime[i];
				int b = N - a;

				if (!notPrime[b]) {
					sb.append(a + " + " + b + "\n");
					return sb.toString();
				}

			}
		}

		sb = new StringBuffer("Goldbach's conjecture is wrong.\n");
		return sb.toString();
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		notPrime = new boolean[max + 1];
		prime = new int[max + 1];
		count = 0;

		getPrime();

		int N;
		while (true) {
			N = Integer.parseInt(br.readLine());
			if (N == 0)
				break;

			bw.write(goldBach(N));
		}

		br.close();
		bw.flush();
		bw.close();
	}

}
