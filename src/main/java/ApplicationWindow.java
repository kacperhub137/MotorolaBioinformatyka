import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ApplicationWindow extends JFrame {
    private JPanel panelMain;
    private JPanel panelMenu;
    private JPanel panelHeader;
    private JPanel panelCenter;
    private JTextField RNATextField;
    private JButton mainButton;
    private JButton openFileButton;
    private JLabel labelEtap1;
    private JLabel labelEtap2;
    private JLabel labelEtap3;
    private JPanel menu1;
    private JPanel menu2;
    private JPanel menu3;
    private JLabel menuName;
    Color defaultColor, clickedColor;
    public ApplicationWindow() {
        JFileChooser openFileChooser = new JFileChooser();
        openFileChooser.setFileFilter(new FileNameExtensionFilter("TXT files", "txt"));
        this.mainButton.addActionListener(new RNAListener(this));
        this.openFileButton.addActionListener(new OpenFIleButtonListener(RNATextField, openFileChooser, this));
        defaultColor = new Color(12 ,12 ,12);
        clickedColor = new Color(255,255,255);
        menu1.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent mouseEvent) {
                super.mousePressed(mouseEvent);
                menu1.setBackground(clickedColor);
                menu2.setBackground(defaultColor);
                menu3.setBackground(defaultColor);

                menuName.setText("Etap 1");
            }
        });
        menu2.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent mouseEvent) {
                super.mousePressed(mouseEvent);
                menu1.setBackground(defaultColor);
                menu2.setBackground(clickedColor);
                menu3.setBackground(defaultColor);

                menuName.setText("Etap 2");
            }
        });
        menu3.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent mouseEvent) {
                super.mousePressed(mouseEvent);
                menu1.setBackground(defaultColor);
                menu2.setBackground(defaultColor);
                menu3.setBackground(clickedColor);

                menuName.setText("Etap 3");
            }
        });

        menu1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent mouseEvent) {
                super.mouseClicked(mouseEvent);


            }
        });
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