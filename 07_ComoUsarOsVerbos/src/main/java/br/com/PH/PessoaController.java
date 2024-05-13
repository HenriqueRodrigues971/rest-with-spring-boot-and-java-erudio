package br.com.PH;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
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
	
	@RequestMapping(value = "/{id}", method=RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
public Pessoa findById(@PathVariable(value = "id")String id) throws Exception{
		return servico.findById(id);
	}
	
	
	
  
	/* A anotação PathVariable é usado para recuperar dados da url */
}
