
package edudatahub;
import java.awt.*;
import javax.swing.*;
import com.toedter.calendar.JDateChooser;
import java.awt.event.*;
import java.sql.*;
public class UpdateStudent extends JFrame implements ActionListener{
   JTextField tfcourse,tfadd,tfemail,tfphone,tfbranch;
   JLabel lblrolln;
  
   JButton submit,cancel;
   Choice crollno;
  
           public UpdateStudent() {
       setSize(900,650);
       setLocation(350,50);
       setLayout(null);
       
       JLabel heading = new JLabel("Update student Details");
       heading.setBounds(50,10,500,50);
       heading.setFont(new Font("Tahoma",Font.ITALIC,30));
       add(heading);
       
       JLabel lblrollnumber=new JLabel("Select Roll Number");
       lblrollnumber.setBounds(50,100,200,20);
       lblrollnumber.setFont(new Font("serif",Font.PLAIN,20));
       add(lblrollnumber);
       
       crollno = new Choice();
       crollno.setBounds(250,100,250,20);
       add(crollno);
       
       try{
           Conn c =new Conn();
           ResultSet rs = c.s.executeQuery("select * from student");
           while(rs.next()){
               crollno.add(rs.getString("rollno"));
           }
       }catch(Exception e){
           e.printStackTrace();
       }
       
       JLabel lblname = new JLabel("Name");
       lblname.setBounds(50,150,100,30);
       lblname.setFont(new Font("serif",Font.BOLD,20));
       add(lblname);
       
      JLabel labelname = new JLabel();
       labelname.setBounds(200,150,150,30);
       add(labelname);
      
       JLabel lbflname = new JLabel("Father's Name");
       lbflname.setBounds(400,150,200,30);
       lbflname.setFont(new Font("serif",Font.BOLD,20));
       add(lbflname);
       
       JLabel labelfname = new JLabel();
       labelfname.setBounds(600,150,150,30);
       add(labelfname);
       
       JLabel lblrollno = new JLabel("Roll no :");
       lblrollno.setBounds(50,200,200,30);
       lblrollno.setFont(new Font("serif",Font.BOLD,20));
       add(lblrollno);
       
       lblrolln = new JLabel();
       lblrolln.setBounds(200,200,200,30);
       lblrolln.setFont(new Font("serif",Font.BOLD,20));
       add(lblrolln);
       
       JLabel lbldob = new JLabel("Date of Birth:");
       lbldob.setBounds(400,200,200,30);
       lbldob.setFont(new Font("serif",Font.BOLD,20));
       add(lbldob);
       
       JLabel labeldob = new JLabel();
       labeldob.setBounds(600,200,150,30);
       add(labeldob);
       
      JLabel lbladd = new JLabel("Address");
       lbladd.setBounds(50,250,200,30);
       lbladd.setFont(new Font("serif",Font.BOLD,20));
       add(lbladd);
       
       tfadd = new JTextField();
       tfadd.setBounds(200,250,150,30);
       add(tfadd);
       
       JLabel lblphone = new JLabel("Phone Number");
       lblphone.setBounds(400,250,200,30);
       lblphone.setFont(new Font("serif",Font.BOLD,20));
       add(lblphone);
       
       tfphone = new JTextField();
       tfphone.setBounds(600,250,150,30);
       add(tfphone);
       
       JLabel lblemail = new JLabel("Email");
       lblemail.setBounds(50,300,200,30);
       lblemail.setFont(new Font("serif",Font.BOLD,20));
       add(lblemail);
       
       tfemail = new JTextField();
       tfemail.setBounds(200,300,150,30);
       add(tfemail);
       
       JLabel lblx = new JLabel("Class X (%)");
       lblx.setBounds(400,300,200,30);
       lblx.setFont(new Font("serif",Font.BOLD,20));
       add(lblx);
       
       JLabel labelx = new JLabel();
       labelx.setBounds(600,300,150,30);
       add(labelx);
       
      
       
       JLabel lblxii = new JLabel("Class XII (%)");
       lblxii.setBounds(50,350,200,30);
       lblxii.setFont(new Font("serif",Font.BOLD,20));
       add(lblxii);
       
       JLabel labelxii = new JLabel();
       labelxii.setBounds(200,350,150,30);
       add(labelxii);
       
       JLabel lbladhaar = new JLabel("Adhaar No");
       lbladhaar.setBounds(400,350,200,30);
       lbladhaar.setFont(new Font("serif",Font.BOLD,20));
       add(lbladhaar);
       
       JLabel labelaadhar = new JLabel();
       labelaadhar.setBounds(600,350,150,30);
       add(labelaadhar);
       
       JLabel lblcourse = new JLabel("select course");
       lblcourse.setBounds(50,400,200,30);
       lblcourse.setFont(new Font("serif",Font.BOLD,20));
       add(lblcourse);

       
       tfcourse = new JTextField("Course");
       tfcourse.setBackground(Color.PINK);
       tfcourse.setBounds(200,400,150,30);
       add(tfcourse);
    
       
       JLabel lblbranch = new JLabel("Branch");
       lblbranch.setBounds(400,400,200,30);
       lblbranch.setFont(new Font("serif",Font.BOLD,20));
       add(lblbranch);

        tfbranch = new JTextField();
       tfbranch.setBackground(Color.PINK);
       tfbranch.setBounds(600,400,150,30);
       add(tfbranch);
       try{
           Conn c = new Conn();
           String query = "Select * from student where rollno='"+crollno.getSelectedItem()+"'";
           ResultSet rs=c.s.executeQuery(query);
           while(rs.next()){
               labelname.setText(rs.getString("name"));
               labelfname.setText(rs.getString("fname"));
               labeldob.setText(rs.getString("dob"));
               tfadd.setText(rs.getString("address"));
               tfphone.setText(rs.getString("phone"));
               tfemail.setText(rs.getString("email"));
               labelx.setText(rs.getString("class_x"));
               labelxii.setText(rs.getString("class_xii"));
               lblrolln.setText(rs.getString("rollno"));
               tfcourse.setText(rs.getString("course"));
               tfbranch.setText(rs.getString("branch"));
               labelaadhar.setText(rs.getString("aadhar"));

           }
       }catch(Exception e){
           e.printStackTrace();
       }
       crollno.addItemListener(new ItemListener(){
             public void itemStateChanged(ItemEvent ie){
                 try{
           Conn c = new Conn();
           String query = "Select * from student where rollno='"+crollno.getSelectedItem()+"'";
           ResultSet rs=c.s.executeQuery(query);
           while(rs.next()){
               labelname.setText(rs.getString("name"));
               labelfname.setText(rs.getString("fname"));
               labeldob.setText(rs.getString("dob"));
               tfadd.setText(rs.getString("address"));
               tfphone.setText(rs.getString("phone"));
               tfemail.setText(rs.getString("email"));
               labelx.setText(rs.getString("class_x"));
               labelxii.setText(rs.getString("class_xii"));
               lblrolln.setText(rs.getString("rollno"));
               tfcourse.setText(rs.getString("course"));
               tfbranch.setText(rs.getString("branch"));
               labelaadhar.setText(rs.getString("aadhar"));

           }
       }catch(Exception e){
           e.printStackTrace();
       }
                 
             
             }
           });
       
        submit = new JButton("Update");                        
        submit.setBounds(150,550,120,30);
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.addActionListener(this);
        add(submit);
        
         cancel = new JButton("Cancel");                        
        cancel.setBounds(610,550,120,30);
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.addActionListener(this);
        add(cancel);
    
            setVisible(true);
           }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()== submit){
        String  rollno = lblrolln.getText();
       
        String phone = tfphone.getText();
        String address = tfadd.getText();
        String email = tfemail.getText();
        String course = tfcourse.getText();            
        String branch = tfbranch.getText();
        //get selected item returns object. so typecast string so cource will be able to store the value
        
        try{
            String query = "update student set address='"+address+"', phone='"+phone+"',email='"+email+"',course='"+course+"',branch='"+branch+"' where rollno='"+rollno+"'";
        //DML cmd   
        //single inverted comma is used cause we have used varchar in DB which takes value from ''.
           Conn con = new Conn();
           con.s.executeUpdate(query);
           
           JOptionPane.showMessageDialog(null, "Student Details updated Successfully");    //popup
           setVisible(false);
        }catch (Exception e){
            
        }
        }else{
            setVisible(false);
        }
    }
    public static void main (String[] args){
        new UpdateStudent();
        
    }
}
