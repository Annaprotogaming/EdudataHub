package JDBCPROJECT;
import java.sql.*;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.awt.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import java.util.Calendar;
import java.util.GregorianCalendar;
public class Enquiry extends JFrame implements ActionListener
{
	JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9,l10,l11;
	JTextField t1,t2,t3,t4,t5,t6;
	JComboBox c1,c2,c3,c4;
	JRadioButton rd1,rd2;
	JButton b1,b2,b3,b4,b5;
	Connection con=null;
	ResultSet res;
	String sql;
	int stud_id,k;
	Statement stmt;
	String date1,stud_name,stud_add,stud_gender,stud_phno,stud_email,co_name,Batch_time,mode;
	String s1[]= {"Male","Female"};
	String s2[]= {"Online","Offline"};
	DefaultTableModel model=new DefaultTableModel();
	JTable tabGrid=new JTable(model);
	JScrollPane scrlPane=new JScrollPane(tabGrid);
	Font f1=new Font ("algerian",Font.CENTER_BASELINE,26);
	private JLabel tdate;
   
	Thread datimeThread;
    Date date;
    GregorianCalendar calendar;
    String strDate;
	
public Enquiry()
{
	setLayout(null);
	setSize(500,500);
	setVisible(true);
	getContentPane().setBackground(Color.black);
	
	
	l1=new JLabel("Enquiry");
	l1.setBounds(400, 100, 300, 30);
	l1.setForeground(Color.red);
	l1.setFont(f1);
	add(l1);
	
	l2=new JLabel("Stud Id :");
	l2.setBounds(250, 200, 100, 30);
	l2.setForeground(Color.red);
	add(l2);
	
	t1=new JTextField();
	t1.setBounds(370, 200, 100, 30);
	add(t1);
	
	l3=new JLabel("Date1:");
	l3.setBounds(490,200,100,30);
	l3.setForeground(Color.red);
	add(l3);
	
	t2=new JTextField();
	t2.setBounds(600,200,100,30);
	add(t2);
	
	l4=new JLabel("Stud Name :");
	l4.setBounds(250,280,100,30);
	l4.setForeground(Color.red);
	add(l4);
	
	t3=new JTextField();
	t3.setBounds(370,280,100,30);
	add(t3);
	
	l5=new JLabel("Stud Address :");
	l5.setBounds(490,280,100,30);
	l5.setForeground(Color.red);
	add(l5);
	
	t4=new JTextField();
	t4.setBounds(600,280,100,30);
	add(t4);
	
	l6=new JLabel("Stud Gender :");
	l6.setBounds(250,360,100,30);
	l6.setForeground(Color.red);
	add(l6);
	
	c1=new JComboBox(s1);
	c1.setBounds(370,360,100,30);
	add(c1);
	
	l7=new JLabel("Stud ph :");
	l7.setBounds(490,360,100,30);
	l7.setForeground(Color.red);
	add(l7);
	
	t5=new JTextField();
	t5.setBounds(600, 360, 100, 30);
	add(t5);
	
	l8=new JLabel("Stud Email :");
	l8.setBounds(250,430,100,30);
	l8.setForeground(Color.red);
	add(l8);
	
	t6=new JTextField();
	t6.setBounds(370,430,100,30);
	add(t6);
	
	l9=new JLabel("Co_Name :");
	l9.setBounds(490,430,100,30);
	l9.setForeground(Color.red);
	add(l9);
	
	c2=new JComboBox();
	c2.setBounds(600,430,100,30);
	add(c2);
	
	l10=new JLabel("Batch time :");
	l10.setBounds(250,500,100,30);
	l10.setForeground(Color.red);
	add(l10);
	
	c3=new JComboBox();
	c3.setBounds(370,500,100,30);
	add(c3);
	
	l11=new JLabel("Mode :");
	l11.setBounds(490,500,100,30);
	l11.setForeground(Color.red);
	add(l11);
	
	c4=new JComboBox(s2);
	c4.setBounds(600,500,100,30);
	add(c4);
	
	b1=new JButton("New");
	b1.setBounds(200,580,100,30);
	b1.setForeground(Color.red);
	add(b1); 
	
	b2=new JButton("Insert");
	b2.setBounds(320,580,100,30);
	b2.setForeground(Color.red);
	add(b2);
	
	b3=new JButton("Update");
	b3.setBounds(440,580,100,30);
	b3.setForeground(Color.red);
	add(b3);
	
	b4=new JButton("Delete");
	b4.setBounds(560,580,100,30);
	b4.setForeground(Color.red);
	add(b4);
	
	b5=new JButton("Display");
	b5.setBounds(680,580,100,30);
	b5.setForeground(Color.red);
	add(b5);
	
	scrlPane.setBounds(90,650,800,150);
	add(scrlPane);
	 
	b1.addActionListener(this);
	b2.addActionListener(this);
	b3.addActionListener(this);
	b4.addActionListener(this);
	b5.addActionListener(this);
	model.addColumn("stu_id");
	model.addColumn("strdate");
	model.addColumn("stu_name");
	model.addColumn("stu_add");
	model.addColumn("stu_gender");
	model.addColumn("stu_phno");
	model.addColumn("stu_email");
	model.addColumn("co_name");
	model.addColumn("b_time");
	model.addColumn("mode");
	
	tdate=new JLabel();
	add(tdate);
	date=new Date();
    calendar=new GregorianCalendar();
    calendar.setTime(date);
    strDate=calendar.get(Calendar.DATE)+"/"+(calendar.get(Calendar.MONTH)+1)+"/"+calendar.get(Calendar.YEAR);
    tdate.setText(strDate);
           
	try
	{
		  Class.forName("com.mysql.jdbc.Driver");
		  JOptionPane.showMessageDialog(null, "Driver reg successfully");
		   con=DriverManager.getConnection("jdbc:mysql://localhost:3306/institute","root","");
		  JOptionPane.showMessageDialog(null, "Connection successful");
		  try
		  {
			  sql="Select co_name from course";
				stmt=con.createStatement();
				res=stmt.executeQuery(sql);
				while(res.next())
				{
					  String s2=(res.getString(1));
				       c2.addItem(s2);
				}
		  }
		  catch(Exception e1)
		  {
			  JOptionPane.showMessageDialog(null,""+e1);
		  }
		  try
		  {
			  sql="Select b_time  from batch";
				stmt=con.createStatement();
				res=stmt.executeQuery(sql);
				while(res.next())
				{
					  String s2=(res.getString(1));
				       c3.addItem(s2);
				}
		  }
		  catch(Exception e1)
		  {
			  JOptionPane.showMessageDialog(null,""+e1);
		  }
	}
	catch(Exception e1)
	{
		JOptionPane.showMessageDialog(null,""+e1);
	}
	
}
	public static void main(String[] args) 
	{
		new Enquiry();
	}


