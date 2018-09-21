import java.io.File;
class Plagarism {
    List<String> doclist;

    public Plagarism(List<String> doclist) {
        this.doclist = doclist;
    }
    public String getdocument() {
        return this.doclist;
    }
    public void setdocument(List<String> doclist) {
        this.doclist = doclist;
    }
    public void addDoc() {
        System.out.println("dot");
    }
    public void bagOfWords() {
        double[][] matrix = new double[4][4];
        for (int i = 0; i < doclist.size(); i++) {
            for (int j; j < doclist.size(); j++) {
                if (i < j) {
                   matrix[i][j] = bagOfWords(doclist.get(i), doclist.get(j)); 
                } else {
                    matrix[i][j] = matrix[j][i];
                }
            }
        }
    }
    public int dotProduct(){

    } 
    public double eculidean(Hastable<String, Integer> ht) {
        int add = 0;
    }
    public void loadStopWords(String file) {
        List<String> stopwordslist = new List<String>();
        Scanner scan = new Scanner(new file("Stopwords.txt"));
        while(scan.hasNext()) {
            String line = scan.nextLine();
            stopwordslist.add(tokens);
        }
        return stopwordslist;
    }

    public List<String> removeStopwords() {
        List<String> reswords = new List<String>();
        List<String> stopwords = new List<String>();
        for (String word : tokens) {
            if (!stopwords.contains(word.get(i))) {
                reswords.add(word);
            }
        }
        return reswords;
    }
    public Hastable<String, Integer> Count(String document) {
        Hastable<String, Integer> ht = new Hastable<String, Integer>();
        dc = dc.toLowerCase();
        String[] token = line.replaceAll("[^a-zA-Z0-9]", "");
        String[] tokens = token.split(" ");
        //loadStopWords();
        //removeStopwords(tokens);
        List<String> wlist = removeStopwords(tokens);
        for (int i = 0; i < wlist.size(); i++) {
        //for (String token : tokens) {
            if (ht.contain(wlist.get(i))) {
                ht.put(wlist.get(i), ht.get(wlist.get(i)) + 1);
            } else {
                ht.put((wlist.get(i)) + 1);
            }
        }
        return ht.x;
    }
}