package part2;

import java.math.BigInteger;

public class KeyPairRSA {
    private PublicKeyRSA publicKey;
    private PrivateKeyRSA privateKey;

    public KeyPairRSA(BigInteger d, BigInteger e, BigInteger n){
        publicKey = new PublicKeyRSA(e, n);
        privateKey = new PrivateKeyRSA(d, n);
    }
    public PublicKeyRSA getPublicKey(){
        return publicKey;
    }
    public PrivateKeyRSA getPrivateKey(){
        return privateKey;
    }
    public String toString(){
        return privateKey.toString() + " " + publicKey.toString();
    }
}