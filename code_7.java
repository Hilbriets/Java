package heei;
import java.util.Scanner;
import java.util.Arrays;
public class code_7 
{
	public static void main(String[] args) 
	{
		Scanner s=new Scanner(System.in);
		Institution I[]=new Institution[4];
		for(int i=0;i<4;i++)
		{
			int id=s.nextInt();s.nextLine();
			String name=s.nextLine();
			int nosP=s.nextInt();
			int nosC=s.nextInt();s.nextLine();
			String Loc=s.nextLine();
			I[i]=new Institution(id,name,nosP,nosC,Loc);
		}
		String L=s.nextLine();
		String N=s.nextLine();
		int sum=findNum(I,L);
		if(sum==0)
			System.out.println("There are no cleared students in this particular location");
		else
			System.out.println(sum);
		Institution k=update(N,I);
		if(k==null)
		{
			System.out.println("No Institute is available with the specified name");
		}
		else
		{
			System.out.println(k.getname()+"::"+k.getgrade());
		}
	}
	
	public static int findNum(Institution I[],String L)
	{
		int sum=0;
		for(int i=0;i<4;i++)
		{
			if(I[i].getLoc().equals(L))
			{
				sum=sum+I[i].getnosC();
			}
		}
		return sum;
	}
	public static Institution update(String N, Institution I[])
	{
		Institution P=null;
		for(int i=0;i<4;i++)
		{
			if(I[i].getname().equals(N))
			{
				int val=(I[i].getnosP()*100)/I[i].getnosC();
				if(val>=80)
				{
					I[i].setgrade("A");
				}
				else
					I[i].setgrade("B");
			
				return I[i];
			}
		}
		return P;
		
	}

}
class Institution
{
	int id;
	String name;
	int nosP;
	int nosC;
	String Loc;
	String grade;
	
	public int getid()
	{
		return id;
	}
	public String getname()
	{
		return name;
	}
	public int getnosP()
	{
		return nosP;
	}
	public int getnosC()
	{
		return nosC;
	}
	public String getLoc()
	{
		return Loc;
	}
	public String getgrade()
	{
		return grade;
	}
	public void setgrade(String grade)
	{
		this.grade=grade;
	}
	Institution(int id,String name,int nosP,int nosC,String Loc)
	{
		this.id=id;
		this.name=name;
		this.nosP=nosP;
		this.nosC=nosC;
		this.Loc=Loc;
	}
}