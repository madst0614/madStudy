package stageA14;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/* 알고리즘 개요
 * 0을 미리 넣어놓고(따라서 teamSelect(0,1)이 초기값), 모든 team의 경우의 수 구하였다.
 * 이는 스타트팀과 링크팀 능력치의 차이의 절대값을 구하는데는 플레이어의 구분이 필요 없기 때문이다.
 * ex) 6명의 플레이어를 두 팀으로 나눌 때 minValue({0, 1, 2},{3, 4, 5}) = minValue({3, 4, 5}, {0, 1, 2})
 *  0~j / j+1~k / k+1~ Num  이런식으로 중복되는 시도가 없도록 알고리즘의 효율을 고려하였다.
 */

public class Problem14889 {
	static int[][] synergy;
	static int[] selected;
	static int min;
	static int Num;

	public static int valueDiff() {
		int valueDiff = 0;
		int lastNum = 0;

		// Team1의 마지막 플레이어 구하기 = selected[마지막 플레이어]=0
		while (selected[lastNum] != 0) {
			lastNum = selected[lastNum];
		}

		// Team 2에 속한 player들 구하기
		int[] team2 = new int[Num / 2];
		int count = 0;
		for (int j = 0; j < Num; j++) {
			if (selected[j] == 0 && j != lastNum)
				team2[count++] = j;
		}

		// Team1의 value
		for (int i = 0; selected[i] != 0; i = selected[i]) {
			for (int j = selected[i]; j != 0; j = selected[j]) {
				valueDiff += synergy[i][j] + synergy[j][i];

			}
		}

		// Team2의 value
		for (int m = 0; m < Num / 2; m++) {
			for (int n = m + 1; n < Num / 2; n++) {
				int i = team2[m];
				int j = team2[n];
				valueDiff -= synergy[i][j] + synergy[j][i];
			}
		}
		return Math.abs(valueDiff);
	}

	public static void teamSelect(int playerNum, int totalSelected) {
		if (totalSelected == Num / 2) {
			int currentValue = valueDiff();
			if (currentValue < min)
				min = currentValue;
			return;
		} else {
			int canSelect = Num / 2 + totalSelected; // Num-(Num-totalSelected) 괄호 안은 남아 있는 선택 개수
			for (int j = playerNum + 1; j <= canSelect; j++) {
				selected[playerNum] = j;
				teamSelect(j, totalSelected + 1);
				selected[playerNum] = 0;
			}
			return;
		}
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		Num = Integer.parseInt(br.readLine());
		synergy = new int[Num][Num];
		selected = new int[Num];

		for (int i = 0; i < Num; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < Num; j++) {
				synergy[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		min = Integer.MAX_VALUE;

		teamSelect(0, 1);
		System.out.println(min);
	}

}
