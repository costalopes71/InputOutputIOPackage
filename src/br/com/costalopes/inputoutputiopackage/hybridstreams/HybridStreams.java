
package br.com.costalopes.inputoutputiopackage.hybridstreams;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.LineNumberReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

public class HybridStreams {

	/*
	 Streams hibridos :
	 	- InputStreamReader (extende a classe abstrata Reader): pode ler chars e Strings mas eh criado em cima de um InputStream
	 	Ou seja, eh um decorator pattern em cima de InputStream adicionando assim o metodo read ao inputStream e tbm pode conter
	 	um segundo parametro que eh o CharSet
	 	- OutputStreamWrte (extende a classe abstrata Writer): pode escrever chars e strings mas eh criado em cima de um OutputStream
	 	Ou seja, eh uma decoracao em cima de um stream binario OutputStream que prove os metodos de escrever chars e strings! 
	 	Tbm pode ter o segundo parametro que eh o Charset!
	 
	 	Ambas classes habilitam a possibilidade de ler/escrever chars e strings em streams binarios! E tbm cuidam da conversao
	 	do CharSet!
	 
	 	Podemos criar entao streams hibridos escrevendo dados binarios usando por exemplo um DataOutputStream e dados texto usando
	 	um writer. Assim podemos misturar string/chars e bytes crus num mesmo stream.
	 
	 */
	
	@SuppressWarnings("unused")
	public static void main(String[] args) throws IOException {
		
		// ex: InputStreamReader
		InputStream is = Files.newInputStream(Paths.get(""));
		InputStreamReader isr = new InputStreamReader(is, StandardCharsets.UTF_8);
		
		// como eh um reader pode ser usado para criar outros readers usando o decorator pattern
		LineNumberReader lnr = new LineNumberReader(isr);
		String line = lnr.readLine();
		int lineNumber = lnr.getLineNumber();
		
		// a mesma ideia serve para writes!
		OutputStream os = new FileOutputStream("exemplo.txt");
		OutputStreamWriter osw = new OutputStreamWriter(os, StandardCharsets.UTF_8);
		
		PrintWriter pw = new PrintWriter(osw);
		pw.printf("Hello %s\n", "Joao");
		pw.close();
		
	}
	
}
