package JDBCPROJECT;
import java.sql.*;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
public class Admission extends JFrame implements ActionListener {
    int Add_id,stu_id;
    String Date1,stu_name,Email_id,stu_add,stu_phno,stu_gender,co_name,b_time,feetype,fee,paid_Fee,strdate,Admission_Fee,Paid_Fee;
	GregorianCalendar calendar;

	JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9,l10,l11,l12,l13,l14,l15,l16;
	JTextField t1,t2,t3,t4,t5,t6,t7,t8,t9,t10;
	JComboBox c1,c2,c3,c4,c5;
	JButton b1,b2,b3,b4,b5;
	Connection con;
	ResultSet res;
	String sql;
	Statement stmt;
	int k;
	DefaultTableModel model=new DefaultTableModel();
	JTable tabGrid=new JTable(model);
	JScrollPane scrlPane=new JScrollPane(tabGrid);
	String s1[]= {"Male","Female"};
	String s2[]= {"Onetime","Installation"};
	Font f1=new Font ("algerian",Font.CENTER_BASELINE,26);
	public Admission() 
	{
		setLayout(null);
		setSize(800,800);
		setVisible(true);
		getContentPane().setBackground(Color.black);
		
		
		
		
		l13=new JLabel("Admission");
		l13.setBounds(260,40,300,30);
		l13.setForeground(Color.red);
		l13.setFont(f1);
		add(l13);
		
		l1=new JLabel("Add_id             :");
		l1.setBounds(100,100, 100, 30);
		l1.setForeground(Color.red);
		add(l1);
		
		t1=new JTextField();
		t1.setBounds(220,100,100,30);
		add(t1);
		
		l2=new JLabel("Date1              :");
		l2.setBounds(350,100, 100, 30);
		l2.setForeground(Color.red);
		add(l2);
		
		t2=new JTextField();
		t2.setBounds(470,100,100,30);
		add(t2);
		
		l3=new JLabel("Stu_id              :");
		l3.setBounds(100,150, 100, 30);
		l3.setForeground(Color.red);
		add(l3);
		
		c1=new JComboBox();
		c1.setBounds(220,150,100,30);
		add(c1);
		
		l4=new JLabel("Stu_name       :");
		l4.setBounds(350,150, 100, 30);
		l4.setForeground(Color.red);
		add(l4);
		
		t3=new JTextField();
		t3.setBounds(470,150,100,30);
		add(t3);
		
		l5=new JLabel("Email_id          :");
		l5.setBounds(100,200, 100, 30);
		l5.setForeground(Color.red);
		add(l5);
		
		t4=new JTextField();
		t4.setBounds(220,200,100,30);
		add(t4);
		
		l6=new JLabel("Stu_add          :");
		l6.setBounds(350,200, 100, 30);
		l6.setForeground(Color.red);
		add(l6);
		
		t5=new JTextField();
		t5.setBounds(470,200,100,30);
		add(t5);
		
		l7=new JLabel("Stu_phno        :");
		l7.setBounds(100,250, 100, 30);
		l7.setForeground(Color.red);
		add(l7);
		
		t6=new JTextField();
		t6.setBounds(220,250,100,30);
		add(t6);
		
		l8=new JLabel("Stu_gender    :");
		l8.setBounds(350,250, 100, 30);
		l8.setForeground(Color.red);
		add(l8);
		
		c2=new JComboBox(s1);
		c2.setBounds(470,250,100,30);
		add(c2);
		
		l9=new JLabel("Co_name        :");
		l9.setBounds(100,300, 100, 30);
		l9.setForeground(Color.red);
		add(l9);
		
		c3=new JComboBox();
		c3.setBounds(220,300,100,30);
		add(c3);
		
		l10=new JLabel("B_time            :");
		l10.setBounds(350,300, 100, 30);
		l10.setForeground(Color.red);
		add(l10);
		
		c4=new JComboBox();
		c4.setBounds(470,300,100,30);
		add(c4);
		
		l11=new JLabel("FeeType         :");
		l11.setBounds(100,350, 100, 30);
		l11.setForeground(Color.red);
		add(l11);
		
		c5=new JComboBox(s2);
		c5.setBounds(220,350,100,30);
		add(c5);
		
		l12=new JLabel("Fee                  :");
		l12.setBounds(350,350, 100, 30);
		l12.setForeground(Color.red);
		add(l12);
		t7=new JTextField();
		t7.setBounds(470,350,100,30);
		add(t7);
		
		
		l14=new JLabel("Paid fee           :");
		l14.setBounds( 350,400,100,30);
		l14.setForeground(Color.red);
		add(l14);
		
		
		t8=new JTextField();
		t8.setBounds(470,400,100,30);
		add(t8);
		
		l15=new JLabel("Admission_Fee          :");
		l15.setBounds(100,400,100,30);
		l15.setForeground(Color.red);
		add(l15);
		
		t9=new JTextField();
		t9.setBounds(220,400,100,30);
		add(t9);
		
		
		
		
		
		
		b1=new JButton("New");
		b1.setBounds(140,480,100,30);
		add(b1);
		
		b2=new JButton("Insert");
		b2.setBounds(280,480,100,30);
		add(b2);
		
		b3=new JButton("Update");
		b3.setBounds(420,480,100,30);
		add(b3);
		
		b4=new JButton("Delete");
		b4.setBounds(210,530,100,30);
		add(b4);
		
		b5=new JButton("Display");
		b5.setBounds(350,530,100,30);
		add(b5);
		
		scrlPane.setBounds(10,600,1500,150);
		add(scrlPane);
		model.addColumn("Add_id");
		model.addColumn("Date1");
		model.addColumn("stu_id");
		model.addColumn("stu_name");
		model.addColumn("Email_id");
		model.addColumn("stu_add");
		model.addColumn("stu_phno");
		model.addColumn("stu_gender");
		model.addColumn("co_name");
		model.addColumn("b_time");
		model.addColumn("feetype");
		model.addColumn("fee");
		model.addColumn("Admission_fee");
		model.addColumn("Paid_fee");
		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
		b4.addActionListener(this);
		b5.addActionListener(this);
		
	
		
		Date Date = new Date();
        calendar=new GregorianCalendar();
        calendar.setTime(Date);
        strdate=calendar.get(Calendar.DATE)+"/"+(calendar.get(Calendar.MONTH)+1)+"/"+calendar.get(Calendar.YEAR);
        t2.setText(strdate);
		
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			JOptionPane.showInternalMessageDialog(null, "Driver reg Succ");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/institute","root","");
			JOptionPane.showInternalMessageDialog(null, "Connection  Succ");
			try
			{
				sql="Select stud_id from enquiry1";
				stmt=con.createStatement();
				res=stmt.executeQuery(sql);
				while(res.next())
				{
					String s1=(res.getString(1));
					c1.addItem(s1);
				}
			}
			catch(Exception e1)
			{
				JOptionPane.showInternalMessageDialog(null, ""+e1);
			}
			
			t1.addKeyListener(new KeyAdapter()
		    {
		        public void keyTyped(KeyEvent e) {
		    	char c = e.getKeyChar();
		      		if (!((Character.isDigit(c) || (c == KeyEvent.VK_BACK_SPACE) || (c == KeyEvent.VK_DELETE))))
		      		{
		        	 JOptionPane.showMessageDialog(null, "Please enter a numerical value");
		           	 e.consume();
		      		}
		    		}
		  		    });
			
			
			t2.addKeyListener(new KeyAdapter()
		    {
		        public void keyTyped(KeyEvent e) {
		    	char c = e.getKeyChar();
		      		if (!((Character.isDigit(c) || (c == KeyEvent.VK_BACK_SPACE) || (c == KeyEvent.VK_DELETE))))
		      		{
		        	 JOptionPane.showMessageDialog(null, "Please enter a numerical value");
		           	 e.consume();
		      		}
		    		}
		  		    });
			
			
			t3.addKeyListener(new KeyAdapter()
		     {
		         public void keyTyped(KeyEvent e) {
		     	char c = e.getKeyChar();
		       		if (((Character.isDigit(c))))
		       	//if(!((c>=65 && c<=90) || (c>=97 && c<=122)))
		       		{
		         	 JOptionPane.showMessageDialog(null, "Please enter Alphabets");
		            	 e.consume();
		       		}
		     		}
		   		    });
			
			t4.addKeyListener(new KeyAdapter()
		    {
		        public void keyTyped(KeyEvent e5) {
		    	char c = e5.getKeyChar();
		      		//if (((Character.isDigit(c))))
		      	if(!((c>=65 && c<=90) || (c>=97 && c<=122)||(c==32)||(c==64)||(c==46)||(c == KeyEvent.VK_BACK_SPACE)))
		      		{
		        	 JOptionPane.showMessageDialog(null, "Please enter Alphabets");
		           	 e5.consume();
		      		}
		    		}
		  		    });
			
			
			
			
			
			t5.addKeyListener(new KeyAdapter()
		    {
		        public void keyTyped(KeyEvent e5) {
		    	char c = e5.getKeyChar();
		      		//if (((Character.isDigit(c))))
		      	if(!((c>=65 && c<=90) || (c>=97 && c<=122)||(c==32)||(c==64)||(c==46)||(c == KeyEvent.VK_BACK_SPACE)))
		      		{
		        	 JOptionPane.showMessageDialog(null, "Please enter Alphabets");
		           	 e5.consume();
		      		}
		    		}
		  		    });
			
			t6.addKeyListener(new KeyAdapter()
		    {
		        public void keyTyped(KeyEvent e) {
		    	char c = e.getKeyChar();
		      		if (!((Character.isDigit(c) || (c == KeyEvent.VK_BACK_SPACE) || (c == KeyEvent.VK_DELETE))))
		      		{
		        	 JOptionPane.showMessageDialog(null, "Please enter a numerical value");
		           	 e.consume();
		      		}
		    		}
		  		    });
			
			

			t7.addKeyListener(new KeyAdapter()
		    {
		        public void keyTyped(KeyEvent e) {
		    	char c = e.getKeyChar();
		      		if (!((Character.isDigit(c) || (c == KeyEvent.VK_BACK_SPACE) || (c == KeyEvent.VK_DELETE))))
		      		{
		        	 JOptionPane.showMessageDialog(null, "Please enter a numerical value");
		           	 e.consume();
		      		}
		    		}
		  		    });
			
			

			try
			{
				sql="Select co_name from course";
				stmt=con.createStatement();
				res=stmt.executeQuery(sql);
				while(res.next())
				{
					String s1=res.getString(1);
					c3.addItem(s1);
				}
			}
			catch(Exception e1)
			{
				JOptionPane.showInternalMessageDialog(null, ""+e1);
			}
			try
			{
				sql="Select b_time from batch";
				stmt=con.createStatement();
				res=stmt.executeQuery(sql);
				while(res.next())
				{
					String s1=res.getString(1);
					c4.addItem(s1);
				}
			}
			catch(Exception e1)
			{
				JOptionPane.showInternalMessageDialog(null, ""+e1);
			}
		}
		catch(Exception e1)
		{
			JOptionPane.showInternalMessageDialog(null, ""+e1);
		}
	}
	public static void main(String[] args)
	{
		new Admission();
	}


	public void actionPerformed(ActionEvent e) 
	{
		if(b1==e.getSource())
		{
			try
			{
				stmt=con.createStatement();
				sql="select Add_id from admission";
				res=stmt.executeQuery(sql);
				int i=1;
				while(res.next())
				{
					i=Integer.parseInt(res.getString(1));
				}
				i++;
				t1.setText(""+i);
			} 
			catch(Exception e3)
			{
				JOptionPane.showMessageDialog(null, ""+e3);
			}
		}
		if(b2==e.getSource())
		{
			try
			{
				Add_id=Integer.parseInt(t1.getText());
				Date1=t2.getText();
				stu_id=Integer.parseInt(c1.getSelectedItem().toString());
				stu_name=t3.getText();
				Email_id=t4.getText();
				stu_add=t5.getText();
				stu_phno=t6.getText();
				stu_gender=(c2.getSelectedItem().toString());
				co_name=c3.getSelectedItem().toString();
				b_time=c4.getSelectedItem().toString();
				feetype=c5.getSelectedItem().toString();
				fee=t7.getText();
				Admission_Fee=t8.getText();
				paid_Fee=t9.getText();
				sql="Insert into admission value("+Add_id+",'"+Date1+"','"+stu_id+"','"+stu_name+"','"+Email_id+"','"+stu_add+"','"+stu_phno+"','"+stu_gender+"','"+co_name+"','"+b_time+"','"+feetype+"','"+fee+"','"+Admission_Fee+"','"+Paid_Fee+"')";
				stmt=con.createStatement();
				k=stmt.executeUpdate(sql);
				if(k>0)
				    JOptionPane.showMessageDialog(null, "Insert succ");
				else
					JOptionPane.showMessageDialog(null, "Error");
			}
			catch(Exception e3)
			{
				JOptionPane.showMessageDialog(null,""+e3);
			}
			t1.setText("");
			t2.setText("");
			t3.setText("");
			t4.setText("");
			t5.setText("");
			t6.setText("");
			t7.setText("");
		}
		if(b3==e.getSource())
		{
			try
			{
				Add_id=Integer.parseInt(t1.getText());
				Date1=t2.getText();
				stu_id=Integer.parseInt(c1.getSelectedItem().toString());
				stu_name=t3.getText();
				Email_id=t4.getText();
				stu_add=t5.getText();
				stu_phno=t6.getText();
				stu_gender=(c2.getSelectedItem().toString());
				co_name=c3.getSelectedItem().toString();
				b_time=c4.getSelectedItem().toString();
				feetype=c5.getSelectedItem().toString();
				fee=t7.getText();
				Admission_Fee=t8.getText();
				paid_Fee=t9.getText();
				sql="Update admission set Date1="+Date1+",stu_id='"+stu_id+"', stu_name='"+stu_name+"',Email_id='"+Email_id+"',stu_add='"+stu_add+"',stu_phno='"+stu_phno+"',feetype='"+feetype+"',fee='"+fee+"' ,Admission_Fee ='"+Admission_Fee+"',Paid_Fee='"+Paid_Fee+"'where Add_id="+Add_id+"";
			    stmt=con.createStatement();
			    k=stmt.executeUpdate(sql);
			    if(k>0)
				    JOptionPane.showMessageDialog(null, "Update succ");
				else
					JOptionPane.showMessageDialog(null, "Check Add_id");
			}
			catch(Exception e3)
			{
				JOptionPane.showMessageDialog(null,""+e3);	
			}
			t1.setText("");
			t2.setText("");
			t3.setText("");
			t4.setText("");
			t5.setText("");
			t6.setText("");
			t7.setText("");
		}
		if(b4==e.getSource())
		{
			try
			{
				Add_id=Integer.parseInt(t1.getText());
				sql="Delete from admission where Add_id="+Add_id+"";
				stmt=con.createStatement();
				k=stmt.executeUpdate(sql);
				  if(k>0)
					    JOptionPane.showMessageDialog(null, "Delete succ");
					else
						JOptionPane.showMessageDialog(null, "Check Add_id");
			}
			catch(Exception e3)
			{
				JOptionPane.showMessageDialog(null,""+e3);	
			}
		}
		if(b5==e.getSource())
		{
			int r=0;
			model.setRowCount(0);
			try
			{
				stmt=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
				sql="Select *  from admission";
				res=stmt.executeQuery(sql);
				while(res.next())
				{
					model.insertRow(r++,new Object[] {res.getInt(1),res.getString(2),res.getString(3),res.getString(4),res.getString(5),res.getString(6),res.getString(7),res.getString(8),res.getString(9),res.getString(10),res.getString(11),res.getString(12),res.getString(13),res.getString(14)});
				}
			}
			catch(Exception e3)
			{
				JOptionPane.showMessageDialog(null,""+e3);	
			}
		}
	}

}
