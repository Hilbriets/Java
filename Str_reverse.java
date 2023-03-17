package heei;
import java.util.Scanner;
public class Str_reverse 
{

	public static void main(String[] args) 
	{
		Scanner s=new Scanner(System.in);
		String str=s.nextLine();
		String sd[]=str.split("");
		String aa="";
		for(int i=sd.length-1;i>=0;i--)
			aa=aa+sd[i];
		if(aa.equals(str))
		{
			System.out.println("Palindrome");
		}
		else
			System.out.print("NO");
		
	}

}
