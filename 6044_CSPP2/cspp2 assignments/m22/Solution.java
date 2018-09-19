/**.
 * { item_description }
*/
import java.util.Scanner;
/**.
 * { item_description }
*/
import java.util.ArrayList;
/**.
 * { item_description }
 */
public final class Solution {
    /**
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
        /**.
        * { var_description }
        */
        Network net = new Network();
        Scanner scan = new Scanner(System.in);
        while (scan.hasNext()) {
            // read the line
            String line = scan.nextLine();
             // split the line using space
            String[] tokens = line.split(" ");
            switch(tokens[0]) {
                case"Create":
                    int testcase = Integer.parseInt(tokens[1]);
                    for (int i = 0;i < testcase; i++) {
                        String l = scan.nextLine();
                        String[] tokens1 = l.replace(".", "").split(" is connected to ");
                        String[] array = tokens1[1].split(", ");
                        List<String> frnds = new List<String>();
                        for (int j = 0; j < array.length; j++) {
                            frnds.add(array[j]);
                        }
                        net.addNewUser(tokens1[0], frnds);
                    }
                    break;
                case"addConnections":
                    net.addConnection(tokens[1], tokens[2]);
                    break;
                case"Network":
                    System.out.println(net);
                    break;
                case"getConnections":
                    List<String> list = net.getConnection(tokens[1]);
                    if (list!=null) {
                        System.out.println(getString(list));
                    } else {
                        System.out.println("Not a user in Network");
                    }
                    break;
                case"CommonConnections":
                    list = net.getCommonConnection(tokens[1], tokens[2]);
                    System.out.println(getString(list));
                    break;
                default:
                    break;
            }
        }
    }
    public static String getString(List<String> list) {
        if (list.size() == 0) {
            return "[]";
        }
        StringBuffer sb = new StringBuffer();
        sb.append("[");
        if (list != null) {
            for(int i = 0; i < list.size() - 1; i++) {
                sb.append(list.get(i) + ", ");
            }
            sb.append(list.get(list.size() - 1));
        }
        sb.append("]");
        return sb.toString();
    }
}