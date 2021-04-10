package stage9;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Problem1978 {

	// 어떤 자연수 N의 루트 값 이전의 소수만을 나눠서 나머지가 0이 되지 않는다면
	// 소수인 점을 이용하여 코드를 작성하였다.

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
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		br.close();
		int[] primeList = new int[31];
		int rangeNum = 1000;
		int primeCount = 0;

		Problem1978.initPrimeList(rangeNum, primeList);
		for (int i = 0; i < T; i++) {
			int N = Integer.parseInt(st.nextToken());
			boolean isItPrime = Problem1978.isItPrime(N, primeList);

			if (isItPrime)
				primeCount++;
		}
		bw.write(primeCount + "\n");
		bw.flush();
		bw.close();
	}
}
