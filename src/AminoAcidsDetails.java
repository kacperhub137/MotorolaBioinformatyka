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
