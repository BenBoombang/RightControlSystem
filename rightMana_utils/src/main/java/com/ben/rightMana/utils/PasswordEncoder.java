package com.ben.rightMana.utils;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * @AUTHOR Ben
 * @time 19:26
 */
public class PasswordEncoder {

    private static BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    public static String encoderPwd(String pwd){
        return encoder.encode(pwd);
    }

    public static void main(String[] args) {
        String msg = "123";
        String s = PasswordEncoder.encoderPwd(msg);
        System.out.println(s);
    }
}
