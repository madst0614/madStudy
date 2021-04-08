package stage5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem2562 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		
		int[] list=new int[9];

		int max=0;
		for (int i = 0; i < 9; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			list[i] = Integer.parseInt(st.nextToken());
			
			if (list[i] > list[max])
				max = i;
		}
		br.close();
		System.out.printf("%d\n%d", list[max], max+1);
		
	}

}
