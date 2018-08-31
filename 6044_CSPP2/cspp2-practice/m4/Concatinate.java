import java.util.Scanner;
/**
 * Class for concatinate.
 */
class Concatinate {
    /**
     * @param args
     */
    public static void main(String args[]) {
        /**
         * main function
         */
        Scanner s = new Scanner(System.in);
        System.out.println("Enter name: ");
        String names = s.nextLine();
        System.out.println("Hello ".concat(names) + "!");
    }
}
