/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Sanjeevani.utility;

import java.util.Base64;

/**
 *
 * @author Hp
 */
public class PasswordDecryption {
    public static String getDecryptedPassword(String pwd){
        return (new String(Base64.getDecoder().decode(pwd)));
    }
}
