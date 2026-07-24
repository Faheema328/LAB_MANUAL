import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class StudentRegistrationForm extends JFrame implements ActionListener {

    JLabel l1, l2, l3;
    JTextField t1, t2, t3;
    JButton submit;

    public StudentRegistrationForm() {

        l1 = new JLabel("Name:");
        l2 = new JLabel("Roll Number:");
        l3 = new JLabel("Course:");

        t1 = new JTextField();
        t2 = new JTextField();
        t3 = new JTextField();

        submit = new JButton("Register");

        setLayout(new GridLayout(4, 2, 10, 10));

        add(l1);
        add(t1);

        add(l2);
        add(t2);

        add(l3);
        add(t3);

        add(new JLabel());
        add(submit);

        submit.addActionListener(this);

        setTitle("Student Registration Form");
        setSize(350, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        String name = t1.getText();
        String roll = t2.getText();
        String course = t3.getText();

        JOptionPane.showMessageDialog(this,
                "Registration Successful!\n\n"
                        + "Name: " + name
                        + "\nRoll Number: " + roll
                        + "\nCourse: " + course);
    }

    public static void main(String[] args) {
        new StudentRegistrationForm();
    }
}
