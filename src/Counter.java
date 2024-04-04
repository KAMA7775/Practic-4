import javax.swing.*;

public class Counter extends JFrame {


        private JLabel inputLabel, outputLabel;
        private JTextField inputField, outputField;
        private JButton countButton;

        public Counter() {
            setTitle("счетчик десят.чисел");
            setSize(300, 200);
            setDefaultCloseOperation(EXIT_ON_CLOSE);
            setLocationRelativeTo(null);
            setLayout(null);

            inputLabel = new JLabel("введите число:");
            inputLabel.setBounds(30, 30, 100, 20);
            add(inputLabel);

            inputField = new JTextField();
            inputField.setBounds(140, 30, 100, 20);
            add(inputField);

            outputLabel = new JLabel("ответ:");
            outputLabel.setBounds(30, 70, 100, 20);
            add(outputLabel);

            outputField = new JTextField();
            outputField.setEditable(false);
            outputField.setBounds(140, 70, 100, 20);
            add(outputField);

            countButton = new JButton("считать");
            countButton.setBounds(80, 110, 120, 30);
            countButton.addActionListener(e -> countDigits());
            add(countButton);
        }

        private void countDigits() {
            String numberStr = inputField.getText();
            if (numberStr.isEmpty()) {
                JOptionPane.showMessageDialog(this, "введите норм число", "ошибка", JOptionPane.ERROR_MESSAGE);
                return;
            }

            int number = Integer.parseInt(numberStr);
            int count = 0;

            while (number != 0) {
                number /= 10;
                count++;
            }

            outputField.setText(String.valueOf(count));
        }

        public static void main(String[] args) {
            SwingUtilities.invokeLater(() -> {
                Counter sumkvadrat = new Counter();
                sumkvadrat.setVisible(true);
            });
        }
    }




