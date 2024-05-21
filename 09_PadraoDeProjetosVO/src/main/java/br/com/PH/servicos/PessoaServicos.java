package br.com.PH.servicos;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.PH.Model.Pessoa;
import br.com.PH.data.vo.v1.PessoaVO;
import br.com.PH.data.vo.v2.PessoaVOV2;
import br.com.PH.exceptions.ResourceNotFoundException;
import br.com.PH.mapper.DozerMapper;
import br.com.PH.mapper.custom.PessoaMapper;
import br.com.PH.repositories.PessoaRepository;

@Service
public class PessoaServicos {

	private Logger logger = Logger.getLogger(PessoaServicos.class.getName());

	@Autowired
	PessoaRepository repository;
	@Autowired
    PessoaMapper mapper;
	public List<PessoaVO> buscarTodos() {
		logger.info("Procurando todas as pessoas!");

		return DozerMapper.converteListaObjeto(repository.findAll(), PessoaVO.class);
	}

	public PessoaVO buscarPorId(Long id) {
		logger.info("Buscando uma pessoa");
		
		var entity = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("no records found for this id"));
		return DozerMapper.converteObjeto(entity, PessoaVO.class);
	}

	public PessoaVO criarPessoa(PessoaVO pessoaVO) {
		logger.info("Criando pessoa");
    var entity = DozerMapper.converteObjeto(pessoaVO, Pessoa.class);
		var vo = DozerMapper.converteObjeto(repository.save(entity),PessoaVO.class);
		return vo;
		
	}
	public PessoaVOV2 criarPessoaV2(PessoaVOV2 pessoaVOV2) {
		logger.info("Criando pessoa V2");
		var entity = mapper.converteVoParaEntidade(pessoaVOV2);
		var vo = mapper.converteEntidadeParaVo(repository.save(entity));
		return vo;
		
	}

	public PessoaVO atualizarPessoa(PessoaVO pessoaVO) {
		logger.info("Atualizar pessoa");

		var entity =repository.findById(pessoaVO.getId())
				.orElseThrow(() -> new ResourceNotFoundException("no records found for this id"));
		entity.setPrimeiroNome(pessoaVO.getPrimeiroNome());
		entity.setUltimoNome(pessoaVO.getUltimoNome());
		entity.setEndereco(pessoaVO.getEndereco());
		entity.setGenero(pessoaVO.getGenero());
		var vo = DozerMapper.converteObjeto(repository.save(entity), PessoaVO.class);
		
		return vo;
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
