import java.util.Scanner;
/**
 * Write a java program to find the odd composite ns
 * between 2 and n where n is given as an scan.
 *
 * @author : 
 */
public final class Solution {
    /**
    * Empty constructor.
    */
    private Solution() {
        //not used
    }
    private static String comps;
    /**
     * Prints the odd composite ns between 2 and n.
     *
     * @param      n     n value
     */
    public static boolean oddComposites(int n){
        boolean isTrue = true;
        for(int i = 2; i <= Math.ceil((n / 2)); i++){
            if(n % i == 0){
                if(comps.equals("")){
                    comps += ""+i;
                }
                else{
                    comps += "," + i;
                }
                isTrue = false;
            }
        }
        return isTrue;
    }
    /**
    * main method as driver program.
    * @param args is the parameter for this method
    */
    public static void main(String[] args){
    	/**
    	 * main function
    	 */

        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        comps = "";
        boolean prime = oddComposites(n);
        System.out.println(n);
    
    }
}
