package stage7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem10809 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();

		int[] charAt = new int[26];
		for (int i = 0; i < charAt.length; i++)
			charAt[i] = -1;

		for (int i = 0; i < str.length(); i++) {
			int index = str.charAt(i) - 'a';
			if (charAt[index] == -1)
				charAt[index] = i;
		}
		for (int i = 0; i < charAt.length; i++)
			System.out.print(charAt[i] + " ");
	}

}
