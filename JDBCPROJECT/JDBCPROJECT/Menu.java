package JDBCPROJECT;

import javax.swing.*;

import jdbcExample.Courceform;
import jdbcExample.Courseex;

import java.awt.*;
import java.awt.event.*;

public class Menu extends JFrame 
{
	 public JFrame frame1;
	 public JPanel top,lower;
	
	 	JLabel leli;	

		JMenuBar mbr=new JMenuBar();
		
		JMenu enquiry=new JMenu("Enquiry");

		JMenu login=new JMenu("Login");
	
		static JMenu CourceForm=new JMenu("CourseForm");
	 
		 JMenu teacher=new JMenu("Teacher");
	 
		 JMenu admission=new JMenu("Admission");
		 
		 JMenu batch=new JMenu("Batch");
		 
		 JMenu bill=new JMenu("Bill");
    	
		 //Enquiry
    	JMenuItem open1=new JMenuItem("Open");
    	
    	//Login
		JMenuItem open2=new JMenuItem("Open");
		
		//Course
		JMenuItem open3=new JMenuItem("Open");
		
		//Teacher
		JMenuItem open4=new JMenuItem("Open");
 
		//Admission
		JMenuItem open5=new JMenuItem("Open");
				
		//Batch
		JMenuItem open6=new JMenuItem("Open");
		
		//Bill
		JMenuItem open7=new JMenuItem("Open");
		
		
	  public static void main(String args[])
	  {
		  Menu menu1=new Menu();
		  menu1.LaunchFrame(CourceForm);
	  		menu1.Check_Event();	
	  	
	  }
		
	  public Menu()
	  {
		  frame1=new JFrame();
	  }
	  
	  public void LaunchFrame(JMenu CourseForm)	
	  {
		  //1023,735
		  frame1.setSize(1500,900);
		  frame1.setLayout(null);
		  frame1.setTitle("Student Addmisson System");
		  frame1.setResizable(false);
		  frame1.add(mbr);


		 /* leli=new JLabel(new ImageIcon("44.jpg"));
		  leli.setBounds(0,0,1023,1000);
		  frame1.add(leli);*/
		                
		  //Enquiry
		  mbr.add(enquiry);
		  enquiry.add(open1);
		  
		  //Login
		  mbr.add(login);
		  login.add(open2);

		
		//Course
		  mbr.add(CourseForm);
		  CourseForm.add(open3);
		  JDBCPROJECT.CourceForm CourseForm1 = new JDBCPROJECT.CourceForm();
		
		  
		  //Teacher
		  mbr.add(teacher);
		  teacher.add(open4);
		  
		//admission
		  mbr.add(admission);
		  admission.add(open5);
		  
		  //Batch
		  mbr.add(batch);
		  batch.add(open6);
		  
		//Bill
		  mbr.add(bill);
		  bill.add(open7);
		  
		  
		         	 	
		 frame1.setJMenuBar(mbr);
		 frame1.setVisible(true);
		 
	  }
	  
	  public void Check_Event()
	  {
		  
		  //enquiry
		  open1.addActionListener(new ActionListener()
		  {
			  public void actionPerformed(ActionEvent ae)
			  {
				  if(ae.getSource()==open1)
				  {
	   	  	 
					  Enquiry open1=new Enquiry();
				  }
			  }   	  
		  });
		  
		  //login
		  open2.addActionListener(new ActionListener()
		  {
			  public void actionPerformed(ActionEvent ae)
			  {
				  if(ae.getSource()==open2)
				  {
	   	  	 
					  Login open2=new Login();
				  }
			  }   	  
		  });
		  
		  //course
		  open3.addActionListener(new ActionListener()
		  {
			  public void actionPerformed(ActionEvent ae)
			  {
				  if(ae.getSource()==open3)
				  {
	   	  	 
					  CourseReport open3=new CourseReport();
				  }
			  }   	  
		  });
		  
		  //teacher
		  open4.addActionListener(new ActionListener()
		  {
			  public void actionPerformed(ActionEvent ae)
			  {
				  if(ae.getSource()==open4)
				  {
	   	  	 
					  Trainer open4=new Trainer();
				  }
			  }   	  
		  });
		  
		  
		  //Admission
		  open5.addActionListener(new ActionListener()
		  {
			  public void actionPerformed(ActionEvent ae)
			  {
				  if(ae.getSource()==open5)
				  {
					  Admission open5=new Admission();
				  }
			  }   	  
		  });
		  
		  
		  //batch
		  open6.addActionListener(new ActionListener()
		  {
			  public void actionPerformed(ActionEvent ae)
			  {
				  if(ae.getSource()==open6)
				  {
	   	  	 
					  BatchRecord open6=new BatchRecord();
				  }
			  }   	  
		  });
		  
		//bill
		  open7.addActionListener(new ActionListener()
		  {
			  public void actionPerformed(ActionEvent ae)
			  {
				  if(ae.getSource()==open7)
				  {
	   	  	 
					  Bill open7=new Bill();
				  }
			  }   	  
		  });
		  
		  
	  }
}
	 

	 
