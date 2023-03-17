package heei;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;
public class TCS_qn_1 
{
	public static void main(String[] args) 
	{
		Scanner s = new Scanner(System.in);
		int n=s.nextInt();
		int a[]=new int[n];
		for(int i=0;i<n;i++)
			a[i]=s.nextInt();
		ArrayList<Integer> ans=new ArrayList<Integer>();
		ArrayList<Integer> temp=new ArrayList<Integer>();
		int t=1, x=0,sum=0;
		if(a[0]>0)
			t=0;
		for(int i=0;i<n;i++)
		{
				if(t==0)
				{
					for(int j=i;j<n;j++)
					{
						if(a[j]>0)
							temp.add(a[j]);
						else
							break;
						i=j;	
					}
					t=1;
					x=Collections.max(temp);
					ans.add(x);
					temp.clear();
				}
				else
				{
					for(int j=i;j<n;j++)
					{
						if(a[j]<0)
							temp.add(a[j]);
						else
							break;
						i=j;
					}
					t=0;
					x=Collections.max(temp);
					ans.add(x);
					temp.clear();
				}
			}
		for(int i: ans)
		{
			sum+=i;
		}
		System.out.println(sum);
	}
}
