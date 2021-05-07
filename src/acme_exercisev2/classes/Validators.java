/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package acme_exercisev2.classes;

/**
 *
 * @author daleonv
 */
public class Validators {

    //Singleton
    private static Validators instance;

    //Singleton instance
    public static Validators getInstance() {
        if (instance == null) {
            instance = new Validators();
        }
        return instance;
    }

    //Constructor
    private Validators() {
    }

    //Methods
    //Method to execute the rest of the validations of the class 
    public boolean validate(String plain_text) {
        //Variable that will store the state of the method validate
        boolean aux = true;
        //Conditionals to determine the continuation or break in the execution of the program 
        if (!validateFile(plain_text)) {
            aux = false;
            return aux;
        }
        //Class intance of TextFile to access it method.
        Methods solve = Methods.getInstance();
        //Set attributes 
        solve.setName(plain_text);
        solve.setArray_details(plain_text);
        if (validateTyping() || validateCharacters()) {
            System.out.println("Error: Typing error in .txt file.");
            aux = false;
        } else {
            if (validateNumberCharacters(plain_text)) {
                System.out.println("Error: Check the text string entered.");
                aux = false;
            }
            if (validateAllowedDays()) {
                System.out.println("Error: Check the writing of the days entered.");
                aux = false;
            }
            if (validateHours()) {
                System.out.println("Error: The hour must be an integer on 24 hours format.");
                aux = false;
            }
            if (validateCheckOut()) {
                System.out.println("Error: Check-in time must be less than check-out time.");
                aux = false;
            }
        }
        return aux;
    }

    //Method to check if the txt file was read without problems 
    private boolean validateFile(String plain_text) {
        boolean aux = true;
        if (plain_text == null) {
            aux = false;
        }
        return aux;
    }

    //Method to verify that the nomenclature of the days entered was correct 
    private boolean validateAllowedDays() {
        boolean aux = false;
        Methods solve = Methods.getInstance();
        String[][] array_details = solve.getArray_details();
        for (int i = 0; i < array_details.length; i++) {
            String day = array_details[i][0];
            if (!day.equals("MO") && !day.equals("TU") && !day.equals("WE") && !day.equals("TH") && !day.equals("FR") && !day.equals("SA") && !day.equals("SU")) {
                aux = true;
                return aux;
            }
        }
        return aux;
    }

    //Method for handling program exceptions 
    private boolean validateTyping() {
        boolean aux = false;
        try {
            Methods.getInstance();
        } catch (Exception e) {
            aux = true;
        }
        return aux;
    }

    //Method to handle errors in plain text to array transformation 
    private boolean validateCharacters() {
        boolean aux = false;
        Methods solve = Methods.getInstance();
        String[][] array_details = solve.getArray_details();
        for (int i = 0; i < array_details.length; i++) {
            try {
                Integer.parseInt(array_details[i][1]);
                Integer.parseInt(array_details[i][2]);
            } catch (Exception e) {
                aux = true;
                break;
            }
        }
        return aux;
    }

    //Method to validate that the input syntax is correct, based on the number of characters 
    private boolean validateNumberCharacters(String plain_text) {
        boolean aux = false;
        Methods solve = Methods.getInstance();
        String[][] array_details = solve.getArray_details();
        for (int i = 0; i < array_details.length; i++) {
            if (Integer.parseInt(array_details[i][1]) < 0 || Integer.parseInt(array_details[i][1]) > 24
                    || Integer.parseInt(array_details[i][2]) > 24 || Integer.parseInt(array_details[i][2]) > 24) {
                aux = true;
            }
        }
        int written_characters = plain_text.length() - Methods.getInstance().getName().length() - array_details.length;
        int expected_characters = 13 * array_details.length;
        if (written_characters != expected_characters) {
            aux = true;
        }
        return aux;
    }

    //Method to validate that the entered hours are in 24 hour format 
    private boolean validateHours() {
        boolean aux = false;
        try {
            Methods solve = Methods.getInstance();
            String[][] array_details = solve.getArray_details();
            for (int i = 0; i < array_details.length; i++) {
                if (Integer.parseInt(array_details[i][1]) < 0 || Integer.parseInt(array_details[i][1]) >= 24
                        || Integer.parseInt(array_details[i][2]) < 0 || Integer.parseInt(array_details[i][2]) >= 24) {
                    aux = true;
                }
            }
        } catch (Exception e) {
            aux = true;
        }
        return aux;
    }

    //Method to validate that the check-in time is less than the check-out time 
    private boolean validateCheckOut() {
        boolean aux = false;
        try {
            Methods solve = Methods.getInstance();
            String[][] array_details = solve.getArray_details();
            for (int i = 0; i < array_details.length; i++) {
                if (Integer.parseInt(array_details[i][1]) > Integer.parseInt(array_details[i][2]) && Integer.parseInt(array_details[i][2]) != 0) {
                    aux = true;
                }
            }
        } catch (Exception e) {
            aux = true;
        }
        return aux;
    }
}
