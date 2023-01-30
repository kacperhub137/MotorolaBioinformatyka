import javax.swing.*;
import java.awt.*;

public class Protein{
    public final StringBuilder sequence;
    public JPanel peptide = new JPanel();
    public Protein(StringBuilder sequence)
    {
        this.sequence = sequence;
    }

    public void drawPeptideChain() {
        addStartImage();
        addMiddleImages();
        addEndImage();
        ApplicationWindow.window.getContentPane().add(peptide);
        ApplicationWindow.window.setVisible(true);
    }

    private void addMiddleImages()
    {
        for(int i=0;i<sequence.length()*2-1;i++)
        {
            if(i%4==0)
            {
                addDownImage(sequence.charAt(i/4));
            } else if((i-1)%4==0) {
                addNH();
            }else if((i-2)%4==0) {
                addUpImage(sequence.charAt((i-2)/4));
            }else if((i-3)%4==0){
                addHN();
            }
        }
    }

    private void addStartImage()
    {
        JLabel startImage = new JLabel();
        peptide.add(startImage);
        startImage.setIcon(new ImageIcon("Images/AminaAcidsChains/Start.png"));
    }

    private void addDownImage(char aminoAcid)
    {
        JLabel aminoAcidImage = new JLabel();
        peptide.add(aminoAcidImage);
        aminoAcidImage.setIcon(new ImageIcon("Images/AminaAcidsChains/" + aminoAcid +"Down.png"));
    }

    private void addUpImage(char aminoAcid)
    {
        JLabel aminoAcidImage = new JLabel();
        peptide.add(aminoAcidImage);
        aminoAcidImage.setIcon(new ImageIcon("Images/AminaAcidsChains/" + aminoAcid +"Up.png"));
    }

    private void addNH()
    {
        JLabel NH = new JLabel();
        peptide.add(NH);
        NH.setIcon(new ImageIcon("Images/AminaAcidsChains/NH.png"));
    }

    private void addHN()
    {
        JLabel HN = new JLabel();
        peptide.add(HN);
        HN.setIcon(new ImageIcon("Images/AminaAcidsChains/HN.png"));
    }

    private void addEndImage()
    {
        JLabel endImage = new JLabel();
        peptide.add(endImage);
        endImage.setIcon(new ImageIcon("Images/AminaAcidsChains/EndUp.png"));
    }
}
