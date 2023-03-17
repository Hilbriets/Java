package heei;
import java.util.Scanner;
import java.util.Arrays;
public class code_5 {

	public static void main(String[] args) 
	{
		Scanner s=new Scanner(System.in);
		String str=s.nextLine();
		int count=0;
		str=str.replace(";","");
		String sr[]=str.split(" ");
		int prime[]=new int[0];
		boolean result=true;
		for(int i=0;i<sr.length;i++)
		{
			result=primeres(Integer.parseInt(sr[i]));
		if(result==true)
		{ 
			prime=Arrays.copyOf(prime,prime.length+1);
			prime[prime.length-1]=Integer.parseInt(sr[i]);	
			count++;
		}
		}
		Arrays.sort(prime);
		System.out.println(count+prime[prime.length-2]);
		
	}
	public static boolean primeres(int a)
	{
		if(a<=1)
			return false;
		
		for(int i=2;i<(a/2);i++)
		{
			if(a%i==0)
				return false;
		}
		return true;
	}
}