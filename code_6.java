package heei;
import java.util.Scanner;
import java.util.Arrays;
public class code_6 {

	public static void main(String[] args) 
	{
		Phone p[]=new Phone[4];
		Scanner s=new Scanner(System.in);
		for(int i=0;i<4;i++)	
		{
			int phoneId=s.nextInt();s.nextLine();
			String os=s.nextLine();
			String brand=s.nextLine();
			int price=s.nextInt();s.nextLine();
			p[i]=new Phone(phoneId,os,brand,price);
		}
		String B=s.nextLine();
		String O=s.nextLine();
		s.close();
		int Price=findPriceForGivenBrand(p, B);
		Phone ph=getPhoneIdBasedOnOs(p, O);
		if(Price==0)
			System.out.println("The given Brand is not available");
		else
			System.out.println(Price);
	
		if(ph==null)
		{
			System.out.println("No phones are available with specified os and price range");
		}
		else
		{
			System.out.println(ph.getphoneId());
		}
			
	}
	public static int findPriceForGivenBrand(Phone[] phone, String brand)
	{
		int sum=0;
		for(int i=0;i<4;i++)
		{
			if(phone[i].getbrand().equals(brand))
			{
				sum=sum+phone[i].getprice();
			}
		}
		return sum;
	}

	public static Phone getPhoneIdBasedOnOs(Phone[] phone, String os)
	{
		Phone p=null;
		for(int i=0;i<4;i++)
		{
			String s1=phone[i].getos().toUpperCase();
			String s2=os.toUpperCase();
			if(s1.equals(s2) && phone[i].getprice()>=50000)
			{
				return phone[i];
			}
		}
		return p;
	}

}
class Phone
{
	int phoneId;
	String os;
	String brand;
	int price;
	
	public int getphoneId()
	{
		return phoneId;
	}
	public String getos()
	{
		return os;
	}
	public String getbrand()
	{
		return brand;
	}
	public int getprice()
	{
		return price;
	}
	Phone(int phoneId,String os,String brand,int price)
	{
		this.phoneId=phoneId;
		this.os=os;
		this.brand=brand;
		this.price=price;
	}
}