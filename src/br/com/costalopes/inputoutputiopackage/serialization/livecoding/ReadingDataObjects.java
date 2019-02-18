package br.com.costalopes.inputoutputiopackage.serialization.livecoding;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.util.List;

public class ReadingDataObjects {

	public static void main(String[] args) {
		
		String file = "files/livecoding/chapter6-serealization/person.bin";
		
		try (InputStream is = new FileInputStream(file);
			 ObjectInputStream ois = new ObjectInputStream(is))
		{
		
			@SuppressWarnings("unchecked")
			List<Person> people = (List<Person>) ois.readObject();
			
			people.forEach(System.out::println);
			
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		
	}
	
}
