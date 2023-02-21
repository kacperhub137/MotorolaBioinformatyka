import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class ProteinsWindow extends JFrame {
    public ProteinsWindow(ArrayList<Protein> proteinsList)
    {
        setTitle("Proteins informations");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocation(400,100);
        setSize(600,400);
        Container frame = getContentPane();
        JPanel jp = new JPanel();
        for(Protein protein : proteinsList)
        {
            jp.add(protein.getImage());
        }
        frame.add(jp);
    }
}
