import java.util.*;
/**
 * Class for input validator.
 */
class InputValidator {
    /*Write the atrributes and methods for InputValidator*/
    static String value;
    public InputValidator(String input) {
        this.value = input;
    }
    /**
     * { function_description }
     *
     * @return     { description_of_the_return_value }
     */
    public boolean validateData() {
        if (value.length() >= 6) {
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
        Scanner s=new Scanner(System.in);
        String input=s.next();
        InputValidator i=new InputValidator(input);     
        System.out.println(i.validateData());

    }

}
