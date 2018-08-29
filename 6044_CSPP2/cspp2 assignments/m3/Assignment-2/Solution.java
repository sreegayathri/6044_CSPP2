import java.util.Scanner;
/*
    Do not modify this main function.
    */
public final class Solution {
    /**.
    * class of the program*/
    private Solution() {
        /**.
        * constructor of the class*/
    }
/* Fill the main function to print the number of 7's between 1 to n*/
    /**.
    * @param n the given n numbers
    * @param i initialization
    * @param count number count of total 7s
    * @param temp temporary variable*/
    public static void main(final String[] args) {
        /**.
        * main function of the program*/
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int count = 0;
        int temp = 1;
        final int x = 10;
        final int y = 7;
        for (int i = 0; i <= n; i++) {
            temp = i;
            while (temp != 0) {
                if (temp % x == y) {
                    count++;
                }
                temp = temp / x;

            }

        }
        System.out.println(count);
    }
}
