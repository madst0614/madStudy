package stageA10;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Scanner;

// 전체적인 알고리즘 개요

// 입력 값 NxN을 f(N/3)->f(N/9)-> ... f(3) 호출해가면서 각각의 단계에서 9개의 분할된 영역, i=0, j=0부터 i=2, j=2까지 f(3)으로 채워나가는 방법을 사용하였다.

// i, j는 영역 ij, 즉 (영역 00, 영역 01, 영역 02, 영역 10, ... , 영역 22) 9개의 영역을 의미하며, x[base] + i*(N/3)[offset] 방식으로 채워나갔다

// 예를 들어, f(81, 0, 0 , starLight)는 f(27, 0, 0+0*27, starLight), f(27, 27,0+1*27, starLight), f(27, 54,0+2*27, starLight)를 호출한다.

// 즉 함수 N=81은 0~26, 27~53, 54~80 3개의 영역으로 나눠지고, 호출된 함수 N=27에서도 재귀적으로 0~8, 9~17, 18~26 / 27~35, 36~44, 45~53 / 54~62, 63~71, 72~80

// 3개의 영역으로 나눠진다. 이는 함수 N=3이 호출돼어 각 자리가 채워지고 return되기 전까지 재귀적으로 반복된다. 

// 빈자리 채우는 것은 미리 함수에 " "를 모두 채워넣고 continue로 별자리 채우는 것을 스킵하는 방식으로 해결하였다.

public class Problem2447 {
	public static void star(int N, int x, int y, char[][] starLight) throws IOException {
		if (N == 3) { // 최소 재귀 단위
			for (int i = 0; i < 3; i++) {
				for (int j = 0; j < 3; j++) {
					if (i != 1 || j != 1)
						starLight[x + i][y + j] = '*';
					else
						starLight[x + i][y + j] = ' ';
				}
			}
			return;
		}

		else {
			for (int i = 0; i < 3; i++)
				for (int j = 0; j < 3; j++) {
					if (i == 1 && j == 1)
						continue;
					else
						star(N / 3, x + i * (N / 3), y + j * (N / 3), starLight);
				}
		}
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		sc.close();

		char[][] starLight = new char[N][N];
		for (int i = 0; i < starLight.length; i++) {
			Arrays.fill(starLight[i], ' ');
		}
		Problem2447.star(N, 0, 0, starLight);
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++)
				bw.write(starLight[i][j]);
			bw.write("\n");
		}

		bw.flush();
		bw.close();

	}

}
