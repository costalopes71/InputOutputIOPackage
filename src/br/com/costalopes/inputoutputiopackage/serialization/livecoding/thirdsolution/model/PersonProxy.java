package br.com.costalopes.inputoutputiopackage.serialization.livecoding.thirdsolution.model;

import java.io.ObjectStreamException;
import java.io.Serializable;

public class PersonProxy implements Serializable {

	private static final long serialVersionUID = 6900598983180276850L;
	
	private String name;
	
	public PersonProxy() { }

	public PersonProxy(String name) {
		this.name = name;
	}

	private Object readResolve() throws ObjectStreamException {
		
		String[] elements = this.name.split("::");
		String name = elements[0];
		int age = Integer.parseInt(elements[1]);

		return new Person(name, age);
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "PersonProxy [name=" + name + "]";
	}

}
