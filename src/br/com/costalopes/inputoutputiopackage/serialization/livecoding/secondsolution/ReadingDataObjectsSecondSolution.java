package br.com.costalopes.inputoutputiopackage.serialization.livecoding.secondsolution;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;

import br.com.costalopes.inputoutputiopackage.serialization.livecoding.secondsolution.model.Person;

public class ReadingDataObjectsSecondSolution {

	public static void main(String[] args) {
		
		String file = "files/livecoding/chapter6-serealization/person-second-solution.bin";
		
		try (InputStream is = new FileInputStream(file);
			 ObjectInputStream ois = new ObjectInputStream(is))
		{
			
			Person p1 = (Person) ois.readObject();
			System.out.println(p1);
			Person p2 = (Person) ois.readObject();
			System.out.println(p2);
			
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		
	}
	
}
