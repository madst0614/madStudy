package stage8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem1193 {

	public static void findFraction(int N) {
		int belt=1;
		int beltSum=((belt+1)*(belt))/2;
		int beltPosition=1;
		
		int fractionSum=0;
		while(beltSum<N) {
			belt++;
			beltSum=((belt+1)*(belt))/2;
		}
		fractionSum+=(belt+1);
		beltPosition=N-(beltSum-belt);

		if((belt%2)==0)
			System.out.println(beltPosition+"/"+(fractionSum-beltPosition));
		else
			System.out.println((fractionSum-beltPosition)+"/"+beltPosition);
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		int N=Integer.parseInt(br.readLine());
		br.close();
		
		Problem1193.findFraction(N);
	}

}
