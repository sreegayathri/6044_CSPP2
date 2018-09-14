/**
 * @ author sree gayathri : 20186044
 */

/**.
 * { item_description }
 */
import java.util.Scanner;
/**.
 * Class for solution.
 */
public final class Solution {
    /**.
     * Constructs the object.
     */
    private Solution() {
    /**.
     * { item_description }
     */
    }
    /**.
     * { function_description }
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        ShoppingCart ss = new ShoppingCart();
        Scanner scan = new Scanner(System.in);
        int testCases = Integer.parseInt(scan.nextLine());
        for (int i = 0; i < testCases; i++) {
            String line = scan.nextLine();
            String[] tokens = line.split(" ");
            switch (tokens[0]) {
                case "Item":
                String[] ss1 = tokens[1].split(",");
                ss.addToCatalog(new Item(ss1[0],
                    Integer.parseInt(ss1[1]), Float.parseFloat(ss1[2])));
                break;

                case "catalog":
                    ss.showCatalog();
                break;

                case "add":
                    String[] ss2 = tokens[1].split(",");
                    ss.addToCart(new Item(ss2[0],
                        Integer.parseInt(ss2[1]), 0.0f));
                break;

                case "remove":
                    String[] ss3 = tokens[1].split(",");
                    ss.removeFromCart(new Item(ss3[0],
                        Integer.parseInt(ss3[1]), 0.0f));
                break;
                case "show":
                    ss.showCart();
                break;
                case "totalAmount":
                    System.out.println("totalAmount: " + ss.getTotalAmount());
                break;
                case "payableAmount":
                    System.out.println("Payable amount: " + ss.
                        getPayableAmount());
                break;
                case "print":
                    ss.printInvoice();
                break;
                case "coupon":
                    ss.applyCoupon(tokens[1]);
                break;
                default:
                break;
            }
        }
    }
}
