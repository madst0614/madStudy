package stage8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem1712 {

	public static int breakEvenPoint(int fixedCost, int variableCost, int price) {
		int salesPoint;
		int profit = price - variableCost; // 한대당 수익(고정 지출 제외)
		if (profit <= 0)
			return -1;
		else
			salesPoint = (fixedCost / profit) + 1;
		return salesPoint;
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		br.close();

		int fixedCost = Integer.parseInt(st.nextToken());
		int variableCost = Integer.parseInt(st.nextToken());
		int price = Integer.parseInt(st.nextToken());

		int breakEP = Problem1712.breakEvenPoint(fixedCost, variableCost, price);
		System.out.println(breakEP);
	}

}
