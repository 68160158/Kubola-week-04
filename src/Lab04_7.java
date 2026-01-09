import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Lab04_7 {

    static int n1, n2, ans;
    static char op;
    static int count = 1;
    static int score = 0;

    static JLabel lb1, lb2, lbOp, lbResult, lbCount;
    static JTextField ansBox;

    public static void randomQuestion() {
        n1 = (int)(Math.random() * 10);
        n2 = (int)(Math.random() * 10);
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

        lb1.setText("" + n1);
        lb2.setText("" + n2);
        lbOp.setText(" " + op + " ");
        lbCount.setText("Question " + count + " / 10");
        ansBox.setText("");
    }

    public static void main(String[] args) {

        JFrame win = new JFrame("Easy Math Quiz");
        win.setSize(500, 350);
        win.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setBackground(new Color(127, 130, 187));

        lbCount = new JLabel("Question 1 / 10");
        lbCount.setFont(new Font("Serif", Font.PLAIN, 20));
        panel.add(lbCount);

        lb1 = new JLabel();
        lb1.setFont(new Font("Serif", Font.PLAIN, 40));
        panel.add(lb1);

        lbOp = new JLabel();
        lbOp.setFont(new Font("Serif", Font.PLAIN, 40));
        panel.add(lbOp);

        lb2 = new JLabel();
        lb2.setFont(new Font("Serif", Font.PLAIN, 40));
        panel.add(lb2);

        JLabel lbEq = new JLabel(" = ");
        lbEq.setFont(new Font("Serif", Font.PLAIN, 40));
        panel.add(lbEq);

        ansBox = new JTextField(3);
        ansBox.setFont(new Font("Serif", Font.PLAIN, 40));
        panel.add(ansBox);

        JButton btn = new JButton("Check");
        btn.setFont(new Font("Serif", Font.PLAIN, 20));
        panel.add(btn);

        lbResult = new JLabel("");
        lbResult.setFont(new Font("Serif", Font.PLAIN, 25));
        panel.add(lbResult);

        randomQuestion();

        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                try {
                    int userAns = Integer.parseInt(ansBox.getText());

                    if (userAns == ans) {
                        score++;
                        lbResult.setText("Correct!");
                    } else {
                        lbResult.setText("Wrong!");
                    }

                    count++;

                    if (count <= 10) {
                        randomQuestion();
                    } else {
                        lbResult.setText("Score : " + score + " / 10");
                        btn.setEnabled(false);
                        ansBox.setEnabled(false);
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