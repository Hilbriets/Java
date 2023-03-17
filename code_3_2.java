package heei;
import java.util.Scanner;
import java.util.Arrays;
public class code_3_2 {


		public static void main(String[] args) 
		{
			Scanner s=new Scanner(System.in);
			AutonomousCar a[]=new AutonomousCar[4];
			for(int i=0;i<4;i++)
			{
				int carId=s.nextInt();s.nextLine();
				String brand=s.nextLine();
				int notC=s.nextInt();
				int notP=s.nextInt();s.nextLine();
				String environment=s.nextLine();
				a[i]=new AutonomousCar(carId,brand,notC,notP,environment);
			}
			String en=s.next();
			String br=s.next();
			s.close();
			int sum=findTestPassedByEnv(a,en);
			AutonomousCar C=updateCarGrade(br,a);
			if(sum>0)
			{
				System.out.println(sum);
			}
			else
			{
				System.out.println("There are no tests passed in this particular environment");
			}
			if(C==null)
			{
				System.out.print("No car is available with the specified brand");
			}
			else
			{
				System.out.print(C.getbrand()+"::"+C.getgrade());
			}
			
		}
		
		public static int findTestPassedByEnv(AutonomousCar a[],String e)
		{
			int sum=0;
			for(int i=0;i<4;i++)
			{
				if(a[i].getenvironment().equals(e))
				{
					sum=sum+a[i].getnotP();
				}
			}
			return sum;
		}
		public static AutonomousCar updateCarGrade(String b,AutonomousCar a[])
		{
			int val=0;
			AutonomousCar C=null;
			for(int i=0;i<4;i++)
			{
				if(a[i].getbrand().equals(b))
				{
					val=(a[i].getnotP()*100)/a[i].getnotC();
					if(val>80)
					{
						a[i].setgrade("A1");
					}
					else
						
					{
						a[i].setgrade("B2");
					}
					C=a[i];
					break;
				}
			}
			return C;
		}

	}

	class AutonomousCar
	{
		int carId;
		String brand;
		int notC;
		int notP;
		String environment;
		String grade;
		
		public int getcarId()
		{
			return carId;
		}
		public void setcarId(int carId)
		{
			this.carId=carId;
		}
		public String getbrand()
		{
			return brand;
		}
		public void setbrand(String brand)
		{
			this.brand=brand;
		}
		public int getnotC()
		{
			return notC;
		}
		public void setnotC(int notC)
		{
			this.notC=notC;
		}
		public int getnotP()
		{
			return notP;
		}
		public void setnotP(int notP)
		{
			this.notP=notP;
		}
		public String getenvironment()
		{
			return environment;
		}
		public void setenvironment(String environment)
		{
			this.environment=environment;
		}
		public String getgrade()
		{
			return grade;
		}
		public void setgrade(String grade)
		{
			this.grade=grade;
		}
		
		AutonomousCar(int carId,String brand,int notC,int notP,String environment)
		{
			this.carId=carId;
			this.brand=brand;
			this.notC=notC;
			this.notP=notP;
			this.environment=environment;
			
		}
	}

