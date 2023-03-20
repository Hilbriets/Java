package Code_java;

public class Triangle_star 
{

	public static void main(String[] args) 
	{
		int n = 10; 
        pyramidPattern(n); 
	}  
    public static void pyramidPattern(int n) 
    {  
        for(int k=0;k<n;k++)
        {
        	for (int i=k+1; i<n; i++) //outer loop for number of rows(n) { for (int j=n-i; j>1; j--) //inner loop for spaces
        		System.out.print(" ");  
        	for (int j=0; j<(2*k+1); j++ ) //inner loop for number of columns
        		System.out.print("*"); //print star
        	System.out.println();
        }
        for(int k=n-2;k>=0;k--)
        {
        	for (int i=k+1; i<n; i++) //outer loop for number of rows(n) { for (int j=n-i; j>1; j--) //inner loop for spaces
        		System.out.print(" "); 
        	for (int j=0; j<(2*k+1); j++ ) //inner loop for number of columns
        		System.out.print("*"); //print star
        	System.out.println();
        }
     }            
}

