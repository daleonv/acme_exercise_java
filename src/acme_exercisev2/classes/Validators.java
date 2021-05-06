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

    private Validators() {
    }

    public boolean validate(String plain_text) {
        //Class intance of TextFile to access it method.
        Methods solve = Methods.getInstance();
        //Set attributes 
        solve.setName(plain_text);
        solve.setArray_details(plain_text);
        //Variable that will store the state of the method validate
        boolean aux = true;
        //Conditionals to determine the continuation or break in the execution of the program 
        if (!validateFile(plain_text)) {
            aux = false;
            return aux;
        }
        if (validateTyping(plain_text) || validateCharacters(plain_text)) {
            System.out.println("Error: Typing error in .txt file.");
            aux = false;
        } else {
            if (validateNumberCharacters(plain_text)) {
                System.out.println("Error: Check the text string entered.");
                aux = false;
            }
            if (validateAllowedDays(plain_text)) {
                System.out.println("Error: Check the writing of the days entered.");
                aux = false;
            }
            if (validateHours(plain_text)) {
                System.out.println("Error: The hour must be an integer on 24 hours format.");
                aux = false;
            }
            if (validateCheckOut(plain_text)) {
                System.out.println("Error: Check-in time must be less than check-out time.");
                aux = false;
            }
        }
        return aux;
    }

    private boolean validateFile(String plain_text) {
        boolean aux = true;
        if (plain_text == null) {
            aux = false;
        }
        return aux;
    }

    private boolean validateAllowedDays(String plain_text) {
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

    private boolean validateTyping(String plain_text) {
        boolean aux = false;
        try {
            Methods.getInstance();
        } catch (Exception e) {
            aux = true;
        }
        return aux;
    }

    private boolean validateCharacters(String plain_text) {
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

    private boolean validateHours(String plain_text) {
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

    private boolean validateCheckOut(String plain_text) {
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
