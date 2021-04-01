package stage1;
import java.util.Scanner;
import java.math.BigDecimal;

public class Problem1008 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner keyboard =new Scanner(System.in);
		int a,b;
		a=keyboard.nextInt();
		b=keyboard.nextInt();
		
		BigDecimal number1=new BigDecimal(a);
		BigDecimal number2=new BigDecimal(b);
		
		System.out.println(number1.divide(number2, 10, BigDecimal.ROUND_HALF_DOWN));
	}

}
