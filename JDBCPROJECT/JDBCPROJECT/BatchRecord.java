 package JDBCPROJECT;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.ProcessHandle.Info;
import java.sql.*;
import javax.swing.*;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class BatchRecord  extends JFrame implements ActionListener
{
	
	
	
	private static final String BatchRecord = null;
	int b_id,date,tabGrid,k;

	
	Connection cn;
	Statement stmt;
	String co_name,date1,b_time,t_name,sql;
	JLabel lbl1,lbl2,lbl3,lbl4,lbl5,lbl6;
	JTextField txt1 ,txt2 ,txt3;
	JComboBox c1,c2 ,c3;
	JButton b1,b2,b3,b4,b5;
	JScrollBar scrl;
	Font f1=new Font ("algerian",Font.CENTER_BASELINE,18);
	DefaultTableModel model = new DefaultTableModel();
    JTable tabGrid1 = new JTable(model);
    JScrollPane scrlPane = new JScrollPane( tabGrid1);
	public BatchRecord() 
	{
		setSize (300,300);
		setVisible (true);
		setLayout (null);
		setTitle (BatchRecord);
	
		
		getContentPane().setBackground(Color.black);
		lbl6=new JLabel("Batch Record");
		lbl6.setBounds(380,50,200,40);
		add(lbl6);
		lbl6.setForeground(Color.red);
		lbl6.setFont(f1);
		
		
	    lbl1=new JLabel("Batch_id:");
	    lbl1.setBounds(200,150,100,30);
	    lbl1.setForeground(Color.red);
	    add (lbl1);
	   
	   
	    txt1=new JTextField ("");
	    txt1.setBounds(320,150,100,30);
	    add(txt1);
	    
	    lbl2=new JLabel ("course Name : ");
	    lbl2.setForeground(Color.red);
	    lbl2.setBounds(480,150,100,30);
	    add(lbl2);
	    
	    c1=new JComboBox ();
	    c1.setBounds(590,150,120,30);
        add(c1);
	    
        lbl3=new JLabel ("Start Date :");
        lbl3.setBounds(200,200,100,30);
        lbl3.setForeground(Color.red);
        add(lbl3) ;
        
         txt2 = new JTextField ("");
         txt2.setBounds(320,200,100,30);
         add(txt2);
        
         lbl4=new JLabel ("Batch Time :");
         lbl4.setBounds(480,200,80,30);
         lbl4.setForeground(Color.red);
         add(lbl4);
         
         c2=new JComboBox ();
         c2.setBounds(590,200,120,30);
         add(c2);
         
         lbl5=new JLabel ("Trainer Name:");
         lbl5.setBounds( 480,250,100,30);
         lbl5.setForeground(Color.red);
         add(lbl5);
         
         c3=new JComboBox ();
         c3.setBounds(590,250,120,30);
         add(c3);
         
         
         b1=new JButton ("New");
         b1.setBounds(220,350,100,30);
         add(b1);
	  
         b2=new JButton ("Insert");
         b2.setBounds(390,350,100,30);
	     add(b2);
	     
	     b3=new JButton ("Update");
	     b3.setBounds(560,350,100,30);
	     add(b3);
	     
	     b4=new JButton ("Delete");
	     b4.setBounds(330,420,100,30);
	     add(b4);
	     
	     b5=new JButton ("Display All");
	     b5.setBounds(470,420,100,30);
	     add(b5);
	
	     try 
	     {
				 Class.forName("com.mysql.jdbc.Driver");
			 JOptionPane.showMessageDialog(null, "Driver reg successfully");
			 cn=DriverManager.getConnection("jdbc:mysql://localhost:3306/institute","root","");
			 JOptionPane.showMessageDialog(null, "Connection successful");
			 try
			 {
				String sql = "select co_name  from Batch" ;
				stmt=cn.createStatement();
				ResultSet res = stmt.executeQuery(sql);
				while(res.next())
				{
					String s1=res.getString(1);
					c1.addItem(s1);
				}
			 
	     	}
			 catch(Exception e1)
			 {
				 JOptionPane.showMessageDialog(null, e1); 
			 }
	
			 
			 
			 try
			 {
				sql="select b_time  from Batch" ;
				stmt=cn.createStatement();
				ResultSet res = stmt.executeQuery(sql);
				while(res.next())
				{
					String s2=res.getString(1);
					c2.addItem(s2);
				}
			 
	     	}
			 catch(Exception e1)
			 {
				 JOptionPane.showMessageDialog(null, e1); 
			 }
			 try
			  {
				  sql="Select t_name  from batch";
					stmt=cn.createStatement();
					ResultSet res = stmt.executeQuery(sql);
					while(res.next())
					{
						  String s1=(res.getString(1));
					       c3.addItem(s1);
					}
			  }
			  catch(Exception e2)
			  {
				  JOptionPane.showMessageDialog(null,""+e2);
			  }
	 
	     }
	     catch(Exception e1)
		{
			JOptionPane.showMessageDialog(null, e1);
		}
		

	    scrlPane.setBounds(150,500,627,200);
        add(scrlPane);
        tabGrid1.setFont(new Font ("Verdana",0,13));
       
        
        model.addColumn("b_id");
        model.addColumn("co_Name ");
        model.addColumn("Start_date");
        model.addColumn("b_time");
        model.addColumn("T_name");
   
	    b1.addActionListener(this);
	    b2.addActionListener(this);
	    b3.addActionListener(this);
	    b4.addActionListener(this);
	    b5.addActionListener(this);
	   
	
	}
	
	public static void main(String[] args) 
	{
		new BatchRecord();
		
	}

public void actionPerformed(ActionEvent e)
{
		if(b1==e.getSource())
		{
				try
				{
	                stmt=cn.createStatement();
					ResultSet res = stmt.executeQuery("select b_id from batch");
					int i=1;
					while(res.next())
					{
						i=Integer.parseInt(res.getString("b_id"));
					}
					i++;
					txt1.setText(""+i);
					txt2.setText("");
				}
				catch(Exception e4)
				{
					JOptionPane.showMessageDialog(null,""+e4);		
				}
		}
			
			if(b2==e.getSource())
			{
					try
					{
						b_id=Integer.parseInt(txt1.getText());
						co_name=c1.getSelectedItem().toString();
						date1=(txt2.getText());
						b_time=c2.getSelectedItem().toString();
						t_name=c3.getSelectedItem().toString();
						sql="insert into batch values("+b_id+",'"+co_name+"','"+date1+"','"+b_time+"','"+t_name+"')";
						stmt=cn.createStatement();
						int k=stmt.executeUpdate(sql);
						if(k>0)
						JOptionPane.showMessageDialog(null, "Insert successfully");
						else
						JOptionPane.showMessageDialog(null,"Error");
						stmt.close();
						txt1.setText("");
					}
					catch(Exception e4)
					{
						JOptionPane.showMessageDialog(null,""+e4);	
					}
			}
					
					if(b3==e.getSource())
					{
						try
						{
							b_id=Integer.parseInt(txt1.getText());
							co_name=c1.getSelectedItem().toString();
							date1=txt2.getText();
							b_time=c2.getSelectedItem().toString();
							t_name=c3.getSelectedItem().toString();
							sql="Update  batch set co_name='"+co_name+"' ,b_time='"+b_time+"',date1='"+date1+"',t_name='"+t_name+"' where b_id="+b_id+"";
							stmt=cn.createStatement();
							int k=stmt.executeUpdate(sql);
							if(k>0)
							JOptionPane.showMessageDialog(null, "Update successfully");
							else
							JOptionPane.showMessageDialog(null,"Check cid");
							txt1.setText("");
							c1.setToolTipText("");
							txt2.setText("");
							c2.setToolTipText("");
							c3.setToolTipText("");
							
						}
						catch(Exception e4)
						{
							JOptionPane.showMessageDialog(null,""+e4);		
						}
					}
						if(b4==e.getSource())
						{
							try
							{
								b_id=Integer.parseInt(txt1.getText());
								sql="Delete from batch where b_id="+b_id+"";
								stmt=cn.createStatement();
								 int k=stmt.executeUpdate(sql);
								if(k>0)
								JOptionPane.showMessageDialog(null, "Delete successfully");
								else
								JOptionPane.showMessageDialog(null,"Check cid");
								stmt.close();
								txt1.setText("");
							}
							catch(Exception e4)
							{
								JOptionPane.showMessageDialog(null,""+e4);	
							}
						}
				if(b5==e.getSource())
				{
				int r=0;
				model.setRowCount(0);
				try
				{
				sql="Select * from batch";
				stmt=cn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
				ResultSet res=stmt.executeQuery(sql);
				while(res.next())
				{
					model.insertRow(r++,new Object[] {res.getInt(1),res.getString(2),res.getString(3),res.getString(4),res.getString(5)});
				}
				}
				catch(Exception e4)
				{
				JOptionPane.showMessageDialog(null,""+e4);	
				}
			}
					
}
}
		
		
		
	


