package br.com.costalopes.inputoutputiopackage.readingandwritingbytes;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.stream.IntStream;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

public class WrittingFilesWithGZipFormat {

	public static void main(String[] args) throws IOException {
		
		//
		// writting and compressing a file
		//
		OutputStream os = Files.newOutputStream(Paths.get("files/file.bin.gz"), StandardOpenOption.CREATE);
		
		//
		// decorating the output with GZIP format
		//
		GZIPOutputStream gzos = new GZIPOutputStream(os);
		
		//
		// decorating with DataOutput format to more clear writing of primitive types
		//
		DataOutputStream dos = new DataOutputStream(gzos);
		
		IntStream.range(0, 100).forEach(value -> {
			try {
				dos.writeInt(value);
			} catch (IOException e) {
				e.printStackTrace();
			}
		});
		
		dos.close();
		
		//
		// creating a stream to connect with the file
		//
		InputStream is = Files.newInputStream(Paths.get("files/file.bin.gz"), StandardOpenOption.READ);
		
		//
		// decorating the stream to a compressed stream
		//
		GZIPInputStream gis = new GZIPInputStream(is);
		
		//
		// decorating it again to make more read friendly
		//
		DataInputStream dis = new DataInputStream(gis);
		
		int byteNumber = dis.readInt();
		while (byteNumber < 99) {
			byteNumber = dis.readInt();
			System.out.println(byteNumber);
		}
		
		dis.close();

		
	}
	
}
