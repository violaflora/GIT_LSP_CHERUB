package org.howard.edu.lsp.assignment2;

import java.io.FileNotFoundException;
import java.util.HashMap;

public class MapCounter {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FileReader filename = new FileReader();
		HashMap<String, Integer> hashmap = new HashMap<String, Integer>();
		try {
			String filepath = filename.readToString("words.txt"); // call readToString method
			System.out.println(filepath);
			String[] seperated = filepath.replaceAll("[^a-zA-z ]", "").toLowerCase().split(" "); // tokenization with space delimiter, prunes digits and special characters
			//String[] seperated = filepath.toLowerCase().split(" "); // tokenization with space delimiter
			for (int x = 0; x < seperated.length; x++) { // iterate thru array of strings
				if (seperated[x].length() > 3) { // ignore trivial words
					if (hashmap.get(seperated[x]) == null) { // counter code for hash map
						hashmap.put(seperated[x], 1);
					} else {
						hashmap.put(seperated[x], hashmap.get(seperated[x]) + 1);
					}
				}
			}
			for (String i: hashmap.keySet()) {
				System.out.println(i + " " + hashmap.get(i));
			}
		}
		catch (FileNotFoundException e) {
			System.out.println("File not found in directory");
		}
	}

}
