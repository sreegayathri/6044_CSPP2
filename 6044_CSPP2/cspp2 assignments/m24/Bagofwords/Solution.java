import java.io.FileReader;
//import java.lang.*;
import java.io.File;
import java.util.Scanner;
// import java.util.regex.Pattern;
// import java.util.regex.Matcher;
import java.util.TreeMap;
import java.io.BufferedReader;
/**.
 * Class for plagrism.
 */
final class Solution {
    /**.
     * This is solution
     */
    private Solution() {
        //this is solution
    }
    /**
     * this is the main function.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Scanner folder = new Scanner(System.in);
        File test;
        try {
            test = new File(folder.nextLine());
        } catch (Exception e) {
            System.out.println("empty directory");
            return;
        }
        File[] files = test.listFiles();
        // System.out.print("\t\t");
        for (File name : files) {
            System.out.print("\t" + name.toString().split("\\\\")[1]);

        }
        for (File each : files) {
            // String input1 = each.getAbsolutePath();
            // System.out.println(input1);
            System.out.println();

            System.out.print(each.toString().split("\\\\")[1] + "\t");
            for (File next : files) {
                // String input2 = next.getAbsolutePath();
                // System.out.println(input2);
                try {
                    FileReader firstFile = new FileReader(each);
                    FileReader secondFile = new FileReader(next);

                    BufferedReader reader1 = new BufferedReader(firstFile);
                    BufferedReader reader2 = new BufferedReader(secondFile);
                    TreeMap<String, Integer> freqCount1 = new TreeMap<>();
                    TreeMap<String, Integer> freqCount2 = new TreeMap<>();

                    String lines;
                    while ((lines = reader1.readLine()) != null) {
                        String[] line = lines.
                                        replaceAll("[^a-zA-Z0-9_ ]", "").
                                        toLowerCase().split(" ");
                        // String[] line = lines.toLowerCase().split(" ");
                        for (String element : line) {
                            if (freqCount1.containsKey(element)) {
                                freqCount1.
                                put(element, freqCount1.get(element) + 1);

                            } else {
                                freqCount1.put(element, 1);
                            }
                            if (!freqCount2.containsKey(element)) {
                                freqCount2.put(element, 0);

                            }

                        }
                        // System.out.println(freq);

                    }

                    while ((lines = reader2.readLine()) != null) {
                        String[] line = lines.
                                        replaceAll("[^a-zA-Z_ ]", "").
                                        toLowerCase().split(" ");


                        // String [] line = lines.toLowerCase().split(" ");

                        for (String element : line) {
                            if (freqCount2.containsKey(element)) {
                                freqCount2.put(element, freqCount2.
                                    get(element) + 1);

                            } else {
                                freqCount2.put(element, 1);
                            }
                            if (!freqCount1.containsKey(element)) {
                                freqCount1.put(element, 0);

                            }

                        }
                        // System.out.println(freq2);

                    }
                    System.out.print(plagPercent(
                                         freqCount1, freqCount2) + "\t\t");
                } catch (Exception e) {
                    System.out.println("File not Found");

                } /*catch (IOException e) {
                    System.out.println("Invalid Input");
                }*/

            }

        }
        System.out.println();

    }
    /**
     * plagrism percentage calculation.
     *
     * @param      freqCount1   The frequency
     * @param      freqCount2  The frequency 2
     *
     * @return     { description_of_the_return_value }
     */
    public static int plagPercent(final TreeMap<String, Integer> freqCount1,
                                  final TreeMap<String, Integer> freqCount2) {
        int sum1 = 0;
        int sum2 = 0;
        int dot = 0;
        // System.out.println(freq + "    " + freq2);
        for (String each : freqCount1.keySet()) {
            sum1 += freqCount1.get(each) * freqCount1.get(each);
            // System.out.println(sum);
            sum2 += freqCount2.get(each) * freqCount2.get(each);
            // System.out.println(sum2);
            dot += freqCount1.get(each) * freqCount2.get(each);
            // System.out.println(dot);

        }
        // System.out.println("dat "+dot+" s1"+sum1+"s2"+sum2);
        final int hun = 100;
        return ((int) ((dot / (Math.sqrt(sum1) * Math.sqrt(sum2))) * hun));
    }

}
