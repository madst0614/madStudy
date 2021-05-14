package stageA20;

// 출처 : https://hoho325.tistory.com/153
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Problem6549 {
	static long[] rect;

	private static long solution(int start, int end) {
		if (start == end) {
			return rect[start];
		}

		int mid = (start + end) / 2;
		long ret = Math.max(solution(start, mid), solution(mid + 1, end));

		int left = mid;
		int right = mid + 1;

		long height = Math.min(rect[left], rect[right]);
		ret = Math.max(ret, height * 2);

		while (left > start || right < end) {
			if (left > start && right < end) {
				if (rect[left - 1] < rect[right + 1])
					height = Math.min(height, rect[++right]);
				else
					height = Math.min(height, rect[--left]);
			}

			else if (left > start)
				height = Math.min(height, rect[--left]);

			else if (right < end)
				height = Math.min(height, rect[++right]);

			ret = Math.max(ret, height * (right - left + 1));
		}
		return ret;
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		while (true) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			if (N == 0)
				break;

			rect = new long[N];
			for (int i = 0; i < N; i++)
				rect[i] = Long.parseLong(st.nextToken());

			bw.write(solution(0, N - 1) + "\n");

		}

		br.close();
		bw.flush();
		bw.close();
	}

}
