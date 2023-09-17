package JDBCPROJECT;
import java.sql.*;
import java.awt.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import java.awt.event.*;
public class Trainer extends JFrame implements ActionListener {

	int t_id,k;
	String t_name,t_add,Email_id,t_phno,t_gender,sql;
	Statement stmt;
	ResultSet res;
	Connection cn;
	JLabel lbl1,lbl2,lbl3,lbl4,lbl5,lbl6,lbl7;
	JTextField txt1,txt2,txt3,txt4,txt5,txt6;
	JButton b1,b2,b3,b4,b5;
	JComboBox c1; 
	String a1[]= {"Male","Female"};
	DefaultTableModel model=new DefaultTableModel();
	JTable tabGrid=new JTable(model);
	JScrollPane scrlPane=new JScrollPane(tabGrid);
	Font f1=new Font ("algerian",Font.CENTER_BASELINE,18);
	public Trainer()
	{
		setLayout(null);
		setSize(800,800);
		setVisible(true);
		getContentPane().setBackground(Color.black);
		
		lbl7=new JLabel("Trainer Details");
		lbl7.setBounds(230,50,300,30);
		lbl7.setForeground(Color.red);
		lbl7.setFont(f1);
		add(lbl7);
		
		lbl1=new JLabel("Trainer id :");
		lbl1.setBounds(150,100,100,30);
		lbl1.setForeground(Color.red);
		add(lbl1);
		
		txt1=new JTextField();
		txt1.setBounds(270, 100, 150, 30);
		add(txt1);
		
		lbl2=new JLabel("Trainer Name :");
		lbl2.setBounds(150,150,100,30);
		lbl2.setForeground(Color.red);
		add(lbl2);
		
		txt2=new JTextField();
		txt2.setBounds(270, 150, 150, 30);
		add(txt2);
		
		lbl3=new JLabel("Address :");
		lbl3.setBounds(150,200,100,30);
		lbl3.setForeground(Color.red);
		add(lbl3);
		
		txt3=new JTextField();
		txt3.setBounds(270, 200, 150, 30);
		add(txt3);
		
		lbl4=new JLabel("Email_id :");
		lbl4.setBounds(150,250,100,30);
		lbl4.setForeground(Color.red);
		add(lbl4);
		
		txt4=new JTextField();
		txt4.setBounds(270, 250, 150, 30);
		add(txt4);
		
		lbl5=new JLabel("Trainer ph :");
		lbl5.setBounds(150,300,100,30);
		lbl5.setForeground(Color.red);
		add(lbl5);
		
		txt5=new JTextField();
		txt5.setBounds(270, 300, 150, 30);
		add(txt5);
		
		lbl6=new JLabel("Gender :");
		lbl6.setBounds(150,350,100,30);
		lbl6.setForeground(Color.red);
		add(lbl6);
		 
		c1=new JComboBox(a1);
		c1.setBounds(270, 350, 100, 30);
		add(c1);
		
		b1=new JButton("New");
		b1.setBounds(110, 400, 100, 30);
		add(b1);
		
		b2=new JButton("Insert");
		b2.setBounds(230, 400, 100, 30);
		add(b2);
		
		b3=new JButton("Update");
		b3.setBounds(350, 400, 110, 30);
		add(b3);
		
		b4=new JButton("Delete");
		b4.setBounds(170, 450, 100, 30);
		add(b4);
		
		b5=new JButton("Display");
		b5.setBounds(290, 450, 100, 30);
		add(b5);
		
		scrlPane.setBounds(40,500,600,150);
		add(scrlPane);
		
		model.addColumn("t_id");
		model.addColumn("t_name");
		model.addColumn("t_add");
		model.addColumn("Email_id");
		model.addColumn("t_phno");
		model.addColumn("t_gender");
		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
		b4.addActionListener(this);
		b5.addActionListener(this);
		
		try
		{
			  Class.forName("com.mysql.jdbc.Driver");
			  JOptionPane.showMessageDialog(null, "Driver reg successfully");
			  cn=DriverManager.getConnection("jdbc:mysql://localhost:3306/institute","root","");
			  JOptionPane.showMessageDialog(null, "Connection successful");
		}
		catch(Exception e1)
		{
			JOptionPane.showMessageDialog(null, " "+e1);
		}
		
	}
	public static void main(String[] args) 
	{
		new Trainer();
	}

	
	public void actionPerformed(ActionEvent e) 
	{
		if(b1==e.getSource())
		{
			try
			{
				stmt=cn.createStatement();
				res=stmt.executeQuery("select t_id from teacher");
				int i=1;
				while(res.next())
				{
					i=Integer.parseInt(res.getString("t_id"));
				}
				i++;
				    txt1.setText(""+i);
				    txt2.setText("");
				    txt3.setText("");
				    txt4.setText("");
				    txt5.setText("");		
			}
			catch(Exception e2)
			{
				JOptionPane.showMessageDialog(null,""+ e2);
			}
		}
		if(b2==e.getSource())
		{
			try
			{
				t_id=Integer.parseInt(txt1.getText());
				t_name=txt2.getText();
				t_add=txt3.getText();
				Email_id=txt4.getText();
				t_phno=txt5.getText();
				t_gender= c1.getSelectedItem().toString();
				sql="insert into teacher value ("+t_id+",'"+t_name+"','"+t_add+"','"+Email_id+"','"+t_phno+"','"+t_gender+"')";
				stmt=cn.createStatement();
				k=stmt.executeUpdate(sql);
				if(k>0)
				JOptionPane.showMessageDialog(null,"Insert Succ");
				else
				JOptionPane.showMessageDialog(null,"Error");
			}
			catch(Exception e2)
			{
				JOptionPane.showMessageDialog(null,""+ e2);
			}
			txt1.setText("");
			txt2.setText("");
			txt3.setText("");
			txt4.setText("");
			txt5.setText("");		
		}
		if(b3==e.getSource())
		{
			try
			{
				t_id=Integer.parseInt(txt1.getText());
				t_name=txt2.getText();
				t_add=txt3.getText();
				Email_id=txt4.getText();
				t_phno=txt5.getText();
				t_gender=c1.getSelectedItem().toString();
				sql="Update teacher  set t_name='"+t_name+"',t_add='"+t_add+"',Email_id='"+Email_id+"',t_phno='"+t_phno+"',t_gender='"+t_gender+"'  where t_id="+t_id+"";
				stmt=cn.createStatement();
				k=stmt.executeUpdate(sql);
				if(k>0)
				JOptionPane.showMessageDialog(null, "Update Successfully");
				else
				JOptionPane.showMessageDialog(null,"Check eid");
				stmt.close();
				txt1.setText("");
				txt2.setText("");
				txt3.setText("");
				txt4.setText("");
				txt5.setText("");		
			}
			catch(Exception e2)
			{
				JOptionPane.showMessageDialog(null,""+ e2);
			}
		}
	if(b4==e.getSource())
	{
		try
		{
			t_id=Integer.parseInt(txt1.getText());	
			sql="Delete from teacher  where t_id="+t_id+"";
			stmt=cn.createStatement();
			k=stmt.executeUpdate(sql);
			if(k>0)
			JOptionPane.showMessageDialog(null, "Delete successfully");
			else
			JOptionPane.showMessageDialog(null, "Check eid");
			stmt.close();
			txt1.setText("");
		}
		catch(Exception e2)
		{
			JOptionPane.showMessageDialog(null,""+ e2);
		}
	}
	      if(b5==e.getSource())
	      {
				int r=0;
				model.setRowCount(0);
				try
				{
					sql="Select * from teacher";
					stmt=cn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
					ResultSet res=stmt.executeQuery(sql);
					while(res.next())
					{
						model.insertRow(r++,new Object[] {res.getInt(1),res.getString(2),res.getString(3),res.getString(4),res.getString(5),res.getString(6)});
					}
				}
				catch(Exception e2)
				{
					JOptionPane.showMessageDialog(null,""+ e2);
				}
	      }	
	}
}