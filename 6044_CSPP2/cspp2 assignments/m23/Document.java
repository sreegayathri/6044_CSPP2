import java.util.*;
class Document {

    private String filename;
    private HashMap<String, Integer> hashmap;

    Document(String filename, HashMap<String, Integer> hashmap) {
        this.filename = filename;
        this.hashmap = hashmap;
    }

    public String getfilename() {
        return filename;
    }

    public HashMap<String, Integer> getHashMap() {
        return hashmap;
    }
}