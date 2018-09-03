import java.util.Scanner;
/**
 * Class for input validator.
 */
class InputValidator {
    /*Write the atrributes and methods for InputValidator*/
    static String word;
    public InputValidator(String input) {
        this.word = input;
    }
    /**
     * { function_description }
     *
     * @return     { description_of_the_return_word }
     */
    public boolean validateData() {
        if (word.length() >= 6) {
            return true;
        } else {
            return false;
        }
    }
}
public class Solution
{
    /**
     * { item_description }
     */
    public static void main(String args[])
    {
        /**
         * { var_description }
         */
        Scanner s = new Scanner(System.in);
        String input = s.next();
        InputValidator i = new InputValidator(input);     
        System.out.println(i.validateData());

    }

}
