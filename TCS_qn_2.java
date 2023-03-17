package heei;
import java.util.Scanner;

public class TCS_qn_2 {

	public static void main(String[] args) 
	{
		Scanner s=new Scanner(System.in);
		String str=s.nextLine();
//		
		String str1[]=str.split("");
		for(int i=0;i<str.length();i++)
		{
			for(int j=i+1;j<str1.length;j++)
			{
				if(str1[i].equals("a")&& str1[j].equals("b"))
				{
					
				}
			}
			
		}
		for(int i=0;i<str1.length;i++)
		{
			System.out.print(str1[i]+" ");
		}	
		
	}
	

}
