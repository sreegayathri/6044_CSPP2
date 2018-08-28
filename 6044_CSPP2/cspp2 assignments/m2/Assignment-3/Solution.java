/**.
        Author : sreegayathri
        date : 27/08/18
*/
import java.util.Scanner;

public final class Solution {
    /**.
    the class solution**/
    private Solution() {
        /**. constructor**/
    } /**.
    @param args of type string : command line args**/
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);      
        int base = s.nextInt();
        int exponent = s.nextInt();
        long result = power(base, exponent);
        System.out.println(result);
    }
    /**.
     * function for power
     *
     * @param      base     {type int }.
     * @param      e     {type int}.
     *
     * @return     { returns the power }.
     */
    public static long power(final int base, final int e) {
        if (e != 0) {
            return (base * power(base, e - 1));
        } else {
            return 1;
        }
    }
}