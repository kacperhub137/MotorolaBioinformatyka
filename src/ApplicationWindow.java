import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;

public class ApplicationWindow extends JFrame {
    private JPanel panelMain;
    private JPanel pnlSide;
    private JPanel pnlCenter;
    private JTextField RNATextField;
    private JButton mainButton;
    private JButton openFileButton;
    private JButton Home;
    private JButton Files;

    public ApplicationWindow() {
        ApplicationWindow window = this;
        JFileChooser openFileChooser = new JFileChooser();
        openFileChooser.setFileFilter(new FileNameExtensionFilter("TXT files", "txt"));
        mainButton.addActionListener(new RNAListener(window));
        openFileButton.addActionListener(new OpenFIleButtonListener(RNATextField, openFileChooser,window));
    }
    public static void main(String[] args) {
        ApplicationWindow applicationWindow = new ApplicationWindow();
        applicationWindow.setContentPane(applicationWindow.panelMain);
        applicationWindow.setVisible(true);
        applicationWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        applicationWindow.setSize(500,150);
    }
    public String getText()
    {
        return RNATextField.getText();
    }
}