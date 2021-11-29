package com.leopompeu.crm.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.br.CPF;

import lombok.Data;

//Declarando variáveis da classe enfermeiros
@Data
@Entity
@Table(name = "Enfermeiros")
public class Enfermeiros implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	

	@NotBlank
	@Column(name="nome")
	private String nome;
	
	@NotBlank
	@CPF
	@Column(unique=true)
	private String cpf;
	
	@NotBlank
	@Column(name="user", unique=true)
	private String user;
	
	@NotBlank
	@Column(name="senha")
	private String senha;
	
	private String email;
	
	private String telefone;
	
	private boolean ativo = true;
	
	private String role = "ENFERMEIRO";
	
	
	
}
