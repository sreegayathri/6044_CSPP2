import java.util.Scanner;
/**.
begin the class for the maximum number from given set of numbers*/
public final class Solution {
    /**.
    /* Fill the main function to print resultant of addition of matrices
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
        /**
         * { main function }.
         */
        Scanner s = new Scanner(System.in);
        int row1 = s.nextInt();
        int column1 = s.nextInt();
        int[][] matrix1 = new int[row1][column1];
        for (int i = 0; i < row1; i++) {
            for (int j = 0; j < column1; j++) {
                matrix1[i][j] = s.nextInt();
            }
        }
        int rows2 = s.nextInt();
        int column2 = s.nextInt();
        int[][] matrix2 = new int[rows2][column2];
        for (int i = 0; i < rows2; i++) {
            for (int j = 0; j < column2; j++) {
                matrix2[i][j] = s.nextInt();
            }
        }
        int[][] resultmatrix = new int[row1][column2];
        if (row1 == rows2 && column1 == column2) {
            for (int i = 0; i < row1; i++) {
                for (int j = 0; j < column1; j++) {
                    resultmatrix[i][j] = matrix1[i][j] + matrix2[i][j];
                }
            }
            for (int i = 0; i < row1; i++) {
                for (int j = 0; j < column1; j++) {
                    System.out.print(resultmatrix[i][j]);
                    if (j != column1 - 1) {
                        System.out.print(" ");
                    }
                }
                System.out.println();
                }
            } else {
                System.out.println("not possible");
            }
    }
}