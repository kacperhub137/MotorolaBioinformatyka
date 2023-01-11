import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ApplicationWindow extends JFrame {
    private JPanel panelMain;
    private JTextField textField;
    private JButton button;
    public JLabel label1;
    public JLabel label2;
    public JLabel label3;

    private static boolean isDNA(StringBuilder str)
    {
        for(int i=0;i<str.length();i++)
        {
            if(str.charAt(i) != 'A' && str.charAt(i) != 'G' && str.charAt(i) != 'T' && str.charAt(i) != 'C')
            {
                return false;
            }
        }
        return true;
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
        return isDNA(str) || isRNA(str);
    }

    public void swapCodonsToAminoAcids(StringBuilder str)
    {
        StringBuilder proteinSequence = new StringBuilder();
        for (int j = 0; j < 3; j++) {
            for (int i = j; i < str.length() - 2; i += 3) {
                String currentCodon = str.substring(i, i + 3);
                switch (currentCodon) {
                    case "UUU":
                    case "UUC":
                        proteinSequence.append("F");
                        break;
                    case "UUA":
                    case "UUG":
                    case "CUU":
                    case "CUC":
                    case "CUA":
                    case "CUG":
                        proteinSequence.append("L");
                        break;
                    case "GGA":
                    case "GGC":
                    case "GGG":
                    case "GGU":
                        proteinSequence.append("G");
                        break;
                    case "AUU":
                    case "AUC":
                    case "AUA":
                        proteinSequence.append("I");
                        break;
                    case "AUG":
                        proteinSequence.append("M");
                        break;
                    case "GUU":
                    case "GUC":
                    case "GUA":
                    case "GUG":
                        proteinSequence.append("V");
                        break;
                    case "UCU":
                    case "UCC":
                    case "UCA":
                    case "UCG":
                    case "AGU":
                    case "AGC":
                        proteinSequence.append("S");
                        break;
                    case "CCU":
                    case "CCC":
                    case "CCA":
                    case "CCG":
                        proteinSequence.append("P");
                        break;
                    case "ACU":
                    case "ACC":
                    case "ACA":
                    case "ACG":
                        proteinSequence.append("T");
                        break;
                    case "GCU":
                    case "GCC":
                    case "GCA":
                    case "GCG":
                        proteinSequence.append("A");
                        break;
                    case "UAU":
                    case "UAC":
                        proteinSequence.append("Y");
                        break;
                    case "CAU":
                    case "CAC":
                        proteinSequence.append("H");
                        break;
                    case "CAA":
                    case "CAG":
                        proteinSequence.append("Q");
                        break;
                    case "AAU":
                    case "AAC":
                        proteinSequence.append("N");
                        break;
                    case "AAA":
                    case "AAG":
                        proteinSequence.append("K");
                        break;
                    case "GAU":
                    case "GAC":
                        proteinSequence.append("D");
                        break;
                    case "GAA":
                    case "GAG":
                        proteinSequence.append("E");
                        break;
                    case "UGU":
                    case "UGC":
                        proteinSequence.append("C");
                        break;
                    case "UGG":
                        proteinSequence.append("W");
                        break;
                    case "CGU":
                    case "CGC":
                    case "CGA":
                    case "CGG":
                    case "AGA":
                    case "AGG":
                        proteinSequence.append("R");
                        break;
                    case "UAA":
                    case "UAG":
                    case "UGA":
                        proteinSequence.append("-");
                        break;
                }
            }
            if (j == 0)
                label1.setText("1:   "+ proteinSequence);
            if (j == 1)
                label2.setText("2:   "+ proteinSequence);
            if (j == 2)
                label3.setText("3:   "+ proteinSequence);
            proteinSequence.setLength(0);
        }
    }

    public ApplicationWindow() {
    button.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            StringBuilder sequence = new StringBuilder(textField.getText().trim().toUpperCase());
            if(!checkInput(sequence))
            {
                JOptionPane.showMessageDialog(null, "Niepoprawna sekwencja", "Blad" , JOptionPane.INFORMATION_MESSAGE);
            }else {
                swapCodonsToAminoAcids(sequence);
            }
        }
    });
}

    public static void main(String[] args) {
        ApplicationWindow applicationWindow = new ApplicationWindow();
        applicationWindow.setContentPane(applicationWindow.panelMain);
        applicationWindow.setVisible(true);
        applicationWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        applicationWindow.setSize(300,400);
    }
}
