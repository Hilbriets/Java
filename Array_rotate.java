package Code_java;
import java.util.Scanner;
public class Array_rotate {

	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		int n=s.nextInt();
		int arr[]=new int[n];
		int ans[]=new int[n];
		for(int i=0;i<n;i++)
			arr[i]=s.nextInt();
		int k=s.nextInt(),temp=0;
		k=k%n;
		for(int i=0;i<n;i++)
		{
			if(k+i<n)
				ans[k+i]=arr[i];
			else
			{
				ans[temp]=arr[i];
				temp++;	
			}	
		}
		for(int i:ans)
			System.out.println(i);
	}

}
