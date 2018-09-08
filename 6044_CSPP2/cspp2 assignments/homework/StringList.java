import java.io.BufferedInputStream;
import java.util.Scanner;
import java.util.Arrays;
/**
 * StringList of .
 */
public class StringList {
/**
 * { item_description }
 */
    private String[] strlist;
    private int size;

/**
 * Constructs the object.
 */
    public StringList() {
/**
 * { item_description }
 */
        strlist = new String[10];


        size = 0;
    }


/**
 * Constructs the object.
 *
 * @param      capacity  The capacity
 */
    public StringList(int capacity) {
        size = 0;
        StringList = new int[capacity];
    }
/**
 * { function_description }
 *
 * @param      item  The item
 */
    public void add(String item) {
        //Inserts the specified element at the end of the StringList.
        if (size == strlist.length) {
            resize();
        }
        strlist[size++] = item;   
    }
    
    private void resize() {
        strlist = Arrays.copyOf(strlist, size * 2);
    }    

/**
 * { function_description }
 *
 * @return   int  { description_of_the_return_value }
 */
    public int size() {
        return size;
    }

/**
 * { function_description }
 *
 * @param      index  The index
 */
    public void remove(int index) {
        // write the logic for remove here.
        // Think about what to do to the size variable.
        if(index >= 0 && index <= size) {
            for(int i = index; i < size - 1; i++) {
                strlist[i] = strlist[i + 1];
            }
            size--;
        } else {
            System.out.println("Invalid Position Exception");
        }
    }
/**
 * @param      index  The index
 * @return     { description_of_the_return_value }
 */

    public String get(int index) {
        if(index < 0 || index >= size) {
            return -1;
        } else {
            return strlist[index];
        }
    }

/**
 * @return     String representation of the object.
 */
    public String toString() {
        if(size == 0)
            return "[]";
        String str = "[";
        int i = 0;
        for(i = 0; i < size - 1; i++) {
            str = str + StringList[i] + ",";
        }
        str = str + StringList[i] + "]";
        return str;
    }

/**
 * @param      item  The item
 * @return   bool  { description_of_the_return_value }
 */
    public boolean contains(String item) {
        return indexOf(item) == -1;
    }

/**
 * @param      item  The item
 * @return     { description_of_the_return_value }
 */
    public int indexOf(String item) {
        for(int i = 0; i < size; i++) {
            if(item == strlist[i])
                return i;
        }
        return -1;
    }
/**
 * @param      args  The arguments
 */
    public static void main(String[] args) {
        // create an object of the StringList to invoke methods on it
        StringList l = new StringList();

        // code to read the test cases input file
        Scanner stdin = new Scanner(new BufferedInputStream(System.in));
        // check if there is one more line to process
        while (stdin.hasNext()) {
            // read the line
            String line = stdin.nextLine();
            // split the line using space
            String[] tokens = line.split(" ");
            // based on the StringList operation invoke the corresponding method
            switch (tokens[0]) {
                case "add":
                l.add(Integer.parseInt(tokens[1]));
                break;
                case "size":
                // invoke size method and print the StringList size
                // BTW, StringList size is not the array size
                // it is the number of items in the StringList
                System.out.println(l.size());
                break;
                case "print":
                // print the StringList (implement toString for this to work)
                // expected format is [item-1,item-2,...,item-n]
                // review the output testcase file
                System.out.println(l);
                break;
                case "remove":
                l.remove(Integer.parseInt(tokens[1]));
                break;
                case "indexOf":
                System.out.println(l.indexOf(Integer.parseInt(tokens[1])));
                break;
                case "get":
                System.out.println(l.get(Integer.parseInt(tokens[1])));
                break;
                case "contains":
                System.out.println(l.contains(Integer.parseInt(tokens[1])));
                break;
            }
        }
    }
}
