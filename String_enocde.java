package Code_java;
import java.util.Scanner;
public class String_enocde {

	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		String str=s.nextLine();
		String str1="";
		for(int i=0;i<str.length();i++)
		{
			int x=str.charAt(i);
			if(x>=97 && x<=117)
				x+=5;
			else
				x-=21;
			str1+=(char)x;
		}
		System.out.println(str1);
	}

}
