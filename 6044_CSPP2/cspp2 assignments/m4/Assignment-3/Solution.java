
// Given an String, Write a java method that returns the decimal value for the given binary string.


import java.util.Scanner;
public class Solution {
/**
    Do not modify this main function.
    */
    
    public static String binaryToDecimal(String s) {
        /**
         * { var_description }
         */
        double sum = 0;
        for (int i = 0; i < s.length() ; i++) {
            char c = s.charAt(i);
            int numAti = Character.getNumericValue(c);
            sum = sum + numAti * Math.pow(2,(s.length()-1)-i );
        }
        int temp = (int) sum;
        String res = Integer.toString(temp);
        return res;
    }
    public static void main(String[] args) {
        /**
         * { var_description }
         */
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        for(int i = 0; i < n; i++) {
            String s = sc.nextLine();
            String res = binaryToDecimal(s);
            System.out.println(res);
        }
    }

}
