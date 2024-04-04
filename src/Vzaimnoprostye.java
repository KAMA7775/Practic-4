import javax.swing.*;

public class Vzaimnoprostye extends JFrame {

    private JLabel inputLabel, outputLabel;
    private JTextField inputField, outputField;
    private JButton countButton;

    public Vzaimnoprostye() {
        setTitle("счетчик взаимно прост чисел");
        setSize(300, 200);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);

        inputLabel = new JLabel("введите число :");
        inputLabel.setBounds(30, 30, 120, 20);
        add(inputLabel);

        inputField = new JTextField();
        inputField.setBounds(180, 30, 100, 20);
        add(inputField);

        outputLabel = new JLabel("ответ :");
        outputLabel.setBounds(30, 70, 150, 20);
        add(outputLabel);

        outputField = new JTextField();
        outputField.setEditable(false);
        outputField.setBounds(180, 70, 80, 20);
        add(outputField);

        countButton = new JButton("считать");
        countButton.setBounds(80, 110, 120, 30);
        countButton.addActionListener(e -> countvznum());
        add(countButton);
    }

    private void countvznum() {
        String numberStr = inputField.getText();
        if (numberStr.isEmpty()) {
            JOptionPane.showMessageDialog(this, "введите норм число", "ошибка", JOptionPane.ERROR_MESSAGE);
            return;
        }

        int n = Integer.parseInt(numberStr);
        int count = 0;

        for (int i = 1; i <= n; i++) {
            if (nod(n, i) == 1) {
                count++;
            }
        }

        outputField.setText(String.valueOf(count));
    }


    private int nod(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Vzaimnoprostye vznum = new Vzaimnoprostye();
            vznum.setVisible(true);
        });
    }
}
