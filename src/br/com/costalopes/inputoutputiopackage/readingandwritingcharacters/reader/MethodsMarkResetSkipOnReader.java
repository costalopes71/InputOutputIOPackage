package br.com.costalopes.inputoutputiopackage.readingandwritingcharacters.reader;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;

//
//READERS servem para ler CARACTERES!!!
//
public class MethodsMarkResetSkipOnReader {

	public static void main(String[] args) throws IOException {
		
		InputStream is = MethodsMarkResetSkipOnReader.class.getResourceAsStream("testereader.txt");
		Reader reader = new InputStreamReader(is);
		
		//
		// SKIP : pula para o proximo elemento (no parametro ponho quantos elementos devo pular)
		//
		reader.skip(10);
		int number = reader.read();
		System.out.println((char) number);
		
		//
		// MARK : poe uma flag no elemento (pode ou nao ser suportado)
		//
		
		System.out.println("mark supported: " + reader.markSupported());
		reader.mark(1000000000);
		
		reader.read();
		reader.read();
		int number2 = reader.read();
		
		System.out.println((char) number2);
		
		//
		// RESET : volta para o caracter anterior marcado ou para o inicio se nao houver caracter marcado (pode ou nao ser suportado)
		//
		reader.reset();
		System.out.println((char) reader.read());
		
		reader.close();
		
	}
	
}
