package br.com.costalopes.inputoutputiopackage.writer;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;

public class CreatingWriters {

	/*
		Writer eh uma classe abstrata e eh extendida por 2 categorias de classes concretas:
			- 1ª categoria: classes para um certo tipo de saida (output)
			 	- DISK: FileWriter
			 	- In-memory: CharArrayWriter
			 				 StringWriter: nao escreve em uma String, na vdd escreve em um StringBuffer pois String sao imutaveis
			- 2ª categoria: classes que adicionam comportamento ao Writer
				- BufferedWriter: adiciona o comportamento de buffered ao Writer (amortecer)
				- PrintWriter: adiciona o comportamento de escrever com um formato
	 */
	
	
	@SuppressWarnings({ "resource", "unused" })
	public static void main(String[] args) throws IOException {
		
		//
		// JAVA 7 < patterns (nesse padrao o charset default eh utilizado, UTF-8)
		//
		
		File file = new File("files/data.txt");
		Writer writer = new FileWriter(file); // criando assim ele estara sobrescrevendo os dados que ja existem caso esse arquivo ja exista e tenha conteudo
		
		//
		// append mode
		//
		Writer writer2 = new FileWriter(file, true); // criando dessa maneira ele ira acrescentar os dados ao final do conteudo ja existente (append mode)
		
		//
		// com printwriter podemos usar a definicao de formatos para escrever o arquivo
		//
		PrintWriter printer = new PrintWriter(writer);
		
		/*
			Organizacao da hierarquia da classe Writer:
				baseada no Decorator pattern
				
				Writer (classe abstrata) eh extendida por FileWriter/StringWriter (concretas)
				a classe BufferedWriter extende Writer e tem um Writer como relacionamento de composicao (FileWriter/StringWriter etc)

		 */
		
		
	}
	
}
