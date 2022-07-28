package br.com.kbadigital.academia.service;

import java.util.List;

import br.com.kbadigital.academia.entity.Aluno;

public interface IAlunoService {

	public Aluno salvar(Aluno aluno);
	
	public Aluno atualizar(Aluno aluno);
	
	public Aluno buscaPorId(Long id);
	
	public List<Aluno> buscaTodos();
}
