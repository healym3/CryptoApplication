/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs3321.cryptoapp;

/**
 *
 * @author mhhea
 */
public class CryptoControlCaesar extends CryptoControlTemplate{

    public CryptoControlCaesar(Cipher cipher) {
        super(cipher);
    }
    
    
    public boolean encrypt()
    {
        cipherText = "";
        int cKey = Integer.parseInt(cipher.getKey());
        plainText = plainText.toUpperCase();
        for(char c : plainText.toCharArray())
        {
            if (c >= 'A' && c <= 'Z')
            {
                //transform letter with key
                c += cKey;
                //wrap around if key takes char past Z
                if (c > 'Z')
                    c -= 26;
                cipherText += c;
            }
            else
                cipherText += c;
        }
        return true;
    }

    
    public boolean decrypt() {
        plainText = "";
        cipherText = cipherText.toUpperCase();
        int cKey = Integer.parseInt(cipher.getKey());
        for(char c : cipherText.toCharArray())
        {
            if (c >= 'A' && c <= 'Z')
            {
                //Reverse transformation on letter using key
                c -= cKey;
                //wrap around if key takes char past A
                if (c < 'A')
                    c += 26;
                plainText += c;
            }
            else
                plainText += c;
        }
        return true; 
    }
}
