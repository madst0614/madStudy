package stageA12;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Problem10989 {
	static int[] countList;

	public static void countingSort() throws IOException {
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		for (int i = 1; i < countList.length; i++) {
			countList[i] += countList[i - 1];

		}
		for (int i = 1; i < countList.length; i++) {
			int iterNum = countList[i] - countList[i - 1];
			if (iterNum != 0)
				for (int j = 0; j < iterNum; j++) {
					bw.write(i + "\n");
				}
		}

		bw.flush();
		bw.close();
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		int maxNum = 10001;
		countList = new int[maxNum];

		// 입력받을때 countList 계산
		for (int i = 0; i < N; i++) {
			countList[Integer.parseInt(br.readLine())]++;
		}
		br.close();
		Problem10989.countingSort();
	}

}
