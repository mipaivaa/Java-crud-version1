package com.example.SchoolSystem_vnw.models;


import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Pattern;

import com.example.SchoolSystem_vnw.dto.DtoAtualizarAluno;
import com.example.SchoolSystem_vnw.enums.EnumCurso;

@Entity
@Table
public class ModelAluno {
	
	@Id //Chave Primária
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;
	@Column(unique = true)
	private String email;
	@Column(unique = true)
	@Pattern(regexp = "\\d{3}\\.\\d{3}\\.\\d{3}-\\d{2}", message = "CPF deve estar no formato xxx.xxx.xxx-xx")
	private String cpf;
	private EnumCurso curso;
	private String telefone;
	
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public EnumCurso getCurso() {
		return curso;
	}
	public void setCurso(EnumCurso curso) {
		this.curso = curso;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public ModelAluno() {
		
		this.nome = nome;
		this.email = email;
		this.cpf = cpf;
		this.curso = curso;
		this.telefone = telefone;
		
	}
	public void atualizarInfoAluno(DtoAtualizarAluno dtoatualizaraluno) {
	
		this.nome = dtoatualizaraluno.nome() != null ? dtoatualizaraluno.nome(): this.nome;
		this.email = dtoatualizaraluno.email() != null ? dtoatualizaraluno.email(): this.email;
		this.telefone = dtoatualizaraluno.telefone() != null ? dtoatualizaraluno.telefone(): this.email;
		this.curso = dtoatualizaraluno.curso() != null ? dtoatualizaraluno.curso(): this.curso;
	}
	
	



	@Embedded
	private Endereco endereco;
	
	
}
