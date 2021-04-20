package stageA15;

import java.util.Scanner;

public class Problem1463 {
	static int[][] DP; // row=two, col=three

	static int findMinOp(int N, int row, int col) {
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		
		int N=sc.nextInt();
		sc.close();
		
		int i=N;
		int n = 0;
		while(i!=0) {
			i/=2;
			n++;
		}
		DP=new int[n][n];
	}

}
