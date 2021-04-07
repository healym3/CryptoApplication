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
public class CryptoControlVigenere extends CryptoControlTemplate{

    public CryptoControlVigenere(Cipher cipher) {
        super(cipher);
    }
    
    
    
    public boolean encrypt()
    {
        cipherText = "";
        String vKey = cipher.getKey();
        plainText = plainText.toUpperCase();
        for (int i = 0; i < plainText.length(); i++)
        {
            if(plainText.charAt(i) >= 'A' && plainText.charAt(i) <= 'Z')
            {
                //Transform letter
                int shift = (int)(vKey.charAt(i % vKey.length())) - 65;
                char c = (char)((int)plainText.charAt(i) + shift);
                //Wrap around if shift takes past Z
                if (c > 'Z')
                    c -= 26;
                cipherText += c;
            }
            else
            {
                cipherText += plainText.charAt(i);
            }
        }
        return true;
    }

    
    public boolean decrypt() {
        plainText = "";

        String vKey = cipher.getKey();
        cipherText = cipherText.toUpperCase();
        for (int i = 0; i < cipherText.length(); i++)
        {
            if(cipherText.charAt(i) >= 'A' && cipherText.charAt(i) <= 'Z')
            {
                //Reverse transformation on letter
                int shift = (int)(vKey.charAt(i % vKey.length())) - 65;
                char p = (char)((int)cipherText.charAt(i) - shift);
                //Wrap around if shift takes past Z
                if (p < 'A')
                    p += 26;
                plainText += p;
            }
            else
            {
                plainText += cipherText.charAt(i);
            }
        }
        return true; 
    }
}
