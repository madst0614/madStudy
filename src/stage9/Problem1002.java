package stage9;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

class Turret {
	double x, y, r;

	Turret(double x, double y, double r) {
		this.x = x;
		this.y = y;
		this.r = r;
	}

	static double squareRootDistance(Turret t1, Turret t2) {
		double distance = Math.sqrt(Math.pow(t1.x - t2.x, 2) + Math.pow(t1.y - t2.y, 2));
		return distance;
	}

	static double Location(Turret t1, Turret t2) {
		double location = t1.r + t2.r;
		return location;
	}
}

public class Problem1002 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());
		for (int i = 0; i < T; i++) {
			st = new StringTokenizer(br.readLine());
			Turret t1 = new Turret(Double.parseDouble(st.nextToken()), Double.parseDouble(st.nextToken()),
					Double.parseDouble(st.nextToken()));
			Turret t2 = new Turret(Double.parseDouble(st.nextToken()), Double.parseDouble(st.nextToken()),
					Double.parseDouble(st.nextToken()));

			if (t1.r < t2.r) {
				Turret tmp = t2;
				t2 = t1;
				t1 = tmp;
			}

			double distance = Turret.squareRootDistance(t1, t2);
			double loc = Turret.Location(t1, t2);

			if ((distance + t2.r) > t1.r) {
				if (distance < loc)
					bw.write(2 + "\n");
				else if (distance == loc)
					bw.write(1 + "\n");
				else
					bw.write(0 + "\n");

			} else {
				if (t1.x != t2.x || t1.y != t2.y) {
					if ((distance + t2.r) == t1.r) {
						bw.write(1 + "\n");
					} else {
						bw.write(0 + "\n");
					}
				} else {
					if (t1.r != t2.r)
						bw.write(0 + "\n");
					else
						bw.write(-1 + "\n");
				}
			}
		}
		br.close();
		bw.flush();
		bw.close();
	}

}
