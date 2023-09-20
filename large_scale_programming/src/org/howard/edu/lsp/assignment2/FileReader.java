package org.howard.edu.lsp.assignment2;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.Scanner;

public class FileReader {
	
	public FileReader() {
		System.out.println("My constructor!!!");
		System.out.println(new File(".").getAbsolutePath());
	}
	
	public String readToString(String resource) throws FileNotFoundException {
		URL url = getClass().getClassLoader().getResource(resource);
		if (url != null) {
			File file = new File(url.getPath());
			
			Scanner sc = null;
			try {
				sc = new Scanner(file);
				String output = "";
				while (sc.hasNextLine()) {
					output = output + sc.nextLine() + " ";
				}
				return output.trim();
			} finally {
				sc.close();
			}
		}
		throw new FileNotFoundException();
	}
}
