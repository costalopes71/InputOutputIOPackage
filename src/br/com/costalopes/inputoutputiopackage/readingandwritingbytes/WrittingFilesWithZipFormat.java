package br.com.costalopes.inputoutputiopackage.readingandwritingbytes;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class WrittingFilesWithZipFormat {

	/*
	 	O formato ZIP eh um pouco mais completo.
	 	 - permite que crie diretorios e arquivos
	 	 - permite adicionar conteudo em memorioa
	 */
	
	public static void main(String[] args) throws IOException {
		
		//
		// abrindo um pipeline
		//
		OutputStream os = Files.newOutputStream(Paths.get("files/archive.zip"), StandardOpenOption.CREATE);
		
		//
		// usando decorator pattern para trabalhar com o formato zip
		//
		ZipOutputStream zos = new ZipOutputStream(os);
		
		//
		// usando decorator pattern para poder escrever bytes de uma maneira mais facil
		//
		DataOutputStream dos = new DataOutputStream(zos);
		
		//
		// criando diretorios no Zip
		//
		ZipEntry dirEntry = new ZipEntry("files/");
		zos.putNextEntry(dirEntry);
		
		//
		// criando e adionando os arquivos no zip
		//
		ZipEntry fileEntry = new ZipEntry("files/dataZip.bin");
		zos.putNextEntry(fileEntry);
		
		//
		// tudo oq eu escreve no stream sera considerado o conteudo da ultima Entry que abri
		//
		dos.writeInt(1);
		dos.writeInt(2);
		
		//
		// apos chamar o closeEntry posso por exemplo criar outros diretorios e prosseguir criando meu zip
		//
		zos.closeEntry();
		
		zos.close();
		
		
	}
	
	
}
