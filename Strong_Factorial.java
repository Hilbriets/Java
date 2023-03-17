package Code_java;
import java.util.Scanner;
public class Strong_Factorial {
	public static void main(String[] args)
	{
		Scanner s=new Scanner(System.in);
		int x=s.nextInt();
		int temp=x,sum=0;
		while(temp>0)
		{
			int fact=1;
			int a=temp%10;
			while(a>0)
			{
				fact=fact*a;
				a--;
			}
			temp=temp/10;
			sum=sum+fact;
		}
		if(sum==x)
			System.out.print("Strong");
		else
			System.out.print("Weak");
	}
}
