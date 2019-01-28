package br.com.costalopes.inputoutputiopackage.readingandwritingcharacters.writer.livecoding;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class WrittingCharacters {

	public static void main(String[] args) {
		
		Path path = Paths.get("files/some-text.txt");
		
		try (BufferedWriter writer = Files.newBufferedWriter(path, StandardOpenOption.CREATE, StandardOpenOption.APPEND);){
			
			PrintWriter pw = new PrintWriter(writer);
			pw.println("Hello world!");
			
			
		} catch (IOException e) {
			e.printStackTrace(); // numa aplicacao real deveria logar a excecao em algum lugar e lancar um erro de novo envolvendo-o em uma excecao de aplicacao
		}
		
	}
	
}
