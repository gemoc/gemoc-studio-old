package org.gemoc.execution.engine.example;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Test {

	public static void writeToFile(String s) {
		try {
			File file = new File("example.txt");
			BufferedWriter output = new BufferedWriter(new FileWriter(file));
			output.write(s);
			output.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
