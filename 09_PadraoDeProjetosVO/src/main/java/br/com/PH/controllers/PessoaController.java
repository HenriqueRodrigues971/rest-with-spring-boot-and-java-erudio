package br.com.PH.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.PH.data.vo.v1.PessoaVO;
import br.com.PH.servicos.PessoaServicos;

@RestController
@RequestMapping("/pessoa")
public class PessoaController {

	@Autowired
	private PessoaServicos servico;


	@GetMapping( produces = MediaType.APPLICATION_JSON_VALUE)
	public List<PessoaVO> buscarTodos() {
		return servico.buscarTodos();
	}
	
	@GetMapping(value = "/{id}",  produces = MediaType.APPLICATION_JSON_VALUE)
	public PessoaVO findById(@PathVariable(value = "id") Long id) throws Exception {
		return servico.buscarPorId(id);
	}
	@PostMapping(
			consumes = MediaType.APPLICATION_JSON_VALUE, 
			produces = MediaType.APPLICATION_JSON_VALUE)
	public PessoaVO criarPessoa(@RequestBody PessoaVO pessoa) {
		return servico.criarPessoa(pessoa);
	}
	@PutMapping(
			consumes = MediaType.APPLICATION_JSON_VALUE, 
			produces = MediaType.APPLICATION_JSON_VALUE)
	public PessoaVO atualizarPessoa(@RequestBody PessoaVO pessoa) {
		return servico.atualizarPessoa(pessoa);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity <?> deletarPessoa(@PathVariable(value = "id") Long id){
		servico.deletarPessoa(id);
		return ResponseEntity.noContent().build();
	}

	/* A anotação PathVariable é usado para recuperar dados da url */
}
