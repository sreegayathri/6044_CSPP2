/**.
        Author : sreegayathri
        date : 27/08/18
*/
import java.util.Scanner;

public final class Solution {
    /**. the class solution**/
    private Solution() {
        /**. constructor**/
    } /**.
    @param args of type string : command line args**/
    public static void main(String[] args) {
        /*main function*/
        Scanner s = new Scanner(System.in);      
        int base = s.nextInt();
        int exponent = s.nextInt();
        if (base >= 0 && exponent == 0) {
            int result = 1;
        }
        else
            if (base == 0 && exponent >= 1) {
            int result = 0;
            }
        else {
            for (int i = 1; i <= exponent; i++) {
                base *= exponent;
            }       
        }
        System.out.println("power of the number:" + base);
    }
    /*
    Need to write the power function and print the output.
    */
}
