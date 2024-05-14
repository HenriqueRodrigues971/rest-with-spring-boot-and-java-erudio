package br.com.PH.servicos;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Logger;

import org.springframework.stereotype.Service;

import br.com.PH.Model.Pessoa;

@Service
public class PessoaServicos {
	private final AtomicLong contador = new AtomicLong();

	private Logger logger = Logger.getLogger(PessoaServicos.class.getName());

	
	public List<Pessoa> buscarTodos() {
		logger.info("Procurando todas as pessoas!");
		List<Pessoa> pessoas = new ArrayList<>();
		for(int i = 0; i < 8; i++) {
			Pessoa pessoa = simularPessoa(i);
			pessoas.add(pessoa);
		}
		return pessoas ;
	}
		public Pessoa buscarPorId(String id) {
		logger.info("Buscando uma pessoa");
		Pessoa pessoa = new Pessoa();
		pessoa.setId(contador.incrementAndGet());
		pessoa.setPrimeiroNome("Paulo");
		pessoa.setUltimoNome("Freitas");
		pessoa.setEndereco("Rua Ernesto Giorno, 70");
		pessoa.setGenero("Masculino");
		return pessoa;
	}
		private Pessoa simularPessoa(int i) {
			Pessoa pessoa = new Pessoa();
			pessoa.setId(contador.incrementAndGet());
			pessoa.setPrimeiroNome("Nome da pessoa: " + i);
			pessoa.setUltimoNome("Ultimo nome: " + i);
			pessoa.setEndereco("Some adress in Brasil: " + i);
			pessoa.setGenero("Masculino");
			return pessoa;
		}
	/*
	 * o @Service para que o spring boot encare a classe PersonServices como um
	 * objeto que vai ser enjetado em runtime em outras classses da nossa aplicação
	 */
}
