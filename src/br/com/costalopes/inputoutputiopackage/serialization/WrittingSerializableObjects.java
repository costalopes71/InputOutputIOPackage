
package br.com.costalopes.inputoutputiopackage.serialization;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class WrittingSerializableObjects {

	/*
	 SEREALIZACAO
	 	serealizar significa poder mandar o objeto e seu estado para um arquivo em disco ou pela rede por exemplo.
	 	Para um objeto poder ser serealizado eh necessario que a classe implemente Serializable e tenha um valor de ID para poder
	 	ser comparado na aplicacao que o recebera.
	 	Se a classe tem alguma relacao com outro objeto, esse objeto tbm deve ser serealizavel. Caso esse objeto nao posso ser sereali
	 	zavel entao devo adicionar a palavra chave transient. Ex: na classe pessoa temos um dos atributos que eh o endereco e este nao
	 	pode ser serealizado.
	 		private transient Address endereco;
	 */
	
	public static void main(String[] args) throws IOException {
		
		Path path = Paths.get("files/serialization/people.bin");
		OutputStream os = Files.newOutputStream(path , StandardOpenOption.CREATE);
		
		ObjectOutputStream oos = new ObjectOutputStream(os);
		
		oos.writeObject(new Person("Joao Carlos", 31));
		oos.writeObject(new Person("Ana", 34));
		
		oos.close();
		os.close();
		
	}
	
}
