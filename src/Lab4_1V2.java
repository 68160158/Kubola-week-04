import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class Lab4_1V2 {
    public static void main(String[] args){
        JFrame f = new JFrame();
        f.setTitle("Hello Program: Chatkamphol Homnual 68160317 n43");
        f.setSize(500,300);
        f.setLayout(new FlowLayout());

        JLabel label1 = new JLabel();
        label1.setText("Enter name: ");
        f.add(label1);

        JTextField nameBox = new JTextField(5);
        f.add(nameBox);

        JButton b1 = new JButton();
        b1.setText("Send");
        b1.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = nameBox.getText();
                JOptionPane.showMessageDialog(null, "Hello " + name);
            }
        });
        f.add(b1);

        f.setVisible(true);

    }
}