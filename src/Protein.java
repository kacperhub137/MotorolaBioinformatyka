import javax.swing.*;
import java.awt.*;
import java.util.HashMap;

public class Protein extends ProteinImage{
    private final StringBuilder sequence;
    private final JPanel peptide;
    private final double mass;
    private static final HashMap<Character, Double> aminoAcidMasses = new HashMap<>();
    static {
        aminoAcidMasses.put('A', 89.0475);
        aminoAcidMasses.put('C', 121.0196);
        aminoAcidMasses.put('D', 133.0373);
        aminoAcidMasses.put('E', 147.0529);
        aminoAcidMasses.put('F', 165.0787);
        aminoAcidMasses.put('G', 75.0319);
        aminoAcidMasses.put('H', 155.0693);
        aminoAcidMasses.put('I', 131.0943);
        aminoAcidMasses.put('K', 146.1052);
        aminoAcidMasses.put('L', 131.0943);
        aminoAcidMasses.put('M', 149.0508);
        aminoAcidMasses.put('N', 132.0533);
        aminoAcidMasses.put('P', 115.0631);
        aminoAcidMasses.put('Q', 146.0689);
        aminoAcidMasses.put('R', 174.1114);
        aminoAcidMasses.put('S', 105.0424);
        aminoAcidMasses.put('T', 119.0580);
        aminoAcidMasses.put('V', 117.0787);
        aminoAcidMasses.put('W', 204.0896);
        aminoAcidMasses.put('Y', 181.0736);
    }

    public Protein(StringBuilder sequence)
    {
        super(sequence);
        this.sequence = sequence;
        this.peptide = makePeptideChain();
        this.mass = calculateMass();
    }
    public JPanel getImage()
    {
        return peptide;
    }
    public double getMass() { return mass; }
    private double calculateMass() {
        double mass = 0;
        for (int i = 0; i < sequence.length(); i++) {
            char aminoAcid = sequence.charAt(i);
            mass += aminoAcidMasses.getOrDefault(aminoAcid, 0.0);
        }
        return mass;
    }
    private double calculateHydrophobicityIndex(){
        HashMap<Character, Double> hydrophobicityValues = new HashMap<>();
        hydrophobicityValues.put('A', 0.62);
        hydrophobicityValues.put('C', 0.29);
        hydrophobicityValues.put('D', -0.90);
        hydrophobicityValues.put('E', -0.74);
        hydrophobicityValues.put('F', 1.19);
        hydrophobicityValues.put('G', 0.48);
        hydrophobicityValues.put('H', -0.40);
        hydrophobicityValues.put('I', 1.38);
        hydrophobicityValues.put('K', -1.50);
        hydrophobicityValues.put('L', 1.06);
        hydrophobicityValues.put('M', 0.64);
        hydrophobicityValues.put('N', -0.78);
        hydrophobicityValues.put('P', 0.12);
        hydrophobicityValues.put('Q', -0.85);
        hydrophobicityValues.put('R', -2.53);
        hydrophobicityValues.put('S', -0.18);
        hydrophobicityValues.put('T', -0.05);
        hydrophobicityValues.put('V', 1.08);
        hydrophobicityValues.put('W', 0.81);
        hydrophobicityValues.put('Y', 0.26);
        double hydrophobicitySum = 0.0;
        for (int i = 0; i < sequence.length(); i++) {
            char aminoAcid = sequence.charAt(i);
            hydrophobicitySum += hydrophobicityValues.get(aminoAcid);
        }
        double hydrophobicityIndex = hydrophobicitySum / sequence.length();
        return hydrophobicityIndex;
    }
    private double calculateIndexpH(){
        HashMap<Character, Double> pHValues = new HashMap<>();
        pHValues.put('D', 3.90);
        pHValues.put('E', 4.07);
        pHValues.put('Y', 10.07);
        pHValues.put('C', 8.33);
        pHValues.put('H', 6.04);
        pHValues.put('K', 10.54);
        double ph= 0.0;
        return ph;
    }
}