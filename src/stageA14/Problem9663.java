package stageA14;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem9663 {

	static int[] point; // 편리하게 1 ~ N까지의 값을 이용하기 위해 [1, N+1]까지 만듬.
	static int possibleTrial = 0; // 가능한 케이스

	/*
	 * 대략적인 알고리즘 개요 : N*N의 체스판에 N개의 퀸이 들어가므로 행렬[i, j]를 좌표값(x,y)로 봤을때, x=[1, N]에 모든 퀸
	 * N개가 들어가기 때문에 y의 값만 고려하면 된다. 이는 그림을 통해 이해하면 쉽다. 따라서 2차원 (x, y)-좌표계의 문제가 1차원
	 * (y)-좌표계의 문제로 축소되고, 서술할 유망성 검사 + NQueen 메소드의 재귀적 호출로 문제를 풀어나가게 된다. cf) x-좌표계를
	 * 고려할 필요가 없기 때문에 "축소시켰다" 표현 했을 뿐, x-좌표값은 사용해야 한다. 따라서 int형 1차원 배열 point[x] = y를
	 * 의미한다.
	 * 
	 */

	/*
	 * 유망성 검사(int N) : 파라미터 int N의 N은 현재 두어진 퀸의 개수와 퀸이 놓여지는 x의 위치를 의미한다. 즉 위에서 설명했던
	 * (x,y)좌표계에 (N,y)에 퀸이 놓여진다고 가정한다. cf) 퀸이 놓여지는 위치를 x의 위치, N에 고정하는 이유는 퀸의 모양은 똑같고
	 * 구분되지 않기때문에 순서를 고려하지 않기 때문이다.
	 * 
	 * 유망성 검사는 세가지 경우를 고려한다
	 *  false:
	 *  1. 이전에 들어있던 퀸들의 위치 y값과 현재 퀸을 넣을 위치의 y값이 같은가.
	 *  2. y=(x-a)+b. 여기서 (x,y)는 현재 고려하는 위치 (a, b)는 (i, point[i])
	 *  3. y=-(x-a)+b. 여기서 (x,y)는 현재 고려하는 위치(a, b)는 (i, point[i])
	 *  
	 *  true: 위의 경우 빼고 모두 다
	 */
	public static boolean isPromising(int N) {
		for (int i = point.length - 1; i > N; i--) {
			if (point[i] == point[N])
				return false;
			if (point[N] == (N - i) + point[i])
				return false;
			else if (point[N] == -(N - i) + point[i])
				return false;
		}

		return true;
	}

	/* int N : 현재 두어진 퀸의 개수, x의 위치
	 * cf) N==0이 될 경우 모든 퀸이 두어졌으므로 가능한 케이스를 증가하고 return한다.
	 * 
	 * int i : 고려할 y의 위치
	 * 
	 * point[x]=y : 좌표 (x, y)
	*/ 
	
	
	public static void NQueen(int N) {

		if (N == 0) {
			possibleTrial++;
			return;

		} else {
			for (int i = 1; i < point.length; i++) {
				point[N] = i;	// 고려할 y값을 point[x]에 넣는다. 즉 (x,y)를 고려
				if (isPromising(N)) {	// 만약 유망하다면?
					NQueen(N - 1);	// NQueen(N-1) 호출 (= 하나의 퀸을 둔 상태로 다음 N-1개이 퀸을 고려, 재귀적 호출)_
				}
			}

		}
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		point = new int[N + 1];

		NQueen(N);
		System.out.println(possibleTrial);
	}

}
