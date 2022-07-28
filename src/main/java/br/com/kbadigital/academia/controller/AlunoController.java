package br.com.kbadigital.academia.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.kbadigital.academia.entity.Aluno;
import br.com.kbadigital.academia.service.impl.AlunoService;

@RestController
@RequestMapping(value = "/aluno")
public class AlunoController {
	
	@Autowired
	private AlunoService alunoService;
	
	@PostMapping(value = "/salvar")
	public ResponseEntity<Aluno> salvar(@RequestBody Aluno aluno) {
				
		aluno = alunoService.salvar(aluno);
		
		return ResponseEntity.ok().body(aluno);
	}
	
	@PutMapping(value = "/atualizar")
	public ResponseEntity<Aluno> atualizar(@RequestBody Aluno aluno) {
				
		aluno = alunoService.atualizar(aluno);
		
		return ResponseEntity.ok().body(aluno);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Aluno> buscaPorId(Long id) {
		
		Aluno aluno = alunoService.buscaPorId(id);
		
		return ResponseEntity.ok().body(aluno);
	}
	
	@GetMapping(value = "/")
	public ResponseEntity<List<Aluno>> buscaPorId() {
		
		List<Aluno> alunos = alunoService.buscaTodos();
		
		return ResponseEntity.ok().body(alunos);
	}	
}
