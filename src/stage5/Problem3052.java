package stage5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem3052 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str;
		int[] list = new int[42];
		for (int i = 0; i < 42; i++)
			list[i] = 0;

		int diffNum = 0;
		int num;
		while ((str = br.readLine()) != "" && str != "\n" && str != null) {
			num = Integer.parseInt(str);
			if (list[(num % 42)] == 0)
				diffNum++;
			list[(num % 42)]++;
		}
		br.close();

		System.out.println(diffNum);

	}

}
