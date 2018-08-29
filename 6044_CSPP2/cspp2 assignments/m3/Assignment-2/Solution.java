import java.util.Scanner;
/*
    Do not modify this main function.
    */
public final class Solution {
    private Solution() {
        /**.
        * constructor of the class*/
    }
/* Fill the main function to print the number of 7's between 1 to n*/
    public static void main(String[] args) {
        /**.
        * main function of the program */
        Scanner s = new Scanner(System.in);      
        int n = s.nextInt();
        int count = 0;
        for (int i = 1; i <= n; i++) {
            int temp = i;
            while (temp != 0) {
                if (temp %  10 == 7) {
                    count = count + 1;
                }
                temp = temp / 10;
            }
        }
        System.out.println(count);

    }
}
