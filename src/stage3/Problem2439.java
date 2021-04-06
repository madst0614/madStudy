package stage3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Problem2439 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(br.readLine());
		br.close();

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < (n-1)-i; j++) // i가 n-1까지만 동작
				bw.write(" ");
			for(int j=0; j<=i; j++)
				bw.write("*");
			bw.write("\n");
		}
		bw.flush();
		bw.close();

	}

}
