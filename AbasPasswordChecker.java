/*
JHONDEL MICO N. ABAS
BSIT-2A: Object Oriented Programming
Directions:
    Prompt the user to input the password
    Prompt the user to enter confirm password and check password match
    At least 2 lower case and 2 Upper case letters
*/
package jhondelmicoabas;
import java.util.regex.*;
import javax.swing.JOptionPane;

public class AbasPasswordChecker {
    public static void main(String[] args) {
        String password = JOptionPane.showInputDialog("Enter Password: ");
        String confirmPin = JOptionPane.showInputDialog("Confirm Password: ");

        if (password.equals(confirmPin)) {  // checks if password is equal to confirm pin
            boolean isValid = isPasswordValid(password); // returns either true or false
            if (isValid) { // if isValid == true
                JOptionPane.showMessageDialog(null, "PASSWORD IS VALID", "PASSWORD REGISTERED!", JOptionPane.PLAIN_MESSAGE);
            } else {    // if isValid == false
                JOptionPane.showMessageDialog(null, "PASSWORD IS INVALID", "INVALID!", JOptionPane.ERROR_MESSAGE);
            }
        }
        else{ // if password and input is not equal
            JOptionPane.showMessageDialog(null, "Two inputs does not match", "WARNING: UNMATCHED PASSWORD!", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static boolean isPasswordValid(String password) {
        int lowercase=0, uppercase=0;
        if (password == null || password.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Password cannot be empty", "WARNING", JOptionPane.WARNING_MESSAGE);
            return false;
        }
        //Checks if the password is too short
        if (password.length() < 8 || password.length() > 20) {
            JOptionPane.showMessageDialog(null, "Password must be between 8-20 characters", "INVALID!", JOptionPane.INFORMATION_MESSAGE);
            return false;
        }

        // Code goes here if there is at least one lowercase input
        if (Pattern.compile("[a-z]").matcher(password).find()) { // returns TRUE if there is a lowercase
            for (char c : password.toCharArray()) { // for-each loop that traverse each character of password
                if (Character.isLowerCase(c)) { // checks if there is a lowercase character
                    lowercase++; // increments a lowercase counter if there is a lowercase found
                    if (lowercase >= 2) { // checks if there is already 2 lowercase found
                        break; // Stop checking if two lowercase character is found
                    }
                }
            }
            if (lowercase < 2) {   // case handling if there are less than 2 lowercase found
                JOptionPane.showMessageDialog(null, "Password must have AT LEAST 2 LOWERCASE!", "INVALID!", JOptionPane.ERROR_MESSAGE);
                return false;
            }
        }
        // Code goes here if there is at least one uppercase input
        if(Pattern.compile("[A-Z]").matcher(password).find()) { // returns TRUE if there is an uppercase
            for (char c : password.toCharArray()) { // for-each loop that traverse each character of password
                if (Character.isUpperCase(c)) { // checks if there is a lowercase character
                    uppercase++; //increments a uppercase counter if there is an uppercase found
                    if (uppercase >= 2) { // checks if there is already 2 lowercase found
                        break; // Stop checking if we have found at least two lowercase letters.
                    }
                }
            }
            if (uppercase < 2) { // case handling if there are less than 2 lowercase found
                JOptionPane.showMessageDialog(null, "Password must have AT LEAST 2 UPPERCASE!", "INVALID!", JOptionPane.ERROR_MESSAGE);
                return false;
            }
        }
        // Code goes here if there is no uppercase input
        if (!Pattern.compile("[A-Z]").matcher(password).find()){
            JOptionPane.showMessageDialog(null, "NO UPPERCASE FOUND IN YOUR PASSWORD", "INVALID!", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        // Code goes here if there is no lowercase input
        if (!Pattern.compile("[a-z]").matcher(password).find()){
            JOptionPane.showMessageDialog(null, "NO LOWERCASE FOUND IN YOUR PASSWORD", "INVALID!", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        // checks digit inputs
        if (!Pattern.compile("[0-9]").matcher(password).find()) {
            JOptionPane.showMessageDialog(null, "Password must have AT LEAST 1 DIGIT!", "INVALID!", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        // checks special characters
        if (!Pattern.compile(".*[^a-zA-Z0-9].*").matcher(password).find()) {  // returns TRUE if there is no special character
            // .*[^a-zA-Z0-9].* : range of non-alphanumeric characters
            JOptionPane.showMessageDialog(null, "Password must have AT LEAST 1 SPECIAL CHARACTER!", "INVALID!", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        //All check passed, so the password is valid
        return true;
    }
}