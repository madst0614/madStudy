package stageA12;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Problem2751 {

	static int[] list;

	public static void merge(int left, int mid, int right) {
		int leftIndex = left;
		int rightIndex = mid + 1;
		int[] temp = new int[right - left + 1];
		int i = 0;
		while (leftIndex <= mid && rightIndex <= right) {
			if (list[leftIndex] < list[rightIndex])
				temp[i++] = list[leftIndex++];
			else
				temp[i++] = list[rightIndex++];
		}
		for (; leftIndex <= mid; leftIndex++) {
			temp[i++] = list[leftIndex];
		}
		for (; rightIndex <= right; rightIndex++) {
			temp[i++] = list[rightIndex];
		}
		for (i = 0; i < temp.length; i++) {
			list[i + left] = temp[i];
		}
	}

	public static void mergeSort(int left, int right) {
		int mid = (left + right) / 2;

		if (left == right || mid == right)
			return;

		mergeSort(left, mid);
		mergeSort(mid + 1, right);
		merge(left, mid, right);

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

		Problem2751.mergeSort(0, N - 1);
		for (int i = 0; i < list.length; i++) {
			bw.write(list[i] + "\n");
		}
		bw.flush();
		bw.close();
	}

}
