import javax.swing.*;
import java.awt.*;

public class Protein{
    public final StringBuilder sequence;
    public Protein(StringBuilder sequence)
    {
        this.sequence = sequence;
    }

    public void drawPeptideChain() {
        JPanel peptide = new JPanel();
        JLabel structure = new JLabel();
        peptide.add(structure);
        structure.setIcon(new ImageIcon("Images/AminaAcidsChains/Start.png"));
        ApplicationWindow.window.getContentPane().add(peptide);
        ApplicationWindow.window.setVisible(true);
    }

}
