package JDBCPROJECT;

// Accept course name from user and display total number of enquiry for that course
import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.plaf.*;
import javax.swing.table.*;
import java.sql.*;
public class EnquiryReport extends JFrame implements ActionListener
{
      JLabel lrno,lfno;
      JTextField tdate,tdate1;
      JButton bopen;

      Font fo=new Font("vERDANA" ,Font.BOLD,20);	
      Connection con;
      Statement st;
      ResultSet rs;
      String test,test1;

      //Table
      DefaultTableModel model = new DefaultTableModel();
      JTable tabGrid = new JTable(model);
      JScrollPane scrlPane = new JScrollPane(tabGrid);
     
      EnquiryReport()
	  {
            
    	  setSize(590,580);
    	  setLayout(null);
    	  setTitle("Enquiry Report");
    	 //setResizable(false);
    	  setLocation(300,160);
	    	
    	  lrno=new JLabel("Course Name:");
    	  lrno.setBounds(30,70,100,25);
    	  add(lrno);	
    	  
    	  tdate=new JTextField();
    	  tdate.setBounds(130,70,100,25);
    	  add(tdate);
	    	
    	  
    	  bopen=new  JButton("Display");
    	  bopen.setBounds(70,150,90,25);
    	  bopen.addActionListener(this);	        
    	  add(bopen);
	    	
    	  // Table
    	  scrlPane.setBounds(0,230,590,200);
    	  add(scrlPane);
    	  tabGrid.setFont(new Font ("Verdana",0,13));
    	  
    	  model.addColumn("Enq_id");
    	  model.addColumn("Date1");
    	  model.addColumn("Stu_name");
    	  model.addColumn("E_id");
    	
    	  model.addColumn("Stu_add");
    	  model.addColumn("Stu_gender");
    	  model.addColumn("stu_phno");
    	  model.addColumn("co_id");
    	  model.addColumn("b_id");
    	 

    	  setVisible(true);
     
	    }
	    public void actionPerformed(ActionEvent ae)
	    {
	    	
	    	if(ae.getSource()==bopen)
	    	{
	                try
	               	{
	                	 int r=0;
	               	     Class.forName("com.mysql.jdbc.Driver");
	                     con=DriverManager.getConnection("jdbc:mysql://localhost:3306/institute","root","");
	                     Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
	                     
	                     String course_name=tdate.getText();
	                    
                         String qry= "Select * from enquiry where co_id='"+course_name+"'";
	                     rs = stmt.executeQuery(qry);
	                    
	                     while(rs.next())
	                     {
	                     	model.insertRow(r++, new Object[]{rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8),rs.getString(9) });
	                     }

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
	    	
				new EnquiryReport();
				
		}	
	    		    
}
