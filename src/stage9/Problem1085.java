package stage9;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem1085 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int x, y, w, h;

		x = Integer.parseInt(st.nextToken());
		y = Integer.parseInt(st.nextToken());
		w = Integer.parseInt(st.nextToken());
		h = Integer.parseInt(st.nextToken());

		if (x <= (w / 2) && y <= (h / 2)) {
			if (x < y)
				System.out.println(x);
			else
				System.out.println(y);
		} else if (x > (w / 2) && y <= (h / 2)) {
			if ((w - x) < y)
				System.out.println(w - x);
			else
				System.out.println(y);
		} else if (x <= (w / 2) && y > (h / 2)) {
			if (x < (h - y))
				System.out.println(x);
			else
				System.out.println(h - y);
		} else {
			if ((w - x) < (h - y))
				System.out.println(w - x);
			else
				System.out.println(h - y);
		}

	}
}
