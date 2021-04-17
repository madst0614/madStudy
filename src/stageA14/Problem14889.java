package stageA14;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem14889 {

	static int[][] synergy;
	static boolean[] isSelected;
	static int min;
	static int Num;
	
	public static int teamValue1() {
		int sum=0;
		for(int i=0; i<Num; i++)
			for(int j=0; j<Num; j++)
			if(isSelected[i] && isSelected[j])
				sum+=synergy[i][j]+synergy[j][i];
		return sum;
	}
	
	public static int teamValue2() {
		int sum=0;
		for(int i=0; i<Num; i++)
			for(int j=0; j<Num; j++)
			if(!isSelected[i] && !isSelected[j])
				sum+=synergy[i][j]+synergy[j][i];
		return sum;
	}
	
	public static void teamSelect(int playerNum) {
		if (playerNum == 0) {
			int teamValue1=teamValue1();
			int teamValue2=teamValue2();
			int currentValue = Math.abs(teamValue1 - teamValue2);
			if (currentValue < min)
				min = currentValue;
			return;
		} else {
			for(int i=0; i<playerNum; i++)
				if(!isSelected[i]) {
					isSelected[i]=true;
					teamSelect(playerNum-2);
					isSelected[i]=false;
				}
		}
		return;	
		// StringBuffer
	}
		

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		Num = Integer.parseInt(br.readLine());
		synergy = new int[Num][Num];
		isSelected =new boolean[Num];

		for (int i = 0; i < Num; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < Num; j++)
				synergy[i][j] = Integer.parseInt(st.nextToken());
		}
		
		min = Integer.MAX_VALUE;
		Problem14889.teamSelect(Num);

		for (int[] arr : synergy) {
			for (int j : arr)
				System.out.print(j + " ");
			System.out.println();
		}
		System.out.println(min);
	}

}
