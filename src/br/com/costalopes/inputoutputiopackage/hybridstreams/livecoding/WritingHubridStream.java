package br.com.costalopes.inputoutputiopackage.hybridstreams.livecoding;

import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.GZIPOutputStream;

import br.com.costalopes.inputoutputiopackage.hybridstreams.livecoding.model.Fable;
import br.com.costalopes.inputoutputiopackage.hybridstreams.livecoding.util.AesopReader;
import br.com.costalopes.inputoutputiopackage.hybridstreams.livecoding.util.FableData;

public class WritingHubridStream {

	public static void main(String[] args) throws IOException {
		
		AesopReader aesop = new AesopReader();
		List<Fable> fables = aesop.readFable("files/aesop.txt");
		
		// HEADER do arquivo
		
		//	Aesop's Fables
		//	291
		//		1235	123	The Wolf and the Lamb
		//		3271	245	The Bat and the Weasels
		//	<binary texts>
		
		ByteArrayOutputStream aesopBos = new ByteArrayOutputStream();
		OutputStreamWriter out = new OutputStreamWriter(aesopBos, StandardCharsets.UTF_8);
		
		PrintWriter printer = new PrintWriter(out);
		
		printer.println("Aesop's Fables");
		printer.printf("%d\n", fables.size());
		
		for (Fable fable : fables) {
			printer.printf("%7d %7d %s\n", 0, 0, fable.getTitle());
		}
		
		printer.flush();
		out.close();
		int textOffset = aesopBos.size();
		
//		System.out.println(aesopBos.toString());
		
		ByteArrayOutputStream textBos = new ByteArrayOutputStream();
		
		List<FableData> fableDatas = new ArrayList<>();
		int offset = textOffset; 
		for (Fable fable : fables) {
			
			ByteArrayOutputStream fableBos = new ByteArrayOutputStream();
			
			try (GZIPOutputStream gzipOs = new GZIPOutputStream(fableBos);) {
				gzipOs.write(fable.getText().getBytes());
			} catch (IOException e) {
				e.printStackTrace();
			}

			int length = fableBos.size();
			textBos.write(fableBos.toByteArray());
			offset += length;
			
			fableDatas.add(new FableData(fable, offset, length));
		}
		
		textBos.close();
		
		aesopBos = new ByteArrayOutputStream();
		out = new OutputStreamWriter(aesopBos, StandardCharsets.UTF_8);
		
		printer = new PrintWriter(out);
		
		printer.println("Aesop's Fables");
		printer.printf("%d\n", fables.size());

		for (FableData fableData : fableDatas) {
			printer.printf("%7d %7d %s\n", fableData.getOffset(), fableData.getLength(), fableData.getFable().getTitle());
		}
		
		printer.flush();
		
		System.out.println(aesopBos.toString());
		
		aesopBos.write(textBos.toByteArray());
		
		aesopBos.close();
		
		try (OutputStream os = new FileOutputStream("files/aesops-compressed.bin");){
			os.write(aesopBos.toByteArray());
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
}
