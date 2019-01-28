package br.com.costalopes.inputoutputiopackage.readingandwritingbytes;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.stream.IntStream;

public class InMemoryStreams {

	public static void main(String[] args) throws IOException {
		
		
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		DataOutputStream dos = new DataOutputStream(bos);
		
		dos.writeInt(120);
		dos.writeDouble(13.14d);
		dos.writeChar('A');
		dos.writeChar('a');
		
		System.out.println(dos.size());
		
		byte[] bytes = bos.toByteArray();
		for (byte b : bytes) {
			System.out.println(b);
		}
		
		ByteArrayInputStream bis = new ByteArrayInputStream(bytes);
		DataInputStream dis = new DataInputStream(bis);
		
		int readInt = dis.readInt();
		double readDouble = dis.readDouble();
		char readChar = dis.readChar();
		char readChar2 = dis.readChar();
		
		System.out.println("Int -> " + readInt);
		System.out.println("Double -> " + readDouble);
		System.out.println("Char -> " + readChar);
		System.out.println("Char -> " + readChar2);
		
		OutputStream os = Files.newOutputStream(Paths.get("files/file.bin"), StandardOpenOption.CREATE);
		DataOutputStream dos2 = new DataOutputStream(os);
		
		IntStream.range(0, 100).forEach(value -> {
			try {
				dos2.writeInt(value);
			} catch (IOException e) {
				e.printStackTrace();
			}
		});
		
		os.close();
		dos2.close();
		
	}
	
	
}
