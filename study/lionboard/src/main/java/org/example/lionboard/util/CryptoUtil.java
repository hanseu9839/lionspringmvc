package org.example.lionboard.util;

import org.apache.commons.codec.binary.Hex;
import org.springframework.web.HttpMediaTypeNotSupportedException;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

public class CryptoUtil {
    private static final String specName = WebConstants.SPEC_NAME;
    private static final String privateKey = WebConstants.PRIVATE_KEY;
    public static String encrypt(String password){

        try{
            SecretKey secretKey = new SecretKeySpec(privateKey.getBytes("UTF-8"), "AES");
            IvParameterSpec iv = new IvParameterSpec(privateKey.substring(0,16).getBytes());

            Cipher c = Cipher.getInstance(specName);
            c.init(Cipher.ENCRYPT_MODE, secretKey, iv);
            byte[] encryptionByte = c.doFinal(password.getBytes(StandardCharsets.UTF_8));
            return Hex.encodeHexString(encryptionByte);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    public static String decrypt(String password) {
        try{
            SecretKey secretKey = new SecretKeySpec(privateKey.getBytes("UTF-8"), "AES");
            IvParameterSpec iv = new IvParameterSpec(privateKey.substring(0,16).getBytes());
            Cipher c = Cipher.getInstance(specName);
            c.init(Cipher.DECRYPT_MODE, secretKey, iv);
            byte[] decodeBytes = Hex.decodeHex(password.toCharArray());
            return new String(c.doFinal(decodeBytes), "UTF-8");
        } catch(Exception e){
            throw new RuntimeException(e);
        }
    }

}
