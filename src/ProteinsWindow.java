import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.BorderFactory;
import javax.swing.border.Border;

public class ProteinsWindow extends JFrame {
    public ProteinsWindow(ArrayList<Protein> proteinsList)
    {
        setTitle("Proteins informations");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocation(400,100);
        setSize(600,400);
        Container frame = getContentPane();
        frame.setLayout(new BoxLayout(frame,BoxLayout.X_AXIS));
        for(Protein protein : proteinsList)
        {
            JPanel jp = new JPanel();
            Border blackline = BorderFactory.createLineBorder(Color.black);
            jp.setBorder(blackline);
            jp.setAlignmentY(Component.CENTER_ALIGNMENT);
            jp.add(protein.getImage());
            jp.add(new JLabel("Masa: " + protein.getMass()));
            jp.add(new JLabel("GRAVY: " + protein.getHydrophobicityIndex()));
            jp.add(new JLabel("Net charge: " + protein.getNetCharge()));
            frame.add(jp);
        }
    }
}
