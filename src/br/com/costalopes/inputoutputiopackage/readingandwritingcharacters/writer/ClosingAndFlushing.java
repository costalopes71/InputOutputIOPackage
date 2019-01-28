package br.com.costalopes.inputoutputiopackage.readingandwritingcharacters.writer;

public class ClosingAndFlushing {

	/*
	 Qdo escrevemos em um recurso de saida (disco ou rede por exemplo) geralmente nao escrevemos os caracteres ou os bytes diretamento no recurso, mas
	 sim em um buffer, em determinado ponto o buffer deve ser descarregado no recurso de saida. Ha um metodo flush para fazer isso, e qdo o metodo
	 close eh chamado em um writer ira triggar a chamada para o flush.
	 O flush eh propagado para todos os streams ate chegar o recurso de saida e entao ira triggar uma chamada para o sistema (OS), escrever eh responsabilidade
	 do sistema (OS).
	 */
	
}
