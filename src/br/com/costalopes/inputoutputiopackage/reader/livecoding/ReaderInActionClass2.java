package br.com.costalopes.inputoutputiopackage.reader.livecoding;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class ReaderInActionClass2 {

	public static void main(String[] args) {
		
		
		//
		// JAVA 7 < pattern
		//
		File file = new File("files/bat-weasels.txt");
		
		try (Reader reader = new FileReader(file);){ // declarando e inicializando o Reader usando try with resources pq ele implementa AutoCloseable e assim nao preciso
			// fechar o recurso manualmente
			
			BufferedReader br = new BufferedReader(reader); // usando decoration pattern para obter um BufferedReader, ambos os objetos estao conectados ao mesmo
			//arquivo. Quando um objeto for fechado o outro tbm sera.
			
			String line = br.readLine();
			while (line != null) {
				System.out.println(line);
				line = br.readLine();
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		//
		// JAVA 8 pattern
		//
		System.out.println("\nJAVA 8 pattern");
		Path path = Paths.get("files/bat-weasels.txt");
		try (Stream<String> lines = Files.newBufferedReader(path).lines();){
			
			lines.forEach(System.out::println);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
}
