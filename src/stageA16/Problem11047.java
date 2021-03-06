package stageA16;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem11047 {
	static int[] coin;

	public static int greedCoin(int K) {
		int count = 0;
		int index = coin.length - 1;
		for (; index > 0; index--)
			if (coin[index] < K)
				break;

		while (K != 0) {

			count += K / coin[index];
			K %= coin[index--];

		}
		return count;
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		coin = new int[N];

		for (int i = 0; i < N; i++)
			coin[i] = Integer.parseInt(br.readLine());

		System.out.println(greedCoin(K));
	}

}
