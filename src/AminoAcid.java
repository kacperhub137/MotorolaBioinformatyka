public class AminoAcid extends AminoAcidsDetails {
    private final char oneLetterCode;
    private final StringBuilder codon;
    public AminoAcid(StringBuilder codon)
    {
        this.oneLetterCode = setOneLetterCode(codon);
        this.codon = codon;
    }
    private char setOneLetterCode(StringBuilder codon)
    {
        for (int k = 0; k < CODONS.length; k++) {
            if (CODONS[k].equals(codon.toString())) return AMINOS_PER_CODON[k].charAt(0);
        }
        return 'X';
    }
    public StringBuilder getCodon()
    {
        return codon;
    }
    public char getOneLetterCode()
    {
        return oneLetterCode;
    }
    public Double getMass()
    {
        return aminoAcidMasses.get(oneLetterCode);
    }
    protected Double getHydrophobicityValue()
    {
        return hydrophobicityValues.get(oneLetterCode);
    }
}