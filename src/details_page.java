import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class details_page {
    JFrame frame;
    JLabel l1, l2;
    JButton b1, b2, b3, b4, b5;
    boolean safemode=false;
    public details_page(boolean mode) {
        frame = new JFrame("Employee Dashboard");
        frame.setBackground(Color.WHITE);
        frame.setLayout(null);

//        l1 = new JLabel();
//        l1.setBounds(0,0,700,500);
//        l1.setLayout(null);
//        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/details.png"));
//        l1.setIcon(i1);
//        frame.add(l1);



        l2 = new JLabel("Employee Details");
        l2.setBounds(30,20,275,40);
        l2.setFont(new Font("serif",Font.BOLD,25));
        l2.setForeground(Color.BLUE);
        l2.setLayout(null);
        frame.add(l2);

        b1 = new JButton("Add Employee");
        b1.setBounds(20,80,180,30);
        b1.setBackground(Color.pink);
        b1.setFont(new Font("serif",Font.BOLD,15));
        b1.addActionListener(this::actionPerformed);  // perform action on button click.
        frame.add(b1);


        b2 = new JButton("View Employee");
        b2.setBounds(220,80,180,30);
        b2.setBackground(Color.pink);
        b2.setFont(new Font("serif",Font.BOLD,15));
        b2.addActionListener(this::actionPerformed);  // perform action on button click.
        frame.add(b2);


        b3 = new JButton("Remove Employee");
        b3.setBounds(20,120,180,30);
        b3.setBackground(Color.pink);
        b3.setFont(new Font("serif",Font.BOLD,15));
        b3.addActionListener(this::actionPerformed);  // perform action on button click.
        frame.add(b3);



        b4 = new JButton("Update Employee");
        b4.setBounds(220,120,180,30);
        b4.setBackground(Color.pink);
        b4.setFont(new Font("serif",Font.BOLD,15));
        b4.addActionListener(this::actionPerformed);  // perform action on button click.
        frame.add(b4);

        b5 = new JButton("Logout");
        b5.setBounds(260,160,100,30);
        b5.setBackground(Color.pink);
        b5.setFont(new Font("serif",Font.BOLD,15));
        b5.addActionListener(this::actionPerformed);  // perform action on button click.
        frame.add(b5);


        frame.setVisible(true);
        frame.setSize(420,250);
        frame.setLocation(450,200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == b1) {
            frame.setVisible(false);
            new addEmployee(safemode);
            //JOptionPane.showMessageDialog(null, "Invalid login"); // when not matched.

        }
        else if(e.getSource() == b2) {
            frame.setVisible(false);
            new viewEmployee(safemode);
            //JOptionPane.showMessageDialog(null, "Invalid login"); // when not matched.

        }
        else if(e.getSource() == b3) {
            frame.setVisible(false);
            new removeEmployee(safemode);
            //JOptionPane.showMessageDialog(null, "Invalid login"); // when not matched.

        }
        else if(e.getSource() == b4) {
            frame.setVisible(false);
            new searchEmployee(safemode);
            //JOptionPane.showMessageDialog(null, "Invalid login"); // when not matched.

        }
        else if(e.getSource() == b5){
            login_page.current_user = null;
            frame.setVisible(false);
            JOptionPane.showMessageDialog(null, "Logged Out Successfully");
            new login_page();
        }

    }
}
