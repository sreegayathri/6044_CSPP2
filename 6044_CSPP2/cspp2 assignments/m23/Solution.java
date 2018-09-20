import java.io.FileReader;
import java.io.File;
import java.io.BufferedReader;
import java.util.Scanner;
import java.util.HashMap;
import java.util.regex.Pattern;
import java.util.regex.Matcher;
// import java.io.FileNotFoundException;
/**
 * Class for Solution.
 */
public final class Solution {
    /**
     * Constructs the object.
     */
    private Solution() {
        //Nothing happens here.
    }
    /**
     * Converts String to Required format.
     *
     * @param      fileContent  The file content
     *
     * @return     String without delimiters
     */
    public static String convertString(final String fileContent) {
        String ret = "";
        Pattern p = Pattern.compile("[^0-9_]");
        Matcher match = p.matcher(fileContent);

        while (match.find()) {
            ret += match.group();
        }
        return ret.toLowerCase();
    }
    /**
     * Hashmap with word and count.
     *
     * @param      input  The input
     *
     * @return     Hashmap with word and count
     */
    public static HashMap<String, Integer> generateHashMap(final String input) {
        String[] inputs = input.split(" ");
        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i < inputs.length; i++) {
            int count = 1;
            for (int j = 0; j < inputs.length; j++) {
                if (inputs[i].equals(inputs[j]) && i != j) {
                    count += 1;
                }
            }
            if (map.containsKey(inputs[i])) {
                String a;
            } else {
                map.put(inputs[i], count);
            }
        }
        return map;
    }
    /**
     * Reads the input from file.
     *
     * @param      folder     The folder
     * @param      name       The name
     *
     * @return     String format of file.
     *
     * @throws     Exception  Exception if occured.
     */
    public static String fileRead(final String folder, final String name)
        throws Exception {
        BufferedReader br = new BufferedReader(
            new FileReader("G:\\cspp2\\6044_CSPP2\\cspp2 assignments\\m23"
                + folder + "\\" + name));
        String content = "";
        String line;
        try {
            while ((line = br.readLine()) != null) {
                content += line;
            }
        } catch (Exception e) {
                e.printStackTrace();
        } finally {
            try {
                br.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return content;
    }
    /**
     * The main function.
     *
     * @param      args       The arguments
     *
     * @throws     Exception  throws exception if occured
     */
    public static void main(final String[] args) throws Exception {
        Similarity sim = new Similarity();
        Scanner s = new Scanner(System.in);
        if (!(s.hasNext())) {
            System.out.println("empty directory");
            return;
        }
        String folder = s.nextLine();
        File file = new File("G:\\cspp2\\6044_CSPP2\\cspp2 assignments\\m23" + folder);
        String[] str = file.list();
        for (String files : str) {
            String content = fileRead(folder, files);
            String inter = convertString(content);
            HashMap<String, Integer> hashmap = generateHashMap(inter);
            Document d = new Document(files, hashmap);
            sim.addDocument(d);
        }
        sim.documentSimilarity();
    }
}