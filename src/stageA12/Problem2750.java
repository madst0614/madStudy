package stageA12;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Problem2750 {

	static int[] list;

	public static void insertionSort() {
		int key;
		int i, j;

		for (i = 1; i < list.length; i++) {
			key = list[i];
			for (j = i - 1; j > -1 && key < list[j]; j--) {
				list[j + 1] = list[j];
			}
			list[j + 1] = key;
		}
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());
		list = new int[N];
		for (int i = 0; i < N; i++) {
			list[i] = Integer.parseInt(br.readLine());
		}
		br.close();
		Problem2750.insertionSort();
		for (int i = 0; i < list.length; i++) {
			bw.write(list[i] + "\n");
		}
		bw.flush();
		bw.close();

	}

}
