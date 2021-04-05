package stage2;

import java.util.Scanner;

public class Problem2884 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int hour, min;

		hour = sc.nextInt();
		min = sc.nextInt();
		sc.close();

		min = hour * 60 + min - 45;
		if (min < 0) {
			min += 1440;
			hour = min / 60;
			min %= 60;
		} else {
			hour = min / 60;
			min %= 60;
		}
		System.out.printf("%d %d \n", hour, min);
	}

}
