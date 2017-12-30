package com.javaInterview.encryptor;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.springframework.stereotype.Component;

/**
 * <h1>Java Project Body Building  <br/>
 * </h1>
 * 
 * <p>
 * Simple Java Class <br/>
 * This class consists of one method to encrypt the input string.
 * </p>
 *
 * @author Daniyal Saeed
 * 
 * @version 2.0.0
 * @since 1.0.0
 * 
 */
@Component
public class Encryptor {
	
	/**
	 * 
	 * @param input
	 * @param encryptType
	 * @return encrypted string according to the encryption type such as MD5, SHA1,SHA-256,SHA-512
	 */
	public  String getEncryption(String input,String encryptType) {
        try {
            MessageDigest md = MessageDigest.getInstance(encryptType);
            byte[] messageDigest = md.digest(input.getBytes());
            BigInteger number = new BigInteger(1, messageDigest);
            String hashtext = number.toString(16);
           
            while (hashtext.length() < 32) {
                hashtext = "0" + hashtext;
            }
            return hashtext;
        }
        catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }
	
	
}