	public void actionPerformed(ActionEvent e) 
	{
		if(b1==e.getSource())
		{
			try
			{
				stmt=con.createStatement();
				res=stmt.executeQuery("select stud_id from enquiry1");
				int i=0;
				while(res.next())
				{
					i=Integer.parseInt(res.getString("stud_id"));
				}
				i++;
				    t1.setText(""+i);
				    t2.setText("");
				    t3.setText("");
				    t4.setText("");
				    t5.setText("");		
				    t6.setText("");
			}
			catch(Exception e2)
			{
				JOptionPane.showMessageDialog(null, ""+e2);
			}
		}
		if(b2==e.getSource())
		{
			try
			{
				stud_id=Integer.parseInt(t1.getText());
				date1=t2.getText();
				stud_name=t3.getText();
				stud_add=t4.getText();
				stud_gender= c1.getSelectedItem().toString();
				stud_phno=t5.getText();
				stud_email=t6.getText();
				co_name= c2.getSelectedItem().toString();
				Batch_time=c3.getSelectedItem().toString();
				mode=c4.getSelectedItem().toString();
				sql="insert into enquiry1 value ("+stud_id+",'"+date1+"','"+stud_name+"','"+stud_add+"','"+stud_gender+"','"+stud_phno+"','"+stud_email+"','"+co_name+"','"+Batch_time+"','"+mode+"')";
				stmt=con.createStatement();
				k=stmt.executeUpdate(sql);
				if(k>0)
				JOptionPane.showMessageDialog(null,"Insert Succ");
				else
				JOptionPane.showMessageDialog(null,"Error");
			}
			catch(Exception e2)
			{
				JOptionPane.showMessageDialog(null, ""+e2);
			}
			t1.setText("");
			t2.setText("");
			t3.setText("");
			t4.setText("");
			t5.setText("");		
			t6.setText("");		
		}
		if(b3==e.getSource())
		{
			try
			{
				stud_id=Integer.parseInt(t1.getText());
				date1=t2.getText();
				stud_name=t3.getText();
				stud_add=t4.getText();
				stud_gender= c1.getSelectedItem().toString();
				stud_phno=t5.getText();
				stud_email=t6.getText();
				co_name= c2.getSelectedItem().toString();
				Batch_time=c3.getSelectedItem().toString();
				mode=c4.getSelectedItem().toString();
				sql="Update enquiry1 set date1='"+date1+"', stud_name='"+stud_name+"',stud_add='"+stud_add+"',stud_gender='"+stud_gender+"',stud_ph='"+stud_phno+"',stud_email='"+stud_email+"',co_name='"+co_name+"',batch_time='"+Batch_time+"',mode='"+mode+"'  where stud_id="+stud_id+"";
				stmt=con.createStatement();
				k=stmt.executeUpdate(sql);
				if(k>0)
				JOptionPane.showMessageDialog(null, "Update Successfully");
				else
				JOptionPane.showMessageDialog(null,"Check eid");
				stmt.close();
				t1.setText("");
				t2.setText("");
				t3.setText("");
				t4.setText("");
				t5.setText("");		
				t6.setText("");
			}
			catch(Exception e2)
			{
				JOptionPane.showMessageDialog(null, ""+e2);
			}
		}
		if(b4==e.getSource())
		{
			try
			{
				stud_id=Integer.parseInt(t1.getText());	
				sql="Delete from enquiry1  where stud_id="+stud_id+"";
				stmt=con.createStatement();
				k=stmt.executeUpdate(sql);
				if(k>0)
				JOptionPane.showMessageDialog(null, "Delete successfully");
				else
				JOptionPane.showMessageDialog(null, "Check eid");
				stmt.close();
				t1.setText("");
			}
			catch(Exception e2)
			{
				JOptionPane.showMessageDialog(null, ""+e2);
			}
		}
		if(b5==e.getSource())
		{
			int r=0;
			model.setRowCount(0);
			try
			{
				sql="Select * from enquiry1";
				stmt=con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
				ResultSet res=stmt.executeQuery(sql);
				while(res.next())
				{
					model.insertRow(r++,new Object[] {res.getInt(1),res.getString(2),res.getString(3),res.getString(4),res.getString(5),res.getString(6),res.getString(7),res.getString(8),res.getString(9),res.getString(10)});
				}
			}
			catch(Exception e2)
			{
				JOptionPane.showMessageDialog(null, ""+e2);
			}
		}
	}

}