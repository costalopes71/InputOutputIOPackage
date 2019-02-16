package br.com.costalopes.inputoutputiopackage.serialization.overrideserializationdefaultmethods.thirdsolution;

import java.io.ObjectStreamException;
import java.io.Serializable;

public class UsingProxyObjects {

	/*
	 	Esta terceira opcao usa um objeto como "procurador/representante" do objeto que se deseja serealizar!
	 	Para tanto eh necessario prover um metodo writeReplace na classe que se deseja serealizar, como segue:
	 		- private Object writeReplace()	throws ObjectStreamException {
	 			return new InstanciaDoRepresentante(campo + "::" + campo);
	 		}
	  
	 */
	
	// Ex:
	public class Person implements Serializable {
		
		private String name;
		private int age;
		
		public Person() { }
		
		public Person(String name, int age) {
			this.name = name;
			this.age = age;
		}

		// este metodo pode ser privado, protegido ou publico
		private Object writeReplace() throws ObjectStreamException {
			// essa instancia do objeto representante que sera escrita no fluxo serealizado!
			return new PersonProxy(name + "::" + age);
		}
		
	}
	
	// objeto representante!
	public class PersonProxy implements Serializable {
		
		// o objeto representanto deve ser serealizavel, para tanto pode usar o metodo padrao de serealizacao (implementando Seria-
		// lizable) ou prover outro metodo proprio de serealizacao
		
		// eh necessario tbm um metodo especial chamado readResolve que consegue criar o objeto representado!
		
		private static final long serialVersionUID = 8292382503025165827L;
		
		private String replacer;
		
		public PersonProxy(String replacer) {
			this.replacer = replacer;
		}
		
		private Object readResolve() throws ObjectStreamException {
			
			String[] elements = replacer.split("::");
			String name = elements[0];
			int age = Integer.parseInt(elements[1]);
			return new Person(name, age);
		}
		
	}
	
}
