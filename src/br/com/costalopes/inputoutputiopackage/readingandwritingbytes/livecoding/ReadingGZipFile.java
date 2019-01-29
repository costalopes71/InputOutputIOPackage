package br.com.costalopes.inputoutputiopackage.readingandwritingbytes.livecoding;

import java.io.DataInputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.GZIPInputStream;

public class ReadingGZipFile {

	public static void main(String[] args) {
		
		String fileName = "files/livecoding/ints.bin.gz";
		try (InputStream is = new FileInputStream(fileName);
			 GZIPInputStream gzis = new GZIPInputStream(is);
			 DataInputStream dis = new DataInputStream(gzis)){
			
			List<Integer> ints = new ArrayList<>();
			try {
				while (true) {
					ints.add(dis.readInt());
				}
			} catch (EOFException e) {

			}
			
			System.out.println("ints -> " + ints.size());
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}
	
}
