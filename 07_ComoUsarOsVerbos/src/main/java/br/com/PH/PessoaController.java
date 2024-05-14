package br.com.PH;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.PH.Model.Pessoa;
import br.com.PH.servicos.PessoaServicos;

@RestController
@RequestMapping("/pessoa")
public class PessoaController {

	@Autowired
	private PessoaServicos servico;


	@RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Pessoa> buscarTodos() {
		return servico.buscarTodos();
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public Pessoa findById(@PathVariable(value = "id") String id) throws Exception {
		return servico.buscarPorId(id);
	}
	@RequestMapping(
			method = RequestMethod.POST,
			consumes = MediaType.APPLICATION_JSON_VALUE, 
			produces = MediaType.APPLICATION_JSON_VALUE)
	public Pessoa criarPessoa(@RequestBody Pessoa pessoa) {
		return servico.criarPessoa(pessoa);
	}
	@RequestMapping(
			method = RequestMethod.PUT,
			consumes = MediaType.APPLICATION_JSON_VALUE, 
			produces = MediaType.APPLICATION_JSON_VALUE)
	public Pessoa atualizarPessoa(@RequestBody Pessoa pessoa) {
		return servico.atualizarPessoa(pessoa);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE )
	public void deletarPessoa(@PathVariable(value = "id") String id){
		servico.deletarPessoa(id);
	}

	/* A anotação PathVariable é usado para recuperar dados da url */
}
