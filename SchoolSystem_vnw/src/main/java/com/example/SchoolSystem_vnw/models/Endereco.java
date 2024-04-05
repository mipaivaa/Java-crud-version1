package com.example.SchoolSystem_vnw.models;

import com.example.SchoolSystem_vnw.dto.DtoEndereco;

import jakarta.persistence.Embeddable;



@Embeddable
public class Endereco {

	
	private String cep;
	private String logradouro;
	private String bairro;
	private String cidade;
	private String complemento;
	private Integer numero;
	public String getCep() {
		return cep;
	}
	public void setCep(String cep) {
		this.cep = cep;
	}
	public String getLogradouro() {
		return logradouro;
	}
	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}
	public String getBairro() {
		return bairro;
	}
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}
	public String getCidade() {
		return cidade;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	public String getComplemento() {
		return complemento;
	}
	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}
	public Integer getNumero() {
		return numero;
	}
	public void setNumero(Integer numero) {
		this.numero = numero;
	}
	public Endereco(String cep, String logradouro, String bairro, String cidade, String complemento, Integer numero) {
		super();
		this.cep = cep;
		this.logradouro = logradouro;
		this.bairro = bairro;
		this.cidade = cidade;
		this.complemento = complemento;
		this.numero = numero;
	}

	public Endereco(DtoEndereco endereco) {
		// TODO Auto-generated constructor stub
	}

}
