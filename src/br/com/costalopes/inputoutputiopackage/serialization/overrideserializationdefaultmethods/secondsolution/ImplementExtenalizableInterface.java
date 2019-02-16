package br.com.costalopes.inputoutputiopackage.serialization.overrideserializationdefaultmethods.secondsolution;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

public class ImplementExtenalizableInterface {

	/*
	 	Esta eh a segunda opcao para customizar a serealizacao de objetos! Basta implementar a interface Externalizable. 
	 	A interface nos impoe o contrato de implementar dois metodos:
	 		- public void writeExternal(ObjectOutput out) throws IOException;
	 		- public void readExternal(ObjectInput out) throws IOException, ClassNotFoundException;
	  	
	  	Um ponto de diferenca importante do primeiro metodo eh que os metodos sao PUBLICOS e nao privados como o primeiro metodo de
	  	customizacao.
	  	
	  	A segunda grande diferenca eh que deve serealizar a CLASSE E TODOAS SUAS SUPERCLASSES se alguma
	  	Por exemplo, no caso da classe Employee do primeiro exemplo, ela teria a responsabilidade de serealizar tanto o estado da classe
	  	Employee quanto o estado da super classe Pessoa!
	  	
	  	IMPORTANTE!
	  		A ideia central da serealizacao usando Externalizable eh serealizar APENAS a identidade (chave primaria) do objeto e NAO
	  		o seu estado completo! Ou seja, no stream serealizavel teriamos apenas o nome da classe e sua identidade (chave primaria).
	  		Neste caso a responsabilidade de recriar o estado do objeto eh do lado que RECEBE o stream, usando para tanto a chave prima
	  		ria. Por exemplo, fazendo uma query ao banco de dados usando a primary key!!!
	 */
	
	public class Person implements Externalizable {

		@Override
		public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
			
		}

		@Override
		public void writeExternal(ObjectOutput out) throws IOException {
			
		}
		
	}
	
}
