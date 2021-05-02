package stageA18;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Problem17298 {
	static int[] num;

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N=Integer.parseInt(br.readLine());
		num =new int[N];
		Stack<Integer> s=new Stack<>();
		
		st=new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			num[i]=Integer.parseInt(st.nextToken());
			if(i!=0)
				if(num[i-1]<num[i])
					s.push(num[i]);
				else 
					s.push(0);
		}
	}

}
