package heei;
import java.util.Scanner;
public class code_4 {

	public static void main(String[] args) 
	{
		Scanner s=new Scanner(System.in);
		String str=s.nextLine();
		for(int i=0;i<str.length();i++)
		{
			if(i%2!=0)
			{
				System.out.print(str.charAt(i));
			}
		}
	}

}
