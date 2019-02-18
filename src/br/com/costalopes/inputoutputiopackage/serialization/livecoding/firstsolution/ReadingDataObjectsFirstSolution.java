package br.com.costalopes.inputoutputiopackage.serialization.livecoding.firstsolution;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;

import br.com.costalopes.inputoutputiopackage.serialization.livecoding.firstsolution.model.Person;

public class ReadingDataObjectsFirstSolution {

	public static void main(String[] args) {
	
		String file = "files/livecoding/chapter6-serealization/person-first-solution.bin";
		
		try (InputStream is = new FileInputStream(file);
			 ObjectInputStream ois = new ObjectInputStream(is))
		{
			
			// perceber que o codigo abaixo eh tranparente para o usuario pois para todos os 3 metodos eh o mesmo!!
			Person p1 = (Person) ois.readObject();
			System.out.println(p1);
			Person p2 = (Person) ois.readObject();
			System.out.println(p2);
			
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		
	}
	
}
