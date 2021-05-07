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
public class Methods {

    //Class atributes
    private String name;
    private int salary;
    private String[][] array_details;

    //Singleton
    private static Methods instance;

    //Singleton instance
    public static Methods getInstance() {
        if (instance == null) {
            instance = new Methods();
        }
        return instance;
    }

    //Constructor
    private Methods() {
    }

    //Getters
    public String getName() {
        return name;
    }

    public int getSalary() {
        return salary;
    }

    public String[][] getArray_details() {
        return array_details;
    }

    //Setters
    public void setSalary() {
        this.salary = calculateSalary(array_details);
    }

    public void setArray_details(String plain_text) {
        this.array_details = readArrayDetails(plain_text);
    }

    public void setName(String plain_tex) {
        this.name = readName(plain_tex);
    }

    //Methods 
    //We extract the employee's name from the file
    //removing "=" from plain text
    private String readName(String plain_text) {
        String[] parts = plain_text.split("=");
        //Name is returned in this method
        return parts[0];
    }

    //We extract the data's from the file 
    //removing "," from plain text 
    private String[][] readArrayDetails(String plain_text) {
        String[] parts = plain_text.split("=");
        String data = parts[1];
        //We extract the hours from the file 
        String[] dataDays = data.split(",");
        String[][] days = new String[dataDays.length][3];
        //We process the data in plain text to a two-dimensional array 
        //extracting useful characters and digits 
        for (int i = 0; i < dataDays.length; i++) {
            char first_letter = dataDays[i].charAt(0);
            char second_letter = dataDays[i].charAt(1);
            days[i][0] = Character.toString(first_letter) + Character.toString(second_letter);
            char first_check_in_hour = dataDays[i].charAt(2);
            char second_check_in_hour = dataDays[i].charAt(3);
            days[i][1] = Character.toString(first_check_in_hour) + Character.toString(second_check_in_hour);
            char first_check_out_hour = dataDays[i].charAt(8);
            char second_check_out_hour = dataDays[i].charAt(9);
            days[i][2] = Character.toString(first_check_out_hour) + Character.toString(second_check_out_hour);
        }
        //We return a two-dimensional array 
        return days;
    }

    //method to calculate employee salary with two-dimensional array input parameter 
    private int calculateSalary(String[][] dataDaysDetails) {
        //Definition of the variable that will store the result 
        int accum = 0;
        //We go through the array to extract perform the necessary operations with said data 
        //We use a counter that iterates from check-in time to check-out time 
        for (int i = 0; i < dataDaysDetails.length; i++) {
            //conditional for when the entered time equals 0 
            if (Integer.parseInt(dataDaysDetails[i][2]) == 0) {
                dataDaysDetails[i][2] = "24";
            }
            //counter initialization with entry time 
            int count = Integer.parseInt(dataDaysDetails[i][1]);
            //as long as the entry time is different from the exit time we will be in a repetitive cycle 
            while (count != Integer.parseInt(dataDaysDetails[i][2])) {
                //rate verification 
                accum += checkPayment(count, dataDaysDetails[i][0]);
                //we iterate the counter 
                count++;
            }
        }
        //The result is finally returned 
        return accum;
    }

    //method to determine the employee's rate using conditionals 
    //based on the time of entry and exit 
    private int checkPayment(int value, String day) {
        int hour = value;
        //rate control
        if (!day.equals("SA") && !day.equals("SU")) {
            //normal payment rates 
            if (hour >= 0 && hour < 9) {
                return 25;
            }
            if (hour >= 9 && hour < 18) {
                return 15;
            }
            if (hour >= 18 && hour < 24) {
                return 20;
            }
        } else {
            //weekend rates 
            if (hour >= 0 && hour < 9) {
                return 30;
            }
            if (hour >= 9 && hour < 18) {
                return 20;
            }
            if (hour >= 18 && hour < 24) {
                return 25;
            }
        }
        return 0;
    }
}
