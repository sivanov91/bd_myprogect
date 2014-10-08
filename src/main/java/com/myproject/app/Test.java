package com.myproject.app;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.*;
import org.springframework.security.core.authority.GrantedAuthorityImpl;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Created by IntelliJ IDEA.
 * User: lnex
 * Date: 14.06.13
 * Time: 11:15
 * To change this template use File | Settings | File Templates.
 */
public class Test {

    public static String md5(String str) {
        try {
            java.security.MessageDigest md = java.security.MessageDigest.getInstance("MD5");
            byte[] array = md.digest(str.getBytes());
            StringBuffer sb = new StringBuffer();

            for (int i = 0; i < array.length; ++i) {
                sb.append(Integer.toHexString((array[i] & 0xFF) | 0x100).substring(1,3));
            }
            return sb.toString();
        }
        catch (java.security.NoSuchAlgorithmException e) {

        }
    return null;
}

    public static void main(String [] argv) throws NoSuchAlgorithmException {
        //MessageDigest md5 = MessageDigest.getInstance("MD5");
        System.out.println(md5("user"));


    }

}
