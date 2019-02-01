package br.com.costalopes.inputoutputiopackage.serialization;

import java.io.Serializable;
import java.sql.Connection;

public class Person implements Serializable {

	private static final long serialVersionUID = 507669684648847250L;

	public Person(String name, int age) {
		this.name = name;
		this.age = age;
	}

	private String name;
	private int age;
	private transient Connection example;

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Connection getExample() {
		return example;
	}

	public void setExample(Connection example) {
		this.example = example;
	}

	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + "]";
	}

}
