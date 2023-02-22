import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class ProteinsWindow extends JFrame {
    public ProteinsWindow(ArrayList<Protein> proteinsList) {
        setTitle("Proteins informations");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocation(400, 100);
        setSize(600, 400);
        Container frame = getContentPane();
        frame.setLayout(new BoxLayout(frame, BoxLayout.X_AXIS));
        for (Protein protein : proteinsList) {
            JPanel jp = new ProteinInformationPanel(protein);
            frame.add(jp);
        }
    }

}
