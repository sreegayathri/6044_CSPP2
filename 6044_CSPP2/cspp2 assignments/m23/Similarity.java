import java.util.*;
class Similarity {
	private Document[] documents;
	private int documentArraySize;

	Similarity() {
		documents = new Document[10];
		documentArraySize = 0;
	}

	public Document[] getDocument() {
		return documents;
	}

	public void addDocument(Document d) {
		documents[documentArraySize++] = d;
	}

	public Document findDocument(String name) {
		for(int i = 0; i < documentArraySize; i++) {
			if(documents[i].getfilename().equals(name)) {
				return documents[i];
			}
		}
		return null;
	}

	public double getEuclideanNorm(String filename) {
		Document d = findDocument(filename);
		HashMap<String, Integer> hashmap = d.getHashMap();
		Double value = 0.0;
		int currentValue = 0;
		for(String key : hashmap.keySet()) {
			currentValue = currentValue + hashmap.get(key) * hashmap.get(key);
		}
		//System.out.println("BS"+currentValue);
		value = Math.sqrt(currentValue);
		// System.out.println("E:"+value);
		return value;
	}

	public double getDotProduct(String file1, String file2) {
		Document d1 = findDocument(file1);
		Document d2 = findDocument(file2);

		HashMap<String, Integer> hashmap1 = d1.getHashMap();
		HashMap<String, Integer> hashmap2 = d2.getHashMap();

		int value = 0;
		int value1 = 0;
		int value2 = 0;
		for(String key1 : hashmap1.keySet()) {
			// System.out.print(key + ":");
			value1 = hashmap1.get(key1);
			// System.out.println(value);
			for(String key2 : hashmap2.keySet()) {
				if(key1.equals(key2)) {
					value2 = hashmap2.get(key2);
					value += value1 * value2;
				}
			}
		}
		// System.out.println((value));
		return value;
	}

	public double cosineSimilarity(String file1, String file2) {
		double num = getDotProduct(file1, file2);
		double denom = getEuclideanNorm(file1) * getEuclideanNorm(file2);
		double cosine = num/denom;
		// System.out.println(cosine);
		return cosine;
	}

	public void documentSimilarity() {
		if(documentArraySize == 0) {
			System.out.print("empty directory");
			return;
		}
		for(int i=0; i < documentArraySize; i++) {
			if(i == 0) {
				System.out.print("      ");
				System.out.print("	");
				System.out.print("\t");
				System.out.print(documents[i].getfilename() + "\t");
			}
			else {
				System.out.print(documents[i].getfilename() + "\t");
			}
			// System.out.println();
		}
		long[][] result = new long[documentArraySize][documentArraySize];
		for(int i = 0; i < documentArraySize; i++) {
			// Document d = documents[i];
			System.out.println();
			System.out.print(documents[i].getfilename()+"\t");
			for(int j = 0; j < documentArraySize; j++) {
				double res = cosineSimilarity(documents[i].getfilename(),documents[j].getfilename());
				result[i][j] = Math.round(res*100); 
				System.out.print(Math.round(res*100)+"\t"+"\t");
			}
			// System.out.println();
		}
		long max = result[0][1];
		String[] index = new String[2];
		index[0] = documents[0].getfilename();
		index[1] = documents[0].getfilename();
		for(int i = 0; i < documentArraySize; i++) {
			for(int j = 0; j < documentArraySize; j++) {
				if(result[i][j] > max && i!=j) {
					max = result[i][j];
					index[0] = documents[i].getfilename();
					index[1] = documents[j].getfilename();
				}
			}
		}
		System.out.println();
		System.out.print("Maximum similarity is between "+index[0]+" and "+index[1]);
	}

}