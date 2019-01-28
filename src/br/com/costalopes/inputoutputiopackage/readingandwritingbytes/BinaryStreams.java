package br.com.costalopes.inputoutputiopackage.readingandwritingbytes;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class BinaryStreams {

	/*
		Classes bases abstratas:
			1 ) InputStream : define operacoes basicas para ler bytes como:
				- ler um byter
				- ler um vetor de bytes
				- marcar e resetar um dada posicao
				- pular posicoes
				- pedir por bytes disponiveis
				- fechar o stream
			2) OutputStream: define as operacoes basicas para escrever bytes
				- escrever um unico byte
				- escrever um vetor de bytes
				- descarregar e fechar o stream
	 */
	
	@SuppressWarnings("resource")
	public static void main(String[] args) throws IOException {
		
		//
		// INPUTSTREAM patterns
		//
		InputStream is = new FileInputStream(new File("files/some-text.txt"));
		
		int nextByte = is.read(); // le byte a byte (o byte eh convertido em um int)
		// se retornar -1 sinaliza que nao ha mais bytes para ler
		
		//
		// le byte a byte ate o fim
		//
		while (nextByte != -1) {
			nextByte = is.read();
		}
		
		
		byte[] buffer = new byte[1024];
		int number = is.read(buffer); // retorna o numero de bytes lido e inseridos no buffer, se retornar -1 quer dizer que nao ha mais bytes
		
		while (number != -1) {
			number = is.read(buffer);
		}
		
		//
		// OUTPUTSTREAM patterns
		//
		OutputStream os = new FileOutputStream(new File("files/some-bytes.txt"));
		
		os.write(0xCA); // espera um int convertido em byte
		
		os.close();
	}
	
	
}
