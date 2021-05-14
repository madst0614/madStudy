package stageA20;

// 출처 : https://steady-coding.tistory.com/215
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Problem2261 {
	static ArrayList<Point> point = new ArrayList<Point>();

	static class Point {
		int x, y;

		Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	private static int getD(Point a, Point b) {
		return (int) (Math.pow(a.x - b.x, 2) + Math.pow(a.y - b.y, 2));
	}

	private static int bruteForce(int left, int right) {
		int min = Integer.MAX_VALUE;
		for (int i = left; i < right; i++) {
			for (int j = i + 1; j <= right; j++) {
				min = Math.min(min, getD(point.get(i), point.get(j)));
			}
		}
		return min;
	}

	private static int solution(int left, int right) {
		int n = right - left + 1;

		if (n <= 3) {
			return bruteForce(left, right);
		}

		int mid = (left + right) / 2;

		// dLmin, dRmin
		int dLmin = solution(left, mid);
		int dRmin = solution(mid + 1, right);
		int min = Math.min(dLmin, dRmin);

		// dLRmin
		ArrayList<Point> band = new ArrayList<Point>();
		for (int i = left; i <= right; i++) {
			int t = point.get(mid).x - point.get(i).x;
			if (t * t < min) {
				band.add(point.get(i));
			}
		}
		Collections.sort(band, (p1, p2) -> p1.y - p2.y);

		for (int i = 0; i < band.size() - 1; i++) {
			for (int j = i + 1; j < band.size(); j++) {
				int t = band.get(j).y - band.get(i).y;
				if (t * t < min)
					min = Math.min(min, getD(band.get(i), band.get(j)));
				else
					break;
			}
		}

		return min;
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());

			point.add(new Point(x, y));
		}

		Collections.sort(point, (p1, p2) -> p1.x - p2.x);
		System.out.println(solution(0, N - 1));
	}

}
