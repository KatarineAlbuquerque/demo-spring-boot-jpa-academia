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

import br.com.kbadigital.academia.entity.Atividade;
import br.com.kbadigital.academia.service.impl.AtividadeService;

@RestController
@RequestMapping(value = "/atividade")
public class AtividadeController {

	@Autowired
	private AtividadeService atividadeService;
	
	@PostMapping(value = "/salvar")
	public ResponseEntity<Atividade> salvar(@RequestBody Atividade atividade) {
		
		atividade = atividadeService.salvar(atividade);
		
		return ResponseEntity.ok().body(atividade);
	}
	
	@PutMapping(value = "/atualizar")
	public ResponseEntity<Atividade> atualizar(@RequestBody Atividade atividade) {
		
		atividade = atividadeService.atualizar(atividade);
		
		return ResponseEntity.ok().body(atividade);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Atividade> buscaPorId(Long id) {
		
		Atividade atividade = atividadeService.buscaPorId(id);
		
		return ResponseEntity.ok().body(atividade);
	}
	
	@GetMapping(value = "/")
	public ResponseEntity<List<Atividade>> buscaPorId() {
		
		List<Atividade> atividades = atividadeService.buscaTodos();
		
		return ResponseEntity.ok().body(atividades);
	}	
}
