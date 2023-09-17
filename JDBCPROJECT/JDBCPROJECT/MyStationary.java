package JDBCPROJECT;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
public class MyStationary extends JFrame implements ActionListener
{
	HashMap<String, String> product_and_price;
	
	DefaultListModel<String> product_name_bill, product_quantity_bill,product_price_bill;
	
	JLabel product_name, price_per_unit, quantity_label, price_of_product, price_per_unit_label, total, total_amount, bill_product, bill_quantity, bill_price;
    JComboBox product_list, quantity_list;
    JList product_bill, product_quantity, product_price;
    JButton add_product;
    JTextField t1;
    
   // Connection con;
    //Statement st;
    //ResultSet rs;
    String test,name;
    int price=0,quantity,n;
	public MyStationary()
	{
		product_and_price = new HashMap<String, String>();
        
        product_and_price.put("Book", "80");
        product_and_price.put("Pen", "10");
        product_and_price.put("Pencil", "7");
        product_and_price.put("Marker", "40");
        product_and_price.put("Eraser", "5");
		
		bill_product = new JLabel("Item");
		bill_product.setBounds(10, 150, 150, 20);
		add(bill_product);
		 
        bill_quantity = new JLabel("Quantity");
        bill_quantity.setBounds(170, 150, 90, 20);
        add(bill_quantity);
        
        bill_price = new JLabel("Cost");
        bill_price.setBounds(270, 150, 140, 20);
        add(bill_price);
        
        product_name_bill = new DefaultListModel<String>();
        product_price_bill = new DefaultListModel<>();
        product_quantity_bill = new DefaultListModel<>();
        
        product_bill = new JList(product_name_bill);
        product_bill.setBounds(10, 175, 150, 400);
        add(product_bill);
        
        product_price = new JList(product_price_bill);
        product_price.setBounds(270, 175, 140, 400);
        add(product_price);
        
        product_quantity = new JList(product_quantity_bill);
        product_quantity.setBounds(170, 175, 90, 400);
        add(product_quantity);
        
        product_name = new JLabel("Product Name");
        product_name.setBounds(10, 30, 100, 20);
        add(product_name);
        
        quantity_label = new JLabel("Quantity");
        quantity_label.setBounds(310, 30, 100, 20);
        add(quantity_label);
        
        price_per_unit = new JLabel("Price Per Unit(₹)");
        price_per_unit.setBounds(160, 30, 100, 20);
        add(price_per_unit);
        
       price_per_unit_label = new JLabel("80");
        price_per_unit_label.setBounds(160, 50, 100, 20);
        add(price_per_unit_label);
      
        
        
        
      /* t1= new JTextField();
        t1.setBounds(160, 50, 100, 20);
        add(t1);*/
        
        product_list = new JComboBox();
        product_and_price.forEach((key,value)->
        {
            product_list.addItem(key);
        });
        
        product_list.setBounds(10, 50, 100, 20);
        add(product_list);
        product_list.addActionListener(this);
        
        quantity_list = new JComboBox();
        for(int i=1; i<=10; i++)
        {
            quantity_list.addItem(Integer.toString(i));
        }
        quantity_list.setBounds(310, 50, 100, 20);
        add(quantity_list);
        
        total = new JLabel("Total Amount : ");
        total.setBounds(140, 575, 200, 20);
        add(total);
       
        total_amount = new JLabel();
        total_amount.setBounds(310, 575, 90, 20);
        add(total_amount);
        
        add_product = new JButton("Add Product");
        add_product.setBounds(10, 80, 400, 50);
        add(add_product);
        add_product.addActionListener(this);
        
    
        setSize(435,650);
        setLayout(null);
        setVisible(true);
        setTitle("My Stationary");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public void actionPerformed(ActionEvent ae)
	{
		 if(ae.getSource()==add_product)
	        {
	            product_name_bill.addElement((String) product_list.getSelectedItem());
	            product_quantity_bill.addElement((String) quantity_list.getSelectedItem());
	            int unit_price = Integer.parseInt(product_and_price.get(product_list.getSelectedItem()));
	            int product_quantity = Integer.parseInt((String) quantity_list.getSelectedItem());
	            int total_for_product = unit_price*product_quantity; 
	            int total_cost = 0;
	            product_price_bill.addElement(Integer.toString(total_for_product));
	            
	            for(int i=0;i<product_price_bill.getSize();i++)
	            {
	                total_cost += Integer.parseInt(product_price_bill.getElementAt(i));
	            }
	            
	            total_amount.setText(Integer.toString(total_cost));
	        }
	        else if(ae.getSource()==product_list)
	        {
	            price_per_unit_label.setText(product_and_price.get(product_list.getSelectedItem()));
	        }
		
    
	}
	public static void main(String[] args)
	{
		new MyStationary();

	}

}
