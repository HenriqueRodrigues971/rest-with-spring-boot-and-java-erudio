package br.com.PH.data.vo.v2;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

public class PessoaVOV2 implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;

	private String primeiroNome;
	private String ultimoNome;
	private String endereco;
	private String genero;
	private Date aniversario;

	public PessoaVOV2() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPrimeiroNome() {
		return primeiroNome;
	}

	public void setPrimeiroNome(String primeiroNome) {
		this.primeiroNome = primeiroNome;
	}

	public String getUltimoNome() {
		return ultimoNome;
	}

	public void setUltimoNome(String ultimoNome) {
		this.ultimoNome = ultimoNome;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public Date getAniversario() {
		return aniversario;
	}

	public void setAniversario(Date aniversario) {
		this.aniversario = aniversario;
	}

	@Override
	public int hashCode() {
		return Objects.hash(endereco, genero, id, primeiroNome, ultimoNome, aniversario);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PessoaVOV2 other = (PessoaVOV2) obj;
		return Objects.equals(endereco, other.endereco) && Objects.equals(genero, other.genero)
				&& Objects.equals(id, other.id) && Objects.equals(primeiroNome, other.primeiroNome)
				&& Objects.equals(ultimoNome, other.ultimoNome) && Objects.equals(aniversario, other.aniversario);
	}

}
