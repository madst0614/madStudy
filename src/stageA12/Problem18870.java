package stageA12;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

class XPointer {
	XCoordinate link;

	XPointer(XCoordinate x) {
		link = x;
	}
}

class XCoordinate implements Comparable<XCoordinate> {
	int x;

	XCoordinate(int x) {
		this.x = x;
	}

	@Override
	public int compareTo(XCoordinate x1) {
		if (this.x > x1.x)
			return 1;
		else if (this.x == x1.x)
			return 0;
		else
			return -1;
	}
}

public class Problem18870 {

	static int[] xSet;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());
		XPointer[] pointerSet = new XPointer[N];
		XCoordinate[] xSet = new XCoordinate[N];
		st = new StringTokenizer(br.readLine());
		br.close();
		for (int i = 0; i < N; i++) {
			xSet[i] = new XCoordinate(Integer.parseInt(st.nextToken()));
			pointerSet[i] = new XPointer(xSet[i]);
		}

		Arrays.sort(xSet);

		XCoordinate prevX = new XCoordinate(xSet[0].x);
		xSet[0].x = 0;
		for (int i = 1; i < N; i++) {
			if (xSet[i].x == prevX.x) {
				prevX = new XCoordinate(xSet[i].x);
				xSet[i].x = xSet[i - 1].x;
			} else {
				prevX = new XCoordinate(xSet[i].x);
				xSet[i].x = xSet[i - 1].x + 1;
			}
		}
		for (int i = 0; i < N; i++) {
			bw.write(pointerSet[i].link.x + " ");
		}
		bw.flush();
		bw.close();
	}

}
