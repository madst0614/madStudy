package stage9;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Problem9020 {

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

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = Integer.parseInt(br.readLine());

		int rangeNum = 100000000;
		int rtRangeNum = (int) Math.sqrt(rangeNum);
		int[] primeList = new int[rtRangeNum];

		Problem9020.initPrimeList(rangeNum, primeList);
		for (int i = 0; i < T; i++) {
			int N = Integer.parseInt(br.readLine());
			int temPrime = primeList[0];
			int minDiff = 100000;
			int minPrime = 0;
			int j = 0;
			while (temPrime <= (N / 2)) {

				if (Problem9020.isItPrime(N - temPrime, primeList)) {
					minDiff = (N - temPrime) - temPrime;
					minPrime = temPrime;
				}
				temPrime = primeList[j];
				j++;
			}
			if (N - minPrime < minPrime)
				bw.write((N - minPrime) + " " + minPrime + "\n");
			else
				bw.write(minPrime + " " + (N - minPrime) + "\n");
		}
		br.close();
		bw.flush();
		bw.close();
	}

}
