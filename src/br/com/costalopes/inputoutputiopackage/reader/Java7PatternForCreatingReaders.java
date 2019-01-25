package br.com.costalopes.inputoutputiopackage.reader;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Java7PatternForCreatingReaders {

	/*
	Criar Readers usando o pattern do construtor sao patterns do java 1. Existem mais padroes introduzidos no java 7 pelo
	uso de metodos de classes Factories
	 */

	@SuppressWarnings({ "unused", "resource" })
	public static void main(String[] args) throws IOException {
		
		// java 1 pattern
		File file = new File("testereader.txt");
		FileReader fileReader = new FileReader(file);
		BufferedReader bufferedReader = new BufferedReader(fileReader);
		
		// no padrao acima a leitura sera feita usando o encode UTF-8, se o arquivo estiver em outro padrao de encode nao ha
		// oq ser feito e a leitura sera feita de forma errada
		
		//
		// java 7 pattern
		//
		Path path = Paths.get("testereader.txt");
		BufferedReader reader2 = Files.newBufferedReader(path, StandardCharsets.ISO_8859_1);
		// esse reader eh criado em cima do InputStreamReader classe que suporta a definicao do charset
		
	}
	
}
