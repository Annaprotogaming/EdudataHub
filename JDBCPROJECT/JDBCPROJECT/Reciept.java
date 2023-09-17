package JDBCPROJECT;
import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.plaf.*;
import javax.swing.table.*;
import java.sql.*;
import java.util.Date;
import java.util.Calendar;
import java.util.GregorianCalendar;
public class Reciept extends JFrame implements ActionListener

{

	//,l2,,l4,l5,l6,l7,l8,l9,l10,l11,l12
	
	//,t2,t3,t4,t5,t6,t7,t8,t9,t10,t11,t12
    JLabel l1,l2,l3,l4,l5;
    JTextField t1,t2 ,t3,t4;
    //JButton b1,b2,b3,b4,b5,b6;
    // JComboBox gender;

    Font fo=new Font("vERDANA" ,Font.BOLD,20);	
    Connection con;
    Statement st;
    ResultSet rs;
    String test,test1;

    Thread datimeThread;
    Date date;
    GregorianCalendar calendar;
    String strDate;

    DefaultTableModel model = new DefaultTableModel();
    JTable tabGrid = new JTable(model);
    JScrollPane scrlPane = new JScrollPane(tabGrid);
    Reciept()
    {
    	
        setSize(590,680);
    	setLayout(null);
    	setTitle("STUDENT RECEIPT");
    	setResizable(true);
    	setLocation(300,160);
    	
    	l1=new JLabel("RECEIPT");
    	l1.setFont(fo);
    	l1.setBounds(250,30,250,50);
    	l1.setForeground(Color.red);
    	add(l1);
    
    	l2= new JLabel("Receipt no :");
        l2.setBounds(70,100,120,30);          
        l2.setForeground(Color.red);
        add(l2);
    	
    	t1=new JTextField();
		t1.setBounds(190,100,100,30);
		add(t1);
    	
		l3=new JLabel ("Date :");
		l3.setBounds(350,100,70,30);
		l3.setForeground(Color.red);
		add(l3);

		t2=new JTextField();
		t2.setBounds(400,100,100,30);
		add(t2);
		
		
		l4=new JLabel ("Student Name:" );
		l4.setBounds(70,140,170,30);
		l4.setForeground(Color.red);
	    add(l4);
	    
	    t3=new JTextField();
	    t3.setBounds(190,140,100,30);
		add(t3);
		
		
		l5=new JLabel ("Student Address:");
		l5.setBounds(300,140,170,30);
		l5.setForeground(Color.red);
		add(l5);
		
		t4=new JTextField();
		t4.setBounds(400,140,100,30);
		add(t4);
		
		setVisible(true);
	    
	    
    	
    	
}
    public static void main(String[] args)
	{
		new Reciept();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}