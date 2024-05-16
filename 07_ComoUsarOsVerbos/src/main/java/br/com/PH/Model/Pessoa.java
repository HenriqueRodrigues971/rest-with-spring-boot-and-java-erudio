package br.com.PH.Model;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity /* Colocamos isso quando queremos dizer que esse model pertence a um banco */
@Table(name = "pessoa") /* Colocamos o nome da tabela de onde o model vai conectar */
public class Pessoa implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id /* Gera um id automatico sem precisar digitar */
	@GeneratedValue(strategy = GenerationType.IDENTITY) /*
														 * vai autogerar o valor do id e acrescentar +1 a cada cadastro
														 * novo
														 */
	private Long id;

	@Column(name = "primeiro_nome", nullable = false, length =80)/*Colocamos o nome da coluna que os objetos estão refrenciando*/
	private String primeiroNome;
 /*nullble - Usamos para dizer se pode ser vazio ou não, false = não pode ser vazio*/
	@Column(name = "ultimo_nome", nullable = false, length = 80)
	private String ultimoNome;

	@Column(nullable = false, length = 100)/*Caso o nome da coluna seja o mesmo do objeto não precisamos refernciar o nome*/
	private String endereco;

	@Column(nullable = false, length = 6)
	private String genero;

	public Pessoa() {
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

	@Override
	public int hashCode() {
		return Objects.hash(endereco, genero, id, primeiroNome, ultimoNome);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pessoa other = (Pessoa) obj;
		return Objects.equals(endereco, other.endereco) && Objects.equals(genero, other.genero)
				&& Objects.equals(id, other.id) && Objects.equals(primeiroNome, other.primeiroNome)
				&& Objects.equals(ultimoNome, other.ultimoNome);
	}

}
