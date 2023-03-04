import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JScrollPane;

public class ApplicationWindow extends JFrame {
    private JPanel panelMain;
    private JPanel panelMenu;
    private JPanel panelHeader;
    private JPanel panelCenter;
    private JTextField RNATextField;
    private JButton mainButton;
    private JButton openFileButton;

    public ApplicationWindow() {
        JFileChooser openFileChooser = new JFileChooser();
        openFileChooser.setFileFilter(new FileNameExtensionFilter("TXT files", "txt"));
        this.mainButton.addActionListener(new RNAListener(this));
        this.openFileButton.addActionListener(new OpenFIleButtonListener(RNATextField, openFileChooser, this));
    }
    public static void main(String[] args) {
        ApplicationWindow applicationWindow = new ApplicationWindow();
        applicationWindow.setContentPane(applicationWindow.panelMain);
        applicationWindow.setVisible(true);
        applicationWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        applicationWindow.setSize(1000, 900 );
    }
    public String getText() {
        return RNATextField.getText();
    }
}