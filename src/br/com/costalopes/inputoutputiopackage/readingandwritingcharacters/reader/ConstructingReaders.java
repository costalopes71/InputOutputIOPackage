package br.com.costalopes.inputoutputiopackage.readingandwritingcharacters.reader;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;

public class ConstructingReaders {

	/*
		Existem 2 jeitos de extender um Reader (Reader eh uma classe abstrata).
		Existem 2 categorias de classes concretas que extendem Reader
		
			1� categoria: classes para um determinado tipo de entrada (input)
				- Disk : FileReader
				- In-Memory : CharArrayReader, StringReader
				
			2� categoria: classes que adicionam comportamento a um Reader
				- BufferedReader : reader concreto que usa bufferazation
				- LineNumberReader : permite a leitura de um arquivo linha a linha
				- PushbackReader
	 */

	//
	// Exemplos
	//
	@SuppressWarnings({ "resource", "unused" })
	public static void main(String[] args) throws FileNotFoundException {
	
		File file = new File("testereader.txt");
		
		try (Reader fileReader = new FileReader(file);) {
			//do something (usando try with resources pois reader implementa Closeable)
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		String hello = "Hello world!";
		
		Reader memoryReader = new StringReader(hello);
		
		/*
		As extensoes de comportamento seguem a Decotor pattern do livro Gang Of Four
		ou seja, BufferedReader ou LineNumberReader por exemplo, extende Reader e espera no seu construtor uma instancia de um Reader concreto (FileReader
		ou CharArrayReader por exemplo), ou seja tem um relacao de composicao com o Reader concreto.
		 */

		BufferedReader buffered = new BufferedReader(memoryReader);
		// outro exemplo
		BufferedReader buff = new BufferedReader(new FileReader(file));
		
		// BufferedReader adiciona o metodo readLine() ao leitor
		// suporta operacoes com os metodos mark and skip
		// o mesmo vale para LineNumberReader : e ele ainda adiciona um outro metodo chamado getLineNumber e tem tbm o readLine
		// pois ele extende BufferedReader
		
		
		/*
		Quando usando o Decorator pattern, ou seja, passando no construtor de um BufferedReader ou LineNumberReader, outro Reader
		concreto, se lermos com um eh a mesma coisa que lermos com o outro, assim se eu ler um caracter com o buffered e depois um
		caracter com o filereader, estarei lendo o segundo caracter.
		Para fechar basta fechar um deles que o outro ja eh fechado.
		 */
		
	}
	
}
