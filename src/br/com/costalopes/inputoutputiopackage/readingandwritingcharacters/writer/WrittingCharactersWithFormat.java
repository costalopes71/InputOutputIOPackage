package br.com.costalopes.inputoutputiopackage.readingandwritingcharacters.writer;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Locale;

public class WrittingCharactersWithFormat {

	public static void main(String[] args) {
		
		//
		// para escrever com formato precisamos da classe PrintWriter que adiciona o comportamento de escrever com formato ao Writer
		//
		Path path = Paths.get("files/some-text-with-format.txt");
		try (BufferedWriter writer = Files.newBufferedWriter(path , StandardOpenOption.CREATE, StandardOpenOption.APPEND);) {

			PrintWriter pw = new PrintWriter(writer);
			pw.printf("%d\r", 12);
			
			pw.printf("%d %o 0x%04x\n", 12, 8, 248); 
			
			// %d -> imprime o double
			// %o -> imprime na base numerica octal
			// %x -> imprime na base numera hexadecimal
			
			Calendar cal = GregorianCalendar.getInstance();
			cal.set(1969, 6, 20);
			
			pw.printf("Man walked on the moon on: %1$tm %1$te %1$tY \r", cal);
			pw.printf(Locale.US, "Man walked on the moon on: %1$tB %1$tA %1$tY", cal);
			
			// 1$ -> referencia a primeira variavel
			// t -> referencia uma variavel calendar
			// m -> mes numerico
			// e -> dia do mes numerico
			// Y -> ano
			// B -> mes por extenso
			// A -> dia da semana por extenso
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	
	}
	
}
