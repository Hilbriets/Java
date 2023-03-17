package Code_java;
import java.util.Scanner;
import java.util.ArrayList;
// to find if the input string has 3 palindromes words
public class Palendrome_find {

	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		String str=s.nextLine();
		String str1="";
		int k=0,g=0;
		ArrayList<String> ar=new ArrayList<String>();
		for(int i=1;i<str.length();i++)
		{
			if(k<2)
			{
				str1=str.substring(g,i+1);
				boolean x=palen_chck(str1);
				if(x==true)
				{
					ar.add(str1);
					str1="";
					k++;
					g=++i;
				}
			}
			else
				str1=str.substring(g,str.length());
		}
		boolean x=palen_chck(str1);
		if(x==true)
		{
			ar.add(str1);
			str1="";
			k++;
		}
		//System.out.println(str1);
		for(int i=0;i<ar.size();i++)
		{
			System.out.println(ar.get(i));
		}

	}
	public static boolean palen_chck(String s)
	{
		StringBuilder sb=new StringBuilder(s);
		sb=sb.reverse();
		String s2=new String(sb);
		if(s.equals(s2))
				return true;
		else
				return false;
	}

}
