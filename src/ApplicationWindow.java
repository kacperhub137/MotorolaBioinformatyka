import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;

public class ApplicationWindow extends JFrame {
    private JPanel panelMain;
    private JTextField RNATextField;
    private JButton mainButton;
    private JLabel enterText;
    private JButton openFileButton;
    public ApplicationWindow() {
        ApplicationWindow window = this;
        JFileChooser openFileChooser = new JFileChooser();
        openFileChooser.setFileFilter(new FileNameExtensionFilter("TXT files", "txt"));
        mainButton.addActionListener(new RNAListener(RNATextField,window));
        openFileButton.addActionListener(new OpenFIleButtonListener(RNATextField, openFileChooser,window));
    }
    public static void main(String[] args) {
        ApplicationWindow applicationWindow = new ApplicationWindow();
        applicationWindow.setContentPane(applicationWindow.panelMain);
        applicationWindow.setVisible(true);
        applicationWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        applicationWindow.setSize(800,1000);
    }
}