package edu.hillel.homework.lesson10;

import edu.hillel.library.AESGCM256Cipher;
import javax.crypto.SecretKey;

public class Main {

    public static void main(String[] args) {

        // Using our own linked library to encrypt/decrypt plain text with 256-bit key.
        AESGCM256Cipher aesgcm256Cipher = new AESGCM256Cipher();
        try {
            String plainText = "This is our plain text, witch must be encrypt.";

            SecretKey secretKey = aesgcm256Cipher.generateAESKey(256);
            String encryptedText = aesgcm256Cipher.encrypt(plainText, secretKey);
            String decryptedText = aesgcm256Cipher.decrypt(encryptedText, secretKey);

            System.out.println(
                    "\nPlain text:     " + plainText +
                    "\nEncrypted text: " + encryptedText +
                    "\nDecrypted text: " + decryptedText
            );
        }
        catch (Exception e) {
            //e.printStackTrace();
            throw new RuntimeException("Failed to use AESGCM256 encryption library.", e);
        }
    }
}
