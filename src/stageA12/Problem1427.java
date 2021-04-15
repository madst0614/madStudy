package stageA12;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Problem1427 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		char[] array = br.readLine().toCharArray();
		br.close();

		Arrays.sort(array);
		for (int i = array.length - 1; i >= 0; i--)
			bw.write(array[i]);
		bw.flush();
		bw.close();
	}

}
