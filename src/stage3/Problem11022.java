package stage3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;


public class Problem11022 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		int a=0;
		int b=0;
		int t=Integer.parseInt(br.readLine());
		for(int i=1; i<=t; i++)
		{
			st=new StringTokenizer(br.readLine());
			a=Integer.parseInt(st.nextToken());
			b=Integer.parseInt(st.nextToken());
			bw.write("Case #" + i + ": "+ a + " + "
						+ b + " = " + (a+b) + "\n");
		}
		br.close();
		bw.flush();
		bw.close();
	}

}
