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
 * @author User
 */
public final class TextFile {

    //Class atribute
    private String plain_text;
    //Singleton
    private static TextFile instance;

    //Singleton instance
    public static TextFile getInstance(String file_name) {
        if (instance == null) {
            instance = new TextFile(file_name);
        }
        return instance;
    }

    //Constructor
    private TextFile(String file_name) {
        this.plain_text = read_file(file_name);
    }

    //method to read the content of a txt file 
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
            System.out.println("An error occurred while reading the .txt file.");
            data = "Verify that the file name and/or extension are correct.";
        }

        if (data != null) {
            data = data.replace(" ", "");
        }
        return data;
    }

    public String getPlain_text() {
        return plain_text;
    }

}
