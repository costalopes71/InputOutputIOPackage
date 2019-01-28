package br.com.costalopes.inputoutputiopackage.writer;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public class TheWriterClass {

	/*
		Writer eh uma classe abstrata que define operacoes basicas como:
			- escrever um unico caracter
			- escrever um vetor de caracteres
			- escrever uma string
			- acrescentar um caracter ou uma string a um stream de caracteres existente
			- e auto fechar (auto close)
	 */
	
	public static void main(String[] args) throws IOException {
		
		//
		// exemplo Pattern
		//
	
		Writer writer = new FileWriter(new File("files/writting-files.txt"));
		
		writer.write('H'); // escrevendo um unico caracter
		writer.write("Hello World"); // escrevendo uma String
		writer.write("Hello World", 0, 5); // escreve uma String indo da posicao 0 ate a 5 -> escreve Hello
		writer.write("Hello World".toCharArray(), 0, 5); // o mesmo para vetor de caracteres
		
		// o metodo write nao retorna nada
		
		writer.close();
	}
	
}
