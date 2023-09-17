package JDBCPROJECT;

// Accept student name from user and display total paid fee of that student
import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.plaf.*;
import javax.swing.table.*;
import java.sql.*;
public class BillReport extends JFrame implements ActionListener
{
      JLabel lrno,lfno;
      JTextField tdate,tdate1;
      JButton bopen;

      String s1;
      
      Font fo=new Font("vERDANA" ,Font.BOLD,20);	
      Connection con;
      Statement st;
      ResultSet rs;
      String test,test1;

      //Table
      DefaultTableModel model = new DefaultTableModel();
      JTable tabGrid = new JTable(model);
      JScrollPane scrlPane = new JScrollPane(tabGrid);
     
      BillReport()
	  {
            
    	  setSize(590,580);
    	  setLayout(null);
    	  setTitle("Bill Report");
    	  setResizable(false);
    	  setLocation(300,160);
	    	
    	  lrno=new JLabel("Student Name:");
    	  lrno.setBounds(30,70,100,25);
    	  add(lrno);	
    	  
    	  tdate=new JTextField();
    	  tdate.setBounds(130,70,200,25);
    	  add(tdate);
	    	
    	  lfno=new JLabel("Total Paid Fee:");
    	  lfno.setBounds(30,130,100,25);
    	  add(lfno);
    	  
    	  tdate1=new JTextField();
    	  tdate1.setBounds(130,130,200,25);
    	  add(tdate1);
    	  
    	  bopen=new  JButton("Display");
    	  bopen.setBounds(150,200,90,25);
    	  bopen.addActionListener(this);	        
    	  add(bopen);

    	  setVisible(true);
     
	    }
	    public void actionPerformed(ActionEvent ae)
	    {
	    	
	    	if(ae.getSource()==bopen)
	    	{
	                try
	               	{
	                	float k=0;
	                	 int r=0;
	               	     Class.forName("com.mysql.jdbc.Driver");
	                     con=DriverManager.getConnection("jdbc:mysql://localhost:3306/institute","root","");
	                     Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
	                     
	                     String name=tdate.getText();
	                    
                         String qry= "Select sum(Paid_F) from bill where stu_name='"+name+"'";
                        
                         PreparedStatement st=con.prepareStatement(qry);
                         rs=st.executeQuery();
                         
                         while(rs.next())
                         {
                        	 s1=rs.getString(1);
                         }
                         tdate1.setText(s1);
                       //con.close();
	               			
	               	}
	               
	                catch(Exception ex)
	                {
	                	JOptionPane.showMessageDialog(null,"Error Occured : " + ex);
	                }
	   
	    	}
	    	  	
	   }
			
	    public static void main (String args[]) 
	    {
	    	
				new BillReport();
				
		}	
	    		    
}
