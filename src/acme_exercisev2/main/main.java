/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package acme_exercisev2.main;

import acme_exercisev2.classes.Methods;
import acme_exercisev2.classes.TextFile;
import acme_exercisev2.classes.Validators;

/**
 *
 * @author daleonv
 */
public class main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        //Class intance of TextFile to access it method.
        TextFile txt = TextFile.getInstance();

        //Call the set method to read the txt file
        //The input parameter is the file name 
        txt.setPlain_text("example1.txt");

        //We store the plain text in a variable 
        String plain_text = txt.getPlain_text();

        //Class intance of TextFile to access it method.
        Validators val = Validators.getInstance();

        //Conditional for the execution of the program according to the validations 
        if (val.validate(plain_text)) {
            //Class intance of TextFile to access it method.
            Methods solve = Methods.getInstance();
            //Setting attributes 
            solve.setName(plain_text);
            solve.setArray_details(plain_text);
            solve.setSalary();
            //Printing results 
            System.out.printf("INPUT\n%s\nOUTPUT\nThe amount to pay %s is: %d USD\n", plain_text, solve.getName(), solve.getSalary());
        }
    }
}
