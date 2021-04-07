/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs3321.cryptoapp;

import java.util.Random;
import javax.swing.JOptionPane;

/**
 *
 * @author mhhea
 */
public class ManageCiphers {
    private KeyRing keyRing;

    public ManageCiphers() {
    }

    public ManageCiphers(KeyRing keyRing) {
        this.keyRing = keyRing;
    }
    
    public boolean importKey(String cipherType)
    {
        if (!validateCipherType(cipherType))
            return false;
        
        boolean success = false;
        if (cipherType.equals("Caesar"))
            success = importCaesarKey();
        if (cipherType.equals("Vigenere"))
            success = importVigenereKey();
        
        return success;
        
    }
    private boolean importVigenereKey()
    {
        String vigenereKey;
        boolean validInput;
        do {
            vigenereKey = JOptionPane.showInputDialog("Enter Vigenere Key (ONLY LETTERS):");
            vigenereKey = vigenereKey.toUpperCase();
            validInput = vigenereKey.chars().allMatch(Character::isLetter);
        } while (!validInput);
        
        Cipher cipher = new Cipher("Vigenere", vigenereKey);
        keyRing.setVigenereCipher(cipher);
        return true;
    }
    private boolean importCaesarKey()
    {
        Integer caesarKey = getInput(25, "Enter Caesar Key 1-25:");
        Cipher cipher = new Cipher("Caesar", caesarKey.toString());
        keyRing.setCaesarCipher(cipher);
        return true;
    }
    public boolean generateKey(String cipherType)
    {
        if (!validateCipherType(cipherType))
            return false;
        
        boolean success = false;
        if (cipherType.equals("Caesar"))
            success = generateCaesarKey();
        if (cipherType.equals("Vigenere"))
            success = generateVigenereKey();
        
        return success;
        
    }
    private boolean generateVigenereKey()
    {
        int size = getInput(30, "Enter Vigenere Key Size 1-30:");
        Random rand = new Random();
        int temp;
        String vigenereKey = "";
        for (int i = 0; i < size; i++) {
            temp = rand.nextInt(26);
            vigenereKey += (char)('A' + temp);
        }
        Cipher cipher = new Cipher("Vigenere", vigenereKey);
        keyRing.setVigenereCipher(cipher);
        return true;
    }
    private boolean generateCaesarKey()
    {
        Integer caesarKey;
        Random rand = new Random();
        caesarKey = rand.nextInt(25) + 1;
        Cipher cipher = new Cipher("Caesar", caesarKey.toString());
        keyRing.setCaesarCipher(cipher);
        return true;
    }
    
    private static int getInput(int count, String str) {
        String strChoice;
        int choice = 0;
        boolean validInput = false;
        while (!validInput) {
            strChoice = JOptionPane.showInputDialog(str);
            choice = IntegerInputValidation(strChoice);
            validInput = RangeInputValidation(choice, 1, count + 1);
        }
        return choice;
    }
    private static boolean RangeInputValidation(int num, int start, int end) {
        return num >= start && num < end;
    }
    private static int IntegerInputValidation(String s) {
        int num = 0;
        while (true) {
            try {
                num = Integer.parseInt(s);
                break;
            } catch (NumberFormatException e) {
                s = JOptionPane.showInputDialog(s + " is invalid. Please enter a valid number.");
            }
        }
        return num;
    }
    private boolean validateCipherType(String cipherType)
    {
        return cipherType.equals("Caesar") || cipherType.equals("Vigenere");
    }
    
}
