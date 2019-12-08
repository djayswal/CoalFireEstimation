import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Page1{

    public Page1() {
        Frame f = new Frame("Fire Dyanamics");
        JLabel l1 = new JLabel("Fire Dynamics");
        l1.setFont(l1.getFont().deriveFont(50.0f));
        l1.setHorizontalAlignment(SwingConstants.CENTER);
        l1.setVerticalAlignment(SwingConstants.CENTER);

        Button GetStarted = new Button("Get Started");

        f.setBackground(Color.BLUE);
        l1.setSize(200,60);

        f.add(l1);
        f.add(GetStarted);





        GetStarted.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                Page2 p2 = new Page2("Enter Data");


            }
        });

        f.setLayout(new FlowLayout());
        f.setSize(400,300);
        f.setVisible(true);
        f.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                super.windowClosing(e);
            }
        });

             }


        }
