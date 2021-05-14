package stageA21;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Problem10816 {
	static int[] num;

	private static int solution(int M) {

		int start = 0;
		int end = num.length - 1;

		int mid = (start + end) / 2;
		int count = 0;

		while (true) {

			if (num[mid] == M) {
				int tempStart = start;
				int tempEnd = end;
				int tempMid = mid;

				while (true) {
					if (num[tempStart] == M) {
						if (tempMid != mid)
							count += tempMid - tempStart + 1;
						else
							count += tempMid - tempStart;

						if (tempStart == start)
							break;

						tempMid = tempStart - 1;
						tempStart = start;

					}

					if (tempMid - tempStart <= 1) {
						if (tempMid != mid && num[tempMid] == M)
							count++;
						break;
					}

					tempStart = (tempStart + tempMid) / 2;
				}

				tempMid = mid;
				while (true) {
					if (num[tempEnd] == M) {
						if (tempMid != mid)
							count += tempEnd - tempMid + 1;
						else
							count += tempEnd - tempMid;
						if (tempEnd == end)
							break;

						tempMid = tempEnd + 1;
						tempEnd = end;

					}

					if (tempEnd - tempMid <= 1) {
						if (tempMid != mid && num[tempMid] == M)
							count++;
						break;
					}
					tempEnd = (tempEnd + tempMid) / 2;
				}

				count++;
				break;
			}

			if (end - start <= 1) {
				for (int i = start; i <= end; i++)
					if (num[i] == M)
						count++;

				break;
			}

			if (num[mid] < M)
				start = mid;
			else
				end = mid;

			mid = (start + end) / 2;
		}
		return count;

	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());
		num = new int[N];
		st = new StringTokenizer(br.readLine());

		for (int i = 0; i < N; i++)
			num[i] = Integer.parseInt(st.nextToken());

		Arrays.sort(num);

		int M = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());

		for (int i = 0; i < M; i++)
			bw.write(solution(Integer.parseInt(st.nextToken())) + " ");

		br.close();
		bw.flush();
		bw.close();
	}

}
