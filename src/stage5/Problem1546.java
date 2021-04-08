package stage5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem1546 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int n=Integer.parseInt(br.readLine()); // 시험 과목의 개수
		st=new StringTokenizer(br.readLine(), " ");
		
		int max=0; // 점수의 최댓값 저장
		int num; // st의 nextToken()을 담기 위한 임시 변수
		int tot=0; // 원래 점수의 총합
		for(int i=0; i<n; i++)
		{
			num=Integer.parseInt(st.nextToken());
			if(num>max)
				max=num;
			tot+=(double)num;
		}
		br.close();
		/* 나눗셈 연산을 최소화하기 위하여 변수와 상수들을 묶어서 계산
		 * 조작한 점수의 총합 = (점수1/max)*100+(점수2/max)*100+...+(점수n/max)*100
		 *               = (원래 점수의 총합)*(1/max)*100 =(tot)*(1/max)*100
		 * 
		 * 평균 = (점수의 총합)/(n)이므로 
		 * 
		 * 조작한 점수의 평균 = (tot)*(1/max)*100*(1/n) <=여기서 나눗셈 연산과 곱셉연산을 묶는다
		 * 				 = (tot*100)/(max*n)
		 */
		tot*=100;
		max=n*max;
		
		System.out.println((double)tot/max); // 오차를 줄이기 위해 실수 표현 범위가 넓은 double 자료형 사용
	
	}

}
