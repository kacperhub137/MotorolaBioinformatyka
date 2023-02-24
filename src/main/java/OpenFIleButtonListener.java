import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.*;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class OpenFIleButtonListener implements ActionListener {
    private final JTextField textField;
    private final JFileChooser openFIleChooser;
    private final ApplicationWindow window;
    public OpenFIleButtonListener(JTextField textField,JFileChooser openFIleChooser,ApplicationWindow window)
    {
        this.textField = textField;
        this.openFIleChooser = openFIleChooser;
        this.window = window;
    }
    public void actionPerformed(ActionEvent e) {
        int returnValue = openFIleChooser.showOpenDialog(window);
        if(returnValue == JFileChooser.APPROVE_OPTION)
        {
            try
            {
                StringBuilder RNA = new StringBuilder();
                File RNAFile = openFIleChooser.getSelectedFile();
                Scanner fileScanner = new Scanner(RNAFile);
                while(fileScanner.hasNextLine())
                {
                    RNA.append(fileScanner.nextLine());
                }
                fileScanner.close();
                textField.setText(String.valueOf(RNA));
            }catch(FileNotFoundException ignored) {}
        }
    }
}
