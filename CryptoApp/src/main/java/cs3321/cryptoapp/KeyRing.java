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
public class KeyRing {
    private Cipher caesarCipher;
    private Cipher vigenereCipher;

    public KeyRing() {
        caesarCipher = null;
        vigenereCipher = null;
    }


    public Cipher getCaesarCipher() {
        return caesarCipher;
    }

    public void setCaesarCipher(Cipher caesarCipher) {
        this.caesarCipher = caesarCipher;
    }

    public Cipher getVigenereCipher() {
        return vigenereCipher;
    }

    public void setVigenereCipher(Cipher vigenereCipher) {
        this.vigenereCipher = vigenereCipher;
    }
}
