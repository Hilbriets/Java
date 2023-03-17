package Code_java;
import java.util.Scanner;
public class Hash_Star {

	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		String str=s.nextLine();
		int c_hash=0,c_star=0;
		for(int i=0;i<str.length();i++)
		{
			if(str.charAt(i)=='#')
				c_hash++;
			else
				c_star++;
		}
		System.out.print(c_star-c_hash);

	}

}
