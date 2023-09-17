package JDBCPROJECT;

import java.util.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;
public class Login extends JFrame implements ActionListener
{
	JLabel l1,l2;
	JButton btn1,btn2;
	JTextField t1;
	JPasswordField p1;
	String username,password;
	Connection con;
	Statement stmt;
	ResultSet rs;
	int flag=0;
	public Login()
	{
		try
		
		{
		
			Class.forName("com.mysql.jdbc.Driver");               //1 Driver 
			JOptionPane.showMessageDialog(null, "Driver register");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/login","root","");   //2
			JOptionPane.showMessageDialog(null,"Connected.....");
		}
		catch(Exception e)
		{
			JOptionPane.showMessageDialog(null, e);
		}
		setLayout(null);
		setTitle("Login Form");
		setVisible(true);
		setBounds(300,50,700,600);
		
		
		l1=new JLabel("Username:");
		add(l1);
		l1.setBounds(100,50,100,100);
		
		t1=new JTextField();
		add(t1);
		t1.setBounds(250,85,250,30);
		
		l2=new JLabel("Password:");
		add(l2);
		l2.setBounds(100,100,100,100);
		
		p1=new JPasswordField();
		add(p1);
		p1.setBounds(250,135,250,30);
		
		btn1=new JButton("Ok");
		add(btn1);
		btn1.setBounds(100,255,90,30);
		
		btn2=new JButton("Cancel");
		add(btn2);
		btn2.setBounds(200,255,90,30);
			
		
		btn1.addActionListener(this);
		btn2.addActionListener(this);
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	public void actionPerformed(ActionEvent ae)
	{
		if(ae.getSource()==btn1)
		{
		try {
				String username1=t1.getText();
				String password1=p1.getText();
				stmt=con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
				ResultSet rs=stmt.executeQuery("select * from login");
				while(rs.next())
				{
					username=rs.getString(1);
					password=rs.getString(2);
						if(username1.equals(username) && password1.equals(password))
						{
							flag=1;
							break;
						}
						
				}
				if(flag==1)
				{
					JOptionPane.showMessageDialog(null,"Login successfully....");
				}
				else
				{
					JOptionPane.showMessageDialog(null,"Login Failed");
				}
				t1.setText("");
				p1.setText("");
				
			}
			catch(Exception e1)
			{
				JOptionPane.showMessageDialog(null,e1);
			}
		}
		if(ae.getSource()==btn2)
		{
				t1.setText("");
				p1.setText("");
		}
	}
	public static void main(String[] args) 
	{
		new Login();
	}
}
