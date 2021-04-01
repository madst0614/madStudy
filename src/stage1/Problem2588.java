package stage1;
import java.util.Scanner;

public class Problem2588 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		
		int a,b;
		a=sc.nextInt();
		b=sc.nextInt();
		sc.close();
		
		System.out.println(a*(b%10));
		System.out.println(a*((b%100-b%10))/10);
		System.out.println(a*(b/100));
		System.out.println(a*b);
	}

}
