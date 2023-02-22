public class AminoAcid extends AminoAcidsDetails {
    private final char oneLetterCode;
    private final StringBuilder codon;
    private final double pKa;
    private final String chargePosition;
    public AminoAcid(StringBuilder codon)
    {
        this.oneLetterCode = setOneLetterCode(codon);
        this.codon = codon;
        this.pKa = pKaValues.getOrDefault(oneLetterCode,0.0);
        this.chargePosition = chargePositionValues.getOrDefault(oneLetterCode,"");
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
    public Double getHydrophobicityValue()
    {
        return hydrophobicityValues.get(oneLetterCode);
    }
    public int getCharge(int pH)
    {
        if(pKa == 0 || pKa == pH) {return 0;}
        if(pH < pKa)
        {
            if(chargePosition.charAt(0) == 'L')
                if(chargePosition.length() == 3)
                {
                    return -1;
                }
                else
                {
                    return 1;
                }
        }else if(chargePosition.charAt(0) == 'R')
        {
            if(chargePosition.length() == 3)
            {
                return -1;
            }
            else
            {
                return 1;
            }
        }
        return 0;
    }
}