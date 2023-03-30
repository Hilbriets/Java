package Path_gen;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Drone_class implements ActionListener 
{
	JFrame frame;
	JTextField textField;
	JButton[][] ini_val=new JButton[20][20];
	JButton[][] pos_val=new JButton[20][20];
	
	JPanel panel;
	Font myFont=new Font("Ink Free",Font.BOLD,30);
	
	Drone_class()
	{
		frame=new JFrame("Drone Navigation");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(500, 500);
		frame.setLayout(null);
		textField= new JTextField();
		textField.setBounds(100,50,50,50);
		textField.setFont(myFont);
		//textField.setEditable(false);
		
		frame.add(textField);
		frame.setVisible(true);
	}
	public static void main(String[] args) 
	{
		Drone_class c=new Drone_class();
		// TODO Auto-generated method stub
		Scanner s=new Scanner(System.in);
		System.out.print("Enter the number of drones which are about to be operated: ");
		int n=s.nextInt();
		ArrayList<Drone_data> Data=new ArrayList<Drone_data>();
		for(int i=0;i<n;i++)
		{
			System.out.print("X"+(i+1)+"1 :");
			int x1=s.nextInt()-1;
			System.out.print("Y"+(i+1)+"1 :");
			int y1=s.nextInt()-1;
			System.out.print("X"+(i+1)+"2 :");
			int x2=s.nextInt()-1;
			System.out.print("Y"+(i+1)+"2 :");
			int y2=s.nextInt()-1;
			System.out.print("T"+(i+1)+" :");
			int t=s.nextInt();
			Data.add(new Drone_data(x1,y1,x2,y2,t));
		}
		Collections.sort(Data); //sorting the Arraylist with respect to the time
		int min_time=Process(Data,n);
		System.out.print(min_time);
	}
	
	
	public static int Process(ArrayList<Drone_data> Data,int n)
	{
		int time=0;
		int Map[][]=new int[20][20];
		int temp=n;
		while(n>0)
		{
			for(int i=0;i<Data.size();i++)
			{
				if(Data.get(i).x1==Data.get(i).x2 && Data.get(i).y1==Data.get(i).y2 && time ==Data.get(i).t)
				{
					n--;
					continue;
				}
				if(time==Data.get(i).t)
				{
					Map[Data.get(i).x1][Data.get(i).y1]=1;
				}
					
				else if(time>Data.get(i).t)
				{
					if(Data.get(i).x1>Data.get(i).x2)
					{
						if(Data.get(i).y1>Data.get(i).y2)
						{
							if(Map[Data.get(i).x1][Data.get(i).y1]==1)
							{
								Map[Data.get(i).x1][Data.get(i).y1]=0;
								if(Map[Data.get(i).x1-1][Data.get(i).y1-1]==0 && Data.get(i).y1!=0 && Data.get(i).x1!=0)
								{
									Data.set(i, new Drone_data(Data.get(i).x1-1,Data.get(i).y1-1,Data.get(i).x2,Data.get(i).y2,Data.get(i).t));
									Map[Data.get(i).x1][Data.get(i).y1-1]=1;
									continue;
								}
								else if(Map[Data.get(i).x1][Data.get(i).y1-1]==0 && Data.get(i).y1!=0)
								{
									Data.set(i, new Drone_data(Data.get(i).x1,Data.get(i).y1-1,Data.get(i).x2,Data.get(i).y2,Data.get(i).t));
									Map[Data.get(i).x1][Data.get(i).y1]=1;
									continue;
								}
								else if(Map[Data.get(i).x1-1][Data.get(i).y1]==0 && Data.get(i).x1!=0)
								{
									Data.set(i, new Drone_data(Data.get(i).x1-1,Data.get(i).y1,Data.get(i).x2,Data.get(i).y2,Data.get(i).t));
									Map[Data.get(i).x1][Data.get(i).y1]=1;
									continue;
								}
								else
									Map[Data.get(i).x1][Data.get(i).y1]=1;
								
							}
							
						}
						else if(Data.get(i).y1<Data.get(i).y2)
						{
							if(Map[Data.get(i).x1][Data.get(i).y1]==1)
							{
								Map[Data.get(i).x1][Data.get(i).y1]=0;
								if(Map[Data.get(i).x1-1][Data.get(i).y1+1]==0 && Data.get(i).x1!=0 && Data.get(i).y1!=temp-1)
								{
									Data.set(i, new Drone_data(Data.get(i).x1-1,Data.get(i).y1+1,Data.get(i).x2,Data.get(i).y2,Data.get(i).t));
									Map[Data.get(i).x1][Data.get(i).y1]=1;
									continue;
								}
								else if(Map[Data.get(i).x1-1][Data.get(i).y1]==0 && Data.get(i).x1!=0)
								{
									Data.set(i, new Drone_data(Data.get(i).x1-1,Data.get(i).y1,Data.get(i).x2,Data.get(i).y2,Data.get(i).t));
									Map[Data.get(i).x1-1][Data.get(i).y1-1]=1;
									continue;
								}
								else if(Map[Data.get(i).x1][Data.get(i).y1+1]==0 && Data.get(i).y1!=temp-1)
								{
									Data.set(i, new Drone_data(Data.get(i).x1,Data.get(i).y1,Data.get(i).x2,Data.get(i).y2,Data.get(i).t));
									Map[Data.get(i).x1-1][Data.get(i).y1-1]=1;
									continue;
								}
								else
									Map[Data.get(i).x1-1][Data.get(i).y1-1]=1;
							} 
						}
						else
						{
							if(Map[Data.get(i).x1][Data.get(i).y1]==1)
							{
								Map[Data.get(i).x1][Data.get(i).y1]=0;
								if(Map[Data.get(i).x1-1][Data.get(i).y1]==0 && Data.get(i).x1!=0)
								{
									Data.set(i, new Drone_data(Data.get(i).x1-1,Data.get(i).y1,Data.get(i).x2,Data.get(i).y2,Data.get(i).t));
									Map[Data.get(i).x1][Data.get(i).y1]=1;
									continue;
								}
								else if(Map[Data.get(i).x1-1][Data.get(i).y1-1]==0 && Data.get(i).x1!=0 && Data.get(i).y1!=0)
								{
									Data.set(i, new Drone_data(Data.get(i).x1-1,Data.get(i).y1-1,Data.get(i).x2,Data.get(i).y2,Data.get(i).t));
									Map[Data.get(i).x1][Data.get(i).y1]=1;
									continue;
								}
								else if(Map[Data.get(i).x1-1][Data.get(i).y1+1]==0 && Data.get(i).x1!=0 && Data.get(i).y1!=temp-1)
								{
									Data.set(i, new Drone_data(Data.get(i).x1-1,Data.get(i).y1+1,Data.get(i).x2,Data.get(i).y2,Data.get(i).t));
									Map[Data.get(i).x1][Data.get(i).y1]=1;
									continue;
								}
								else
									Map[Data.get(i).x1][Data.get(i).y1]=1;
							}
						}
						 
					}
					else if(Data.get(i).x1<Data.get(i).x2)
					{
						if(Data.get(i).y1>Data.get(i).y2)
						{
							
							if(Map[Data.get(i).x1][Data.get(i).y1]==1)
							{
								Map[Data.get(i).x1][Data.get(i).y1]=0;
								if(Map[Data.get(i).x1+1][Data.get(i).y1-1]==0 && Data.get(i).x1!=temp-1 && Data.get(i).y1!=0)
								{
									Data.set(i, new Drone_data(Data.get(i).x1+1,Data.get(i).y1-1,Data.get(i).x2,Data.get(i).y2,Data.get(i).t));
									Map[Data.get(i).x1][Data.get(i).y1]=1;
									continue;
								}
								else if(Map[Data.get(i).x1+1][Data.get(i).y1]==0 && Data.get(i).x1!=0)
								{
									Data.set(i, new Drone_data(Data.get(i).x1+1,Data.get(i).y1,Data.get(i).x2,Data.get(i).y2,Data.get(i).t));
									Map[Data.get(i).x1][Data.get(i).y1]=1;
									continue;
								}
								else if(Map[Data.get(i).x1][Data.get(i).y1-1]==0 && Data.get(i).y1!=0)
								{
									Data.set(i, new Drone_data(Data.get(i).x1,Data.get(i).y1-1,Data.get(i).x2,Data.get(i).y2,Data.get(i).t));
									Map[Data.get(i).x1][Data.get(i).y1]=1;
									continue;
								}
								else
									Map[Data.get(i).x1][Data.get(i).y1]=1;
							}
						}
						else if(Data.get(i).y1<Data.get(i).y2)
						{
							
							if(Map[Data.get(i).x1][Data.get(i).y1]==1)
							{
								Map[Data.get(i).x1][Data.get(i).y1]=0;
								if(Map[Data.get(i).x1+1][Data.get(i).y1+1]==0 && Data.get(i).x1!=temp-1 && Data.get(i).x1!=temp-1)
								{
									Data.set(i, new Drone_data(Data.get(i).x1+1,Data.get(i).y1+1,Data.get(i).x2,Data.get(i).y2,Data.get(i).t));
									Map[Data.get(i).x1][Data.get(i).y1]=1;
									continue;
								}
								else if(Map[Data.get(i).x1+1][Data.get(i).y1]==0 && Data.get(i).x1!=temp-1)
								{
									Data.set(i, new Drone_data(Data.get(i).x1+1,Data.get(i).y1,Data.get(i).x2,Data.get(i).y2,Data.get(i).t));
									Map[Data.get(i).x1][Data.get(i).y1]=1;
									continue;
								}
								else if(Map[Data.get(i).x1][Data.get(i).y1+1]==0 && Data.get(i).y1!=temp-1)
								{
									Data.set(i, new Drone_data(Data.get(i).x1,Data.get(i).y1+1,Data.get(i).x2,Data.get(i).y2,Data.get(i).t));
									Map[Data.get(i).x1][Data.get(i).y1]=1;
									continue;
								}
								else
									Map[Data.get(i).x1][Data.get(i).y1]=1;
							}
						}
						else
						{ 
							
							if(Map[Data.get(i).x1][Data.get(i).y1]==1)
							{
								Map[Data.get(i).x1][Data.get(i).y1]=0;
								if(Map[Data.get(i).x1+1][Data.get(i).y1]==0 && Data.get(i).x1!=temp-1)
								{
									Data.set(i, new Drone_data(Data.get(i).x1+1,Data.get(i).y1,Data.get(i).x2,Data.get(i).y2,Data.get(i).t));
									Map[Data.get(i).x1][Data.get(i).y1]=1;
									continue;
								}
								else if(Map[Data.get(i).x1+1][Data.get(i).y1-1]==0 && Data.get(i).x1!=temp-1 && Data.get(i).y1!=0)
								{
									Data.set(i, new Drone_data(Data.get(i).x1+1,Data.get(i).y1-1,Data.get(i).x2,Data.get(i).y2,Data.get(i).t));
									Map[Data.get(i).x1][Data.get(i).y1]=1;
									continue;
								}
								else if(Map[Data.get(i).x1+1][Data.get(i).y1+1]==0 && Data.get(i).x1!=temp-1 && Data.get(i).x1!=temp-1)
								{
									Data.set(i, new Drone_data(Data.get(i).x1+1,Data.get(i).y1+1,Data.get(i).x2,Data.get(i).y2,Data.get(i).t));
									Map[Data.get(i).x1][Data.get(i).y1]=1;
									continue;
								}
								else
									Map[Data.get(i).x1][Data.get(i).y1]=1;
							}
						}
					}
					else
					{
						if(Data.get(i).y1>Data.get(i).y2)
						{
							
							if(Map[Data.get(i).x1][Data.get(i).y1]==1)
							{
								Map[Data.get(i).x1][Data.get(i).y1]=0;
								if(Map[Data.get(i).x1][Data.get(i).y1+1]==0 && Data.get(i).y1!=temp-1)
								{
									Data.set(i, new Drone_data(Data.get(i).x1,Data.get(i).y1+1,Data.get(i).x2,Data.get(i).y2,Data.get(i).t));
									Map[Data.get(i).x1][Data.get(i).y1]=1;
									continue;
								}
								else if(Map[Data.get(i).x1-1][Data.get(i).y1+1]==0 && Data.get(i).x1!=0 && Data.get(i).y1!=temp-1)
								{
									Data.set(i, new Drone_data(Data.get(i).x1-1,Data.get(i).y1+1,Data.get(i).x2,Data.get(i).y2,Data.get(i).t));
									Map[Data.get(i).x1][Data.get(i).y1]=1;
									continue;
								}
								else if(Map[Data.get(i).x1+1][Data.get(i).y1+1]==0 && Data.get(i).x1!=temp-1 && Data.get(i).y1!=temp-1)
								{
									Data.set(i, new Drone_data(Data.get(i).x1+1,Data.get(i).y1+1,Data.get(i).x2,Data.get(i).y2,Data.get(i).t));
									Map[Data.get(i).x1][Data.get(i).y1]=1;
									continue;
								}
								else
									Map[Data.get(i).x1][Data.get(i).y1]=1;
							}
						}
						else if(Data.get(i).y1<Data.get(i).y2)
						{
							
							if(Map[Data.get(i).x1][Data.get(i).y1]==1)
							{
								Map[Data.get(i).x1][Data.get(i).y1]=0;
								if(Map[Data.get(i).x1][Data.get(i).y1-1]==0 && Data.get(i).y 1!=0)
								{
									Data.set(i, new Drone_data(Data.get(i).x1,Data.get(i).y1-1,Data.get(i).x2,Data.get(i).y2,Data.get(i).t));
									Map[Data.get(i).x1][Data.get(i).y1]=1;
									continue;
								}
								else if(Map[Data.get(i).x1+1][Data.get(i).y1-1]==0 && Data.get(i).x1!=temp-1 && Data.get(i).y1!=0)
								{
									Data.set(i, new Drone_data(Data.get(i).x1+1,Data.get(i).y1-1,Data.get(i).x2,Data.get(i).y2,Data.get(i).t));
									Map[Data.get(i).x1][Data.get(i).y1]=1;
									continue;
								}
								else if(Map[Data.get(i).x1-1][Data.get(i).y1-1]==0 && Data.get(i).x1!=0 && Data.get(i).y1!=0)
								{
									Data.set(i, new Drone_data(Data.get(i).x1-1,Data.get(i).y1-1,Data.get(i).x2,Data.get(i).y2,Data.get(i).t));
									Map[Data.get(i).x1][Data.get(i).y1]=1;
									continue;
								}
								else
									Map[Data.get(i).x1][Data.get(i).y1]=1;
							}
						}
						else
						{
							if(Map[Data.get(i).x1][Data.get(i).y1]==1)
							{
								Map[Data.get(i).x1][Data.get(i).y1]=0;
								n--;
							}
						}
					}
				}
				else
					break;
			}
			if(n>0)
			time++;
		}
		return time;
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

}
