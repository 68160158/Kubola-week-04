import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.BoxLayout;

public class Lab04_8 {

    public static void main(String[] args) {

        JFrame win = new JFrame("BMI Calculator");
        win.setSize(400, 300);
        win.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBackground(new Color(80, 127, 128));
        panel.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 10, 10, 10));

        JLabel lbWeight = new JLabel("Weight (kg): ");
        lbWeight.setFont(new Font("Serif", Font.PLAIN, 16));
        lbWeight.setAlignmentX(JLabel.CENTER_ALIGNMENT);
        panel.add(lbWeight);

        JTextField txtWeight = new JTextField(10);
        txtWeight.setFont(new Font("Serif", Font.PLAIN, 16));
        panel.add(txtWeight);

        JLabel lbHeight = new JLabel("Height (cm): ");
        lbHeight.setFont(new Font("Serif", Font.PLAIN, 16));
        lbHeight.setAlignmentX(JLabel.CENTER_ALIGNMENT);
        panel.add(lbHeight);

        JTextField txtHeight = new JTextField(10);
        txtHeight.setFont(new Font("Serif", Font.PLAIN, 16));
        panel.add(txtHeight);

        JButton btn = new JButton("Calculate BMI");
        btn.setFont(new Font("Serif", Font.PLAIN, 16));
        btn.setBackground(new Color(127, 130, 173));
        btn.setAlignmentX(JButton.CENTER_ALIGNMENT);
        panel.add(btn);

        JLabel lbResult = new JLabel("");
        lbResult.setFont(new Font("Serif", Font.BOLD, 32));
        lbResult.setAlignmentX(JLabel.CENTER_ALIGNMENT);
        lbResult.setForeground(Color.BLACK);
        panel.add(lbResult);

        JLabel lbMeaning = new JLabel("");
        lbMeaning.setFont(new Font("Serif", Font.PLAIN, 24));
        lbMeaning.setAlignmentX(JLabel.CENTER_ALIGNMENT);
        lbMeaning.setForeground(Color.BLACK);
        panel.add(lbMeaning);

        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    double weight = Double.parseDouble(txtWeight.getText());
                    double heightCm = Double.parseDouble(txtHeight.getText());
                    double heightM = heightCm / 100;

                    double bmi = weight / (heightM * heightM);

                    lbResult.setText(String.format("BMI = %.2f", bmi));

                    if (bmi < 18.5) {
                        lbMeaning.setText("Result: Underweight");
                    } else if (bmi < 23) {
                        lbMeaning.setText("Result: Normal");
                    } else if (bmi < 25) {
                        lbMeaning.setText("Result: Overweight");
                    } else if (bmi < 30) {
                        lbMeaning.setText("Result: Obese");
                    } else {
                        lbMeaning.setText("Result: Extremely Obese");
                    }

                } catch (NumberFormatException ex) {
                    lbResult.setText("Please enter numbers only");
                    lbMeaning.setText("");
                }
            }
        });

        win.add(panel);
        win.setVisible(true);
    }
}