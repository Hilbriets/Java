package Code_java;
import java.util.Scanner;
public class Row_max {

	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		int r=s.nextInt();
		int c=s.nextInt();
		int index=0,max=0;
		int arr[][]=new int[r][c];
		for(int i=0;i<r;i++)
		{
			int sum=0;
			for(int j=0;j<c;j++)
			{
				arr[i][j]=s.nextInt();
				if(arr[i][j]==1)
				{
					sum++;
				}
			}
			if(sum>max)
			{
				max=sum;
				index=i;
			}
		}
		System.out.println(index+1);
	}

}
