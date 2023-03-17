package Code_java;
import java.util.*;
import java.util.Scanner;
public class Number_of_non_same_num {
	public static void main(String[] args)
	{
		Scanner s=new Scanner(System.in);
		int x=s.nextInt();
		int y=s.nextInt();
		int count=0;
		for(int i=x;i<=y;i++)
		{
			Set<Integer> num=new HashSet<Integer>();
			int temp=i,c=0;
			while(temp>0)
			{
				int a=temp%10;
				num.add(a);
				c++;
				temp=temp/10;
			}
			if(num.size()==c)
				count++;
			
		}
		System.out.print(count);
	}
}
