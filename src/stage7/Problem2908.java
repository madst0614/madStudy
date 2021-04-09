package stage7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem2908 {
	
	public static int reverseNumber(String str)
	{
		int count=1;
		int reverseNum=0;
		for(int i=0; i<str.length(); i++)
		{
			reverseNum+=(str.charAt(i)-48)*count;
			count*=10;
		}
		return reverseNum;
	}
	
	public static void compareNum(int a, int b)
	{
		if(a>=b)
			System.out.println(a);
		else
			System.out.println(b);
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine(), " ");
		
		int a=Problem2908.reverseNumber(st.nextToken());
		int b=Problem2908.reverseNumber(st.nextToken());
		
		compareNum(a,b);
	}

}
