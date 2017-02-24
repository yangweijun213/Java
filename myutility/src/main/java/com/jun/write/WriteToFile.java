package com.jun.write;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class WriteToFile {
	
	/**
	 *
	 * @param list The list will be write csv file.
	 * @param fileName The csv file name.
	 * @throws SUException Exception if encounter errors
	 */
	public static void writeCSVFile(List<String> list, String fileName) throws Exception {
		File csv = new File(fileName);
		try (BufferedWriter bw = new BufferedWriter(new FileWriter(csv, true))){
			for (String str : list) {
				bw.write(str);
				bw.newLine();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
