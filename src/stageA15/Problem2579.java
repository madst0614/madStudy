package stageA15;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem2579 {
	static int[] stepValue;
	static int[][] maxSteps;

	/* 알고리즘 개요
	 *  : i-1번째 경우까지 밟은 경우와 밟지 않은 경우를 고려해서 i번째 계단을 밟는 경우를 고려하였다.
	 *   마지막 N번째는 무조건 밟아야 하므로 N-1번째를 밟는 경우와 N-2번째를 밟는 경우를 고려하였다.
	 *   
	 *  maxSteps[i-1][2]->i-1번째까지 연속해서 밟은 계단이 2개
	 *  maxSteps[i-1][1]->i-1번째까지 연속해서 밟은 계단이 1개
	 *  maxSteps[i-1][0]->i-1번째 계단을 밟지 않음
	 *  
	 *  i번째를 밟지 않는 경우 maxSteps[i-1][2], maxSteps[i-1][1] 를 비교해서 max값 -> maxSteps[i][0]
	 *  (여기서 maxSteps[i-1][0]는 무조건 밟아야 하므로 제외 <- 3칸을 건너뛸 순 없으므로)
	 *  i번째를 밟는 경우 maxSteps[i-1][1], maxSteps[i-1][0] 를 비교해서 max값 -> maxSteps[i][0]
	 *  (여기서 maxSteps[i-1][2]는 밟지 못하므로 제외 <- 연속 3칸을 건널 수 없으므로)
	 */
	
	// i번째를 밟은 경우와 밟지 않은 경우 모두 비교해서 max값 return
	public static int findMax(int i) {

		int max = maxSteps[i][0];
		
		if (max < maxSteps[i][1])
			max = maxSteps[i][1];
		
		if (max < maxSteps[i][2])
			max = maxSteps[i][2];
		
		return max;

	}

	// i번째 밟는 경우와 밟지 않는 경우에 대해서 max값 return
	public static int findMax(int i, boolean step) {
		if (!step) {
			if (maxSteps[i][1] < maxSteps[i][2])
				return maxSteps[i][2];
			else
				return maxSteps[i][1];
		} else {
			if (maxSteps[i][0] < maxSteps[i][1])
				return maxSteps[i][1];
			else
				return maxSteps[i][0];
		}
	}

	// 마지막 N번째는 무조건 밟아야 하므로 N-1번째를 밟는 경우와 N-2번째를 밟는 경우를 고려해서 max값 return
	public static int findMaxResult(int N) {
		if (N == 1)
			return stepValue[N];
		// N-1번째 밟아서 N번째로 가는 경우(step=true)
		int prevStep = findMax(N - 1, true) + stepValue[N];

		// N-2번째 밟아서 N번째로 가는 경우
		int prevPrevStep = findMax(N - 2) + stepValue[N];

		// 위 두 가지 경우 대소 비교 후 max값 return
		if (prevPrevStep < prevStep)
			return prevStep;
		else
			return prevPrevStep;
	}

	public static void findMaxRoute(int N) {
		for (int i = 1; i < N; i++) {

			// i-1번째 밟지 않은 경우의 값을 저장
			int zeroPrev = maxSteps[i - 1][0];

			// i번째 계단을 밟지 않는 경우(step=false)
			maxSteps[i][0] = findMax(i - 1, false);

			// i번쨰 계단을 밟는 경우(step 불필요. 비교 필요없음)
			maxSteps[i][2] = maxSteps[i - 1][1] + stepValue[i];
			maxSteps[i][1] = zeroPrev + stepValue[i];
		}
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		stepValue = new int[N + 1];
		maxSteps = new int[N + 1][3];

		for (int i = 1; i < N + 1; i++) {
			int value = Integer.parseInt(br.readLine());
			stepValue[i] = value;
			findMaxRoute(i);
		}
		System.out.println(findMaxResult(N));
	}

}
