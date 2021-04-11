package stage9;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem3009 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int[] list = new int[6];

		for (int i = 0; i < (list.length / 2); i++) {
			st = new StringTokenizer(br.readLine());
			list[(2 * i)] = Integer.parseInt(st.nextToken());
			list[(2 * i) + 1] = Integer.parseInt(st.nextToken());
		}
		if (list[0] == list[2])
			System.out.print(list[4] + " ");
		else {
			if (list[0] == list[4])
				System.out.print(list[2] + " ");
			else
				System.out.print(list[0] + " ");
		}

		if (list[1] == list[3])
			System.out.println(list[5]);
		else {
			if (list[1] == list[5])
				System.out.println(list[3]);
			else
				System.out.println(list[1]);
		}
	}

}
