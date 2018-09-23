import java.util.Arrays;
class Similarity {
	private Document[] documents;
	private int documentArraySize;

	Similarity() {
		documents = new Document[20];
		documentArraySize = 0;
	}

	public Document[] getDocument() {
		Document[] ret = new Document[documentArraySize];
		for(int i = 0; i < documentArraySize; i++) {
			ret[i] = documents[i];
		}
		return ret;
	}

	public int getdocumentArraySize() {
		return documentArraySize;
	}

	public void addDocument(Document d) {
		documents[documentArraySize++] = d;
	}

	public Document findDocument(String name) {
		for(int i = 0; i < documentArraySize; i++) {
			if(documents[i].getFilename().equals(name)) {
				return documents[i];
			}
		}
		return null;
	}

	// public int Occurences(String[] a, String b) {
	// 	int count = 1;
	// 	for(int i = 0; i < a.length; i++) {
	// 		if(a[i].equals(b)) {
	// 			count++;
	// 		}
	// 	}
	// 	return count;
	// }

	public float getSimilarity(String file1, String file2) {
		Document d1 = findDocument(file1);
		Document d2 = findDocument(file2);
		String[] content1 = d1.getContent();
		String[] content2 = d2.getContent();
		String longestString = "";
		String innerString = "";
		for(int i = 0; i < content1.length; i++) {
			for(int j = 0; j < content2.length; j++) {
				if(content1[i].equals(content2[j])) {
					int a = i+1;
					int b = j+1;
					int end = 0;
					innerString = content1[i] + " ";
					if (a < content1.length && b < content2.length) {
						while(content1[a].equals(content2[b])) {
							innerString = innerString + content2[b] + " ";
							a++;
							b++;
							if (a == content1.length || b == content2.length) {
								end = 1;
								break;
							}
						}
					}
					if(end == 1) {
						break;
					}
				}
			}
			if(innerString.length() - 1 > longestString.length()) {
				longestString = innerString;
			}
		}
		int numer = (longestString.length() - 1) * 2;
		// System.out.println("num "+numer);
		int denom = d1.getLength() + d2.getLength();
		// System.out.println("denom "+denom);
		float xp = (float)numer/denom;
		// System.out.println(xp);
		return xp * 100;
	}

	
	public void getDocumentSimilarity() {
		for(int i = 0; i < documentArraySize; i++) {
			for(int j = 0; j < documentArraySize; j++) { 
				System.out.println(getSimilarity(documents[i].getFilename(), documents[j].getFilename()));
				// System.out.println("------------");
			}
		}
	} 
}