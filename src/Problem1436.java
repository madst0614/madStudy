import java.util.Scanner;

public class Problem1436 {
	public static void shomFilm(int N) {

		int count = 0;
		int i = 0;
		int j = 1;
		int shomNum = 0;
		while (count != N) {
			j = i;
			do {
				if ((j - 666) % 1000 == 0) {
					count++;
					if (count == N) {
						shomNum = i;
						break;
					}
					break;
				} else
					j /= 10;

			} while ((j / 100) != 0);
			i++;
		}
		System.out.println(shomNum);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		sc.close();

		Problem1436.shomFilm(N);

	}

}
