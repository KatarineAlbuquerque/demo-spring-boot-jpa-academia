package br.com.kbadigital.academia.service;

import java.util.List;

import br.com.kbadigital.academia.entity.Atividade;

public interface IAtividadeService {

	public Atividade salvar(Atividade atividade);
	
	public Atividade atualizar(Atividade atividade);
	
	public Atividade buscaPorId(Long id);
	
	public List<Atividade> buscaTodos();
}
