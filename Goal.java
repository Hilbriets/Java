package Code_java;
import java.util.Scanner;
public class Goal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s=new Scanner(System.in);
		int alpha[]=new int[26];
		int n=s.nextInt();s.nextLine();
		String str[]=new String[n];
		for(int i=0;i<(n*(n-1))/2;i++)
		{
			str[i]=s.nextLine();
			String str1[]=str[i].split(" ");
			String str2[]=str1[2].split("-");
			int home=Integer.parseInt(str2[0]);
			int away=Integer.parseInt(str2[1]);
			if(home>away)
			{
				int val1=str1[0].charAt(0);
				alpha[val1-65]+=3;
			}
			else if(home<away)
			{
				int val1=str1[1].charAt(0);
				alpha[val1-65]+=3;
			}
			else
			{
				int val1=str1[0].charAt(0);
				alpha[val1-65]+=1;
				int val2=str1[1].charAt(0);
				alpha[val2-65]+=1;
			}
		}
		int index=0,val=0;
		for(int i=0;i<26;i++)
		{
			if(alpha[i]>val)
			{
				index=i;
				val=alpha[i];
			}
		}
		char ch=(char)(65+index);
		System.out.print(ch+" "+val);
		
	}

}
