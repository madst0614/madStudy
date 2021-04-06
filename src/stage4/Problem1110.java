package stage4;

import java.util.Scanner;

public class Problem1110 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		sc.close();
		int a = n;
		int b = n;
		int i = 0;

		do {
			a = b;
			if (b < 10)
				b = b * 10 + b;
			else {
				b = (a / 10) + (a % 10);
				b = (a % 10) * 10 + (b % 10);
			}
			i++;
		} while (b != n);
		System.out.println(i);
	}

}
