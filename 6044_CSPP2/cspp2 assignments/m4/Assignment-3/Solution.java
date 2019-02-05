import java.util.Scanner;
/**. Given an String, Write a java method that returns the decimal value
for the given binary string.*/
public final class Solution {
    /**.
     * class of the program
     */
    private Solution() {
        /**.
         * { constructor }
         */
    }
/**
 * @param      s     { parameter_description }
 * @return     { description_of_the_return_value }
 */
    public static String binaryToDecimal(final String s) {
        /**
         * { var_description }
         */
        double sum = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            System.out.println(c);
            int numAti = Character.getNumericValue(c);
            sum = sum + numAti * Math.pow(2, (s.length() - 1) - i);
        }
        int temp = (int) sum;
        String result = Integer.toString(temp);
        return result;
    }
    /**.
     * { function_description }
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        /**
         * { var_description }
         */
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        for (int i = 0; i < n; i++) {
            String s = sc.nextLine();
            String result = binaryToDecimal(s);
            System.out.println(result);
        }
    }

}
