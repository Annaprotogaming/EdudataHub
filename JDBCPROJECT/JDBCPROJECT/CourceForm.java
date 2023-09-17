package JDBCPROJECT;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.EventObject;

import javax.swing.*;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class CourceForm extends JFrame implements ActionListener
{
	
	JLabel  lbl1,lbl2,lbl3,lbl4,lbl5,lbl6;
	JTextField  txt1,txt2,txt3,txt4,txt5;
	JButton b1,b2, b3,b4,b5;
	int co_id,co_fee,co_fee1;
     String co_name,co_duration,sql;
     Connection cn;
     Statement stmt;
     DefaultTableModel model = new DefaultTableModel();
     JTable tabGrid = new JTable(model);
     JScrollPane scrlPane = new JScrollPane(tabGrid);

 	Font f1=new Font("Algerian",Font.CENTER_BASELINE, 18);
 	
	public  CourceForm()
	{
		 setSize(500,500);
		 
		 setLayout(null);
		 setVisible(true);
		 setLocation(500,300);
		 getContentPane().setBackground(Color.black);
		 ImageIcon background_image= new ImageIcon(" background3.jpg ");
		 
		 lbl1=new JLabel("cource Id :");
		 add(lbl1);
		 lbl1.setForeground(Color.red);
		 
		 lbl2=new JLabel ("Cource Name :");
		 add (lbl2);
		 lbl2.setForeground(Color.red);
		 
		 
		 lbl3=new JLabel ("Cource Period");
		 add(lbl3);
		 lbl3.setForeground(Color.red);
		 
		 lbl4=new JLabel ("Courceonetimefees");
		 add(lbl4);
		 lbl4.setForeground(Color.red);
		 
		 lbl5=new JLabel ("Installmentfees");
		 add(lbl5);
		 lbl5.setForeground(Color.red);
		 
		 lbl6=new JLabel ("Add Record");
		 lbl6.setBounds(150,100,200,30);
		 add(lbl6);
		 lbl6.setFont(f1);
		 lbl6.setForeground(Color.red);
		
		
		 
		 
		 txt1=new JTextField();
		 add(txt1);
		 txt2=new JTextField();
		 add(txt2);
		 txt3=new JTextField();
		 add(txt3);
		 txt4=new JTextField();
		 add(txt4);
		 txt5=new JTextField();
		 add(txt5);
		 
		 b1=new JButton("new ");
		 add(b1);
		 b2=new JButton("save");
		 add(b2);
		 b3=new JButton("update");
		 add(b3);
		 b4=new JButton("Delete ");
		 add(b4);
		 b5=new JButton ("Display all");
		 add(b5);
		 
		 lbl1.setBounds(100,200,100,50);     txt1.setBounds(210,200,150,30);
		 lbl2.setBounds(100,250,150,50);    txt2.setBounds(210,250,150,30);
		 lbl3.setBounds(100,300,100,50);    txt3.setBounds( 210,300,150,30);
		 lbl4.setBounds(100,350,100,50);    txt4.setBounds(210,350,150,30);
		 lbl5.setBounds(100,400,100,50);    txt5.setBounds(210,400,150,30);
		
		 b1.setBounds(30,470,100,30);
		 b2.setBounds(150,470,100,30);
		 b3.setBounds(270,470,100,30);
		 b4.setBounds(390,470,100,30);
		 b5.setBounds (510,470,100,30);
		
		 try 
		 {
			 Class.forName("com.mysql.jdbc.Driver");
			 JOptionPane.showMessageDialog(null, "Driver register");
			  cn=DriverManager.getConnection("jdbc:mysql://localhost:3306/institute","root","");
			 JOptionPane.showMessageDialog(null, "connection Sucess");	 
			 
		 }
		
		 catch(Exception e)
		 {
			 JOptionPane.showMessageDialog(null, e);
			 
		 }
		
		 scrlPane.setBounds(10,550,627,200);
         add(scrlPane);
         tabGrid.setFont(new Font ("Verdana",0,13));
      
      model.addColumn("courseId");
      model.addColumn("courceName");
      model.addColumn("courseperiod");
      model.addColumn("couseonetimefees");
      model.addColumn("Installmentfees");
 
         b1.addActionListener(this);//3
         b2.addActionListener(this);
         b3.addActionListener(this);
         b4.addActionListener(this);
         b5.addActionListener(this);
		 }

	public static void main(String[] args)
	{
		new CourceForm();
		
	}
	public void actionPerformed(ActionEvent e)
	{
		if(b1==e.getSource())
		{
			try
			{
				stmt=cn.createStatement();
				ResultSet res=stmt.executeQuery("Select co_id from course");
				int i=1;
				while(res.next())
				{
					i=Integer.parseInt(res.getString("co_id"));
				}
				i++;
				txt1.setText(""+i);
				txt2.setText("");
				txt3.setText("");
				txt4.setText("");
				txt5.setText("");
			}
			catch(Exception e1)
			{
				JOptionPane.showMessageDialog(null,""+ e1);
			}
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		if (b2==e.getSource())
		{
			try
			{
				
				co_id=Integer.parseInt(txt1.getText());
				co_name=(txt2.getText());
				co_duration=(txt3.getText());
				co_fee1=Integer.parseInt(txt4.getText());
				co_fee=Integer.parseInt(txt5.getText());
				sql="insert into course values ("+co_id+",'"+co_name+"','"+co_duration+"',"+co_fee1+","+co_fee+")";
				stmt=cn.createStatement();
				int k=stmt.executeUpdate(sql);
				if(k>0)
				{
					JOptionPane.showMessageDialog(null, "save successfully");
				}
				else
				{
					JOptionPane.showMessageDialog(null, "error found");
				}
				stmt.close();
				txt1.setText("");
				txt2.setText("");
				txt3.setText("");
				txt4.setText("");
				txt5.setText("");
			}
			catch(Exception e2)
			{
				JOptionPane.showMessageDialog(null, e2);
			}
		}
		if(b3==e.getSource())
		{
			try
			{
				co_id=Integer.parseInt(txt1.getText());
				co_name=(txt2.getText());
				co_duration=(txt3.getText());
				co_fee1=Integer.parseInt(txt4.getText());
				co_fee=Integer.parseInt(txt5.getText());
				sql=sql="Update course  set co_name='"+co_name+"',co_duration='"+co_duration+"',co_fee1='"+co_fee1+"',co_fee='"+co_fee+"'  where co_id="+co_id+"";
				stmt=cn.createStatement();
				int k=stmt.executeUpdate(sql);
				if(k>0)
				{
					JOptionPane.showMessageDialog(null, "update successfully");
					
				}
				else
				{
					JOptionPane.showMessageDialog(null, "error");
				}
				stmt.close();
				txt1.setText("");
				txt2.setText("");
				txt3.setText("");
				txt4.setText("");
				txt5.setText("");
				
			}
			catch(Exception e3)
			{
			JOptionPane.showMessageDialog(null, e3);
			}
		}
		if(b4==e.getSource())
		{
			try
			{
				co_id=Integer.parseInt(txt1.getText());
				sql="delete from course where co_id="+co_id+"";
				stmt=cn.createStatement();
				int	K=stmt.executeUpdate(sql);
				if(K>0)
				{
					JOptionPane.showMessageDialog(null, "Delete sucessfully");
				}
				else
				{
					JOptionPane.showMessageDialog(null, "error");
				}
				stmt.close();
				txt1.setText("");
				txt2.setText("");
				txt3.setText("");
				txt4.setText("");
				txt5.setText("");
				
				
			}
			catch(Exception e4)
			{
				JOptionPane.showMessageDialog(null, e4);
			}
		}
		if(b5==e.getSource())
		{
			int r=0;
			model.setRowCount(0);
			try
			{
				
				stmt = cn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);			
	            ResultSet rs = stmt.executeQuery("SELECT * from course" );			
	            while(rs.next())
	            {
					model.insertRow(r++, new Object[]{rs.getInt(1),rs.getString(2),rs.getString(3),rs.getInt(4),rs.getInt(5) });
	            }
	            
		
			}
			catch(Exception e5)
			{
				JOptionPane.showMessageDialog(null, e5);
			}
		}
		
	}

}
