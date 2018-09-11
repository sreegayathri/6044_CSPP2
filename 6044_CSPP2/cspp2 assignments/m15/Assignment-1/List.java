import java.io.BufferedInputStream;
import java.util.Scanner;
import java.util.Arrays;
/**
 * List of .
 */
public class List {
/**.
 * { var_description }
 */
    private int[] list;
    /**.
     * { size }
     */
    private int size;
    /**.
     * { magic }
     */
    private static final int H = 10;
/**
* Constructs the object.
*/
    public List() {
        list = new int[H];
        size = 0;
    }
    /**
     * @param      item  The item
     */
    public void add(final int item) {
        if (size == list.length) {
            resize();
        }
        list[size++] = item;
    }
    /**
     * @return     { description_of_the_return_value }
     */
    public int size() {
        // replace the code below to implement the size method
        return size;
    }
    /**.
     * resize
     */
    private void resize() {
        list = Arrays.copyOf(list, size * 2);
    }
/**.
 * { function_description }
 *
 * @param      index      The index
 *
 * @throws     Exception  { exception_description }
 */
    public void remove(final int index) throws Exception {
        if (index < 0 || index >= size) {
            throw new Exception();
        } else {
            for (int i = index; i < size - 1; i++) {
                list[i] = list[i + 1];
            }
            size--;
        }
    }
    /**
     * @param      index  The index
     * @return     { description_of_the_return_value }
     */
    public int get(final int index) {
        // Replace the code below to write the code for get
        if (index < 0 && index >= size) {
            return -1;
        } else {
            return list[index];
        }
    }
    /**
     * @return     String representation of the object.
     */
    public String toString() {
        // Replace the code below
        if (size == 0) {
            return "[]";
        }
        String str = "[";
        int i = 0;
        for (i = 0; i < size - 1; i++) {
            str = str + list[i] + ",";
        }
        str = str + list[i] + "]";
        return str;
    }
    /*
     * Contains return true if the list has the item passed as an argument to
     * the method So, iterate through the list and return true if the item
     * exists and otherwise false
     */
    /**
     * @param      item  The item
     * @return     { description_of_the_return_value }
     */
    public boolean contains(final int item) {
        // Replace the code below
        return indexOf(item) == -1;
    }
    /*
     * Returns the index of the first occurrence of the specified element in
     * this list, or -1 if this list does not contain the element.
     */
    /**
     * @param      item  The item
     * @return     { description_of_the_return_value }
     */
    public int indexOf(final int item) {
        // Replace the code below
        for (int i = 0; i < size; i++) {
            if (item == list[i]) {
                return i;
            }
        }
        return -1;
    }
    //Inserts all the elements of specified int array to the end of list.
    /**.
     * Adds all.
     * @param      items  The items
     */
    public void addAll(final int[] items) {
        // write the logic
        for (int i = 0; i < items.length; i++) {
            add(items[i]);
        }
    }
    //Removes all of its elements that are contained in specified int
    //array.
    /**
     * Removes all.
     * @throws     Exception  { exception_description }
     * @param      newArray  The new array
     */
    public void removeAll(final int[] newArray) throws Exception {
        // write the logic
        for (int i = 0; i < newArray.length; i++) {
            int index = indexOf(newArray[i]);
            while (index != -1) {
                remove(index);
                index = indexOf(newArray[i]);
            }
        }
    }
    /* Returns a list object containing elements, including startIndex and
    excluding endIndex. The first parameter indicates the startIndex and the
    second parameter indicates the endIndex. Returns null and print
    "Index Out of Bounds Exception" if any of values start and end are negative
    and also if start is greater than end. */
    /**
     * @param      start  The start
     * @param      end    The end
     * @throws     Exception  { exception_description }
     * @return     { description_of_the_return_value }
     */
    public List subList(final int start, final int end) throws Exception {
        // write the logic for subList
        List subList = new List();
        if (start < 0 || end < 0 || start == end) {
            throw new Exception("Index Out of Bounds Exception");
        }
        if (start > end || start > size || end > size) {
            throw new Exception("Index Out of Bounds Exception");
        }
        for (int i = start; i < end; i++) {
            subList.add(this.list[i]);
        }
        return subList;
    }
    /* Returns a boolean indicating whether the parameter i.e a List
    object is exactly matching with the given list or not.*/
    /**
     * @param      list1  The list
     * @return     { description_of_the_return_value }
     */
    public boolean equals(final List list1) {
        // Replace the code below
        return toString().equals(list1.toString());
        /*if (size() != list.size()) {
            return false;
        }
        for (int i = 0; i < list.size; i++) {
            //if (list.get(i) == this.get(i))
            if (list.contains(this.list[i])) {
                return false;
            }
        }
        return true;*/
    }
    /* Removes all the elements from list
    * Think about this case and make the method
    * the simpler.*/
    /**.
     * { null }
     */
    public void clear() {
        // write the logic for clear.
        size = 0;
        list = new int[H];
    } // after clearing the list it's size is back to 10
    // no need of new object of list again, only the
    // size/length is set to original empty list
    /**.
     * { function_description }
     * @param      index  The index
     * @param      item   The item
     */
    public void add(final int index, final int item) {
         // write the logic
        if (index < 0) {
            System.out.println("Negative Index Exception");
        } else {
            for (int i = size; i > index; i--) {
                list[i] = list[i - 1];
            }
            list[index] = item;
                size++;
         }
    }
    /**.
     * { function_description }
     *
     * @param      item  The item
     *
     * @return     { description_of_the_return_value }
     */
    public int count(final int item) {
         // write the logic
        int count = 0;
        for (int i = 0; i < size; i++) {
            if (list[i] == item) {
                count += 1;
            }
        }
        return count;
    }
    /**
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        // create an object of the list to invoke methods on it
        List l = new List();
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
            case "add":
                if (tokens.length == 2) {
                    String[] t = tokens[1].split(",");
                    if (t.length == 1) {
                        l.add(Integer.
                            parseInt(tokens[1]));
                    }
                }
                break;
            case "size":
                System.out.println(l.size());
                break;
            case "print":
                System.out.println(l);
                break;
            case "remove":
                try {
                    if (tokens.length == 2) {
                        l.remove(Integer.parseInt(tokens[1]));
                    } 
                } catch(Exception e) {
                    System.out.println("Invalid Position Exception");
                }
                break;
            case "indexOf":
                if (tokens.length == 2) {
                    System.out.println(l.indexOf(
                                           Integer.parseInt(tokens[1])));
                }
                break;
            case "get":
                if (tokens.length == 2) {
                    System.out.println(l.get(
                                           Integer.
                                           parseInt(tokens[1])));
                }
                break;
            case "contains":
                if (tokens.length == 2) {
                    System.out.println(l.contains(
                                           Integer.
                                           parseInt(tokens[1])));
                }
                break;
            case "count":
                    System.out.println(l.count(Integer.parseInt(tokens[1])));
                    break;
            case "addAll":
                if (tokens.length == 2) {
                    String[] t1 = tokens[1].split(",");
                    int[] temp = new int[t1.length];
                    for (int i = 0; i < temp.length; i++) {
                        temp[i] = Integer.
                        parseInt(t1[i]);
                    }
                    l.addAll(temp);
                }
                break;
            case "removeAll":
                try {
                    if (tokens.length == 2) {
                        String[] t2 = tokens[1].split(",");
                        int[] a = new int[t2.length];
                        for (int i = 0; i < t2.length; i++) {
                            a[i] = Integer.parseInt(t2[i]);
                        }
                        l.removeAll(a);
                    }
                } catch(Exception e) {
                    System.out.println("Invalid Position Exception");
                }
                
                break;
            case "subList":
                try {
                    if (tokens.length != 2) {
                        break;
                    }
                    String[] arrstring3 = tokens[1].split(",");
                    List object = l.subList(Integer.
                        parseInt(arrstring3[0]),
                     Integer.parseInt(arrstring3[1]));
                    if (object != null) {
                        System.out.println(object);
                    }
                } catch(Exception e) {
                    System.out.println("Index Out of Bounds Exception");
                }
                break;
            case "equals":
                if (tokens.length == 2) {
                    String[] lt = tokens[1].split(",");
                    List l2 = new List();
                    for (int k = 0; k < lt.length; k++) {
                        l2.add(Integer.parseInt(lt[k]));
                    }
                    System.out.println(l.equals(l2));
                }
                break;
            case "clear":
                l.clear();
                break;
            default:
                break;
            }
        }
    }
}
