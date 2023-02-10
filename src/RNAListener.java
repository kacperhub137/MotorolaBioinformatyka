import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.util.ArrayList;

public class RNAListener implements ActionListener {

    public void actionPerformed(ActionEvent event) {
        StringBuilder sequence = new StringBuilder(ApplicationWindow.window.textField.getText().trim().toUpperCase().replace("T","U"));
        StringBuilder[] aminoAcids_sequence = new StringBuilder[3];
        ArrayList<Protein> Proteins = new ArrayList<>();
        if(checkInput(sequence))
        {
            swapCodonsToAminoAcids(aminoAcids_sequence, sequence);
        }else
        {
            return;
        }
        findProteins(aminoAcids_sequence,Proteins);
        ApplicationWindow.window.getContentPane().add(Proteins.get(0).getImage());
        System.out.println(Proteins.get(0).getMass());
        ApplicationWindow.window.setVisible(true);
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
    public void swapCodonsToAminoAcids(StringBuilder[] aminoAcids_sequence,StringBuilder str)
    {
        String[] CODONS = {
                "UUU", "UUC", "UUA", "UUG", "UCU",
                "UCC", "UCA", "UCG", "UAU", "UAC", "UGU", "UGC", "UGG", "CUU",
                "CUC", "CUA", "CUG", "CCU", "CCC", "CCA", "CCG", "CAU", "CAC",
                "CAA", "CAG", "CGU", "CGC", "CGA", "CGG", "AUU", "AUC", "AUA",
                "AUG", "ACU", "ACC", "ACA", "ACG", "AAU", "AAC", "AAA", "AAG",
                "AGU", "AGC", "AGA", "AGG", "GUU", "GUC", "GUA", "GUG", "GCU",
                "GCC", "GCA", "GCG", "GAU", "GAC", "GAA", "GAG", "GGU", "GGC",
                "GGA", "GGG", "UGA" , "UAG" , "UAA"};

        String[] AMINOS_PER_CODON = {
                "F", "F", "L", "L", "S", "S",
                "S", "S", "Y", "Y", "C", "C", "W", "L", "L", "L", "L", "P", "P",
                "P", "P", "H", "H", "Q", "Q", "R", "R", "R", "R", "I", "I", "I",
                "M", "T", "T", "T", "T", "N", "N", "K", "K", "S", "S", "R", "R",
                "V", "V", "V", "V", "A", "A", "A", "A", "D", "D", "E", "E", "G",
                "G", "G", "G", "-" , "-", "-"};

        StringBuilder proteinSequence = new StringBuilder();
        for (int j = 0; j < 3; j++) {
            for (int i = j; i < str.length() - 2; i += 3) {
                String currentCodon = str.substring(i, i + 3);
                for (int k = 0; k < CODONS.length; k++) {
                    if (CODONS[k].equals(currentCodon)) {
                        proteinSequence.append(AMINOS_PER_CODON[k]);
                    }
                }
            }
            aminoAcids_sequence[j] = new StringBuilder(proteinSequence);
            proteinSequence.setLength(0);
        }
    }

    public void findProteins(StringBuilder[] aminoAcid_sequence,ArrayList<Protein> Proteins) {
        StringBuilder proteinSequence = new StringBuilder();
        for (int i = 0; i < 3; i++) {
            boolean isProtein = false;
            for (int j = 0; j < aminoAcid_sequence[i].length(); j++) {
                if (aminoAcid_sequence[i].substring(j, j + 1).equals("M")) {
                    isProtein = true;
                }
                if (aminoAcid_sequence[i].substring(j, j + 1).equals("-") && isProtein) {
                    isProtein = false;
                    Proteins.add(new Protein(proteinSequence));
                    proteinSequence = new StringBuilder();
                }
                if (isProtein) {
                    proteinSequence.append(aminoAcid_sequence[i].substring(j, j + 1));
                }
            }
        }
    }
}
