package JDBCPROJECT;

//Accept trainer name and display trainer name,batch time and course name
import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.plaf.*;
import javax.swing.table.*;
import java.sql.*;
public class BatchReport3 extends JFrame implements ActionListener
{
      JLabel lrno,lfno;
      JTextField tdate,tdate1;
      JButton bopen;
      // JComboBox gender;

      Font fo=new Font("vERDANA" ,Font.BOLD,20);	
      Connection con;
      Statement st;
      ResultSet rs;
      String test,test1;

      //Table
      DefaultTableModel model = new DefaultTableModel();
      JTable tabGrid = new JTable(model);
      JScrollPane scrlPane = new JScrollPane(tabGrid);
     
      BatchReport3()
	  {
            
    	  setSize(590,580);
    	  setLayout(null);
    	  setTitle("Batch Report");
    	 // setResizable(false);
    	  setLocation(300,160);
	    	
    	  lrno=new JLabel("Trianer Name:");
    	  lrno.setBounds(10,70,100,25);
    	  add(lrno);	
    	  
    	  tdate=new JTextField();
    	  tdate.setBounds(100,70,200,25);
    	  add(tdate);
	    	
    	 
    	  
    	 bopen=new  JButton("Display");
    	  bopen.setBounds(70,180,90,25);
    	  bopen.addActionListener(this);	        
    	  add(bopen);
	    	
    	  // Table
    	  scrlPane.setBounds(0,230,590,200);
    	  add(scrlPane);
    	  tabGrid.setFont(new Font ("Verdana",0,13));
    
    	  model.addColumn("Trainer Name");
    	  model.addColumn("Batch Time");
    	 model.addColumn("Course Name");
    	 

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
	                  
                         String qry= "Select t_name,b_time,co_name from batch where t_name='"+stdt+"'";
	                     rs = stmt.executeQuery(qry);
	                     
	                     while(rs.next())
	                     {
	                     	model.insertRow(r++, new Object[]{rs.getString(1),rs.getString(2),rs.getString(3)  });
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
	    	
				new BatchReport3();
				
		}	
	    		    
}
