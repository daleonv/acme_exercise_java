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
 * @author User
 */
public class main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        //Class intance of TextFile to access it method.
        //the input parameter is the file text name and the extension
        TextFile txt = TextFile.getInstance("input.txt");
        String plain_text = txt.getPlain_text();

        Validators val = Validators.getInstance(plain_text);
        if (val.validatePlainText(plain_text)) {
            //Class intance of TextFile to access it method.
            //the input parameter is the file text name and the extension
            Methods solve = Methods.getInstance(plain_text);
            solve.setSalary();
            //Printing results 
            System.out.printf("INPUT\n%s\nOUTPUT\nThe amount to pay %s is: %d USD\n", plain_text, solve.getName(), solve.getSalary());
        }
    }
}