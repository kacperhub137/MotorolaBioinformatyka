import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.util.ArrayList;

public class RNAListener implements ActionListener {
    private final ApplicationWindow window;
    private StringBuilder RNAsequence = new StringBuilder();
    private final ArrayList<AminoAcid>[] aminoAcids_sequence = new ArrayList[3];
    private final ArrayList<Protein> Proteins = new ArrayList<>();
    public RNAListener(ApplicationWindow window)
    {
        this.window = window;
    }
    public void actionPerformed(ActionEvent event) {
        RNAsequence = new StringBuilder(window.getText().trim().toUpperCase().replace("T", "U"));
        if(isRNA())
        {
            if(swapRNAToProteins())
            {
                JOptionPane.showMessageDialog(window, "Znaleziono proteiny");
                for(Protein protein : Proteins)
                {
                    System.out.println("Masa: " + protein.getMass());
                    System.out.println("GRAVY: " + protein.getHydrophobicityIndex());
                }
                window.dispose();
                new ProteinsWindow(Proteins).setVisible(true);
            }else
            {
                JOptionPane.showMessageDialog(window, "Nie znaleziono protein");
            }
        }else
        {
            JOptionPane.showMessageDialog(window, "Niepoprawna sekwencja");
        }
    }
    private boolean isRNA()
    {
        for(int i=0;i<RNAsequence.length();i++)
        {
            if(RNAsequence.charAt(i) != 'A' && RNAsequence.charAt(i) != 'G' && RNAsequence.charAt(i) != 'U' && RNAsequence.charAt(i) != 'C')
            {
                return false;
            }
        }
        return true;
    }
    private void findProteins(ArrayList<AminoAcid> aminoAcid_sequence) {
        ArrayList<AminoAcid> proteinSequence = new ArrayList<>();
        boolean isProtein = false;
        for (AminoAcid aminoAcid : aminoAcid_sequence) {
            if (aminoAcid.getOneLetterCode() == 'M') {
                isProtein = true;
            }
            if (aminoAcid.getOneLetterCode() == '-' && isProtein) {
                isProtein = false;
                Proteins.add(new Protein(proteinSequence));
                proteinSequence.clear();
            }
            if (isProtein) {
                proteinSequence.add(new AminoAcid(aminoAcid.getCodon()));
            }
        }
    }
    private boolean swapRNAToProteins()
    {
        for(int i=0;i<3;i++)
        {
            aminoAcids_sequence[i] = new ArrayList<>();
            for (int j = i; j < RNAsequence.length() - 2; j += 3) {
                aminoAcids_sequence[i].add(new AminoAcid(new StringBuilder(RNAsequence.substring(j, j + 3))));
            }
            findProteins(aminoAcids_sequence[i]);
        }
        return Proteins.size() > 0;
    }
}