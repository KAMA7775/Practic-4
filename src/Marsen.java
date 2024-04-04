import javax.swing.*;

public class Marsen extends JFrame {

    private JLabel inputLabel, outputLabel;
    private JTextField inputField, outputField;
    private JButton countButton;

    public Marsen() {
        setTitle("Марсен счетчик");
        setSize(300, 200);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);

        inputLabel = new JLabel("введите число:");
        inputLabel.setBounds(30, 30, 120, 20);
        add(inputLabel);

        inputField = new JTextField();
        inputField.setBounds(160, 30, 100, 20);
        add(inputField);

        outputLabel = new JLabel("ответ:");
        outputLabel.setBounds(30, 70, 200, 20);
        add(outputLabel);

        outputField = new JTextField();
        outputField.setEditable(false);
        outputField.setBounds(230, 70, 80, 20);
        add(outputField);

        countButton = new JButton("считать");
        countButton.setBounds(80, 110, 120, 30);
        countButton.addActionListener(e -> countMersennePrimes());
        add(countButton);
    }

    private void countMersennePrimes() {
        String numberStr = inputField.getText();
        if (numberStr.isEmpty() ) {
            JOptionPane.showMessageDialog(this, "введите норм число", "ошибка", JOptionPane.ERROR_MESSAGE);
            return;
        }

        int n = Integer.parseInt(numberStr);
        int count = 0;
        for (int i = 2; i <= n; i++) {
            if (isMersennePrime(i)) {
                count++;
            }
        }

        outputField.setText(String.valueOf(count));
    }

    private boolean isPrime(int num) {
        if (num <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }

    private boolean isMersennePrime(int num) {
        if (!isPrime(num)) {
            return false;
        }
        int mersenne = (1 << num) - 1;
        return isPrime(mersenne);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Marsen gui = new Marsen();
            gui.setVisible(true);
        });
    }
}
