import javax.swing.*;
import java.util.HashMap;
import org.jfree.chart.*;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;

public class AtomsCompositionDiagram {
    private final Protein protein;

    public static JPanel createDiagram(Protein protein)
    {
        return new AtomsCompositionDiagram(protein).createDiagram();
    }

    private AtomsCompositionDiagram(Protein protein)
    {
        this.protein = protein;
    }

    private JPanel createDiagram()
    {
        JFreeChart atomsCompositionDiagram = ChartFactory.createPieChart("Amino Acids Composition", createDataset(), false,true, false);
        ChartPanel atomsCompositionPanel = new ChartPanel(atomsCompositionDiagram);
        return atomsCompositionPanel;
    }
    private DefaultPieDataset createDataset()
    {
        DefaultPieDataset atomsCompositionDataset = new DefaultPieDataset();
        for (HashMap.Entry<Character, Integer> entry : protein.getFormulaAsHashMap().entrySet()) {
            if(entry.getValue()!=0)
                atomsCompositionDataset.setValue(entry.getKey(),entry.getValue());
        }
        return atomsCompositionDataset;
    }
}
