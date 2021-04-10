package stage8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem2869 {

	public static void snailClimb(int dayClimb, int nightFall, int height) {
		int effV = dayClimb - nightFall;
		int day;
		if (dayClimb == height)							
			day = 1;
		else if (((height - nightFall) % effV) == 0)	// 마지막 날 낮동안 딱 알맞게 height에 도달할 때
			day = (height - nightFall) / effV;
		else
			day = ((height - nightFall) / effV) + 1;	// 마지막 날 낮동안 여유롭게 height에 도달할 때

		System.out.println(day);
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		br.close();

		int dayClimb = Integer.parseInt(st.nextToken());
		int nightFall = Integer.parseInt(st.nextToken());
		int height = Integer.parseInt(st.nextToken());

		Problem2869.snailClimb(dayClimb, nightFall, height);
	}

}
