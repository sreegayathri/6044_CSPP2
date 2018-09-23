import java.util.Scanner;
import java.io.FileReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.NoSuchElementException;

/**this class is to maintain.
*complete details of two files.
*/
class Data {
    /** this is an empty constructor.
    */
    Data() {
    }
    /**this method is to convert the.
    *file document text to string
    *@param file File
    *@return str returns string of that text.
    */
    public static String toText(final File file) {
        String str = "";
        try {
            Scanner input = new Scanner(new FileReader(file));
            StringBuilder text = new StringBuilder();
            while (input.hasNext()) {
                text.append(input.next());
                text.append(" ");
            }
            input.close();
            str = text.toString();
        } catch (FileNotFoundException e) {
            System.out.println("No file");
        }
        return str;
    }
    /**this method is to give the.
     *document distance.
     *@param textOne first file string
     *@param textTwo second file string
     *@return document distance
     */

    public double stringMatching(final String textOne, final String textTwo) {
        int lengthOne = textOne.length();
        int lengthTwo = textTwo.length();
        double totalLength = lengthOne + lengthTwo;
        int max = 0;
        double lcs = 0;
        final int hundred = 100;
        int[][] array = new int[lengthOne][lengthTwo];
        for (int i = 0; i < lengthOne; i++) {
            for (int j = 0; j < lengthTwo; j++) {
                if (textOne.charAt(i) == textTwo.charAt(j)) {
                    if (i == 0 || j == 0) {
                        array[i][j] = 1;
                    } else {
                        array[i][j] = array[i - 1][j - 1] + 1;
                    }
                    if (max < array[i][j]) {
                        max = array[i][j];
                    }
                }
            }
        }
        lcs = (((max * 2) / totalLength) * hundred);
        return lcs;
    }
}
/** this is the solution class.
*/
public final class Solution {
    /** an empty constructor.
    */
    private Solution() {

    }
    /**
     * this is main method.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        try  {
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();
        File files = new File(input);
        Data obj = new Data();
        File[] fileList = files.listFiles();
        int length = fileList.length;
        double maxValue = 0;
        final int hundred = 100;
        String result = "";
        double[][] fileMatrix = new double[length][length];
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                if (i == j) {
                    fileMatrix[i][j] = hundred;
                } else {
                    fileMatrix[i][j] = obj.stringMatching(
                        obj.toText(fileList[i]), obj.toText(fileList[j]));
                    if (maxValue < fileMatrix[i][j]) {
                        maxValue = fileMatrix[i][j];
                        result = "Maximum similarity is between "
                        + fileList[i].getName() + " and "
                        + fileList[j].getName();
                    }
                }
            }
        }
        System.out.print("      \t");
        for (int i = 0; i < length - 1; i++) {
            System.out.print("\t" + fileList[i].getName());
        }
        System.out.println("\t" + fileList[length - 1].getName());
        for (int i = 0; i < length; i++) {
            System.out.print(fileList[i].getName() + "\t");
            for (int j = 0; j < length; j++) {
                    System.out.print(
                        String.format("%.1f", fileMatrix[i][j]) + "\t\t");
            }
            System.out.println();
        }
     System.out.println(result);
    } catch (NoSuchElementException e) {
        System.out.println("Empty Directory");
    }
    }
}
