import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class viewEmployee {
    JFrame frame;
    JTextField t;
    JLabel l1,l2;
    JButton b1,b2;
    boolean safemode=false;
    public viewEmployee(boolean mode) {
        safemode=mode;
        frame=new JFrame("View Details");
        frame.setBackground(Color.green);
        frame.setLayout(null);

	    l1=new JLabel();
	    l1.setBounds(0,0,500,270);
        l1.setLayout(null);


        l2=new JLabel("Employee Id");
        l2.setVisible(true);
        l2.setBounds(40,60,250,30);
        l2.setForeground(Color.black);
        Font F1 = new Font("serif",Font.BOLD,15);
        l2.setFont(F1);
        l1.add(l2);
        frame.add(l1);


        t=new JTextField();
        t.setFont(new Font("serif", Font.PLAIN,13));
        t.setBounds(150,60,320,30);
        l1.add(t);

        b1=new JButton("Search");
        b1.setBounds(240,150,100,30);
        b1.addActionListener(this::actionPerformed);
        l1.add(b1);

        b2=new JButton("Cancel");
        b2.setBounds(360,150,100,30);
        b2.addActionListener(this::actionPerformed);
        l1.add(b2);

        frame.setSize(500,270);
        frame.setLocation(450,250);
        frame.setVisible(true);
    }

    private void actionPerformed(ActionEvent actionEvent) {
        if(actionEvent.getSource()==b2){
            frame.setVisible(false);
            details_page d=new details_page(safemode);
        }
        if(actionEvent.getSource()==b1){
            frame.setVisible(false);
            //TODO 1
            new printData(t.getText(),safemode);
            //new updateEmployee(t.getText());
        }

    }
}
