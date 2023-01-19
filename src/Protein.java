import javax.swing.*;
import java.awt.*;

public class Protein{
    public final StringBuilder sequence;
    public Protein(StringBuilder sequence)
    {
        this.sequence = sequence;
    }

    public void drawPeptideChain() {
        /*JLabel structure[] = new JLabel[sequence.length() * 2 + 1];
        for (int i = 0; i < structure.length; i++) {
            structure[i] = new JLabel("");

        }*/
        JLabel structure = new JLabel("wwww");
        structure.setIcon(new ImageIcon("C:\\Users\\egzaminInf03_202301\\IdeaProjects\\MotorolaBioinformatyka\\Images\\AminaAcidsChains\\Start.png"));
        ApplicationWindow.window.getContentPane().add(structure);

    }

}
