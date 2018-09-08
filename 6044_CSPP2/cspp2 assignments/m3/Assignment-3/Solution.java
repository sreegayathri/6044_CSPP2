import java.util.Scanner;
/*
    Do not modify this main function.
    */
/**
 * class begins.
 */
public final class Solution {
    /**
     * the class.
     */

    private Solution() {
    }
    /**
     * Constructor of class.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        /**
         * main function of program.
         */

        Scanner s = new Scanner(System.in);
        int n1 = s.nextInt();
        int n2 = s.nextInt();
        System.out.println(gcd(n1, n2));
    }
    /**
     * params of gcd function.
     *
     * @param      n1    1st number
     * @param      n2    2nd number
     *
     * @return     greater common factor
     */
    public static int gcd(final int n1, final int n2) {
        int greaterfactor = 1;
        for (int i = 2; i <= n2; i++) {
            if (n1 % i == 0 && n2 % i == 0) {
                greaterfactor = i;
            }
        }
        return greaterfactor;
    }
}
