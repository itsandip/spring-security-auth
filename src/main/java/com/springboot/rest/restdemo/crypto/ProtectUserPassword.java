package com.springboot.rest.restdemo.crypto;
public class ProtectUserPassword {
    public static void main(String[] args)
    {
        String myPassword = "myPassword123";
        
        // Generate Salt. The generated value can be stored in DB. 
        String salt = CryptoPasswordEncoder.getSalt(30);
        
        // Protect user's password. The generated value can be stored in DB.
        String mySecurePassword = CryptoPasswordEncoder.generateSecurePassword(myPassword, salt);
        
        // Print out protected password 
        System.out.println("myPassword : "+myPassword);
        System.out.println("My secure password = " + mySecurePassword);
        System.out.println("Salt value = " + salt);
    }
}