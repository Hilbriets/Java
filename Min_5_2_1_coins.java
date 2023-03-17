package Code_java;
import java.util.Scanner;
public class Min_5_2_1_coins 
{
	public static void main(String[] args)
	{
		Scanner s=new Scanner(System.in);
		int N=s.nextInt();
		int five=(N-4)/5,one=0,two=0;
		if(N+9%2==0)
			one=2;
		else
			one=1;
		two=(N-(5*five)-one)/2;
		System.out.println(five+one+two+" Five: "+five+" One:"+one+" Two:"+two);
	}
}
