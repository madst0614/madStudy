package stageA17;

import java.util.Scanner;
import java.util.StringTokenizer;

public class Problem2004 {

	private static int findMin(int fiveNum, int twoNum) {
		if (fiveNum < twoNum)
			return fiveNum;
		else
			return twoNum;
	}

	private static int findNum(int N, int M, int number) {
		int xNum = 0;

		// nCm = N! / ( (N-M)!*M!)

		// N!
		int temp = N;
		while (temp != 0) {
			xNum += temp / number;
			temp /= number;
		}

		// N-M!
		temp = N - M;
		while (temp != 0) {
			xNum -= temp / number;
			temp /= number;
		}

		// M!
		temp = M;
		while (temp != 0) {
			xNum -= temp / number;
			temp /= number;
		}
		
		return xNum;

	}

	private static int findNotZero(int N, int M) {
		if ((N / 2) < M)
			M = N - M;

		int fiveNum = findNum(N, M, 5);
		int twoNum = findNum(N, M, 2);

		// 남은 숫자 5의 개수와 남은 숫자 2의 개수 중 작은 쪽에 맞춰 숫자 10으로 만들어짐
		return findMin(fiveNum, twoNum);

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		StringTokenizer st = new StringTokenizer(sc.nextLine());
		sc.close();

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		System.out.println(findNotZero(N, M));
	}
}
