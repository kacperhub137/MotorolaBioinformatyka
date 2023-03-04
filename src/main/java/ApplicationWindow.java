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
    public JPanel panelCenter;
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
        applicationWindow.setExtendedState(JFrame.MAXIMIZED_BOTH);
        JScrollPane scrollFrame = new JScrollPane(applicationWindow.panelCenter);
        applicationWindow.panelCenter.setAutoscrolls(true);
        applicationWindow.panelCenter.setBackground(new Color(105, 220, 158));
        scrollFrame.setPreferredSize(new Dimension( 800,300));
        applicationWindow.add(scrollFrame);
    }
    public String getText() {
        return RNATextField.getText();
    }
}