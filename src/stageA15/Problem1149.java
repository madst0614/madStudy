package stageA15;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem1149 {

	/*
	 * 알고리즘 개요 (i번째 coloring) = {(i-1번째까지의 RGB 각각 최소값) + (i번째 colorCost)} i-1번째까지
	 * RGB 각각 최소값을 구해놨다는 가정 하에 다음 색칠 칠하기를 진행한다.(수학적 귀납법으로 증명가능)
	 * 
	 * i번쨰 색칠 칠하기의 경우
	 *  1. 'Red'   = min(i-1번째까지의 'GreenCost', 'BlueCost') + i번째 'RedCost'
	 *  2. 'Blue'  = min(i-1번째까지의 'RedCost', 'GreenCost') + i번째 'BlueCost'
	 *  3. 'Green' = min(i-1번째까지의 'RedCost', 'BlueCost') + i번째 'GreenCost'
	 * 
	 * 따라서 i-번쨰까지 RGB 최소값이 구해져있다는 가정이 만족하고, 이 가정은 문제의 정의에 기반한다 => 각각의 집이 한줄로 붙어 있기 때문에,
	 * 예를 들어 (i-2) ㅡ (i-1) ㅡ (i)에서 i번째의 값에 i-2번째 값은 i번째 color에 제한을 주지 않는다.
	 */

	// 편의상 1~N까지의 배열 인덱스 사용(= [N+1]배열 선언)
	// 0='Red '1='Green' 2='Blue
	static int[][] colorCost;

	// 마지막 N번쨰 RGB값 중 최소값 구하기
	public static int findMinCost(int N) {
		int min = 0;
		if (colorCost[N][0] < colorCost[N][1])
			min = colorCost[N][0];
		else
			min = colorCost[N][1];

		if (colorCost[N][2] < min)
			min = colorCost[N][2];

		return min;
	}

	public static int calMinCost(int N, int color) {
		if (color == 0) { // Red면
			if (colorCost[N][1] < colorCost[N][2])
				return colorCost[N][1];
			else
				return colorCost[N][2];
		} else if (color == 1) { // Green이면
			if (colorCost[N][0] < colorCost[N][2])
				return colorCost[N][0];
			else
				return colorCost[N][2];
		} else { // Blue면
			if (colorCost[N][0] < colorCost[N][1])
				return colorCost[N][0];
			else
				return colorCost[N][1];
		}
	}

	public static int coloring(int N) {
		for (int i = 1; i < N + 1; i++) {
			// i번째 집을 Red로 칠할때 최소값
			colorCost[i][0] = calMinCost(i - 1, 0) + colorCost[i][0];

			// i번째 집을 Greed로 칠할때 최소값
			colorCost[i][1] = calMinCost(i - 1, 1) + colorCost[i][1];

			// i번째 집을 Greed로 칠할때 최소값
			colorCost[i][2] = calMinCost(i - 1, 2) + colorCost[i][2];
		}
		return findMinCost(N);
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());
		colorCost = new int[N + 1][3];
		colorCost = new int[N + 1][3];

		for (int i = 1; i < N + 1; i++) {
			st = new StringTokenizer(br.readLine());
			int R = Integer.parseInt(st.nextToken());
			int G = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			colorCost[i][0] = R;
			colorCost[i][1] = G;
			colorCost[i][2] = B;
		}
		br.close();
		System.out.println(coloring(N));

	}
}