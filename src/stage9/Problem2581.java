package stage9;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Problem2581 {

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

	// findPrimeSumAndMin
	// : PrimeList를 이용하는 isItPrime 메소드를 통해 소수를 판별하고 Sum에 합산,
	// Prime 최솟값은 처음 만나는 소수를 저장
	public static void findPrimeSumAndMin(int startNum, int endNum, int[] primeList) throws IOException {
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int sum, minPrime;
		boolean findMinPrime = false;

		sum = 0;
		minPrime = -1;
		for (int i = startNum; i <= endNum; i++) {
			if (Problem2581.isItPrime(i, primeList)) {
				if (!findMinPrime) { // minPrime을 찾았다면 앞으로는 저장 X
					minPrime = i;
					findMinPrime = true;
				}
				sum += i;
			}
		}
		if (findMinPrime) {
			bw.write(sum + "\n" + minPrime + "\n");
			bw.flush();
		} else {
			bw.write(-1 + "\n");
			bw.flush();
		}
		bw.close();
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int rangeNum = 10000;
		int rtRangeNum = (int) Math.sqrt(rangeNum);
		int[] primeList = new int[rtRangeNum];

		Problem2581.initPrimeList(rangeNum, primeList);

		int startNum = Integer.parseInt(br.readLine());
		int endNum = Integer.parseInt(br.readLine());
		br.close();

		Problem2581.findPrimeSumAndMin(startNum, endNum, primeList);
	}
}
