package br.com.costalopes.inputoutputiopackage.serialization.livecoding;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class WritingDataObjects {

	public static void main(String[] args) {
		
		Person p1 = new Person("Linda", 32);
		Person p2 = new Person("David", 27);
		
		// tbm posso serealizar usando umas lista de pessoas, uma vez que a maioria das implementacoes de 
		// Collection sao serealizaveis
		List<Person> lista = new ArrayList<>();
		lista.add(p1);
		lista.add(p2);
		
		String file = "files/livecoding/chapter6-serealization/person.bin";
		try (OutputStream os = new FileOutputStream(file);
			 ObjectOutputStream oos = new ObjectOutputStream(os)) {
			
//			oos.writeObject(p1);
//			oos.writeObject(p2);
			oos.writeObject(lista);
			
			System.out.println(Files.size(Paths.get(file)));
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}
	
}
