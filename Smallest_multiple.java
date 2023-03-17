package Code_java;
import java.util.Scanner;

public class Small_multiple {

	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		int x=s.nextInt();
		int y=0,num=x,temp=0,mul=1,val=0,count=0;
		for(int i=2;i<(x/2);i++)
			if(x%i==0)
			{
				count++;
				break;
			}
		if(x<=9)
			System.out.println(x+10);
		else if(count!=0)
		{
			while(y==0)
			{
				temp=num;
				while(temp>0)
				{
					int a=temp%10;
					mul*=a;
					temp/=10;
				}
				if(mul==x)
				{
					val=num;
					y=1;
					break;
				}
				mul=1;
				if(num<10000)
					num++;
				else
					break;
			}
		}
		if(val!=0)
			System.out.println(val);
		if(count==0 || num>=10000)
			System.out.println("NotPossible");
	}								
}
