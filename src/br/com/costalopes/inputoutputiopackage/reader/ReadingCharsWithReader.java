
package br.com.costalopes.inputoutputiopackage.reader;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.StandardCharsets;

//
// READERS servem para ler CARACTERES!!!
//
public class ReadingCharsWithReader {

	public static void main(String[] args) throws IOException {
		
		InputStream is = ReadingCharsWithReader.class.getResourceAsStream("testereader.txt");
		Reader reader = new InputStreamReader(is, StandardCharsets.UTF_8);
		
		int nextChar = reader.read();
		
		while (nextChar != -1) {
			System.out.print((char) nextChar);
			nextChar = reader.read();
		}
		
		reader.close();
		is.close();
		
		System.out.println("\n");
		InputStream is2 = ReadingCharsWithReader.class.getResourceAsStream("testereader.txt");
		Reader reader2 = new InputStreamReader(is2, StandardCharsets.UTF_8);
		
		char[] buffer = new char[1024];
		int number = reader2.read(buffer);
	
		while (number != -1) {
			
			System.out.println(buffer.length);
			number = reader2.read(buffer);
			
		}
		
		reader2.close();
		is2.close();
		
	}
	
	
}
