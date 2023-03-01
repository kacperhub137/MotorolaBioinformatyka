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
    protected static final HashMap<Character, Double> pKaValues = new HashMap<>();
    static {
        pKaValues.put('D',4.0);
        pKaValues.put('E',4.0);
        pKaValues.put('H',6.0);
        pKaValues.put('C',8.5);
        pKaValues.put('Y',10.5);
        pKaValues.put('K',10.5);
        pKaValues.put('R',12.5);
        pKaValues.put('S',13.0);
        pKaValues.put('T',13.0);
    }
    protected static final HashMap<Character, String> chargePositionValues = new HashMap<>();
    static {
        chargePositionValues.put('R',"L1");
        chargePositionValues.put('D',"R-1");
        chargePositionValues.put('C',"R-1");
        chargePositionValues.put('E',"R-1");
        chargePositionValues.put('H',"L1");
        chargePositionValues.put('K',"L1");
        chargePositionValues.put('S',"R-1");
        chargePositionValues.put('T',"R-1");
        chargePositionValues.put('Y',"R-1");
    }
    protected static final  HashMap<Character, Integer> polarities = new HashMap<>();
    static {polarities.put('A', 0);
        polarities.put('C', 0);
        polarities.put('D', 1);
        polarities.put('E', 1);
        polarities.put('F', 0);
        polarities.put('G', 0);
        polarities.put('H', 1);
        polarities.put('I', 0);
        polarities.put('K', 1);
        polarities.put('L', 0);
        polarities.put('M', 0);
        polarities.put('N', 1);
        polarities.put('P', 0);
        polarities.put('Q', 1);
        polarities.put('R', 1);
        polarities.put('S', 1);
        polarities.put('T', 1);
        polarities.put('V', 0);
        polarities.put('W', 0);
        polarities.put('Y', 1);
    }
    protected static final HashMap<Character, Double> aminoAcidMolecularMasses = new HashMap<>();
    static {
        aminoAcidMolecularMasses.put('A', 89.094);
        aminoAcidMolecularMasses.put('C', 121.154);
        aminoAcidMolecularMasses.put('D', 133.104);
        aminoAcidMolecularMasses.put('E', 147.131);
        aminoAcidMolecularMasses.put('F', 165.192);
        aminoAcidMolecularMasses.put('G', 75.067);
        aminoAcidMolecularMasses.put('H', 155.156);
        aminoAcidMolecularMasses.put('I', 131.175);
        aminoAcidMolecularMasses.put('K', 146.189);
        aminoAcidMolecularMasses.put('L', 131.175);
        aminoAcidMolecularMasses.put('M', 149.208);
        aminoAcidMolecularMasses.put('N', 132.119);
        aminoAcidMolecularMasses.put('P', 115.132);
        aminoAcidMolecularMasses.put('Q', 146.146);
        aminoAcidMolecularMasses.put('R', 174.203);
        aminoAcidMolecularMasses.put('S', 105.093);
        aminoAcidMolecularMasses.put('T', 119.119);
        aminoAcidMolecularMasses.put('V', 117.148);
        aminoAcidMolecularMasses.put('W', 204.228);
        aminoAcidMolecularMasses.put('Y', 181.191);
    }
    protected static final  HashMap<Character, Integer> aminoAcidCounts = new HashMap<>();
    static {
        aminoAcidCounts.put('A', 0);
        aminoAcidCounts.put('C', 0);
        aminoAcidCounts.put('D', 0);
        aminoAcidCounts.put('E', 0);
        aminoAcidCounts.put('F', 0);
        aminoAcidCounts.put('G', 0);
        aminoAcidCounts.put('H', 0);
        aminoAcidCounts.put('I', 0);
        aminoAcidCounts.put('K', 0);
        aminoAcidCounts.put('L', 0);
        aminoAcidCounts.put('M', 0);
        aminoAcidCounts.put('N', 0);
        aminoAcidCounts.put('P', 0);
        aminoAcidCounts.put('Q', 0);
        aminoAcidCounts.put('R', 0);
        aminoAcidCounts.put('S', 0);
        aminoAcidCounts.put('T', 0);
        aminoAcidCounts.put('V', 0);
        aminoAcidCounts.put('W', 0);
        aminoAcidCounts.put('Y', 0);
    }
    protected static final HashMap<Character, Double> extinctionCoefficientValue = new HashMap<Character, Double>();
    static {
        extinctionCoefficientValue.put('A', 5500.0);
        extinctionCoefficientValue.put('C', 125.0);
        extinctionCoefficientValue.put('D', 11500.0);
        extinctionCoefficientValue.put('E', 9400.0);
        extinctionCoefficientValue.put('F', 20500.0);
        extinctionCoefficientValue.put('G', 1700.0);
        extinctionCoefficientValue.put('H', 21600.0);
        extinctionCoefficientValue.put('I', 8800.0);
        extinctionCoefficientValue.put('K', 32500.0);
        extinctionCoefficientValue.put('L', 8600.0);
        extinctionCoefficientValue.put('M', 6800.0);
        extinctionCoefficientValue.put('N', 5600.0);
        extinctionCoefficientValue.put('P', 8700.0);
        extinctionCoefficientValue.put('Q', 7600.0);
        extinctionCoefficientValue.put('R', 12200.0);
        extinctionCoefficientValue.put('S', 5700.0);
        extinctionCoefficientValue.put('T', 8400.0);
        extinctionCoefficientValue.put('V', 7000.0);
        extinctionCoefficientValue.put('W', 22000.0);
        extinctionCoefficientValue.put('Y', 14900.0);
    }
    protected static final HashMap<Character, Integer> amountOfCarbon = new HashMap<Character, Integer>();
    static {
        amountOfCarbon.put('A',3);
        amountOfCarbon.put('C',3);
        amountOfCarbon.put('D',4);
        amountOfCarbon.put('E',5);
        amountOfCarbon.put('F',9);
        amountOfCarbon.put('G',2);
        amountOfCarbon.put('H',6);
        amountOfCarbon.put('I',6);
        amountOfCarbon.put('K',6);
        amountOfCarbon.put('L',6);
        amountOfCarbon.put('M',5);
        amountOfCarbon.put('N',4);
        amountOfCarbon.put('P',5);
        amountOfCarbon.put('Q',5);
        amountOfCarbon.put('R',6);
        amountOfCarbon.put('S',3);
        amountOfCarbon.put('T',4);
        amountOfCarbon.put('V',4);
        amountOfCarbon.put('W',11);
        amountOfCarbon.put('Y',9);
    }
    protected static final HashMap<Character,Integer> amountOfHydrogen = new HashMap<Character,Integer>();
    static{
        amountOfHydrogen.put('A',5);
        amountOfHydrogen.put('C',5);
        amountOfHydrogen.put('D',5);
        amountOfHydrogen.put('E',7);
        amountOfHydrogen.put('F',9);
        amountOfHydrogen.put('G',3);
        amountOfHydrogen.put('H',7);
        amountOfHydrogen.put('I',11);
        amountOfHydrogen.put('K',12);
        amountOfHydrogen.put('L',11);
        amountOfHydrogen.put('M',9);
        amountOfHydrogen.put('N',6);
        amountOfHydrogen.put('P',7);
        amountOfHydrogen.put('Q',8);
        amountOfHydrogen.put('R',12);
        amountOfHydrogen.put('S',5);
        amountOfHydrogen.put('T',7);
        amountOfHydrogen.put('V',9);
        amountOfHydrogen.put('W',10);
        amountOfHydrogen.put('Y',9);
    }
    protected static final HashMap<Character,Integer> amountOfNitrogen = new HashMap<Character,Integer>();
    static{
        amountOfNitrogen.put('A',1);
        amountOfNitrogen.put('C',1);
        amountOfNitrogen.put('D',1);
        amountOfNitrogen.put('E',1);
        amountOfNitrogen.put('F',1);
        amountOfNitrogen.put('G',1);
        amountOfNitrogen.put('H',3);
        amountOfNitrogen.put('I',1);
        amountOfNitrogen.put('K',2);
        amountOfNitrogen.put('L',1);
        amountOfNitrogen.put('M',1);
        amountOfNitrogen.put('N',2);
        amountOfNitrogen.put('P',1);
        amountOfNitrogen.put('Q',2);
        amountOfNitrogen.put('R',4);
        amountOfNitrogen.put('S',1);
        amountOfNitrogen.put('T',1);
        amountOfNitrogen.put('V',1);
        amountOfNitrogen.put('W',2);
        amountOfNitrogen.put('Y',1);
    }
    protected static final HashMap<Character,Integer> amountOfOxygen = new HashMap<>();
    static {
        amountOfOxygen.put('A',1);
        amountOfOxygen.put('C',1);
        amountOfOxygen.put('D',3);
        amountOfOxygen.put('E',3);
        amountOfOxygen.put('F',1);
        amountOfOxygen.put('G',1);
        amountOfOxygen.put('H',1);
        amountOfOxygen.put('I',1);
        amountOfOxygen.put('K',1);
        amountOfOxygen.put('L',1);
        amountOfOxygen.put('M',1);
        amountOfOxygen.put('N',2);
        amountOfOxygen.put('P',1);
        amountOfOxygen.put('Q',2);
        amountOfOxygen.put('R',1);
        amountOfOxygen.put('S',2);
        amountOfOxygen.put('T',2);
        amountOfOxygen.put('V',1);
        amountOfOxygen.put('W',1);
        amountOfOxygen.put('Y',2);
    }
}