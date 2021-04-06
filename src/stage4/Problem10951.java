package stage4;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Problem10951 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		String eof;
		int a, b;

		while( (eof=br.readLine())!=null) {
			st = new StringTokenizer(eof);
			a=Integer.parseInt(st.nextToken());
			b=Integer.parseInt(st.nextToken());
			bw.write(a+b+"\n");
			
		}
		br.close();
		bw.flush();
		bw.close();
	}

}
