package com.example.SchoolSystem_vnw.models;


import org.hibernate.validator.constraints.br.CPF;

import com.example.SchoolSystem_vnw.dto.DtoEndereco;
import com.example.SchoolSystem_vnw.enums.EnumCargo;
import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Pattern;


//Anotação que diz que essa classe é uma entidade
@Entity
@Table(name = "tb_colaborador" )


// será a classe responsavel pela entidade
public class ModelColaborador {
	


	@Id //Chave Primária
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String nome;
	
	@Column(unique = true)
	@Email 
	private String email;
	@Column(unique = true)
	
	private String cpf;
	private EnumCargo cargo;
	@Embedded 
	private Endereco endereco;
	
	
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


	public EnumCargo getCargo() {
		return cargo;
	}


	public void setCargo(EnumCargo cargo) {
		this.cargo = cargo;
	}


	public Endereco getEndereco() {
		return endereco;
	}


	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}


	public ModelColaborador(String nome,String email, String cpf, EnumCargo cargo,DtoEndereco endereco) {
		this.nome = nome;
		this.email = email;
		this.cpf = cpf;
		this.cargo = cargo;
		this.endereco = new Endereco(endereco.cep(),endereco.logradouro(),endereco.bairro(),endereco.cidade(), endereco.complemento(),endereco.numero());
	}


	

	}


	

