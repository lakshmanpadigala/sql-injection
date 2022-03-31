import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class login_page {
    JFrame frame;
    JLabel l1, l2;
    JTextField t1;
    JTextField t2;
    JButton b1, b2;
    public static String current_user;
    JCheckBox checkBox1;
    public static boolean safeMode;

    public login_page() {
        frame = new JFrame("Login Page");
        frame.setBackground(Color.WHITE);
        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocation(380,230);

        l1 = new JLabel("Username");
        l1.setBounds(40,20,100,30);
        frame.add(l1);


        l2 = new JLabel("Password");
        l2.setBounds(40,70,100,30);
        frame.add(l2);

        t1 = new JTextField();
        t1.setBounds(150,20,250,30);
        frame.add(t1);


        t2 = new JTextField();
        t2.setBounds(150,70,250,30);
        frame.add(t2);

//
        JLabel l3 =  new JLabel(new ImageIcon("logo.png"),JLabel.CENTER); // set imageicon on label
        l3.validate();

        l3.setBounds(450,20,250,152);
        frame.add(l3); // finally, add label on welcome frame.

        checkBox1 = new JCheckBox("Safe Mode");
        checkBox1.setBounds(150,120, 150,30);
        frame.add(checkBox1);

//        JLabel jl = new JLabel();
//        jl.setIcon(new ImageIcon("games.jpg"));
//        jl.validate()

        b1 = new JButton("Login");
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        b1.setBounds(40,170,120,30);
        b1.setFont(new Font("serif",Font.BOLD,15));
        b1.addActionListener(this::actionPerformed);  // perform action on button click.
        frame.add(b1);


        b2 = new JButton("Cancel");
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
        b2.setBounds(180,170,120,30);
        b2.setFont(new Font("serif",Font.BOLD,15));
        b2.addActionListener(this::actionPerformed);  // perform action on button click.
        frame.add(b2);


        frame.getContentPane().setBackground(Color.WHITE);

        frame.setVisible(true);
        frame.setSize(750,275);
    }

    public void actionPerformed(ActionEvent e) {
        if(checkBox1.isSelected()){
            safeMode = true;
            System.out.println("Safe Mode is selected");
        }else{
            safeMode = false;
        }

        if(e.getSource() == b2) {
            //frame.setVisible(false);
            t1.setText("");
            t2.setText("");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        }else if(e.getSource()==b1){
            if(safeMode){
                System.out.println("Safe Mode is selected");
                try {
                    connection c1 = new connection();
                    String u = t1.getText();
                    String p = String.valueOf(t2.getText());
                    System.out.println("username:"+u+" password:"+p);
                    String q = "select * from login where username = ? and password =?;";
                    PreparedStatement stmt = c1.c.prepareStatement(q);
                    stmt.setString(1,u);
                    stmt.setString(2,p);
                    System.out.println("Here:"+stmt);

                    ResultSet rs = stmt.executeQuery(); // used to retrieve data from database using conn.s.executeQuery()
                    if(rs.next()) {  //used to match username and password
                        current_user = u;
                        JOptionPane.showMessageDialog(null, "Login Successful"); // when not matched.
                        new details_page(true).frame.setVisible(true); // open details page and make visible also.
                        frame.setVisible(false); // close login page
                    }else {
                        JOptionPane.showMessageDialog(null, "Invalid login, Please correct the details entered!"); // when not matched.
                        //frame.setVisible(true); // close login page
                        t1.setText("");
                        t2.setText("");
                    }
                }catch(Exception ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(null, "Invalid Input--Sql Injection"); // when not matched.
                }
            }else{
                try {
                    connection c1 = new connection();
                    String u = t1.getText();
                    String p = String.valueOf(t2.getText());
                    System.out.println("username:"+u+" password:"+p);
                    String q = "select * from login where username ='"+u+"' and password ='"+p+"'";
                    System.out.println(q);
                    ResultSet rs = c1.st.executeQuery(q); // used to retrieve data from database using conn.s.executeQuery()

                    if(rs.next()) {  //used to match username and password
                        current_user = u;
                        JOptionPane.showMessageDialog(null, "Login Successful"); // when not matched.
                        new details_page(false).frame.setVisible(true); // open details page and make visible also.
                        frame.setVisible(false); // close login page
                    }else {
                        JOptionPane.showMessageDialog(null, "Invalid login, Please correct the details entered!"); // when not matched.
                        //frame.setVisible(true); // close login page
                        t1.setText("");
                        t2.setText("");
                    }
                }catch(Exception ex) {
                    ex.printStackTrace();
                }
            }
        }


    }

    public static void main(String[] args){
        new login_page();
    }
}
