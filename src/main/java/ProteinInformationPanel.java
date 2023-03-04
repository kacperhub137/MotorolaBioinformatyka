import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.util.Arrays;
import java.util.HashMap;

public class ProteinInformationPanel extends JPanel {
    public ProteinInformationPanel(Protein protein)
    {
        this.protein = protein;
        setProteinInformationPanelProperties();
        addPanels();
    }
}