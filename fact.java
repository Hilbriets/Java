package heei;
import java.util.Scanner;

public class fact {

	public static void main(String[] args) 
	{
		Scanner s=new Scanner(System.in);
		int arr[]=new int[5];
		for(int i=0;i<5;i++)
		{
			arr[i]=s.nextInt();
		}
		for(int i=0;i<5;i++)
		{
			int fact=1;
			while(arr[i]>0)
			{
				fact=fact*arr[i];
				arr[i]=arr[i]-1;
			}
			System.out.println(fact);
		}
	}

}
