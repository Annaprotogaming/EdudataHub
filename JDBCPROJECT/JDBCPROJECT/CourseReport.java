package JDBCPROJECT;

// Accept course name from user and display total number of admission for that course
import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.plaf.*;
import javax.swing.table.*;
import java.sql.*;
public class CourseReport extends JFrame implements ActionListener
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
     
      CourseReport()
	  {
            
    	  setSize(590,580);
    	  setLayout(null);
    	  setTitle("Course Report");
    	 //setResizable(false);
    	  setLocation(300,160);
	    	
    	  lrno=new JLabel("Course Name:");
    	  lrno.setBounds(30,70,100,25);
    	  add(lrno);	
    	  
    	  tdate=new JTextField();
    	  tdate.setBounds(130,70,200,25);
    	  add(tdate);
	    	
    	  
    	  bopen=new  JButton("Display");
    	  bopen.setBounds(70,150,90,25);
    	  bopen.addActionListener(this);	        
    	  add(bopen);
	    	
    	  // Table
    	  scrlPane.setBounds(0,230,590,200);
    	  add(scrlPane);
    	  tabGrid.setFont(new Font ("Verdana",0,13));
    
    	// course_id course_name  course_period onetime_fees installment_fees
    	  model.addColumn("course_id");
    	  model.addColumn("course_name");
    	  model.addColumn("course_period");
    	  model.addColumn("onetime_fees");
    	  model.addColumn("installment_fees");
    	  

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
	                     
	                     String co_name=tdate.getText();
	                   
						// course_id course_name  course_period onetime_fees installment_fees
                         String qry= "Select * from course where co_name='"+co_name+"'";
	                     rs = stmt.executeQuery(qry);
	                     
	                     while(rs.next())
	                     {
	                     	model.insertRow(r++, new Object[]{rs.getInt(1),rs.getString(2),rs.getString(3),rs.getInt(4),rs.getInt(5) });
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
	    	
				new CourseReport();
				
		}	
	    		    
}
