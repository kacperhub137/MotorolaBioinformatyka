import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ApplicationWindow extends JFrame {
    private JPanel panelMain;
    private JTextField textField;
    private JButton button;
    private JLabel label1;
    private JLabel label2;
    private JLabel label3;
    private JLabel label4;


    public ApplicationWindow() {
    button.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            //JOptionPane.showMessageDialog(button, textField.getText());

            String displacementOne = textField.getText();
            String displacementTwo = textField.getText();
            String displacementThree = textField.getText();
            displacementOne.trim();
            displacementTwo.trim();
            displacementThree.trim();
            displacementOne.toUpperCase();
            displacementTwo.toUpperCase();
            displacementThree.toUpperCase();

            //label1.setText("+1: " + displacementOne.replaceAll("(.{" + 3 + "})", "$1 ").trim());
            //label2.setText("+2: " + displacementTwo.substring(1).replaceAll("(.{" + 3 + "})", "$1 ").trim());
            //label3.setText("+3: " + displacementThree.substring(2).replaceAll("(.{" + 3 + "})", "$1 ").trim());

            String firstSequence = "AAAUGAACGAAAAUCUGUUCGCUUCAUUCAUUGCCCCCACAAUCCUAGGCCUAC";
            String secondSequence = "AUGAACGAAAAUCUGUUCGCUUCAUUCAUUGCCCCCACAAUCCUAGGCCUACCC";
            //String one = firstSequence.trim();
            //String two = secondSequence.trim();
            String proteinSequence = "";

            for (int i = 0; i < secondSequence.length(); i += 3) {
                String currentCodon = secondSequence.substring(i, i + 3);
                switch (currentCodon) {
                    case "UUU":
                    case "UUC":
                        proteinSequence += "F";
                        break;
                    case "UUA":
                    case "UUG":
                    case "CUU":
                    case "CUC":
                    case "CUA":
                    case "CUG":
                        proteinSequence += "L";
                        break;
                    case "AUU":
                    case "AUC":
                    case "AUA":
                        proteinSequence += "I";
                        break;
                    case "AUG":
                        proteinSequence += "M";
                        break;
                    case "GUU":
                    case "GUC":
                    case "GUA":
                    case "GUG":
                        proteinSequence += "V";
                        break;
                    case "UCU":
                    case "UCC":
                    case "UCA":
                    case "UCG":
                    case "AGU":
                    case "AGC":
                        proteinSequence += "S";
                        break;
                    case "CCU":
                    case "CCC":
                    case "CCA":
                    case "CCG":
                        proteinSequence += "P";
                        break;
                    case "ACU":
                    case "ACC":
                    case "ACA":
                    case "ACG":
                        proteinSequence += "T";
                        break;
                    case "GCU":
                    case "GCC":
                    case "GCA":
                    case "GCG":
                        proteinSequence += "A";
                        break;
                    case "UAU":
                    case "UAC":
                        proteinSequence += "Y";
                        break;
                    case "CAU":
                    case "CAC":
                        proteinSequence += "H";
                        break;
                    case "CAA":
                    case "CAG":
                        proteinSequence += "Q";
                        break;
                    case "AAU":
                    case "AAC":
                        proteinSequence += "N";
                        break;
                    case "AAA":
                    case "AAG":
                        proteinSequence += "K";
                        break;
                    case "GAU":
                    case "GAC":
                        proteinSequence += "D";
                        break;
                    case "GAA":
                    case "GAG":
                        proteinSequence += "E";
                        break;
                    case "UGU":
                    case "UGC":
                        proteinSequence += "C";
                        break;
                    case "UGG":
                        proteinSequence += "W";
                        break;
                    case "CGU":
                    case "CGC":
                    case "CGA":
                    case "CGG":
                    case "AGA":
                    case "AGG":
                        proteinSequence += "R";
                        break;
                    default:
                        //proteinSequence = "error";
                };
            }
            label4.setText(proteinSequence);
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
