package br.com.PH.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.PH.Model.Pessoa;

@Repository
public interface PessoaRepository extends JpaRepository<Pessoa, Long> {
   
}
