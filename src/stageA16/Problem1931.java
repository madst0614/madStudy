package stageA16;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Arrays;
import java.util.Comparator;

public class Problem1931 {
	static int[][] meeting;

	private static int bookedMeeting() {
		int count = 0;
		int prev = -1;
		for (int i = 0; i < meeting.length; i++) {
			if (meeting[i][1] != -1) {
				if (prev == -1) {
					prev = i;
					count++;
					continue;
				}

				if (meeting[i][1] < meeting[prev][1]) {
					prev = i;
				} else if (meeting[prev][1] <= meeting[i][0]) {
					prev = i;
					count++;
				}
			}
		}
		return count;
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());
		meeting = new int[N][2];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());

			meeting[i][0] = Integer.parseInt(st.nextToken());
			meeting[i][1] = Integer.parseInt(st.nextToken());
		}
		// 정렬
		Arrays.sort(meeting, new Comparator<int[]>() {
			@Override
			public int compare(int[] meet1, int[] meet2) {
				if (meet1[0] > meet2[0])
					return 1;
				else if (meet1[0] == meet2[0])
					if (meet1[1] > meet2[1])
						return 1;
					else
						return -1;
				else
					return -1;
			}
		});
		System.out.println(bookedMeeting());
	}

}
