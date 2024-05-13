package br.com.PH.servicos;

import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Logger;

import org.springframework.stereotype.Service;

import br.com.PH.Model.Pessoa;

@Service
public class PessoaServicos {
	private final AtomicLong contador = new AtomicLong();

	private Logger logger = Logger.getLogger(PessoaServicos.class.getName());

	
	public Pessoa findById(String id) {
		logger.info("Buscando uma pessoa");
		Pessoa pessoa = new Pessoa();
		pessoa.setId(contador.incrementAndGet());
		pessoa.setPrimeiroNome("Paulo");
		pessoa.setUltimoNome("Freitas");
		pessoa.setEndereco("Rua Ernesto Giorno, 70");
		pessoa.setGenero("Masculino");
		return pessoa;
	}
	/*
	 * o @Service para que o spring boot encare a classe PersonServices como um
	 * objeto que vai ser enjetado em runtime em outras classses da nossa aplicação
	 */
}
