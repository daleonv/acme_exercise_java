/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package acme_exercisev2.classes;

/**
 *
 * @author User
 */
public class Validators {

    //Singleton
    private static Validators instance;

    //Singleton instance
    public static Validators getInstance(String plain_text) {
        if (instance == null) {
            instance = new Validators();
        }
        return instance;
    }

    private Validators() {
    }

    public boolean validatePlainText(String plain_text) {
        boolean aux = true;
        if (validateTyping(plain_text) || validateCharacters(plain_text)) {
            System.out.println("Error: Typing error in .txt file.");
            aux = false;
        } else {
            if (validateNumberCharacters(plain_text)) {
                System.out.println("Error: Check the text string entered.");
                aux = false;
            }
            if (validateHours(plain_text)) {
                System.out.println("Error: The hour must be an integer between 0 and 23.");
                aux = false;
            }
            if (validateCheckOut(plain_text)) {
                System.out.println("Error: Check-in time must be less than check-out time.");
                aux = false;
            }
        }
        return aux;
    }

    private boolean validateTyping(String plain_text) {
        boolean aux = false;
        try {
            Methods.getInstance(plain_text);
        } catch (Exception e) {
            aux = true;
        }
        return aux;
    }

    private boolean validateCharacters(String plain_text) {
        boolean aux = false;
        Methods solve = Methods.getInstance(plain_text);
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
        Methods solve = Methods.getInstance(plain_text);
        String[][] array_details = solve.getArray_details();
        for (int i = 0; i < array_details.length; i++) {
            if (Integer.parseInt(array_details[i][1]) < 0 || Integer.parseInt(array_details[i][1]) > 24
                    || Integer.parseInt(array_details[i][2]) > 24 || Integer.parseInt(array_details[i][2]) > 24) {
                aux = true;
            }
        }
        int written_characters = plain_text.length() - Methods.getInstance(plain_text).getName().length() - array_details.length;
        int expected_characters = 13 * array_details.length;
        if (written_characters != expected_characters) {
            aux = true;
        }
        return aux;
    }

    private boolean validateHours(String plain_text) {
        boolean aux = false;
        try {
            Methods solve = Methods.getInstance(plain_text);
            String[][] array_details = solve.getArray_details();
            for (int i = 0; i < array_details.length; i++) {
                if (Integer.parseInt(array_details[i][1]) < 0 || Integer.parseInt(array_details[i][1]) > 24
                        || Integer.parseInt(array_details[i][2]) > 24 || Integer.parseInt(array_details[i][2]) > 24) {
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
            Methods solve = Methods.getInstance(plain_text);
            String[][] array_details = solve.getArray_details();
            for (int i = 0; i < array_details.length; i++) {
                if (Integer.parseInt(array_details[i][1]) > Integer.parseInt(array_details[i][2])) {
                    aux = true;
                }
            }
        } catch (Exception e) {
            aux = true;
        }
        return aux;
    }
}
