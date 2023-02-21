import java.util.HashMap;

public abstract class AminoAcidsDetails {
    protected final String[] CODONS = {
            "UUU", "UUC", "UUA", "UUG", "UCU",
            "UCC", "UCA", "UCG", "UAU", "UAC", "UGU", "UGC", "UGG", "CUU",
            "CUC", "CUA", "CUG", "CCU", "CCC", "CCA", "CCG", "CAU", "CAC",
            "CAA", "CAG", "CGU", "CGC", "CGA", "CGG", "AUU", "AUC", "AUA",
            "AUG", "ACU", "ACC", "ACA", "ACG", "AAU", "AAC", "AAA", "AAG",
            "AGU", "AGC", "AGA", "AGG", "GUU", "GUC", "GUA", "GUG", "GCU",
            "GCC", "GCA", "GCG", "GAU", "GAC", "GAA", "GAG", "GGU", "GGC",
            "GGA", "GGG", "UGA" , "UAG" , "UAA"};

    protected final String[] AMINOS_PER_CODON = {
            "F", "F", "L", "L", "S", "S",
            "S", "S", "Y", "Y", "C", "C", "W", "L", "L", "L", "L", "P", "P",
            "P", "P", "H", "H", "Q", "Q", "R", "R", "R", "R", "I", "I", "I",
            "M", "T", "T", "T", "T", "N", "N", "K", "K", "S", "S", "R", "R",
            "V", "V", "V", "V", "A", "A", "A", "A", "D", "D", "E", "E", "G",
            "G", "G", "G", "-" , "-", "-"};
    protected static final HashMap<Character, Double> aminoAcidMasses = new HashMap<>();
    static {
        aminoAcidMasses.put('A', 71.078);
        aminoAcidMasses.put('C', 103.143);
        aminoAcidMasses.put('D', 115.087);
        aminoAcidMasses.put('E', 129.114);
        aminoAcidMasses.put('F', 147.174);
        aminoAcidMasses.put('G', 57.051);
        aminoAcidMasses.put('H', 137.139);
        aminoAcidMasses.put('I', 113.158);
        aminoAcidMasses.put('K', 128.172);
        aminoAcidMasses.put('L', 113.158);
        aminoAcidMasses.put('M', 131.196);
        aminoAcidMasses.put('N', 114.103);
        aminoAcidMasses.put('P', 97.115);
        aminoAcidMasses.put('Q', 128.129);
        aminoAcidMasses.put('R', 156.186);
        aminoAcidMasses.put('S', 87.077);
        aminoAcidMasses.put('T', 101.104);
        aminoAcidMasses.put('V', 99.131);
        aminoAcidMasses.put('W', 186.210);
        aminoAcidMasses.put('Y', 163.173);
    }
    protected static final HashMap<Character, Double> hydrophobicityValues = new HashMap<>();
    static {
        hydrophobicityValues.put('A', 1.8);
        hydrophobicityValues.put('C', 2.5);
        hydrophobicityValues.put('D', -3.5);
        hydrophobicityValues.put('E', -3.5);
        hydrophobicityValues.put('F', 2.8);
        hydrophobicityValues.put('G', -0.4);
        hydrophobicityValues.put('H', -3.2);
        hydrophobicityValues.put('I', 4.5);
        hydrophobicityValues.put('K', -3.9);
        hydrophobicityValues.put('L', 3.8);
        hydrophobicityValues.put('M', 1.9);
        hydrophobicityValues.put('N', -3.5);
        hydrophobicityValues.put('P', -1.6);
        hydrophobicityValues.put('Q', -3.5);
        hydrophobicityValues.put('R', -4.5);
        hydrophobicityValues.put('S', -0.8);
        hydrophobicityValues.put('T', -0.7);
        hydrophobicityValues.put('V', 4.2);
        hydrophobicityValues.put('W', -0.9);
        hydrophobicityValues.put('Y', -1.3);
    }
}
