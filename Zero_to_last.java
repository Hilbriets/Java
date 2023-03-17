package Code_java;
import java.util.Scanner;
public class Zero_to_last {

	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		int n=s.nextInt();
		int a[]=new int[n];
		int b[]=new int[n];
		int j=0;
		for(int i=0;i<n;i++)
		{
			a[i]=s.nextInt();
			if(a[i]!=0)
			{
				b[j]=a[i];
				j++;
			}
		}
		while(j<5)
		{
			b[j]=0;
			j++;
		}
		for(int i:b)
			System.out.println(i);
	}

}
