class Document {
    private String filename;
    private String[] content;
    private int length;

    Document(String filename, String[] content, int length) {
        this.filename = filename;
        this.content = content;
        this.length = length;
    }

    public String getFilename() {
        return filename;
    }

    public String[] getContent() {
        return content;
    }

    public int getLength() {
        return length;
    }
}