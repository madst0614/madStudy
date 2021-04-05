package stage3;
import java.util.Scanner;

public class Problem8393 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	int n;
	int sum = 0;
	Scanner sc=new Scanner(System.in);
	
	n=sc.nextInt();
	sc.close();
	
	for(int i=0; i<=n; i++)
		sum+=i;
	System.out.println(sum);
	
	
	}

}
