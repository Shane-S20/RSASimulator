package part2;

import java.math.BigInteger;

public class PrivateKeyRSA extends KeyRSA {
    private BigInteger d;

    public PrivateKeyRSA(BigInteger initD, BigInteger initN){
        super(initN);
        d = initD;
}

    public String decrypt(BigInteger cipherInt){
        BigInteger plaintext1 = cipherInt.modPow(d, getN());
        String str = new String(plaintext1.toByteArray());
        return str;
    }
    public String toString(){
        return "KR: {" + d.toString() + ", " + getN().toString() + "}";
    }
}