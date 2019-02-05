import java.util.Scanner;
/**.
*program of quadratic equation
*/
public final class Solution {
    /**.
    class of solution.
    */
    private Solution() {
        /**.
        this is a constructor*/
    }
    /**.
    *@param args the arguments */
    public static void main(final String[] args) {
        Scanner scan = new Scanner(System.in);
        int a = scan.nextInt();
        int b = scan.nextInt();
        int c = scan.nextInt();
        quadratic(a, b, c);
    }
    /**. solving the quadratic equation
    * @param a = numeric element
    * @param b = numeric element
    * @param c = numeric element*/
    public static void quadratic(final int a, final int b, final int c) {
        /**. conditions for quadratic equation*/
        final int value = 4;
        double root = Math.sqrt((b * b) - (value * a * c));
        double numerator1 = -b + root;
        double numerator2 = -b - root;
        double denominator = 2 * a;
        double value1 = numerator1 / denominator;
        double value2 = numerator2 / denominator;
        System.out.println(value1 + " " + value2);
    // int[] a = {10, 20, 30, 40, 50};
    // for (int i=0; i<a.length; i=i+2) {
    // 	System.out.println(a[i]);
    // }
    }
}