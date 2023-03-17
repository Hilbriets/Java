package Code_java;
import java.util.Scanner;
public class Keyword_variable {

	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		int x=s.nextInt();
		int y=s.nextInt();
		int len=Integer.toString(y).length();
		for(int i=x;i<=y;i++)
		{
			String str=Integer.toString(i);
			while(str.length()<len)
			{
				str="0"+str;
			}
			System.out.println(str);
		}
		

	}

}
