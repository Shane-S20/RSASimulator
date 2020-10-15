package part2;

import java.math.BigInteger;

public class KeyRSA {
    private BigInteger n;

    public KeyRSA(BigInteger initN){
        n = initN;
    }
    public void setN(BigInteger v){
        n = v;
    }
    public BigInteger getN(){
        return n;
    }
}

