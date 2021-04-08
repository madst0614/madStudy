package stage5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem10818 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int n = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine(), " ");
		br.close();

		int min = 1000001;
		int max = -1000001;
		int a;
		for (int i = 0; i < n; i++) {
			a = Integer.parseInt(st.nextToken());
			if (a < min)
				min = a;
			if (a > max)
				max = a;
		}

		System.out.println(min + " " + max);
	}

}
