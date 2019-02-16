package br.com.costalopes.inputoutputiopackage.serialization.overrideserializationdefaultmethods.firstsolution;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class ProvideReadAndWriteObjectMethods {

	/*
	 	Primeira maneira de sobreescrever o mecanismo default de serealizacao de objetos do Java:
	 		- devo prover um metodo readObject e outro writeObject na classe serealizavel:
	 */
	
	// Ex:
		
		// deve implementar serializable
		public class Person implements Serializable {
			
			private static final long serialVersionUID = 227215431606381214L;
		
			@SuppressWarnings("unused")
			private String name;
			@SuppressWarnings("unused")
			private int age;
			
			// prover os metodos readObject e writeObject com as assinaturas abaixo (deve ser EXATAMENTE essa assinatura)
			private void writeObject(ObjectOutputStream oos) throws Exception {
				
				// logica de escrita serealizavel do objeto 
				
			}
			
			private void readObject(ObjectInputStream ois) throws Exception {
				
				// logica
				
			}
			
			/*
			 	IMPORTANTE!
			 		A responsabilidade desses metodos eh escrever e ler os campos da classe q ele esta no stream object
			 		fornecido, ou seja, se um classe extender pessoa ela DEVE APENAS PREOCUPAR-SE em dar a logica de como
			 		escrever e ler os seus CAMPOS PROPRIOS e nao os da superclasse!!!!
			 */
			
			/*
			 	IMPORTANTE
			 		se fornecermos um metodo de serealizacao customizado para a superclasse devemos fornecer tbm para as 
			 		classes filhas!
			 */
			
		}
		
		// como Funcionario extende pessoa ele tbm eh serealizavel!
		public class Employee extends Person {
			
			private static final long serialVersionUID = 6357336973196393103L;
			
			@SuppressWarnings("unused")
			private int salary;
		
			// deve prover os metodos read e writeObject preocupando se APENAS COM SEUS CAMPOS PROPRIOS! (ou seja, salary)
			
			private void writeObject(ObjectOutputStream oos) throws Exception {
				
				// logica para escrever o campo salario
				// a logica deve ser espelho da logica da superclasse mas preocupando-se apenas com os campos da sua classe
				
			}
			
			private void readObject(ObjectInputStream ois) throws Exception {
				
				// logica para ler o campo salario
				// a logica deve ser espelho da logica da superclasse mas preocupando-se apenas com os campos da sua classe
				
			}
			
		}
		
}
