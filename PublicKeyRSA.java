package part2;

import java.math.BigInteger;

public class PublicKeyRSA extends KeyRSA {
    private BigInteger e;

    public PublicKeyRSA(BigInteger initE, BigInteger initN){
        super(initN);
        e = initE;
    }
    public BigInteger encrypt(String plaintext){
        BigInteger encryption = new BigInteger(plaintext.getBytes());
        if (encryption.compareTo(getN()) == 1){
            String message = "PLAINTEXT MESSAGE IS TOO BIG";
            BigInteger printMessage = new BigInteger(message.getBytes());
 //           String endMessage = new String(printMessage.toByteArray());
            return printMessage;
        }
        else{
            BigInteger ciphertext = encryption.modPow(e, getN());
            return ciphertext;
        }
    }
    public String toString(){
        return  "KU: {" + e.toString() + ", " + getN().toString() + "}";
    }
}