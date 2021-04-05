package stage2;
import java.util.Scanner;

public class Problem14681 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int x,y;
		
		x=sc.nextInt();
		y=sc.nextInt();
		sc.close();
		if(x>0 && y>0)
			System.out.println("1");
		else if(x<0 && y>0)
			System.out.println("2");
		else if(x<0 && y<0)
			System.out.println("3");
		else
			System.out.println("4");
	}

}
