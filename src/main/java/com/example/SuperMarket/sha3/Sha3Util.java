package com.example.SuperMarket.sha3;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Sha3Util {
   

    public static byte[] digest(byte[] password){
        MessageDigest md;
        try {
            md = MessageDigest.getInstance("SHA3-256");
        } catch (NoSuchAlgorithmException e) {
            throw new IllegalArgumentException(e);
        }
        byte[] result = md.digest(password);
        return result;
        
    }

    public static String bytesToHex(byte[] bytes){
        StringBuilder  sb = new StringBuilder();
        for (byte b : bytes) {
            sb.append(String.format("%02x", b));
        }
        return sb.toString();
        
    }
}
