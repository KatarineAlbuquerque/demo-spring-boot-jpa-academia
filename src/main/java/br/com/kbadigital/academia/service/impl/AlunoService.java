package br.com.kbadigital.academia.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.kbadigital.academia.entity.Aluno;
import br.com.kbadigital.academia.entity.Atividade;
import br.com.kbadigital.academia.exception.CpfException;
import br.com.kbadigital.academia.exception.DadoException;
import br.com.kbadigital.academia.exception.DadoNullException;
import br.com.kbadigital.academia.repository.AlunoRepository;
import br.com.kbadigital.academia.service.IAlunoService;

@Service
public class AlunoService implements IAlunoService {
	
	@Autowired
	private AlunoRepository alunoRepository;
	
	@Autowired
	private AtividadeService atividadeService;
	
	
	@Override
	public Aluno salvar(Aluno aluno) {
		List<Atividade> atividades = new ArrayList<>();
		aluno.getAtividades().forEach(atividade -> {
			atividades.add(atividadeService.buscaPorId(atividade.getId()));
		});
		aluno.setAtividades(atividades);
		validaDadosAoSalvar(aluno);
		return alunoRepository.save(aluno);
	}
	
	@Override
	public Aluno atualizar(Aluno aluno) {
		List<Atividade> atividades = new ArrayList<>();
		aluno.getAtividades().forEach(atividade -> {
			atividades.add(atividadeService.buscaPorId(atividade.getId()));
		});
		aluno.setAtividades(atividades);
		validaDadosAoAtualizar(aluno);
		return alunoRepository.saveAndFlush(aluno);			
	}
	
	@Override
	public Aluno buscaPorId(Long id) {
		return alunoRepository.findById(id).orElse(null);
	}

	@Override
	public List<Aluno> buscaTodos() {
		return alunoRepository.findAll();
	}
	
	public void validaDadosAoSalvar(Aluno aluno) {
		if(aluno.getNome() == null || aluno.getCpf() == null) {
			throw new DadoNullException();
		}
		if(aluno.getAltura() < 0 || aluno.getPeso() < 0) {
			throw new DadoException();
		}
		List<Aluno> alunos = buscaTodos();
		
		alunos.forEach(a -> {
			if(a.getCpf().equals(aluno.getCpf())) {
				throw new CpfException();
			}
		});
	}
	
	public void validaDadosAoAtualizar(Aluno aluno) {
		if(aluno.getNome() == null || aluno.getCpf() == null) {
			throw new DadoNullException();
		}
		if(aluno.getAltura() < 0 || aluno.getPeso() < 0) {
			throw new DadoException();
		}
	}
}
