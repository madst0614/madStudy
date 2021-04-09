package stage7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem2941 {

	public static int countCroatian(String str) {
		int count = 0;
		for (int i = 0; i < str.length(); i++) {
			if ((str.charAt(i) == '-') || (i < (str.length() - 1) && (str.charAt(i) == 'l' && str.charAt(i + 1) == 'j'))
					|| (i < (str.length() - 1) && (str.charAt(i) == 'n' && str.charAt(i + 1) == 'j')))
				count--;
			if (str.charAt(i) == '=') {
				if (i >= 2 && (str.charAt(i - 1) == 'z') && (str.charAt(i - 2) == 'd'))
					count--;
				count--;
			}

			count++;
		}

		return count;
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();

		int count = Problem2941.countCroatian(str);
		System.out.println(count);

	}

}
