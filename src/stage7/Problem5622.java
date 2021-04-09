package stage7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem5622 {

	// 알파벳-To-넘버
	// 숫자당 알파벳 세개씩 할당된다는 점을 이용하여 나눗셈의 몫 연산을 통해 재할당하였다(!예외처리 7:PQRS / 8:TUV / 9:WXYZ)
	public static void alphToNum(StringBuilder str) {
		for (int i = str.length() - 1; i >= 0; i--) {

			int num = str.charAt(i) - 'A';
			if (num < 18)
				num = (num / 3) + 2;
			else if (num > 21)
				num = 9;
			if (num == 18)
				num = 7;
			if (num > 18 && num < 22)
				num = 8;
			str.setCharAt(i, (char) (num + 48));

		}
	}

	// 최소 시간
	// : Mintime에 각 자리 숫자 + 1(초)을 더한다
	public static int minTime(StringBuilder str) {
		int minTime = 0;
		for (int i = 0; i < str.length(); i++) {
			minTime += (str.charAt(i) - 48) + 1;
		}
		return minTime;
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder str = new StringBuilder(br.readLine());
		br.close();

		Problem5622.alphToNum(str);
		System.out.println(str);
		System.out.println(Problem5622.minTime(str));

	}

}
