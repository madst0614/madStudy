package stageA12;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

class Coordinate2 implements Comparable<Coordinate2> {
	int x, y;

	public Coordinate2(int x, int y) {
		this.x = x;
		this.y = y;
	}

	@Override
	public int compareTo(Coordinate2 c) {
		if (this.x > c.x) {
			return 1;
		} else if (this.x == c.x) {
			if (this.y > c.y) {
				return 1;
			}
		}
		return -1;
	}
}

class YComparator implements Comparator<Coordinate2> {
	@Override
	public int compare(Coordinate2 c1, Coordinate2 c2) {
		if (c1.y > c2.y)
			return 1;
		else if (c1.y == c2.y) {
			if (c1.x > c2.x)
				return 1;
		}
		return -1;
	}
}

public class Problem11651 {

	static Coordinate2[] set;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		YComparator yCom = new YComparator();

		int N = Integer.parseInt(br.readLine());
		set = new Coordinate2[N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			set[i] = new Coordinate2(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}
		br.close();

		Arrays.sort(set, yCom);
		for (int i = 0; i < N; i++) {
			bw.write(set[i].x + " " + set[i].y + "\n");
		}
		bw.flush();
		bw.close();
	}
}
