package edudatahub;
import java.awt.Color;
import java.awt.Image;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

public class Login extends JFrame implements ActionListener{
   JButton login,cancel;
   JTextField tusername,tpassword; 
    Login(){
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);
      
        JLabel lname = new JLabel("Username");
        lname.setBounds(40,20,100,20);
        add(lname);
        
       tusername = new JTextField();
        
        tusername.setBounds(150,20,150,20);
        add(tusername);
        
      
        JLabel lpass = new JLabel("Password");
        lpass.setBounds(40,70,100,20);
        add(lpass);
        
        tpassword = new JPasswordField();
        
        tpassword.setBounds(150,70,150,20);
        add(tpassword);
        
        
        login = new JButton("Login");                        
        login.setBounds(40,140,120,30);
        login.setBackground(Color.BLACK);
        login.setForeground(Color.WHITE);
        login.addActionListener(this);
        add(login);
        
        
        cancel = new JButton("cancel");                        
        cancel.setBounds(180,140,120,30);
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        login.addActionListener(this);
        add(cancel);
        
        ImageIcon i1= new ImageIcon(ClassLoader.getSystemResource("icons/second.jpg"));
        Image i2=i1.getImage().getScaledInstance(200, 200,Image.SCALE_DEFAULT);
        ImageIcon i3= new ImageIcon(i2);
        JLabel image= new JLabel(i3);
        image.setBounds(350,0,200,200);
        add(image);
        
        setSize(600,300);
        setLocation(350,250);
        setVisible(true);
        }
   
     public void actionPerformed(ActionEvent ae){
        if (ae.getSource() == login){
         String username= tusername.getText();
         String password= tpassword.getText();
         
         String query ="select * from login where username='"+username+"'and password='"+password+"'";
         
         try{
             Conn c = new Conn();     //conection opened with mysql
          ResultSet rs = c.s.executeQuery(query);
          if (rs.next()){
              setVisible(false);
              new Project();
          }else{
              JOptionPane.showMessageDialog(null,"Invalid username or password");
              setVisible(false);
          }
          c.s.close();           // connection closed
         }catch(Exception e){
           e.printStackTrace();
         }
        } else if (ae.getSource() == cancel){
         setVisible(false);
        
         
        }
         
     }  
    
    public static void main (String[]args){
        new Login();
    }
}
