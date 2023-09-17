package JDBCPROJECT;

// Accept start date and end date from user and display total number of admission during that period
import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.plaf.*;
import javax.swing.table.*;
import java.sql.*;
public class AdmissionFormReport extends JFrame implements ActionListener
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
     
      AdmissionFormReport()
	  {
            
    	  setSize(590,580);
    	  setLayout(null);
    	  setTitle("Admission Form Report");
    	 // setResizable(false);
    	  setLocation(300,160);
	    	
    	  lrno=new JLabel("Start Date:");
    	  lrno.setBounds(10,70,100,25);
    	  add(lrno);	
    	  
    	  tdate=new JTextField();
    	  tdate.setBounds(100,70,200,25);
    	  add(tdate);
	    	
    	  lfno=new JLabel("End Date:");
    	  lfno.setBounds(10,100,100,25);
    	  add(lfno);
    	  
    	  tdate1=new JTextField();
    	  tdate1.setBounds(100,100,200,25);
    	  add(tdate1);
    	  
    	 bopen=new  JButton("Open");
    	  bopen.setBounds(70,180,90,25);
    	  bopen.addActionListener(this);	        
    	  add(bopen);
	    	
    	  // Table
    	  scrlPane.setBounds(0,230,590,200);
    	  add(scrlPane);
    	  tabGrid.setFont(new Font ("Verdana",0,13));
    
    	  model.addColumn("Add_id");
    	  model.addColumn("Date1");
    	  model.addColumn("Stu_id");
    	  model.addColumn("Stu_name");
    	  model.addColumn("Email_id");
    	  model.addColumn("Stu_add");
    	  model.addColumn("Stu_gender");
    	  model.addColumn("Co_id");
    	  model.addColumn("B_id");
    	  model.addColumn("F_TYPE");
    	  model.addColumn("FEE");

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
	                     
	                     String stdt=tdate.getText();
	                     String enddt=tdate1.getText();
                         String qry= "Select * from admission where Date1>='"+stdt+"' and Date1<='"+enddt+"' ";
	                     rs = stmt.executeQuery(qry);
	                     
	                     while(rs.next())
	                     {
	                     	model.insertRow(r++, new Object[]{rs.getString(1),rs.getString(4),rs.getString(3),rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8),rs.getString(9),rs.getString(10),rs.getString(11),rs.getString(12)  });
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
	    	
				new AdmissionFormReport();
				
		}	
	    		    
}
