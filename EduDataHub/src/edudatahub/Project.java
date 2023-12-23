
package edudatahub;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Project extends JFrame implements ActionListener {
 
    Project(){
        setSize(1500,850);
      ImageIcon i1= new ImageIcon(ClassLoader.getSystemResource("icons/university.jpg"));
        Image i2=i1.getImage().getScaledInstance(1500, 750,Image.SCALE_DEFAULT);
        ImageIcon i3= new ImageIcon(i2);
        JLabel image= new JLabel(i3);
        add(image);
        
        JMenuBar mb = new JMenuBar();
        JMenu newInformation = new JMenu("New Information");
        newInformation.setForeground(Color.BLACK);
        mb.add(newInformation);
        
        JMenuItem facultyInfo = new JMenuItem("New faculty Information");
        facultyInfo.setBackground(Color.WHITE);
        facultyInfo.addActionListener(this);
        newInformation.add(facultyInfo);
        
        JMenuItem studentInfo = new JMenuItem("New student Information");
        studentInfo.setBackground(Color.WHITE);
        studentInfo.addActionListener(this);
        newInformation.add(studentInfo);
        
        //Details
        JMenu details = new JMenu("view deatils");
        newInformation.setForeground(Color.BLACK);
        mb.add(details);
        
        JMenuItem facultydetails = new JMenuItem("View Faculty Details");
        facultydetails.setBackground(Color.WHITE);
        facultydetails.addActionListener(this);
        details.add(facultydetails);
        
        JMenuItem studentdeatails = new JMenuItem("view Students Details");
        studentdeatails.setBackground(Color.WHITE);
        studentdeatails.addActionListener(this);
        details.add(studentdeatails);
        
        //Leave
        JMenu leave = new JMenu("Apply Leave");
        leave.setForeground(Color.BLUE);
       // mb.add(leave);
        
        JMenuItem facultyleave = new JMenuItem("Apply Faculty Leave");
        facultyleave.setBackground(Color.WHITE);
        leave.add(facultyleave);
        
        JMenuItem studentleave = new JMenuItem("Apply Student Leave");
        studentleave.setBackground(Color.WHITE);
        leave.add(studentleave);
        
        //leave deatils
        JMenu leaveDetails = new JMenu("Leave details");
        leaveDetails.setForeground(Color.BLUE);
       // mb.add(leaveDetails);
        
        JMenuItem facultyleavedetails = new JMenuItem("Faculty Leave Details");
        facultyleavedetails.setBackground(Color.WHITE);
        leaveDetails.add(facultyleavedetails);
        
        JMenuItem studentleavedetails = new JMenuItem("Student Leave Details");
        studentleavedetails.setBackground(Color.WHITE);
        leaveDetails.add(studentleavedetails);
        
        //Exam
        JMenu exam = new JMenu("Exam ");
        exam.setForeground(Color.BLUE);
       // mb.add(exam);
        
        JMenuItem examinationDetails = new JMenuItem("Examination Results");
        examinationDetails.setBackground(Color.WHITE);
        exam.add(examinationDetails);
        
        JMenuItem entermarks = new JMenuItem("Enter Exam Marks");
        entermarks.setBackground(Color.WHITE);
        exam.add(entermarks);
        
        //update info
          JMenu updateinfo = new JMenu("Update Details ");
        updateinfo.setForeground(Color.BLACK);
        mb.add(updateinfo);
        
        JMenuItem updatefacultyinfo = new JMenuItem("Update Faculty Details");
        updatefacultyinfo.setBackground(Color.WHITE);
        updatefacultyinfo.addActionListener(this);
        updateinfo.add(updatefacultyinfo);
        
        JMenuItem updatestudentinfo = new JMenuItem("Update student Details");
        updatestudentinfo.setBackground(Color.WHITE);
        updatestudentinfo.addActionListener(this);
        updateinfo.add(updatestudentinfo);
       
        //fees deatails
         JMenu fee = new JMenu("fee Details ");
        fee.setForeground(Color.BLACK);
        mb.add(fee);
        
        JMenuItem feestructure = new JMenuItem("Fee Structure");
        feestructure.setBackground(Color.WHITE);
        fee.add(feestructure);
        
        JMenuItem feeform = new JMenuItem("Update student Details");
        feeform.setBackground(Color.WHITE);
        fee.add(feeform);
        
        //utility
            JMenu utility = new JMenu("Utility ");
        utility.setForeground(Color.BLACK);
        mb.add(utility);
        
        JMenuItem notepad = new JMenuItem("Notepad");
        notepad.setBackground(Color.WHITE);
        notepad.addActionListener(this);
        utility.add(notepad);
        
        JMenuItem calc = new JMenuItem("Calculator");
        calc.setBackground(Color.WHITE);
        calc.addActionListener(this);
        utility.add(calc);
        
        //Exit
        JMenu exit = new JMenu("Exit ");
        exit.setForeground(Color.BLACK);
        mb.add(exit);
        
        JMenuItem ex = new JMenuItem("Exit");
        ex.setBackground(Color.WHITE);
        ex.addActionListener(this);
        exit.add(ex);
        
        
        setJMenuBar(mb);
        setVisible(true);
      
    }
    
    public void actionPerformed(ActionEvent ae){
       String mag = ae.getActionCommand();
       
       if(mag.equals("Exit")) {
           setVisible(false);
     
       } else if (mag.equals("Calculator")){
           try{
               Runtime.getRuntime().exec("calc.exe");
           } catch(Exception e){
               
           }
           
       } 
           else if (mag.equals("Notepad")){
           try{
               Runtime.getRuntime().exec("notepad.exe");
           } catch(Exception e){
               
           }
           
       }else if (mag.equals("New faculty Information")){
           new AddTeacher();
       }else if(mag.equals("New student Information"))
       {
           new AddStudent();
       }else if(mag.equals("View Faculty Details"))
       {
           new TeacherDetails();
       }else if(mag.equals("view Students Details"))
       {
           new StudentDetails();
       }else if(mag.equals("Update Faculty Details"))
       {
           new UpdateTeacher();
       }else if(mag.equals("Update student Details"))
       {
           new UpdateStudent();
       }
    }
    
    
    public static void main(String[]args){
        new Project();
    }
    
    
}
// this class is home page of the system contains swing components
