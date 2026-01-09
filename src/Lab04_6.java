import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Lab04_6 {

    public static void main(String[] args) {

        int n1 = (int)(Math.random() * 10);
        int n2 = (int)(Math.random() * 10);

        char op;
        int ans;
        int r = (int)(Math.random() * 3);

        if (r == 0) {
            op = '+';
            ans = n1 + n2;
        } else if (r == 1) {
            op = '-';
            ans = n1 - n2;
        } else {
            op = '*';
            ans = n1 * n2;
        }

        JFrame win = new JFrame("Easy Math Quiz");
        win.setSize(500, 300);
        win.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setBackground(new Color(127, 175, 180));

        JLabel lb1 = new JLabel("" + n1);
        lb1.setFont(new Font("Serif", Font.PLAIN, 40));
        panel.add(lb1);

        JLabel lbOp = new JLabel(" " + op + " ");
        lbOp.setFont(new Font("Serif", Font.PLAIN, 40));
        panel.add(lbOp);

        JLabel lb2 = new JLabel("" + n2);
        lb2.setFont(new Font("Serif", Font.PLAIN, 40));
        panel.add(lb2);

        JLabel lbEq = new JLabel(" = ");
        lbEq.setFont(new Font("Serif", Font.PLAIN, 40));
        panel.add(lbEq);

        JTextField ansBox = new JTextField(3);
        ansBox.setFont(new Font("Serif", Font.PLAIN, 40));
        panel.add(ansBox);

        JButton btn = new JButton("Check");
        btn.setFont(new Font("Serif", Font.PLAIN, 20));
        panel.add(btn);

        JLabel lbResult = new JLabel("");
        lbResult.setFont(new Font("Serif", Font.PLAIN, 30));
        panel.add(lbResult);

        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int userAns = Integer.parseInt(ansBox.getText());

                    if (userAns == ans) {
                        lbResult.setText("Excellent!");
                    } else {
                        lbResult.setText("Try again!");
                    }

                } catch (NumberFormatException ex) {
                    lbResult.setText("Enter number only");
                }
            }
        });

        win.add(panel);
        win.setVisible(true);
    }
}