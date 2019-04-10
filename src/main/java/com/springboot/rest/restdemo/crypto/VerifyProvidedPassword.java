package com.springboot.rest.restdemo.crypto;
public class VerifyProvidedPassword {
    public static void main(String[] args)
    {
        // User provided password to validate
        String providedPassword = "myPassword123";
                
        // Encrypted and Base64 encoded password read from database
        String securePassword = "t6fjslaD8LllqcHBU64h36wUsvfM286mFH1fVn+YJx4=";
        
        // Salt value stored in database 
        String salt = "4h4jCKsSC4BrkYdz48MKVwpBDdfqyE";
        
        boolean passwordMatch = CryptoPasswordEncoder.verifyUserPassword(providedPassword, securePassword, salt);
        
        if(passwordMatch) 
        {
            System.out.println("Provided user password " + providedPassword + " is correct.");
        } else {
            System.out.println("Provided password is incorrect");
        }
    }
}