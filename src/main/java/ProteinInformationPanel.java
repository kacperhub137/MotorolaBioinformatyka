import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.util.Arrays;
import java.util.HashMap;

public class ProteinInformationPanel extends JPanel {
    public ProteinInformationPanel(Protein protein)
    {
        Border blackline = BorderFactory.createLineBorder(Color.black);
        this.setBorder(blackline);
        this.setAlignmentY(Component.CENTER_ALIGNMENT);
        this.add(protein.getImage());
        this.add(new JLabel("Masa: " + protein.getMass()));
        this.add(new JLabel("GRAVY: " + protein.getHydrophobicityIndex()));
        this.add(new JLabel("Net charge at pH = 7: " + protein.getNetCharge()));
        this.add(new JLabel("Polarity: " + protein.getPolarity()));
        this.add(new JLabel("Molecular mass: " + protein.getMolecularMass()));
        this.add(new JLabel("Isoelectric point: " + protein.getIsoelectricPoint()));
        String empty = "";
        for (HashMap.Entry<Character, Integer> entry : protein.getAminoAcidCounts().entrySet()) {
            empty += entry.getKey() + ": " + entry.getValue();
        }
        this.add(new JLabel(empty));
        this.add(new NetChargeDiagram(protein));
        this.add(AminoAcidCompositionDiagram.createDiagram(protein));
        //this.add(new JLabel(protein.getFormula()));
        this.add(AtomsCompositionDiagram.createDiagram(protein));
    }
}