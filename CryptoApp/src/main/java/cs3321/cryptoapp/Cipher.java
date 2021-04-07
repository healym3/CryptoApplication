/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs3321.cryptoapp;

import javax.swing.JOptionPane;

/**
 *
 * @author mhhea
 */
public class Cipher {
    
    private String cipherType;
    private String key;

    public Cipher(String cipherType, String key) {
        if (validateCipherType(cipherType))
        {
            this.cipherType = cipherType;
            this.key = key;
        }
        else
        {
            JOptionPane.showMessageDialog(null, "Invalid Cipher Type.");
            this.cipherType = "";
            this.key = "";
        }
        
    }

    public String getCipherType() {
        return cipherType;
    }

    public String getKey() {
        return key;
    }

    private boolean validateCipherType(String cipherType)
    {
        return cipherType.equals("Caesar") || cipherType.equals("Vigenere");
    }
    
    
}
