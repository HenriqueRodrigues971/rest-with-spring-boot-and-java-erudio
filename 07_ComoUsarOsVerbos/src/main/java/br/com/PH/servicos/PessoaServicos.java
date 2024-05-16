package br.com.PH.servicos;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.PH.Model.Pessoa;
import br.com.PH.exceptions.ResourceNotFoundException;
import br.com.PH.repositories.PessoaRepository;

@Service
public class PessoaServicos {

	private Logger logger = Logger.getLogger(PessoaServicos.class.getName());

	@Autowired
	PessoaRepository repository;

	public List<Pessoa> buscarTodos() {
		logger.info("Procurando todas as pessoas!");

		return repository.findAll();
	}

	public Pessoa buscarPorId(Long id) {
		logger.info("Buscando uma pessoa");
		
		return repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("no records found for this id"));
	}

	public Pessoa criarPessoa(Pessoa pessoa) {
		logger.info("Criando pessoa");

		return repository.save(pessoa);
	}

	public Pessoa atualizarPessoa(Pessoa pessoa) {
		logger.info("Atualizar pessoa");

		var entity =repository.findById(pessoa.getId())
				.orElseThrow(() -> new ResourceNotFoundException("no records found for this id"));
		entity.setPrimeiroNome(pessoa.getPrimeiroNome());
		entity.setUltimoNome(pessoa.getUltimoNome());
		entity.setEndereco(pessoa.getEndereco());
		entity.setGenero(pessoa.getGenero());
		
		return repository.save(pessoa);
	}

	public void deletarPessoa(Long id) {
		logger.info("Deletando pessoa");
	
		var entity =repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("no records found for this id"));
	
		repository.delete(entity);
	}

	
	/*
	 * o @Service para que o spring boot encare a classe PersonServices como um
	 * objeto que vai ser enjetado em runtime em outras classses da nossa aplicação
	 */
}
