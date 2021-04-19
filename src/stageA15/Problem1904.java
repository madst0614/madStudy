package stageA15;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem1904 {
	static int[] storedFact;

	
	
	public static void initFact(int n) {
		for(int i=0; i<2; i++) {
			storedFact[i]=1;
		}
		
		for(int div=n%2+2; div<=n; div+=2) {
			storedFact[div]=(div)*(div-1)*storedFact[div-2];
		}
	}
	
	public static int zeroOneTile(int n) {
		int possibleCase=1;
		int num=n/2;
		while(num!=0) {
			if(n%2==0) {
				possibleCase++;
				num--;
			}else {
				
			}
			
		}
		return possibleCase;
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int maxNum = 1000001;
		storedFact = new int[maxNum];
		int n = Integer.parseInt(br.readLine());
		
		initFact(n);
		System.out.println(zeroOneTile(n) % 15746);
		
	}

}
