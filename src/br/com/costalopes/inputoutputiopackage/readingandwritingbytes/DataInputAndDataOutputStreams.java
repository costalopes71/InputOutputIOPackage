package br.com.costalopes.inputoutputiopackage.readingandwritingbytes;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class DataInputAndDataOutputStreams {

	public static void main(String[] args) throws IOException {
		
		//
		// classes que facilitam escrever ou ler tipos primitivos e String em um fluxo de bytes
		//
		OutputStream os = new FileOutputStream(new File("files/writing-byte-file.txt"));
		
		DataOutputStream dos = new DataOutputStream(os);
		
		dos.writeUTF("Joao Carlos Costa Lopes tem ");
		dos.write(31);
		dos.writeUTF(" anos, e sexo ");
		dos.writeChar('M');
		
		dos.flush();
		dos.close();
		os.close();
		
		//
		// lendo 
		//
		InputStream is = new FileInputStream(new File("files/writing-byte-file.txt"));
		DataInputStream dis = new DataInputStream(is);
		
		String name = dis.readUTF();
		int i = dis.readInt();
		String desc = dis.readUTF();
		char sexo = dis.readChar();
		
		System.out.println("Name: " + name);
		System.out.println("Idade: " + i);
		System.out.println("Descricao: " + desc);
		System.out.println("Sexo: " + sexo);
		
		dis.close();
		is.close();
		
	}
	
}
