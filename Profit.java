package Code_java;
import java.util.Scanner;
public class Profit {

	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		int n=s.nextInt();
		int ar[]=new int[n];
		ar[n-1]=s.nextInt();
		int percent=s.nextInt();
		for(int i=n-1;i>0;i--)
		{
			ar[i-1]=(ar[i]*(percent));
			ar[i-1]=ar[i-1]/100;
			System.out.print(ar[i]+" ");
		}
		System.out.print(ar[0]);
	}

}
