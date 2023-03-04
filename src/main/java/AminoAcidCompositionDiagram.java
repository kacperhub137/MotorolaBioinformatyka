import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import org.jfree.chart.*;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;


public class AminoAcidCompositionDiagram{
    private final Protein protein;
    public static JPanel createDiagram(Protein protein)
    {
        return new AminoAcidCompositionDiagram(protein).createDiagram();
    }
    private AminoAcidCompositionDiagram(Protein protein) {
        this.protein = protein;
    }
    private JPanel createDiagram()
    {
        JFreeChart aminoAcidsCompositionDiagram = ChartFactory.createPieChart("Amino Acids Composition", createDataset(), false,true, false);
        aminoAcidsCompositionDiagram.setBackgroundPaint(new Color(105, 220, 158));
        aminoAcidsCompositionDiagram.getPlot().setBackgroundPaint(new Color(105, 220, 158));
        ChartPanel aminoAcidsCompositionPanel = new ChartPanel(aminoAcidsCompositionDiagram);
        aminoAcidsCompositionPanel.setPreferredSize( new java.awt.Dimension( 350 , 350 ) );
        return aminoAcidsCompositionPanel;
    }
    private PieDataset createDataset() {
        DefaultPieDataset aminoAcidsCompositionDataset = new DefaultPieDataset();
        for (HashMap.Entry<Character, Integer> entry : protein.getAminoAcidCounts().entrySet()) {
            if(entry.getValue()!=0)
                aminoAcidsCompositionDataset.setValue(entry.getKey(),entry.getValue());
        }
        return aminoAcidsCompositionDataset;
    }
}
