import java.util.*;
import java.io.*;
import java.io.FileReader;
public class Solution {

	public static String fileRead(final String folder, final String name)
        throws Exception {
        BufferedReader br = new BufferedReader(
            new FileReader("G:\\cspp2\\6044_CSPP2\\cspp2 assignments\\m24\\Stringmatching"
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
	public static void main(String[] args) throws Exception {
		Similarity sim = new Similarity();
        Scanner s = new Scanner(System.in);
        if (!(s.hasNext())) {
            System.out.println("empty directory");
            return;
        }
        String folder = s.nextLine();
        File file = new File("G:\\cspp2\\6044_CSPP2\\cspp2 assignments\\m24\\Stringmatching" + folder);
        String[] str = file.list();
        // System.out.println(Arrays.toString(str));
        for (String files : str) {
        	// System.out.println(files);
            String read = fileRead(folder, files);
            String[] content = read.split(" ");
            Document d = new Document(files, content, read.length());
            // System.out.println(read);
            // System.out.println(Arrays.toString(content));
            // System.out.println(read.length());
            sim.addDocument(d);
        }
        sim.getDocumentSimilarity();
    }
}