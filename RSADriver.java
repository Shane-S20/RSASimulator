package part2;
import java.util.Scanner;
import java.math.BigInteger;

public class RSADriver {
    public static void main(String[] args) {
        KeyPairGeneratorRSA generator = new KeyPairGeneratorRSA(32);
        KeyPairRSA keys = generator.generateKeyPair();
        System.out.println(keys.toString());

        String plain, cipher, decrypted;

        do
        {
            // REQUEST plaintext MESSAGE FROM USER
            System.out.print("\nEnter a Plaintext Message: ");
            plain = new Scanner(System.in).nextLine();

            // ENCRYPT plaintext MESSAGE INTO ciphertext NUMBER AND THEN TEXT
            BigInteger cipherBigInt = keys.getPublicKey().encrypt(plain);
            cipher = new String(cipherBigInt.toByteArray());

            // DECRYPT ciphertext NUMBER BACK INTO plaintext MESSAGE
            decrypted = keys.getPrivateKey().decrypt(cipherBigInt);

            // PRINT SUMMARY INFORMATION
            System.out.println("plain:     " + plain);
            System.out.println("cipher:    " + cipher);
            System.out.println("decrypted: " + decrypted);
        }while (! plain.toLowerCase().equals("quit") );
    }
}