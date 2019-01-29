package br.com.costalopes.inputoutputiopackage.readingandwritingbytes.livecoding;

import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.stream.IntStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class WrittingZipFile {

	public static void main(String[] args) {
		
		try (FileOutputStream os = new FileOutputStream("files/livecoding/archive.zip");
			 ZipOutputStream zos = new ZipOutputStream(os);
			 DataOutputStream dos = new DataOutputStream(zos)){
			
			ZipEntry binDirEntry = new ZipEntry("bin/");
			zos.putNextEntry(binDirEntry);
			
			ZipEntry binFileEntry = new ZipEntry("bin/ints.bin");
			zos.putNextEntry(binFileEntry);
			
			IntStream.range(0, 1000).forEach(
					i -> {
						try {
							dos.writeInt(i);
						} catch (IOException e) { }
					}
				);
			
			ZipEntry txtDirEntry = new ZipEntry("text/");
			zos.putNextEntry(txtDirEntry);
			
			ZipEntry txtFileEntry = new ZipEntry("txt/file.txt");
			zos.putNextEntry(txtFileEntry);
			
			dos.writeUTF("This is some content!");
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
}
