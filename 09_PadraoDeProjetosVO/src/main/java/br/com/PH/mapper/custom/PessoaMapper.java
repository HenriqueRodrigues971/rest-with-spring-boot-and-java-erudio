package br.com.PH.mapper.custom;

import java.util.Date;

import org.springframework.stereotype.Service;

import br.com.PH.Model.Pessoa;
import br.com.PH.data.vo.v2.PessoaVOV2;

@Service
public class PessoaMapper {
  public PessoaVOV2 converteEntidadeParaVo(Pessoa person) {
	  PessoaVOV2 vo = new PessoaVOV2();
	  vo.setId(person.getId());
	  vo.setPrimeiroNome(person.getPrimeiroNome());
	  vo.setUltimoNome(person.getUltimoNome());
	  vo.setGenero(person.getGenero());
	  vo.setAniversario(new Date());
	  vo.setEndereco(person.getEndereco());
	  return vo;
  }
  public Pessoa converteVoParaEntidade(PessoaVOV2 person) {
	  Pessoa vo = new Pessoa();
	  vo.setId(person.getId());
	  vo.setPrimeiroNome(person.getPrimeiroNome());
	  vo.setUltimoNome(person.getUltimoNome());
	  vo.setGenero(person.getGenero());
	  vo.setEndereco(person.getEndereco());	 // vo.setAniversario(new Date());
	  return vo;
  }
}
