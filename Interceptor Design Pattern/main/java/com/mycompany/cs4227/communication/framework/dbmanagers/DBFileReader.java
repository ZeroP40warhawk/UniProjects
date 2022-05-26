/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.cs4227.communication.framework.dbmanagers;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Rory
 */
public class DBFileReader {
    
    private String filePath;
    
    public DBFileReader(String filePath){
       this.filePath = filePath;
    }
    
    public boolean readFile(){
        boolean isValid = false;
         BufferedReader br = null;
        File file = new File(filePath);
        if (file.exists()) {
            try {
                br = new BufferedReader(new java.io.FileReader(filePath));
                StringBuilder sb = new StringBuilder();
                String line = br.readLine();

                while (line != null) {
                    sb.append(line);
                    sb.append(System.lineSeparator());
                    if(!line.equalsIgnoreCase("")){
                    new FileParser().parseFile(line);
                    line = br.readLine();
                    }
                }
                isValid = true;

            } catch (FileNotFoundException e) {
                System.out.println("File Not Found");
            } catch (IOException ex) {
                Logger.getLogger(DBReader.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                if (br != null) {
                    try {
                        br.close();
                    } catch (IOException ex) {
                        Logger.getLogger(DBReader.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        } else {
            System.out.println("File Not Found");
        }
        return isValid;
    }
}
