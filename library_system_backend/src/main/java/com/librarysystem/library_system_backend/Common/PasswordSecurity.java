package com.librarysystem.library_system_backend.Common;

import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Random;

public class PasswordSecurity {
    private static char[] salt = {'0', '1', '2', '3', '4', '5', '6', 'a', 'b', 'c'};

    public static String addSalt() {
        Random random = new Random();
        StringBuilder stringBuilder = new StringBuilder(10);
        for(int i=0; i < stringBuilder.capacity(); i++){
            stringBuilder.append(salt[random.nextInt(10)]);
        }
        
        return stringBuilder.toString();
    }

    public static String encryptionWithSalt(String userPassword, String saltToAdd) {
        
        byte[] passwordBytes = null;

        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            String saltedPassword = userPassword + saltToAdd;
            messageDigest.update(saltedPassword.getBytes("UTF-8"));
            passwordBytes = messageDigest.digest();


        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        return String.format("%032x", new BigInteger(1, passwordBytes));

    }

    public static String dencryptionWithSalt(String userPassword, String salt) {
        return null;
    }

}
