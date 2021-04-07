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
public abstract class CryptoControlTemplate {
    protected Cipher cipher;
    protected String plainText;
    protected String cipherText;

    public CryptoControlTemplate(Cipher cipher) {
        this.cipher = cipher;
        this.plainText = "";
        this.cipherText = "";
    }

    public String getPlainText() {
        return plainText;
    }

    public void setPlainText(String plainText) {
        this.plainText = plainText;
    }

    public String getCipherText() {
        return cipherText;
    }

    public void setCipherText(String cipherText) {
        this.cipherText = cipherText;
    }
    
    public abstract boolean encrypt();
    public abstract boolean decrypt();
    
}
