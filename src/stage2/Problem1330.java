package stage2;
import java.util.Scanner;

public class Problem1330 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int a,b;
		
		while(sc.hasNextInt())

		{
		a=sc.nextInt();
		b=sc.nextInt();
		
		if(a<b)
			System.out.println("<");
		else if(a==b)
			System.out.println("==");
		else
			System.out.println(">");
		}
	}
}
