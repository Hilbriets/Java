package Code_java;
import java.util.Scanner;
public class Number_replace {

	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		int N=s.nextInt();
		int ans=0,i=0;
		while(N>0)
		{
			int temp=N%10;
			temp=9-temp;
			ans+=Math.pow(10,i)*temp;
			i++;
			N=N/10;
		}
		System.out.println(ans);

	}

}
