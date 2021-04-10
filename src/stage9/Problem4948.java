package stage9;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Problem4948 {

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

	// isItPrime
	// : 해당 N이 소수인지 아닌지 판별해주는 메소드
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

		int rangeNum = 1000000;
		int rtRangeNum = (int) Math.sqrt(rangeNum);
		int[] primeList = new int[rtRangeNum];
		StringTokenizer st;

		Problem4948.initPrimeList(rangeNum, primeList);

		while ((st = new StringTokenizer(br.readLine())) != null) {
			int N = Integer.parseInt(st.nextToken());
			int count = 0;
			if (N == 0)
				break;
			for (int i = N + 1; i <= (N * 2); i++)
				if (Problem4948.isItPrime(i, primeList))
					count++;

			bw.write(count + "\n");
		}
		br.close();
		bw.flush();
		bw.close();
	}
}
