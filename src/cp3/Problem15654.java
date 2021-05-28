package cp3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Problem15654 {
	static int[] num;
	static int[] selected;

	private static void solution(int index, BufferedWriter bw) throws IOException {
		if (index == selected.length) {
			for (int i = 0; i < selected.length; i++) {
				bw.write(selected[i] + " ");
			}
			bw.write("\n");
			return;
		}

		for (int i = 0; i < num.length; i++) {
			if (num[i] != 0) {
				selected[index] = num[i];
				num[i] = 0;
				solution(index + 1, bw);
				num[i] = selected[index];
			}
		}
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		num = new int[N];
		selected = new int[M];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < num.length; i++) {
			num[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(num);
		solution(0, bw);

		br.close();
		bw.flush();
		bw.close();
	}

}
