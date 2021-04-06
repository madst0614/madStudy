package stage3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Problem10871 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st=new StringTokenizer(br.readLine());
		
		int n=Integer.parseInt(st.nextToken());
		int x=Integer.parseInt(st.nextToken());
		
		st=new StringTokenizer(br.readLine());
		
		int a=0;
		for(int i=0; i<n; i++) {
			a=Integer.parseInt(st.nextToken());
			if(a<x)
				bw.write(a+" ");
		}
		br.close();
		bw.flush();
		bw.close();
		
	}

}
