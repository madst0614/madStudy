package stageA17;

import java.util.Scanner;

public class Problem1676 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		sc.close();

		int answer = 0;
		while (N != 0) {
			answer += N / 5;
			N /= 5;
		}
		System.out.println(answer);
	}

}
