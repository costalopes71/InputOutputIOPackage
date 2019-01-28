package br.com.costalopes.inputoutputiopackage.readingandwritingcharacters.reader.livecoding;

import java.io.File;
import java.io.IOException;

public class ReaderInAction {

	
	public static void main(String[] args) throws IOException {
		
		File batWeasels = new File("files/bat-weasels.txt");
		System.out.println(batWeasels.getName()); // NAO acessa o sistema (ou seja, apenas pega o nome que foi dado pra ele com a string)
		System.out.println(batWeasels.exists()); // requisita o sistema se o arquivo existe
		
		File dontExist = new File("files/nope.txt");
		System.out.println(dontExist.getName()); // NAO acessa o sistema
		System.out.println(dontExist.exists());
		
		// para criar o arquivo q nao existe!
		dontExist.createNewFile();
		
	}
	
}
