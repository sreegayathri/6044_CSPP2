/**.
* { item_description }
*/
import java.io.BufferedInputStream;
/**.
* { item_description }
*/
import java.util.Scanner;
/** . { item_description }
*/
import java.util.Arrays;
/**.
* List of .
*/
public class SortedSet extends Set {
    /**.
    * { function_description }
    *
    * @return     { description_of_the_return_value }
    */
    public int last() throws Exception {
        if (size() == 0) {
            throw new Exception("Set Empty Exception");
        } else {
            return get(size() - 1);
        }
    }
    /**.
    * { function_description }
    *
    * @param      item  The item
    */
    public void add(final int item) {
        if (!contains(item)) {
            int index = getIndex(item);
            add(index, item);
        }
    }
    /**.
    * Gets the index.
    *
    * @param      item  The item
    *
    * @return     The index.
    */
    public int getIndex(final int item) {
        for (int i = 0; i < size(); i++) {
            if (item <= this.get(i)) {
                return i;
            }
        }
        return size();
    }
    /**.
    * { function_description }
    *
    * @param      fromElement  The fromElement
    * @param      toElement    The toElement
    *
    * @return     { description_of_the_return_value }
    */
    public int[] subSet(final int fromElement, final int toElement) throws Exception {
        if (fromElement > toElement) {
            throw new Exception("Invalid Arguments to Subset Exception");
        } else {
            int fromindex = getIndex(fromElement);
            int toindex = getIndex(toElement);
            int[] subset = new int[toindex - fromindex];
            int k = 0;
            for (int i = fromindex; i < toindex; i++) {
                subset[k++] = this.get(i);
            }
            return subset;
        }
    }
    /**.
    * { function_description }
    *
    * @param      toElement  The toElement
    *
    * @return     { description_of_the_return_value }
    */
    public int[] headset(final int toElement) throws Exception {
        if (toElement <= this.get(0)) {
            throw new Exception("Set Empty Exception");
        } else {
            return subSet(get(0), toElement);
        }
    }
    /**.
    * { function_description }
    *
    * @param      s     { parameter_description }
    *
    * @return     { description_of_the_return_value }
    */
    public static int[] intArray(final String s) {
        String input = s;
        if (input.equals("[]")) {
            return new int[0];
        }
        if (s.contains("[")) {
            input = s.substring(1, s.length() - 1);
        }
        return Arrays.stream(input.split(","))
               .mapToInt(Integer::parseInt)
               .toArray();
    }
    /**.
    * { function_description }
    *
    * @param      args  The arguments
    */
    public static void main(final String[] args) {
        SortedSet s = new SortedSet();
// code to read the test cases input file
        Scanner stdin = new Scanner(new BufferedInputStream(System.in));
// check if there is one more line to process
        while (stdin.hasNext()) {
// read the line
            String line = stdin.nextLine();
// split the line using space
            String[] tokens = line.split(" ");
// based on the list operation invoke the corresponding method
            switch (tokens[0]) {
            case "size":
                System.out.println(s.size());
                break;
            case "contains":
                System.out.println(s.
                                   contains(Integer.parseInt(tokens[1])));
                break;
            case "print":
                System.out.println(s);
                break;
            case "addAll":
                int[] intArray = intArray(tokens[1]);
                if (intArray.length == 1) {
                    s.add(intArray[0]);
                } else {
                    s.add(intArray);
                }
                break;
            case "subSet":
                try {
                    String[] arrstring = tokens[1].split(",");
                    int[] subarray = s.subSet(Integer.parseInt(arrstring[0]),
                                              Integer.parseInt(arrstring[1]));
                    Set subset = new Set();
                    subset.add(subarray);
                    if (subset != null) {
                        System.out.println(subset);
                    }
                }  catch (Exception se) {
                    System.out.println(se.getMessage());
                }
                break;
            case "headSet":
                try {
                    int[] headarray = s.headset(Integer.parseInt(tokens[1]));
                    Set headset = new Set();
                    headset.add(headarray);
                    if (headset != null) {
                        System.out.println(headset);
                    }
                } catch (Exception se) {
                    System.out.println(se.getMessage());
                }
                break;
            case "last":
                try {
                    System.out.println(s.last());
                    break;
                } catch (Exception se) {
                    System.out.println(se.getMessage());
                }
            case "intersection":
                s = new SortedSet();
                SortedSet t = new SortedSet();
                intArray = intArray(tokens[1]);
                s.add(intArray);
                intArray = intArray(tokens[2]);
                t.add(intArray);
                System.out.println(s.intersection(t));
                break;
            case "retainAll":
                s = new SortedSet();
                intArray = intArray(tokens[1]);
                s.add(intArray);
                intArray = intArray(tokens[2]);
                System.out.println(s.retainAll(intArray));
                break;
            case "cartesianProduct":
                s = new SortedSet();
                t = new SortedSet();
                intArray = intArray(tokens[1]);
                s.add(intArray);
                intArray = intArray(tokens[2]);
                t.add(intArray);
                System.out.println(Arrays.deepToString(
                                       s.cartesianProduct(t)));
                break;
            default:
                break;
            }
        }
    }
}
