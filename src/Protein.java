import javax.swing.*;
import java.awt.*;

public class Protein extends ProteinImage{
    private StringBuilder sequence;
    private final JPanel peptide;
    public Protein(StringBuilder sequence)
    {
        super(sequence);
        this.sequence = sequence;
        this.peptide = makePeptideChain();
    }

    public JPanel getImage()
    {
        return peptide;
    }
}
