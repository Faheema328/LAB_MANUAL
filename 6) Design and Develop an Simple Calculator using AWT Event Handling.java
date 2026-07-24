import java.awt.*;
import java.awt.event.*;

public class SimpleCalculator extends Frame implements ActionListener {

    Label l1, l2, l3;
    TextField t1, t2, t3;
    Button add, sub, mul, div;

    public SimpleCalculator() {

        l1 = new Label("Number 1:");
        l2 = new Label("Number 2:");
        l3 = new Label("Result:");

        t1 = new TextField();
        t2 = new TextField();
        t3 = new TextField();
        t3.setEditable(false);

        add = new Button("+");
        sub = new Button("-");
        mul = new Button("*");
        div = new Button("/");

        setLayout(new GridLayout(4, 2, 10, 10));

        add(l1);
        add(t1);

        add(l2);
        add(t2);

        add(add);
        add(sub);

        add(mul);
        add(div);

        add(l3);
        add(t3);

        add.addActionListener(this);
        sub.addActionListener(this);
        mul.addActionListener(this);
        div.addActionListener(this);

        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                dispose();
            }
        });

        setTitle("Simple Calculator");
        setSize(300, 250);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {

        double n1 = Double.parseDouble(t1.getText());
        double n2 = Double.parseDouble(t2.getText());
        double result = 0;

        if (e.getSource() == add)
            result = n1 + n2;

        else if (e.getSource() == sub)
            result = n1 - n2;

        else if (e.getSource() == mul)
            result = n1 * n2;

        else if (e.getSource() == div)
            result = n1 / n2;

        t3.setText(String.valueOf(result));
    }

    public static void main(String[] args) {
        new SimpleCalculator();
    }
}
