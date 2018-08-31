/**. Given an String, Write a java method that
 *returns the decimal value for the given binary string.*/
import java.util.Scanner;
/**
 * Class for solution.
 */
public final class Solution {
    /**
     * { function_description }
     *
     * @param      args  The arguments
     */
    private Solution() {
        /**
         * { item_description }
         */
    }
    public static void main(final String[] args) {
        /**
         * { var_description }
         */
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        StringBuilder sb = new StringBuilder(s);
        System.out.println(sb.reverse().toString());
    }
}
