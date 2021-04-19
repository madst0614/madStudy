package stageA15;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem1904 {
	static int[] storedFibMod;

	public static void initStore() {
		storedFibMod[0] = 1;
		storedFibMod[1] = 1;
	}

	public static int zeroOneTile(int n) {
		for (int i = 2; i < n + 1; i++) {
			storedFibMod[i] = (storedFibMod[i - 1] + storedFibMod[i - 2]) % 15746;
		}
		return storedFibMod[n];
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int maxNum = 1000001;
		storedFibMod = new int[maxNum];
		int n = Integer.parseInt(br.readLine());

		initStore();
		System.out.println(zeroOneTile(n));

	}

}
