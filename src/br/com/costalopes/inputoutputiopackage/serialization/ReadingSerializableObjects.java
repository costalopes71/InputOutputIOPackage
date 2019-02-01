package br.com.costalopes.inputoutputiopackage.serialization;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.nio.file.Files;
import java.nio.file.Paths;

public class ReadingSerializableObjects {

	public static void main(String[] args) throws IOException, ClassNotFoundException {
		
		InputStream is = Files.newInputStream(Paths.get("files/serialization/people.bin"));
		ObjectInputStream ois = new ObjectInputStream(is);
		
		Person p1 = (Person) ois.readObject();
		Person p2 = (Person) ois.readObject();
		
		System.out.println(p1);
		System.out.println(p2);

		ois.close();
		is.close();
		
	}
	
}
