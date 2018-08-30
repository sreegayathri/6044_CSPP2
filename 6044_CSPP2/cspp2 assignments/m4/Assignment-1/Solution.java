import java.util.*;
/**.
begin the class for the maximum number from given set of numbers*/
public final class Solution {
    /**.
    Fill this main function to print maximum of given array
    */
    private Solution() {
        /**.
         * { class constructor }
         */
    }
    /**
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        /**.
         * { main function of the program }
         */
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        //int max = getMax(arr);
        System.out.println(getMax(arr));
    }
    /**
     * Gets the maximum.
     * @param      inputArray  The input array
     * @return     The maximum.
     */
    public static int getMax(final int[] inputArray) {
        /**
         * { getmax function of the program }
         */
        int maxValue = inputArray[0];
        for (int i = 1; i < inputArray.length; i++) {
            if (inputArray[i] > maxValue) {
                maxValue = inputArray[i];
            }
        }
        return maxValue;
    }
}
