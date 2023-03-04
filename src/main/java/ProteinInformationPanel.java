import com.sun.deploy.panel.JavaPanel;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.plaf.FontUIResource;
import java.awt.*;
import java.util.Arrays;
import java.util.HashMap;

public class ProteinInformationPanel extends JPanel {
    private final Protein protein;
    public ProteinInformationPanel(Protein protein)
    {
        this.protein = protein;
        setProteinInformationPanelProperties();
        addPanels();
    }

    private void addPanels()
    {
        JLabel RNAString = setTitleLabel();
        this.add(RNAString);
        this.add(protein.getImage());
        JPanel upperPanel = createUpperPanel();
        this.add(upperPanel);
        JPanel lowerPanel = createLowerPanel();
        this.add(lowerPanel);
    }

    private JLabel setTitleLabel()
    {
        JLabel Title = label(new JLabel("Białko zamienione na aminokwasy: " +protein.getRNAString()));
        Title.setMaximumSize(new Dimension(500,500));
        Title.setMinimumSize(new Dimension(500,500));
        return Title;
    }

    private void setProteinInformationPanelProperties()
    {
        this.setBackground(new Color(105, 220, 158));
        Border blackline = BorderFactory.createLineBorder(Color.black);
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.setBorder(blackline);
        this.setAlignmentY(Component.CENTER_ALIGNMENT);
    }

    private JPanel createUpperPanel()
    {
        JPanel upperPanel = new JPanel();
        upperPanel.setLayout(new BoxLayout(upperPanel, BoxLayout.X_AXIS));
        upperPanel.add(Box.createRigidArea(new Dimension(200,0)));
        upperPanel.add(proteinInformations());
        upperPanel.add(new NetChargeDiagram(protein));
        return panel(upperPanel);
    }

    private JPanel createLowerPanel()
    {
        JPanel lowerPanel = new JPanel();
        lowerPanel.setLayout(new BoxLayout(lowerPanel, BoxLayout.X_AXIS));
        lowerPanel.add(panel(AminoAcidCompositionDiagram.createDiagram(protein)));
        lowerPanel.add(panel(AtomsCompositionDiagram.createDiagram(protein)));
        return panel(lowerPanel);
    }

    private JLabel label(JLabel text)
    {
        text.setFont(new Font("JetBrains Mono", Font.BOLD , 20));
        text.setForeground(new Color(12, 12 , 12));
        return text;
    }

    private JPanel panel(JPanel panel)
    {
        panel.setBackground(new Color(105, 220, 158));
        return panel;
    }

    private JPanel proteinInformations()
    {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel,BoxLayout.Y_AXIS));
        panel.add(label(new JLabel("Masa: " + protein.getMass())));
        panel.add(label(new JLabel("GRAVY: " + protein.getHydrophobicityIndex())));
        panel.add(label(new JLabel("Net charge dla pH = 7: " + protein.getNetCharge())));
        panel.add(label(new JLabel("Polarność białka: " + protein.getPolarity())));
        panel.add(label(new JLabel("Punkt izoelektryczny: " + protein.getIsoelectricPoint())));
        panel.add(label(new JLabel("Wzór: " + protein.getFormula())));
        return panel(panel);
    }
}