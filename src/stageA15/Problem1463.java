package stageA15;

import java.util.Scanner;

public class Problem1463 {

	/* 알고리즘 개요
	 * 아래의 가정을 토대로 작성하였다
	 * 
	 * 1. 숫자 N을 먼저 2로 나누고 그 다음 3으로 나눈 것과
	 *  먼저 3을 나누고 2로 나눈 것은 결과가 동일하다(단, 연산 횟수는 다르다)
	 * 
	 * 2. i번째 숫자 N을 2로 나눈 몫은 그 다음 i+1째 숫자 N'이며,
	 *  연산 횟수 count(i+1) = i+2로 나눈 나머지 + 1(2로 나눴을 때 한번)이다. 마찬가지로 3으로 나눴을 때도 동일
	 *  
	 * 3. 위의 사실을 바탕으로 중복되는 값을 메모이제이션한다.(아래 숫자들은 트리로 만들어서 보면 더 쉽다. 각각의 분기를 2,3으로)
	 *    2 - 2 - 2
	 *  $ 2 - 2 - 3
	 *  $ 2 - 3 - 2
	 *  @ 2 - 3 - 3
	 *  $ 3 - 2 - 2
	 *  @ 3 - 2 - 3
	 *  @ 3 - 3 - 2
	 *    3 - 3 - 3
	 */

	// [i][j][k] : i,j는 각각의 분기 k=0(i번쨰 숫자) k=1(연산 횟수)
	static int[][][] minOp;

	// type=2(2로 계속 나누는 경우), type=-1(j-1과 j를 비교해야하는 경우) type=3 (3으로 쭉 나누는 경우)
	public static void findMinOp(int i, int j, int type) {
		if (type == 2) {
			minOp[i][j][0] = minOp[i - 1][j][0] / 2;
			minOp[i][j][1] = minOp[i - 1][j][1] + minOp[i - 1][j][0] % 2 + 1;
		} else if (type == -1) {
			minOp[i][j][0] = minOp[i - 1][j - 1][0] / 3;
			if (minOp[i - 1][j - 1][0] % 2 < minOp[i - 1][j][0] % 3)
				minOp[i][j][1] = minOp[i - 1][j][1] + minOp[i - 1][j][0] % 2 + 1;
			else
				minOp[i][j][1] = minOp[i - 1][j - 1][1] + minOp[i - 1][j - 1][0] % 3 + 1;
		} else {
			minOp[i][j][0] = minOp[i - 1][j - 1][0] / 3;
			minOp[i][j][1] = minOp[i - 1][j - 1][1] + minOp[i - 1][j - 1][0] % 3 + 1;
		}
	}

	public static int findMinOp(int N) {
		int minCount = Integer.MAX_VALUE;

		// 초기화
		minOp[0] = new int[1][];
		minOp[0][0] = new int[2];
		minOp[0][0][0] = N;
		if (N == 1)
			return minOp[0][0][1];

		for (int i = 1; i < minOp.length; i++) {
			minOp[i] = new int[i + 1][];
			for (int j = 0; j <= i; j++) {
				minOp[i][j] = new int[2];
				// 2로만 나누는 경우(type=2)
				if (j == 0)
					findMinOp(i, j, 2);
				// 3로만 나누는 경우(type=3)
				else if (j == i)
					findMinOp(i, j, 3);
				// 복합(type=-1)
				else
					findMinOp(i, j, -1);

				if (minOp[i][j][0] == 1 && minOp[i][j][1] < minCount)
					minCount = minOp[i][j][1];
			}
		}
		
		for (int i = 1; i < minOp.length; i++) {
			for (int j = 0; j <= i; j++) {
				if (minOp[i][j][0] == 1 && minOp[i][j][1] < minCount)
					minCount = minOp[i][j][1];
			}
		}
		return minCount;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		sc.close();

		int i = N;
		int n = 0;
		while (i != 0) {
			i /= 2;
			n++;
		}
		minOp = new int[30][][];

		System.out.println(findMinOp(N));
	}

}
