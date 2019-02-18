package br.com.costalopes.inputoutputiopackage.serialization.livecoding.firstsolution.model;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Person implements Serializable {

	private static final long serialVersionUID = -2233578487608653425L;
	
	private transient String name;
	private transient int age;
	
	public Person() { }

	public Person(String name, int age) {
		this.name = name;
		this.age = age;
	}

	// usando minha propria maneira de serealizar o objeto
	private void writeObject(ObjectOutputStream oos) throws Exception {
		
		DataOutputStream dos = new DataOutputStream(oos);
		dos.writeUTF(name + "::" + age);
		
	}
	
	private void readObject(ObjectInputStream ois) throws Exception {
		
		DataInputStream dis = new DataInputStream(ois);
		String readUTF = dis.readUTF();
		String[] content = readUTF.split("::");
		this.name = content[0];
		this.age = Integer.parseInt(content[1]);
		
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
