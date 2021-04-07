/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs3321.cryptoapp;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import javax.swing.JFileChooser;

/**
 *
 * @author mhhea
 */
public class FileIO {
    private String text;

    public FileIO() {
        this.text = "";
    }
    
    public boolean openFile()
    {
        //create flag for success
        boolean success = false;
        //reset FileIO text
        this.text = "";
        
        //Setup file and scanner objects
        File file;
        Scanner fileIn;
        int response;
        JFileChooser chooser = new JFileChooser("");
        chooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
        
        //open File Chooser Dialog
        response = chooser.showOpenDialog(null);
        
        //create string to hold each line
        String line;
        
        if(response == JFileChooser.APPROVE_OPTION)
        {
            file = chooser.getSelectedFile();
            try{
                fileIn = new Scanner(file);
                if (file.isFile())
                {
                    while(fileIn.hasNextLine())
                    {
                        line = fileIn.nextLine() + "\n";
                        text += line; 
                    }
                }
                
                success = true;
                //close file
                fileIn.close();
            } catch (FileNotFoundException e)
            {
                success = false;
            }

        }
        return success;
  
    }

    public String getText() {
        return text;
    }
    
    public boolean saveFile(String text)
    {
        //create flag for success
        boolean success = false;
                
        //Setup file and JFileChooser objects
        File file;
        
        int response;
        JFileChooser chooser = new JFileChooser("");
        chooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
        
        //Save File Chooser Dialog
        response = chooser.showSaveDialog(null);
        
        if(response == JFileChooser.APPROVE_OPTION)
        {
            try(FileWriter fw = new FileWriter(chooser.getSelectedFile()+".txt"))
            {
                fw.write(text);
                success = true;
                fw.flush();
                fw.close();
            } catch (IOException e)
            {
                success = false;
            }
        }
        
        return success;
    }
}
