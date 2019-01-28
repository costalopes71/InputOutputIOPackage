package br.com.costalopes.inputoutputiopackage.readingandwritingcharacters.writer;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class Java7PatternsForCreatingWriters {

	@SuppressWarnings("unused")
	public static void main(String[] args) throws IOException {
		
		//
		// java 7 > pattern
		//
		
		Path path = Paths.get("files/data.txt");
		
		BufferedWriter bufferedWriter = Files.newBufferedWriter(path); // cria um writer com o charset default (UTF-8)
		BufferedWriter bufferedWriter2 = Files.newBufferedWriter(path, StandardCharsets.ISO_8859_1); // cria um writer escolhendo o Charset a ser usado
		
		//
		// outros patterns para abrir os arquivos
		//
		
		BufferedWriter wr = Files.newBufferedWriter(path, StandardOpenOption.CREATE); // se o arquivo nao existe, cria
		BufferedWriter wr2 = Files.newBufferedWriter(path, StandardOpenOption.APPEND); // se o arquivo nao existir uma excecao eh lancada, 
		//se existir adiciona o conteudo ao final do conteudo ja existente
		
		/* OpenOptions
	
			- WRITE, APPEND: escrever ou adicionar a um arquivo existente
			- CREATE, CREATE_NEW: no primeiro cria o arquivo se nao existir, o segundo lanca excecao se o arquivo ja existir
			- DELETE_ON_CLOSE: deleta o arquivo qdo o writer eh fechado
		*/
		
	}
	
}
