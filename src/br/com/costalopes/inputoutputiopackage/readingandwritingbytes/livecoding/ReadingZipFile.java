package br.com.costalopes.inputoutputiopackage.readingandwritingbytes.livecoding;

import java.io.DataInputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public class ReadingZipFile {

	public static void main(String[] args) {
		
		String fileName = "files/livecoding/archive.zip";
		try (FileInputStream is = new FileInputStream(new File(fileName));
			 ZipInputStream zis = new ZipInputStream(is);
			 DataInputStream dis = new DataInputStream(zis))
		{

			ZipEntry entry = zis.getNextEntry();
			while (entry != null) {
				
				if (!entry.isDirectory()) {
					if (entry.getName().endsWith(".txt")) {
						System.out.println(dis.readUTF());
					} else if (entry.getName().endsWith(".bin")) {
						try {
							while (true) {
								System.out.println(dis.readInt());
							}
						} catch (EOFException e) { }
					}
				}
				
				entry = zis.getNextEntry();
			}
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
}
