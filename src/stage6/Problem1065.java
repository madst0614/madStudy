package stage6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem1065 {
	
	public static void findNum() throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		int n=Integer.parseInt(br.readLine());
		br.close();
		int count=0;
	
		for(int i=1; i<=n; i++) {
			// Initialization
			int num=i/10;
			int preNum=i%10;
			int preDiff=(num%10)-preNum;
			
			while( ((num%10)-preNum)==preDiff) {	// (현재 차이 == 이전 차이)인가?
				if( (num/10)==0 ) {					// 최상위 숫자에 도달하면 이전까지 각 자리 숫자가 등차 수열이므로 count++
					count++;
					break;
				}
				preDiff=(num%10)-preNum;			// 현재 차이 저장
				preNum=num%10;						// 현재 자릿수 저장
				num=num/10;							// (num%10)이 다음 자릿수를 가리키게 오른쪽 shift 한자리(10진수이므로(num/10)= num을 10으로 나눈 몫)
			}
		}
		System.out.println(count);
		
		
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Problem1065.findNum();
	}

}
