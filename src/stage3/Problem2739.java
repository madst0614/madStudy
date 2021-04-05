package stage3;
import java.util.Scanner;

public class Problem2739 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int n;
		
		n=sc.nextInt();
		for(int i=0; i<9; i++)
			System.out.println(n+" * "+ (i+1) +" = "+(n*(i+1)));
	}

}
