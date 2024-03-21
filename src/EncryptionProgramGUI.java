import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;

public class EncryptionProgramGUI implements ActionListener {

    private JFrame frame;
    private JPanel panel;
    private JLabel titleLabel, inputLabel, outputLabel;
    private JTextArea inputArea, outputArea;
    private JButton encryptButton, decryptButton;
    private EncryptionProgram encryptionProgram;

    EncryptionProgramGUI() {
        encryptionProgram = new EncryptionProgram();

        frame = new JFrame("Encryption Program");
        frame.setSize(500, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);

        panel = new JPanel();
        panel.setBounds(0, 0, 500, 400);
        panel.setLayout(null);
        panel.setBackground(new Color(0x5E5E5E)); // Dark gray

        titleLabel = new JLabel("Encryption Program");
        titleLabel.setBounds(0, 10, 500, 30);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        titleLabel.setForeground(Color.WHITE);
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);

        inputLabel = new JLabel("Enter Message:");
        inputLabel.setBounds(20, 50, 150, 20);
        inputLabel.setForeground(Color.WHITE);

        inputArea = new JTextArea();
        inputArea.setBounds(20, 80, 450, 100);
        inputArea.setBorder(BorderFactory.createLineBorder(Color.WHITE));
        inputArea.setBackground(new Color(0xD3D3D3)); // Light gray
        inputArea.setForeground(Color.BLACK);

        outputLabel = new JLabel("Result:");
        outputLabel.setBounds(20, 200, 100, 20);
        outputLabel.setForeground(Color.WHITE);

        outputArea = new JTextArea();
        outputArea.setBounds(20, 230, 450, 100);
        outputArea.setBorder(BorderFactory.createLineBorder(Color.WHITE));
        outputArea.setBackground(new Color(0xD3D3D3)); // Light gray
        outputArea.setForeground(Color.BLACK);
        outputArea.setEditable(false);

        encryptButton = new JButton("Encrypt");
        encryptButton.setBounds(20, 190, 100, 30);
        encryptButton.addActionListener(this);

        decryptButton = new JButton("Decrypt");
        decryptButton.setBounds(130, 190, 100, 30);
        decryptButton.addActionListener(this);

        panel.add(titleLabel);
        panel.add(inputLabel);
        panel.add(inputArea);
        panel.add(outputLabel);
        panel.add(outputArea);
        panel.add(encryptButton);
        panel.add(decryptButton);

        frame.add(panel);
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == encryptButton) {
            String message = inputArea.getText();
            String encryptedMessage = encryptionProgram.encrypt(message);
            outputArea.setText(encryptedMessage);
        } else if (e.getSource() == decryptButton) {
            String message = inputArea.getText();
            String decryptedMessage = encryptionProgram.decrypt(message);
            outputArea.setText(decryptedMessage);
        }
    }

    public static void main(String[] args) {
        new EncryptionProgramGUI();
    }
}