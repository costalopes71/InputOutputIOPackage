package br.com.costalopes.inputoutputiopackage.readingandwritingbytes;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public class ReadingZipFilesFormat {

	public static void main(String[] args) throws IOException {
		
		//
		// abrindo o fluxo de dados com o arquivo zip
		//
		InputStream is = Files.newInputStream(Paths.get("files/archive.zip"), StandardOpenOption.READ);
		
		//
		// usando o decorator pattern para trabalha com o formato zip de leitura
		//
		ZipInputStream zis = new ZipInputStream(is);
		
		//
		// usando decorator pattern novamento para ler bytes de forma mais facil
		//
		DataInputStream dis = new DataInputStream(zis);
		
		ZipEntry entry = null;
		while ((entry = zis.getNextEntry()) != null) {
			
			if (!entry.isDirectory()) {
				System.out.println(dis.readInt());
				System.out.println(dis.readInt());
			}
			
		}
		
		dis.close();
		
		//
		// OBSERVACAO
		//
		
		/*
		 	existem tbm duas classes para o formato JAR:
		 		- JarInputStream
		 		- JarOutputStream
		 		Ambas extendem as classes ZipInputStream e ZipOutputStream respectivamente
		 		Possuem metodos a mais para manejar o arquivo de manifesto (manifest file)
		 		Existe tbm uma classe Manifest para auxiliar com o arquivo manifest
		 */
		
	}
	
}
