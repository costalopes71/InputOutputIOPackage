package br.com.costalopes.inputoutputiopackage.serialization.livecoding.thirdsolution;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;

import br.com.costalopes.inputoutputiopackage.serialization.livecoding.thirdsolution.model.Person;

public class WritingDataObjectsThirdSolution {

	public static void main(String[] args) {
		
		Person p1 = new Person("Manuel", 32);
		Person p2 = new Person("Oswaldo", 27);
		
		String file = "files/livecoding/chapter6-serealization/person-third-solution.bin";
		try (OutputStream os = new FileOutputStream(file);
			 ObjectOutputStream oos = new ObjectOutputStream(os)) {
			
			oos.writeObject(p1);
			oos.writeObject(p2);
			
			System.out.println(Files.size(Paths.get(file)));
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
}
