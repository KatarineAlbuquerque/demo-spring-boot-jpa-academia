package br.com.kbadigital.academia.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.kbadigital.academia.entity.Atividade;

@Repository
public interface AtividadeRepository extends JpaRepository<Atividade, Long> {

}
