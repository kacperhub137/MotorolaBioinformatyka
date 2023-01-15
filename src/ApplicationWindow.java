import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ApplicationWindow extends JFrame {
    private JPanel panelMain;
    private JTextField textField;
    private JButton button;

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

    public void findStartAndEndOfSequence(StringBuilder[] aminoAcid_sequence,ArrayList<Protein> Proteins) {
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
    public ApplicationWindow() {
    button.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            StringBuilder sequence = new StringBuilder(textField.getText().trim().toUpperCase().replace("T","U"));
            StringBuilder[] aminoAcids_sequence = new StringBuilder[3];
            ArrayList<Protein> Proteins = new ArrayList<>();
            if(checkInput(sequence))
            {
                swapCodonsToAminoAcids(aminoAcids_sequence, sequence);
            }
            findStartAndEndOfSequence(aminoAcids_sequence,Proteins);
            for(int i=0;i<Proteins.size();i++){
                JOptionPane.showMessageDialog(null, Proteins.get(i).sequence, "Blad" , JOptionPane.INFORMATION_MESSAGE);
            }
        }
    });
}

    public static void main(String[] args) {
        ApplicationWindow applicationWindow = new ApplicationWindow();
        applicationWindow.setContentPane(applicationWindow.panelMain);
        applicationWindow.setVisible(true);
        applicationWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        applicationWindow.setSize(800,1000);
    }
}
