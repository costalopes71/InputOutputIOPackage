package br.com.costalopes.inputoutputiopackage.readingandwritingbytes.livecoding;

import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.IntStream;
import java.util.zip.GZIPOutputStream;

public class WrittingBytes {

	public static void main(String[] args) {
		
		String pathName = "files/livecoding/ints.bin.gz";
		try (OutputStream os = new FileOutputStream(new File(pathName));
			//
			// comprimindo o arquivo
			//
			GZIPOutputStream gzos = new GZIPOutputStream(os);
			//
			// usando decorator pattern para facilitar a escrita de bytes 
			//
			DataOutputStream dos = new DataOutputStream(gzos);)
		{
			
			IntStream.range(0, 1000).forEach(
				i -> {
				
					try {
						dos.writeInt(i);
					} catch (IOException e) { }
					
			});
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		Path path = Paths.get(pathName);
		try {
			long size = Files.size(path);
			System.out.println("File size: " + size + " bytes");
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
}
