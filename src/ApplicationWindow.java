import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import  java.util.HashMap;
public class ApplicationWindow extends JFrame {
    private JPanel panelMain;
    public JTextField textField;
    protected JButton button;
    private JLabel text;
    protected JLabel aminoAcidMass;
    public static ApplicationWindow window;
    ActionListener listener = new RNAListener();

    public ApplicationWindow() {
        window = this;
        button.addActionListener(listener);
    }

    public static void main(String[] args) {
        ApplicationWindow applicationWindow = new ApplicationWindow();
        applicationWindow.setContentPane(applicationWindow.panelMain);
        applicationWindow.setVisible(true);
        applicationWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        applicationWindow.setSize(800,1000);
    }
}
