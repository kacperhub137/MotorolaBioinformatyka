import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.util.ArrayList;

public class RNAListener implements ActionListener {
    private final JTextField textField;
    private final ApplicationWindow window;
    ArrayList<Protein> Proteins = new ArrayList<>();
    public RNAListener(JTextField textField,ApplicationWindow window)
    {
        this.textField = textField;
        this.window = window;
    }
    public void actionPerformed(ActionEvent event) {
        StringBuilder RNAsequence = new StringBuilder(textField.getText().trim().toUpperCase().replace("T","U"));
        ArrayList<AminoAcid>[] aminoAcids_sequence = new ArrayList[3];
        if(checkInput(RNAsequence))
        {
            for(int i=0;i<3;i++)
            {
                aminoAcids_sequence[i] = new ArrayList<AminoAcid>();
                for (int j = i; j < RNAsequence.length() - 2; j += 3) {
                    aminoAcids_sequence[i].add(new AminoAcid(new StringBuilder(RNAsequence.substring(j, j + 3))));
                }
                findProteins(aminoAcids_sequence[i]);
            }
        }else
        {
            return;
        }
        window.add(Proteins.get(0).getImage());
        System.out.println("Masa: " + Proteins.get(0).getMass());
        System.out.println("GRAVY: " + Proteins.get(0).getHydrophobicityIndex());
        window.setVisible(true);
    }
    private static boolean isRNA(StringBuilder str)
    {
        for(int i=0;i<str.length();i++)
        {
            if(str.charAt(i) != 'A' && str.charAt(i) != 'G' && str.charAt(i) != 'U' && str.charAt(i) != 'C')
            {
                return false;
            }
        }
        return true;
    }
    public static boolean checkInput(StringBuilder str)
    {
        if(!isRNA(str))
        {
            JOptionPane.showMessageDialog(null, "Niepoprawna sekwencja", "Blad" , JOptionPane.INFORMATION_MESSAGE);
            return false;
        }
        return true;
    }
    public void findProteins(ArrayList<AminoAcid> aminoAcid_sequence) {
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
}