package br.com.kbadigital.academia.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

@Entity
public class Aluno {
	
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String nome;
		
	@Column(unique = false)
	private String cpf;
	
	private Double peso;
	
	private Double altura;
	
	@ManyToMany
	@Fetch(FetchMode.SELECT)
	private List<Atividade> atividades;
	
	public Aluno() {
		super();
	}

	public Aluno(String nome, String cpf, Double peso, Double altura) {
		super();
		this.nome = nome;
		this.cpf = cpf;
		this.peso = peso;
		this.altura = altura;
	}
	
	public Aluno(String nome, Double peso, Double altura) {
		super();
		this.nome = nome;
		this.peso = peso;
		this.altura = altura;
	}

	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getCpf() {
		return cpf;
	}
	
	public void setCpf(String cpf) {		
		this.cpf = cpf;
	}
	
	public Double getPeso() {
		return peso;
	}
	
	public void setPeso(Double peso) {
		this.peso = peso;
	}
	
	public Double getAltura() {
		return altura;
	}
	
	public void setAltura(Double altura) {
		this.altura = altura;
	}

	public List<Atividade> getAtividades() {
		return atividades;
	}

	public void setAtividades(List<Atividade> atividades) {
		this.atividades = atividades;
	}	
}
