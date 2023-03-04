import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class ProteinsWindow extends JPanel {
    public ProteinsWindow(ArrayList<Protein> proteinsList) {
        setLocation(400, 100);
        setSize(600, 400);
        this.setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
        for (Protein protein : proteinsList) {
            JPanel jp = new ProteinInformationPanel(protein);
            this.add(jp);
        }
    }

}
