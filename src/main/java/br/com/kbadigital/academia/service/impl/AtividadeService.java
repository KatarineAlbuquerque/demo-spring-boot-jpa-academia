package br.com.kbadigital.academia.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.kbadigital.academia.entity.Atividade;
import br.com.kbadigital.academia.exception.DadoNullException;
import br.com.kbadigital.academia.repository.AtividadeRepository;
import br.com.kbadigital.academia.service.IAtividadeService;

@Service
public class AtividadeService implements IAtividadeService {	
	
	@Autowired
	private AtividadeRepository atividadeRepository;

	@Override
	public Atividade salvar(Atividade atividade) {
		validaDados(atividade);
		return atividadeRepository.save(atividade);
	}
	
	@Override
	public Atividade atualizar(Atividade atividade) {		
		validaDados(atividade);
		return atividadeRepository.saveAndFlush(atividade);
	}

	@Override
	public Atividade buscaPorId(Long id) {		
		return atividadeRepository.findById(id).orElse(null);
	}

	@Override
	public List<Atividade> buscaTodos() {
		return atividadeRepository.findAll();
	}
	
	public void validaDados(Atividade atividade) {
		if(atividade.getNome() == null) {
			throw new DadoNullException();
		}
	}
}
