package br.com.costalopes.inputoutputiopackage.readingandwritingbytes.livecoding;

import java.io.DataInputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class ReadingBytes {

	public static void main(String[] args) {
		
		
		String fileName = "files/livecoding/ints.bin";
		
		try {
			Path path = Paths.get(fileName);
			long size = Files.size(path);
			System.out.println(path + " size: " + size);
		} catch (IOException e) {

		}
		
		try (FileInputStream is = new FileInputStream(fileName);
			DataInputStream dis = new DataInputStream(is);){
			
			List<Integer> ints = new ArrayList<>();
			try {
				while (true) {
					ints.add(dis.readInt());
				}
			} catch (EOFException e) {
				
			}
			
			System.out.println("ints: " + ints.size());
			
		} catch (IOException e) {

		}
		
	}
	
}
