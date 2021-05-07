/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package acme_exercisev2.classes;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 *
 * @author daleonv
 */
public final class TextFile {

    //Class atribute
    private String plain_text;

    //Singleton atribute
    private static TextFile instance;

    //Singleton instance
    public static TextFile getInstance() {
        if (instance == null) {
            instance = new TextFile();
        }
        return instance;
    }

    //Constructor
    private TextFile() {
    }

    //Getters 
    public String getPlain_text() {
        return plain_text;
    }

    //Setters
    public void setPlain_text(String plain_text) {
        this.plain_text = read_file(plain_text);
    }

    //Methods
    //Method to read the content of a txt file 
    private String read_file(String file_name) {
        String data = null;
        try {
            File myObj = new File(file_name);
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                data = myReader.nextLine();
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.printf("%s\n%s\n", "An error occurred while reading the .txt file.", "Verify that the file name and/or extension are correct.");
        }
        //delete white spaces
        if (data != null) {
            data = data.replace(" ", "");
        }
        return data;
    }

}
