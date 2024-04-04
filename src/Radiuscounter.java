import javax.swing.*;

public class Radiuscounter extends JFrame {

    private JLabel inputLabel, outputLabel;
    private JTextField inputField, outputField;
    private JButton countButton;

    public Radiuscounter() {
        setTitle("счетчик точек");
        setSize(300, 200);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);

        inputLabel = new JLabel("введите радиус:");
        inputLabel.setBounds(30, 30, 120, 20);
        add(inputLabel);

        inputField = new JTextField();
        inputField.setBounds(160, 30, 100, 20);
        add(inputField);

        outputLabel = new JLabel("число :");
        outputLabel.setBounds(30, 70, 120, 20);
        add(outputLabel);

        outputField = new JTextField();
        outputField.setEditable(false);
        outputField.setBounds(160, 70, 100, 20);
        add(outputField);

        countButton = new JButton("считать");
        countButton.setBounds(80, 110, 120, 30);
        countButton.addActionListener(e -> countPoints());
        add(countButton);
    }

    private void countPoints() {
        String radiusStr = inputField.getText();
        if (radiusStr.isEmpty() ) {
            JOptionPane.showMessageDialog(this, "введите норм число", "ошибка", JOptionPane.ERROR_MESSAGE);
            return;
        }

        int radius = Integer.parseInt(radiusStr);
        int count = 0;

        for (int x = -radius; x <= radius; x++) {
            for (int y = -radius; y <= radius; y++) {
                if (x * x + y * y <= radius * radius) {
                    count++;
                }
            }
        }

        outputField.setText(String.valueOf(count));
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Radiuscounter gui = new Radiuscounter();
            gui.setVisible(true);
        });
    }
}
