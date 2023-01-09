import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ApplicationWindow extends JFrame {
    private JPanel panelMain;
    private JTextField textField;
    private JButton button;
    private JLabel label1;
    private JLabel label2;
    private JLabel label3;


    public ApplicationWindow() {
    button.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            //JOptionPane.showMessageDialog(button, textField.getText());

            String displacementOne = textField.getText();
            String displacementTwo = textField.getText();
            String displacementThree = textField.getText();
            displacementOne.trim();
            displacementTwo.trim();
            displacementThree.trim();
            displacementOne.toUpperCase();
            displacementTwo.toUpperCase();
            displacementThree.toUpperCase();

            label1.setText("+1: "+displacementOne.replaceAll("(.{" + 3 + "})", "$1 ").trim());
            label2.setText("+2: "+displacementTwo.substring(1).replaceAll("(.{" + 3 + "})", "$1 ").trim());
            label3.setText("+3: "+displacementThree.substring(2).replaceAll("(.{" + 3 + "})", "$1 ").trim());
        }
    });
}

    public static void main(String[] args) {
        ApplicationWindow applicationWindow = new ApplicationWindow();
        applicationWindow.setContentPane(applicationWindow.panelMain);
        applicationWindow.setVisible(true);
        applicationWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        applicationWindow.setSize(300,400);
    }
}
