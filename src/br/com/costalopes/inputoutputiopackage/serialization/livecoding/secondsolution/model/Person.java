package br.com.costalopes.inputoutputiopackage.serialization.livecoding.secondsolution.model;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

public class Person implements Externalizable {

	private String name;
	private int age;
	
	public Person() { }

	public Person(String name, int age) {
		this.name = name;
		this.age = age;
	}

	/*
	 Essa segunda maneira serve para mandar apenas a chave primaria, sem se preocupar com o estado do objeto
	 que devera entao ser recriado por quem chamou atraves da primary key enviada. 
	 Notar que no arquivo serealizado atraves de Externalizable nao ha nenhuma referencia aos campos da classe
	 mesmo eles nao sendo transient!
	 */
	
	@Override
	public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
		
		byte[] buffer = new byte[1024];
		int read = in.read(buffer);
		String content = new String(buffer, 0, read);
		String[] elements = content.split("::");
		this.name = elements[0];
		this.age = Integer.parseInt(elements[1]);
		
	}

	@Override
	public void writeExternal(ObjectOutput out) throws IOException {
		
		String pk = name + "::" + age;
		out.write(pk.getBytes());
		
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + "]";
	}

}
