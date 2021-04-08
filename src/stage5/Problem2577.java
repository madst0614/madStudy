package stage5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem2577 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str;
		int[] list=new int[10];
		for(int i=0; i<9; i++)
			list[i]=0;
		
		int mul=1;
		while( (str=br.readLine()) != "" && str!="\n" && str!=null)
		{
			mul*=Integer.parseInt(str);
		}
		br.close();
		
		while(mul!=0)
		{
			list[(mul%10)]++;
			mul=mul/10;
		}
		for(int i=0; i<10; i++)
			System.out.println(list[i]);
	
	}

}
