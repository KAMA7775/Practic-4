import javax.swing.*;

public class Summakvadrat extends JFrame {

    private JLabel inputLabel, outputLabel;
    private JTextField inputField, outputField;
    private JButton calculateButton;

    public Summakvadrat() {
        setTitle("счетчик суммы кв");
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

        calculateButton = new JButton("считать");
        calculateButton.setBounds(80, 110, 120, 30);
        calculateButton.addActionListener(e -> Sumkv());
        add(calculateButton);
    }

    private void Sumkv() {
        String numberStr = inputField.getText();
        if (numberStr.isEmpty() ) {
            JOptionPane.showMessageDialog(this, "введите норм число", "ошибка", JOptionPane.ERROR_MESSAGE);
            return;
        }

        int number = Integer.parseInt(numberStr);
        int sum = 0;
        for (int i = 0; i <= number; i++) {
            sum += i * i;
        }

        outputField.setText(String.valueOf(sum));
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Summakvadrat gui = new Summakvadrat();
            gui.setVisible(true);
        });
    }
}
