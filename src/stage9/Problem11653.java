package stage9;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Problem11653 {

	// initPrimeList
	// : PrimeList에 root(number)이전의 소수들을 찾아 채워주는 메소드
	public static void initPrimeList(int number, int[] primeList) {
		int rt = (int) Math.sqrt(number);
		primeList[0] = 2;
		int count = 0;

		for (int i = 3; i <= rt; i++) {
			int rtI = (int) Math.sqrt(i);
			for (int j = 0; j <= count; j++) {
				if ((i % primeList[j]) == 0)
					break;
				else if (j == count || rtI <= primeList[j]) {
					primeList[++count] = i;
					break;
				}
			}
		}
	}

	public static boolean isItPrime(int N, int[] primeList) {
		int rt = (int) Math.sqrt(N);
		if (N == 1)
			return false;
		for (int i = 0; primeList[i] != 0 && primeList[i] <= rt; i++)
			if (N != primeList[i] && N % primeList[i] == 0)
				return false;

		return true;
	}

	// Factorization
	// : primeList를 이용해 N을 가장 작은 소수로 소인수분해
	public static void factorization(int N, int[] primeList) throws IOException {
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		if (N == 1)
			return;
		for (int i = 0; primeList[i] != 0; i++) {
			if (N == 1)
				break;

			while ((N % primeList[i]) == 0) {
				bw.write(primeList[i] + "\n");
				N /= primeList[i];
			}
		}
		if (Problem11653.isItPrime(N, primeList)) // 남은 N이 소수일경우 판별
			bw.write(N + "\n");

		bw.flush();
		bw.close();
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int rangeNum = 10000000;
		int rtRangeNum = (int) Math.sqrt(rangeNum);
		int[] primeList = new int[rtRangeNum];

		int N = Integer.parseInt(br.readLine());
		br.close();
		Problem11653.initPrimeList(rangeNum, primeList);
		Problem11653.factorization(N, primeList);
	}
}
