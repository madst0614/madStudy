package stage6;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class Problem4673 {

	// Boolean[] isNotSelf
	// : 다음 수가 SelfNumber인지 아닌지 판별
	// !편의상 + (+) 연산 줄일 겸 인덱스 0은 제외하고 1~10000까지의 인덱스만 사용
	static boolean[] isNotSelf = new boolean[10001];

	// Initialization
	// : isNotSelf 배열을 false로 초기화
	static void initProblem() {
		for (int i = 0; i <= 10000; i++)
			isNotSelf[i] = false;
	}

	// dFunction
	// : d(x)의 값을 리턴, x는 d(x)의 생성자
	public static int dFunc(int n) {
		int dNum = n;
		while (n > 0) {
			dNum += (n % 10);
			n /= 10;
		}
		return dNum;
	}

	// FindChild
	// : d(x)의 값을 재귀적으로 호출하여 x의 자식,
	// 즉 셀프 넘버가 아닌 숫자들을 boolean 배열 isNotSelf에 기록
	public static void findChild(int n) {
		if (n > 10000)
			return;
		else if (isNotSelf[n] == true)
			return;
		else {
			isNotSelf[n] = true;
			findChild(dFunc(n));
		}
	}

	// FindSelfNumber
	// : 반복문을 활용하여 1부터 10000까지 셀프 넘버들을 BufferedWriter bw에 저장한 후 flush(화면상 출력)
	public static void findSelfNum() throws IOException {
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		for (int i = 1; i <= 10000; i++) {
			if (isNotSelf[i] == false)
				bw.write(i + "\n");
			findChild(i);
		}
		bw.flush();
		bw.close();
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		Problem4673.initProblem();
		Problem4673.findSelfNum();

	}

}
