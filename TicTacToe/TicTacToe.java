import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;


public class TicTacToe implements ActionListener{
	
	Random random =new Random();
	JFrame frame= new JFrame();
	JPanel title_panel=new JPanel();
	JPanel button_panel=new JPanel();
	JLabel label=new JLabel();
	JButton buttons[]=new JButton[9];
	String str;boolean run=true;
	TicTacToe()
	{
		if(random.nextInt(2)==0)
			str="X";
		else
			str="O";
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(800,800);
		frame.getContentPane().setBackground(Color.BLACK);
		frame.setLayout(new BorderLayout());
		frame.setVisible(true);
		
		label.setBackground(Color.DARK_GRAY);
		label.setForeground(Color.WHITE);
		label.setFont(new Font("Calibri",Font.BOLD,75));
		label.setHorizontalAlignment(JLabel.CENTER);
		label.setText("Tic-Tac-Toe");
		label.setOpaque(true);
		
		title_panel.setLayout(new BorderLayout());
		title_panel.setBounds(0,0,800,100);
		
		button_panel.setLayout(new GridLayout(3,3));
		button_panel.setBackground(Color.RED);
		
		for(int i=0;i<9;i++)
		{
			buttons[i]=new JButton();
			button_panel.add(buttons[i]);
			buttons[i].setFont(new Font("Int Free",Font.BOLD,100));
			buttons[i].setFocusable(false);
			//buttons[i].setBackground(Color.cyan);
			buttons[i].addActionListener(this);
			
		}
		
		title_panel.add(label);
		frame.add(button_panel,BorderLayout.CENTER);
		frame.add(title_panel,BorderLayout.NORTH);
	}

	public void actionPerformed(ActionEvent e) 
	{
		for(int i=0;i<9;i++)
		{
			if(e.getSource()==buttons[i] && run)
			{
				if(str=="X")
				{
					if(buttons[i].getText()=="")
					{
						buttons[i].setForeground(Color.blue);
						buttons[i].setText(str);
						str="O";
						check();
					}
				}
				else
				{
					if(buttons[i].getText()=="")
					{
						buttons[i].setForeground(Color.red);
						buttons[i].setText(str);
						str="X";
						check();
					}
				}
				
			}
		}
		
	}
	public void check()
	{
		int o=0,count=0;
		String c[][]=new String[3][3];
		for(int i=0;i<3;i++)
		{
			for(int j=0;j<3;j++)
			{
				c[i][j]=buttons[o++].getText();
				if(c[i][j]!="")
					count++;
			}
		}
		o=0;
		for(int j=0;j<3;j++)
		{
			if(c[0][j]==c[1][j] && c[0][j]==c[2][j] && c[0][j]!="" && c[0][j]!="" && c[0][j]!="")
			{
				print(c[0][j]);o=1;
				break;
			}
			
			else if(c[j][0]==c[j][1] && c[j][0]==c[j][2] && c[j][0]!="" && c[j][1]!="" && c[j][2]!="")
			{
				print(c[j][0]);o=1;
				break;
			}
			else if(c[0][0]==c[1][1] && c[0][0]==c[2][2] && c[0][0]!="" && c[1][1]!="" && c[2][2]!="")
			{
				print(c[0][0]);o=1;
				break;
			}
			if(count==9 && o==0)
				label.setText("Draw");
		}
	}
	public void print(String str)
	{
			label.setText(str+" wins");
			run=false;
	}
	
}
