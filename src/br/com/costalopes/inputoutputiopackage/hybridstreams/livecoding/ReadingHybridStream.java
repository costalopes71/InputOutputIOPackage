package br.com.costalopes.inputoutputiopackage.hybridstreams.livecoding;

import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.LineNumberReader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.zip.GZIPInputStream;

public class ReadingHybridStream {

	public static void main(String[] args) throws IOException {
		
		
		int skipMagicNumberAndSize = 1;
		int n = 290;
		
		String pathname = "files/aesops-compressed.bin";
		File file = new File(pathname);
		int size = (int) Files.size(Paths.get(pathname));
		
		try (InputStream is = new FileInputStream(file);
		 	 BufferedInputStream bis = new BufferedInputStream(is);
			 InputStreamReader isr = new InputStreamReader(bis);)
		{
			
			// o parametro indica a quantidade de bytes que podem ser lidos sem que a marca se torne invalida
			bis.mark(size + 1);
			
			LineNumberReader lnr = new LineNumberReader(isr);
			
			while (lnr.getLineNumber() < skipMagicNumberAndSize + n) {
				lnr.readLine();
			}
			
			String fableData = lnr.readLine();
			System.out.println(fableData);
			
			int offset = Integer.parseInt(fableData.substring(0, 7).trim());
			int length = Integer.parseInt(fableData.substring(9, 16).trim());
			String title = fableData.substring(16);
			
			System.out.printf("%d %d %s", offset, length, title);
			
			// reseta o ponteiro para a posicao marcada
			bis.reset();
			
			//
			// ATENCAO: o metodo skip mtas vezes pode pular menos bytes do que o esperado, como ele retorna qts bytes foram realmente pulados, o jeito certo de usa-lo eh o abaixo
			//
			int skip = (int) bis.skip(offset);
			int totalSkip = skip;
			while (totalSkip != offset) {
				skip = (int) bis.skip(offset - totalSkip);
				totalSkip += skip;
			}
			System.out.println("\nSkip = " + totalSkip);
			
			byte[] bytes = new byte[4096];
			bis.read(bytes);
			
			ByteArrayInputStream bais = new ByteArrayInputStream(bytes, 0, length);
			GZIPInputStream gzis = new GZIPInputStream(bais);
			
			byte[] bytes2 = new byte[4096];
			int bytesDecompressed = gzis.read(bytes2);
			
			String fableText = new String(bytes2, 0, bytesDecompressed);
			System.out.println(fableText);
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
}
