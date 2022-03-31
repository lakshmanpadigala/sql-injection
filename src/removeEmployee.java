import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.sql.ResultSet;

public class removeEmployee {
    JFrame frame;
    JTextField t;
    JLabel l1,l2,l3,l4,l5,l6,l7,l8;
    JButton b,b1,b2,b3;
    boolean safemode=false;
    public removeEmployee(boolean mode) {
        safemode=mode;
        frame=new JFrame("Remove Employee");
        frame.setBackground(Color.green);
        frame.setLayout(null);

        l5=new JLabel();
        l5.setBounds(0,0,500,500);
        l5.setLayout(null);
        //ImageIcon img=new ImageIcon(ClassLoader.getSystemResource("icon/remove.jpg"));
       // l5.setIcon(img);
        frame.add(l5);


        l1=new JLabel("Employee Id");
        l1.setBounds(50,50,250,30);
        l1.setForeground(Color.black);
        Font f2 = new Font("serif",Font.BOLD,15);
        l1.setFont(f2);
        l5.add(l1);

        t=new JTextField();
        t.setBounds(250,50,150,30);
        l5.add(t);


        b=new JButton("Search");
        b.setBounds(200,100,100,30);
        b.addActionListener(this::actionPerformed);
        l5.add(b);

        b3=new JButton("back");
        b3.setBounds(360,100,100,30);
        b3.addActionListener(this::actionPerformed);
        l5.add(b3);


        l2=new JLabel("Name:");
        l2.setBounds(50,150,250,30);
        l2.setForeground(Color.black);
        Font f3 = new Font("serif",Font.BOLD,20);
        l2.setFont(f3);
        l5.add(l2);

        l6=new JLabel();
        l6.setBounds(200,150,350,30);
        l6.setForeground(Color.black);
        Font F6=new Font("serif",Font.BOLD,20);
        l6.setFont(F6);
        l5.add(l6);

        l3=new JLabel("Mobile No:");
        l3.setBounds(50,200,250,30);
        l3.setForeground(Color.black);
        Font f4 = new Font("serif",Font.BOLD,20);
        l3.setFont(f4);
        l5.add(l3);


        l7=new JLabel();
        l7.setBounds(200,200,350,30);
        l7.setForeground(Color.black);
        Font F7=new Font("serif",Font.BOLD,20);
        l7.setFont(F7);
        l5.add(l7);



        l4=new JLabel("Email Id:");
        l4.setBounds(50,250,250,30);
        l4.setForeground(Color.black);
        Font F5=new Font("serif",Font.BOLD,20);
        l4.setFont(F5);
        l5.add(l4);

        l8=new JLabel();
        l8.setBounds(200,250,350,30);
        l8.setForeground(Color.black);
        Font f8=new Font("serif",Font.BOLD,20);
        l8.setFont(f8);
        l5.add(l8);

        b1=new JButton("Remove");
        b1.setBounds(120,300,100,30);
        b1.addActionListener(this::actionPerformed);
        l5.add(b1);


        b2=new JButton("Cancel");
        b2.setBounds(300,300,100,30);
        b2.addActionListener(this::actionPerformed);
        l5.add(b2);
        l2.setVisible(false);
        l3.setVisible(false);
        l4.setVisible(false);
        b1.setVisible(false);
        b2.setVisible(false);

        frame.setSize(500,500);
        frame.setLocation(500,250);
        frame.setVisible(true);
    }

    private void actionPerformed(ActionEvent actionEvent) {
        if(actionEvent.getSource()==b){
            try{
                connection con = new connection();
                String str = "select name,phone,email from employee where emp_id ='"+t.getText()+"' ";
                ResultSet rs = con.st.executeQuery(str);

                int i=0;
                if(rs.next()){
                    String name  = rs.getString(1); // col no. 1
                    String mob   = rs.getString(2); // col no. 2
                    String email = rs.getString(3); // col no. 3

                    l2.setVisible(true);
                    l3.setVisible(true);
                    l4.setVisible(true);
                    b1.setVisible(true);
                    b2.setVisible(true);
                    i=1;
                    l6.setText(name);
                    l7.setText(mob);
                    l8.setText(email);
                }
                if(i==0)
                    JOptionPane.showMessageDialog(null,"Id not found");
            }catch(Exception ex){}
        }

        // Perform delete operation after confirming id matched
        if(actionEvent.getSource()==b1){
            try{
                connection con = new connection();
                String str = "delete from employee where emp_id = '"+t.getText()+"'";
                con.st.executeUpdate(str);
                JOptionPane.showMessageDialog(null,"deleted successfully");
                l2.setVisible(false);
                l3.setVisible(false);
                l4.setVisible(false);
                l6.setVisible(false);
                l7.setVisible(false);
                l8.setVisible(false);
                b1.setVisible(false);
                b2.setVisible(false);

            }catch(Exception ex){
                JOptionPane.showMessageDialog(null,"Exception occured while deleting record "+ex);
            }
        }
        // When cancel button pressed
        if(actionEvent.getSource()==b2){
            frame.setVisible(false);
            new removeEmployee(safemode);
        }
        if(actionEvent.getSource()==b3){
            frame.setVisible(false);
            //details_page d=new details_page();
            new details_page(safemode);
        }
    }
}
