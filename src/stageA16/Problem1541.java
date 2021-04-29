package stageA16;

import java.util.Scanner;

public class Problem1541 {

	private static int findMin(StringBuffer sb) {

		int i = 0;
		int answer = 0;

		while (i < sb.length()) {
			if (sb.charAt(i) == '+' || sb.charAt(i) == '-')
				break;

			answer *= 10;
			answer += sb.charAt(i) - '0';
			i++;
		}
		for (; i < sb.length(); i++) {
			switch (sb.charAt(i)) {
			case '+':
				int num1 = 0;
				while (i < sb.length() - 1) {
					if (sb.charAt(i + 1) == '+' || sb.charAt(i + 1) == '-')
						break;

					num1 *= 10;
					num1 += sb.charAt(i + 1) - '0';
					i++;
				}
				answer += num1;
				break;
			case '-':
				for (; i < sb.length(); i++) {
					int num2 = 0;
					while (i < sb.length() - 1) {
						if (sb.charAt(i + 1) == '+' || sb.charAt(i + 1) == '-')
							break;

						num2 *= 10;
						num2 += sb.charAt(i + 1) - '0';
						i++;
					}
					answer -= num2;
				}
				break;
			}
		}
		return answer;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		StringBuffer sb = new StringBuffer(sc.nextLine());
		sc.close();
		System.out.println(findMin(sb));
	}

}
