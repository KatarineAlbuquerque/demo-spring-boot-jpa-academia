package br.com.kbadigital.academia.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import br.com.kbadigital.academia.exception.CpfException;
import br.com.kbadigital.academia.exception.DadoException;
import br.com.kbadigital.academia.exception.DadoNullException;

@ControllerAdvice
public class DadosControllerAdvice extends ResponseEntityExceptionHandler {
	
	@ExceptionHandler(DadoNullException.class)
	public ResponseEntity<Object> errosNull() {
		
		Map<String, String> erros = new HashMap<>();
		erros.put("mensagem", "Verifique se os campos do Formulário estão preenchidos.");
		
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(erros);
	}
	
	
	@ExceptionHandler(DadoException.class)
	public ResponseEntity<Object> errosValorNegativo() {
		
		Map<String, String> erros = new HashMap<>();
		erros.put("mensagem", "Os valores não podem ser negativos.");
		
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(erros);
	}
	
	@ExceptionHandler(CpfException.class)
	public ResponseEntity<Object> errosCpf() {
		
		Map<String, String> erros = new HashMap<>();
		erros.put("mensagem", "O CPF já existe!");
		
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(erros);
	}
}
