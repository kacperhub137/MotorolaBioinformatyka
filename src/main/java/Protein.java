import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;

public class Protein extends ProteinImage {
    private final ArrayList<AminoAcid> sequence;
    private final JPanel peptide;
    private final double mass;
    private final double hydrophobicityIndex;
    private final double pH;
    private final int netChargeAtPH7;
    private final int polarity;
    private final double molecularMass;
    private HashMap<Character,Integer> aminoAcidCounts;
    private final double extinctionCoefficient;
    // private  final HashMap<Character, Integer> aminoAcidCounts = new HashMap<>();
    public Protein(ArrayList<AminoAcid> sequence) {
        super(sequence);
        this.sequence = sequence;
        this.peptide = makePeptideChain();
        this.mass = calculateMass();
        this.hydrophobicityIndex = calculateHydrophobicityIndex();
        this.pH = calculateIndexpH();
        this.netChargeAtPH7 = calculateNetCharge(7);
        this.polarity = checkPolarity();
        this.molecularMass = calculateMolecularMass();
    }

    public JPanel getImage() {
        return peptide;
    }

    public double getMass() {
        return mass;
    }

    public double getHydrophobicityIndex() {
        return hydrophobicityIndex;
    }

    public int getNetCharge() {
        return netChargeAtPH7;
    }

    public int getNetCharge(double pH) {
        return calculateNetCharge(pH);
    }

    public int getPolarity() {
        return polarity;
    }

    public double getMolecularMass() {
        return molecularMass;
    }

    public double getIsoelectricPoint() {
        return isoelectricPoint;
    }
    public double getExtinctionCoefficient(){
        return extinctionCoefficient;
    }
    public HashMap<Character,Integer> getAminoAcidCounts(){
        return aminoAcidCounts;
    }

    private double calculateMass() {
        double mass = 18;
        for (AminoAcid aminoAcid : sequence) {
            mass += aminoAcid.getMass();
        }
        return mass;
    }

    private double calculateHydrophobicityIndex() {
        double hydrophobicitySum = 0.0;
        for (AminoAcid aminoAcid : sequence) {
            hydrophobicitySum += aminoAcid.getHydrophobicityValue();
        }
        return hydrophobicitySum / sequence.size();
    }

    private double calculateIndexpH() {
        HashMap<Character, Double> pHValues = new HashMap<>();
        pHValues.put('D', 3.90);
        pHValues.put('E', 4.07);
        pHValues.put('Y', 10.07);
        pHValues.put('C', 8.33);
        pHValues.put('H', 6.04);
        pHValues.put('K', 10.54);
        double ph = 0.0;
        return ph;
    }

    private int calculateNetCharge(double pH) {
        int netCharge = 0;
        if (pH < 9) {
            netCharge++;
        }
        if (pH > 3) {
            netCharge--;
        }
        for (AminoAcid aminoacid : sequence) {
            netCharge += aminoacid.getCharge(pH);
        }
        return netCharge;
    }

    private int checkPolarity() {
        int polarity = 0;
        for (AminoAcid aminoAcid : sequence) {
            polarity += aminoAcid.getPolarity();
        }
        return polarity;
    }

    private double calculateMolecularMass() {
        double molecularMass = 0.0;
        for (AminoAcid aminoAcid : sequence) {
            molecularMass += aminoAcid.getMolecularMass();
        }
        return molecularMass;
    }

    private double calculateIsoelectricPoint() {
        double pH = 0;
        do {
            double QN1=-1/(1+Math.pow(10,(3.0-pH)));
            double QN2=-getAminoAcidCounts().get('D')/(1+Math.pow(10,(4.0-pH)));
            double QN3=-getAminoAcidCounts().get('E')/(1+Math.pow(10,(4.0-pH)));
            double QN4=-CysNumber/(1+Math.pow(10,(8.5-pH)));
            double QN5=-TyrNumber/(1+Math.pow(10,(10.5-pH)));
            double QP1=HisNumber/(1+Math.pow(10,(pH-6.0)));
            double QP2=1/(1+Math.pow(10,(pH-9.0)));
            double QP3=LysNumber/(1+Math.pow(10,(pH-10.5)));
            double QP4=ArgNumber/(1+Math.pow(10,(pH-12.5)));
        }while()
            return pH;
    }
    private HashMap<Character,Integer> countAminoAcids () {
        HashMap<Character, Integer> aminoAcidCounts = AminoAcid.getAminoAcidCount();
        for (AminoAcid aminoAcid : sequence) {
                int count = aminoAcidCounts.get(aminoAcid.getOneLetterCode());
                aminoAcidCounts.put(aminoAcid.getOneLetterCode(), count + 1);
        }
        for (HashMap.Entry<Character, Integer> entry : aminoAcidCounts.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
        return aminoAcidCounts;
    }
    public Double calculateExtinctionCoefficientValue(){
        double EC = 0.0;

        return EC;
    }
}

