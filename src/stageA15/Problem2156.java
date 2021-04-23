package stageA15;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem2156 {
	static int[] wineValue;
	static int[] drunkWine;
	static int maxSequence = 2;

	public static int findMax(int wine, int otherWine) {
		if (wine < otherWine)
			return otherWine;
		else
			return wine;
	}

	public static int drinkMaxValue(int N) {
		int maxValue = Integer.MIN_VALUE;
		for (int i = 0; i < N; i++) {
			int temp = drunkWine[2];
			// temp = 안마시는 경우
			temp = findMax(drunkWine[2], findMax(drunkWine[1], drunkWine[0]));

			drunkWine[2] = drunkWine[1] + wineValue[i];
			drunkWine[1] = drunkWine[0] + wineValue[i];
			drunkWine[0] = temp;
		}

		for (int i = 0; i < drunkWine.length; i++) {
			if (maxValue < drunkWine[i])
				maxValue = drunkWine[i];
		}

		return maxValue;
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		wineValue = new int[N];
		drunkWine = new int[maxSequence + 1];

		for (int i = 0; i < N; i++) {
			wineValue[i] = Integer.parseInt(br.readLine());
		}
		System.out.println(drinkMaxValue(N));
	}

}
