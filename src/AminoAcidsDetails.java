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
    }
}
