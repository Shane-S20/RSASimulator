package part2;
import java.math.BigInteger;
import java.security.SecureRandom;

public class KeyPairGeneratorRSA {
    private int keySizeInBits;


    public KeyPairGeneratorRSA(int initKeySize){
        keySizeInBits = initKeySize;
    }

    public int getKeySizeInBits() {
        return keySizeInBits;
    }

    public KeyPairRSA generateKeyPair(){
        BigInteger pNumber = new BigInteger(getKeySizeInBits(), 50, new SecureRandom());
        BigInteger qNumber = new BigInteger(getKeySizeInBits(), 50, new SecureRandom());
        BigInteger nValue = pNumber.multiply(qNumber);
        BigInteger one = new BigInteger("1");
        BigInteger pSub = (pNumber.subtract(one));
        BigInteger qSub = (qNumber.subtract(one));
        BigInteger phiValue = pSub.multiply(qSub);
        BigInteger eValue = new BigInteger(getKeySizeInBits(), new SecureRandom());
        BigInteger eValueFinal = new BigInteger("0");
        if (eValue.compareTo(phiValue) == -1){
            if (eValue.gcd(phiValue).intValue() == 1){
                eValueFinal = eValue;}
            else if (eValue.gcd(phiValue).intValue() != 1){
                eValueFinal = new BigInteger("127");}}
        else{
            eValueFinal = new BigInteger("127");
        }
        BigInteger dValue = eValueFinal.modInverse(phiValue);
        return new KeyPairRSA(dValue, eValueFinal, nValue);
    }

}