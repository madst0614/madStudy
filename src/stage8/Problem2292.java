package stage8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem2292 {
	
	public static int findBelt(int N)
	{
		int belt=1;
		int beltLeastNum=3*(belt)*(belt-1)+2;
		if(N==1)
			return 1;
		while(beltLeastNum<=N) {
			belt++;
			beltLeastNum=3*(belt)*(belt-1)+2;
		}
			
		return belt;
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int N=Integer.parseInt(br.readLine());
		br.close();
		
		System.out.println(Problem2292.findBelt(N));
	}

}
