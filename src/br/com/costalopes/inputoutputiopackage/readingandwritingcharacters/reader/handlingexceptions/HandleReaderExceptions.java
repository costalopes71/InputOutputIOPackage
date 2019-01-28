package br.com.costalopes.inputoutputiopackage.readingandwritingcharacters.reader.handlingexceptions;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.StandardCharsets;

import br.com.costalopes.inputoutputiopackage.readingandwritingcharacters.reader.ReadingCharsWithReader;

public class HandleReaderExceptions {

	public static void main(String[] args) {
		
		//
		// primeiro padrao para lidar com as IOExceptions, mas eh bugado pois nao fechamos os recursos apropriadamente
		//
		
		InputStream is = null;
		Reader reader = null;
		try {
			is = ReadingCharsWithReader.class.getResourceAsStream("testereader.txt");
			reader = new InputStreamReader(is, StandardCharsets.UTF_8);
			
			int nextChar = reader.read();
			
			while (nextChar != -1) {
				System.out.print((char) nextChar);
				nextChar = reader.read();
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		System.out.println("\n");
		//
		// segundo padrao fechando os recursos
		//
		InputStream is2 = null;
		Reader reader2 = null;
		try {
			is2 = ReadingCharsWithReader.class.getResourceAsStream("testereader.txt");
			reader2 = new InputStreamReader(is2, StandardCharsets.UTF_8); // se alguma excecao acontecer na construcao do Reader ele sera nulo e por isso que
			// tenho que testar no bloco finally se reader eh diferente de nulo
			
			int nextChar = reader2.read();
			
			while (nextChar != -1) {
				System.out.print((char) nextChar);
				nextChar = reader2.read();
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			
			if (reader2 != null ) {
				try {
					reader2.close();
					is2.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			
		}
		
		System.out.println("\n");
		//
		// terceiro padrao usando try with resources (java 7 >)
		//
		try (
				InputStream is3 = ReadingCharsWithReader.class.getResourceAsStream("testereader.txt");
				Reader reader3 = new InputStreamReader(is3, StandardCharsets.UTF_8);
			) {
			
			int nextChar = reader3.read();
			
			while (nextChar != -1) {
				System.out.print((char) nextChar);
				nextChar = reader3.read();
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	
	}
	
}
